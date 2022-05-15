////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class RealEItem implements EItem {

	private String name;

	private EItemType type;

	private double price;

	public RealEItem(String name, EItemType type, double price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public EItemType getEItemType() {
		return type;
	}

	public void setEItemType(EItemType type) {
		this.type = type;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
