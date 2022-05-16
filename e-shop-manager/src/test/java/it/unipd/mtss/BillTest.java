////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import it.unipd.mtss.business.Bill;
import it.unipd.mtss.business.RealBill;
import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.RealEItem;
import it.unipd.mtss.model.EItemType;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.RealUser;

public class BillTest {

    private Bill bill = new RealBill();

    @Test
    public void getOrderPrice_ScontoProcessoreMenoCaroTest() throws BillException{
        EItem[] items = {
            new RealEItem("Prodotto", EItemType.MOTHERBOARD, 12.3),
            new RealEItem("Prodotto", EItemType.PROCESSOR, 6.4),
            new RealEItem("Prodotto", EItemType.MOTHERBOARD, 18.3),
            new RealEItem("Prodotto", EItemType.PROCESSOR, 43.3),
            new RealEItem("Prodotto", EItemType.PROCESSOR, 65.3),
            new RealEItem("Prodotto", EItemType.PROCESSOR, 89.3),
            new RealEItem("Prodotto", EItemType.PROCESSOR, 120.3),
            new RealEItem("Prodotto", EItemType.PROCESSOR, 22.3),
        };
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        List<EItem> itemsOrdered = createEItemList(items);
        double expected = 374.3;
        double actual = bill.getOrderPrice(itemsOrdered, user);

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void getOrderPrice_regaloMouseMenoCaroTest() throws BillException{
        EItem[] items = {
            new RealEItem("Prodotto", EItemType.MOTHERBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 10.0),
            new RealEItem("Prodotto", EItemType.MOTHERBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
        };
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        List<EItem> itemsOrdered = createEItemList(items);
        double expected = 240.0;
        double actual = bill.getOrderPrice(itemsOrdered, user);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void getOrderPrice_regaloMouseTastieraMenoCaroTest() throws BillException{
        EItem[] items = {
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 10.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
        };
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        List<EItem> itemsOrdered = createEItemList(items);
        double expected = 220.0;
        double actual = bill.getOrderPrice(itemsOrdered, user);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void getOrderPrice_scontoOrdineSopraMilleTest() throws BillException{
        EItem[] items = {
            new RealEItem("Prodotto", EItemType.KEYBOARD, 1200.0),
        };
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        List<EItem> itemsOrdered = createEItemList(items);
        double expected = 1080;
        double actual = bill.getOrderPrice(itemsOrdered, user);

        assertEquals(expected, actual, 0.001);
    }

    @Test(expected = BillException.class)
    public void getOrderPrice_numeroDiProdottiEccessivoTest() throws BillException{
        EItem[] items = {
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 10.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 10.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 10.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.KEYBOARD, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
            new RealEItem("Prodotto", EItemType.MOUSE, 20.0),
        };
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        List<EItem> itemsOrdered = createEItemList(items);
        @SuppressWarnings("unused")
        double actual = bill.getOrderPrice(itemsOrdered, user);
    }

    @Test
    public void getOrderPrice_prezzoOrdineTroppoBassoTest() throws BillException{
        EItem[] items = {
            new RealEItem("Prodotto", EItemType.KEYBOARD, 8.0),
        };
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        List<EItem> itemsOrdered = createEItemList(items);
        double expected = 10;
        double actual = bill.getOrderPrice(itemsOrdered, user);

        assertEquals(expected, actual, 0.001);
    }

    private List<EItem> createEItemList(EItem[] items) {
        List<EItem> itemsOrdered = new ArrayList<EItem>();
        for (EItem item : items) {
            itemsOrdered.add(item);
        }
        return itemsOrdered;
    }

}