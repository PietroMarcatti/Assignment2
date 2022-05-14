////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.util.List;
import java.util.Date;
import java.util.Random;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;

public class RealBill implements Bill {

	private int ordiniRegalati =0;
	private long[] idUtenti = new long[10];
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clarity.model.ClientBO#getClientProductsSum(java.util.List)
	 */
	@Override
	double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException {
		DateTime dt = new DateTime();
		int hours = dt.getHourOfDay();
		int[] numeroItem = new int[4];
		double prezzoTotaleProvvisorio = 0;
		for (EItem item : itemsOrdered){
			switch(item.getType()){
				case "MB": numeroItem[0]+=1;break;
				case "CPU": numeroItem[1]+=1;break;
				case "MS": numeroItem[2]+=1;break;
				case "KB": numeroItem[3]+=1;break;
				default: break;
			}
			prezzoTotaleProvvisorio+=item.getPrice();
		}
		if(numeroItem[1]>5){
			prezzoTotaleProvvisorio -= scontoProcessoreMenoCaro(itemsOrdered)
		}
		if(numeroItem[2]>10){
			prezzoTotaleProvvisorio -= regaloMouseMenoCaro(itemsOrdered)
		}
		if(numeroItem[2]==numeroItem[3]){
			prezzoTotaleProvvisorio -= regaloMouseTastieraMenoCaro(itemsOrdered)
		}
		if(prezzoTotaleProvvisorio>1000){
			prezzoTotaleProvvisorio*=0.9;
		}
		if(itemsOrdered.length > 30){
			throw new BillException();
		}
		if(prezzoTotaleProvvisorio<10){
			prezzoTotaleProvvisorio+=2;
		}
		if(hours >=18 && hours <=19 ){
			if(regaloPerMinorenne())
				prezzoTotaleProvvisorio = 0;
		}else{
			idUtenti = new long[10];
			ordiniRegalati = 0;
		}
	}

	private double scontoProcessoreMenoCaro(List<EItem> itemsOrdered){
		double prezzoMinore = Double.POSITIVE_INFINITY;
		for (EItem item : itemsOrdered){
			if(item.getType().equals("CPU") && item.getPrice()<prezzoMinore){
				prezzoMinore = item.getPrice();
			}
		}
		return 0.5*prezzoMinore;
	}

	private double regaloMouseMenoCaro(List<EItem> itemsOrdered){
		double prezzoMinore = Double.POSITIVE_INFINITY;
		for (EItem item : itemsOrdered){
			if(item.getType().equals("MS") && item.getPrice()<prezzoMinore){
				prezzoMinore = item.getPrice();
			}
		}
		return prezzoMinore;
	}

	private double regaloMouseTastieraMenoCaro(List<EItem> itemsOrdered){
		double prezzoMinore = Double.POSITIVE_INFINITY;
		for (EItem item : itemsOrdered){
			if((item.getType().equals("MS") || item.getType().equals("KB")) && item.getPrice()<prezzoMinore){
				prezzoMinore = item.getPrice();
			}
		}
		return prezzoMinore;
	}

	private boolean regaloPerMinorenne(double prezzoTotaleProvvisorio){
		Random rand = new Random();
		DateTime dt = new DateTime();
		DateTime diff = dt - user.getDataNascita();
		if(ordiniRegalati < 10 && rand.nextInt(2) == 1 && diff.getYear()<18){
			bool trovato = false;
			for(long id : idUtenti){
				if(id == user.getId()){
					trovato = true;
				} 
			}
			if(!trovato){
				idUtenti[ordiniRegalati] = user.getId();
				ordiniRegalati +=1;
				return true;
			}else{
				return false;
			}
		}
	}
}