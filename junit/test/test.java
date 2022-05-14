////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.mtss.business.Bill;
import it.unipd.mtss.business.RealBill;
import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.RealEItem;
import it.unipd.mtss.model.EItemType;

public class BillTest {

	private Bill bill = new RealBill();

	@Test
	public void scontoProcessoreMenoCaroTest(){
		EItem[] items = {
			new RealEItem("Prodotto", new EItemType("MB"), 12.3),
			new RealEItem("Prodotto", new EItemType("CPU"), 6.4),
			new RealEItem("Prodotto", new EItemType("MB"), 18.3),
			new RealEItem("Prodotto", new EItemType("CPU"), 43.3),
			new RealEItem("Prodotto", new EItemType("CPU"), 65.3),
			new RealEItem("Prodotto", new EItemType("CPU"), 89.3),
			new RealEItem("Prodotto", new EItemType("CPU"), 120.3),
			new RealEItem("Prodotto", new EItemType("CPU"), 22.3),
		};
		List<EItem> itemsOrdered = createEItemList(items);
		double expected = 3.2;
		double actual = bill.scontoProcessoreMenoCaro(itemsOrdered);
		assertEquals(expected, actual);
	}

	private List<Product> createEItemList(EItem[] items) {
		List<EItem> itemsOrdered = new ArrayList<EItem>();
		for (EItem item : items) {
			itemsOrdered.add(item);
		}
		return products;
	}

	@Test
	public void testClientProductSum_AllProductsSameCurrency()
			throws DifferentCurrenciesException {

		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
				new AmountImpl(new BigDecimal("6.0"), Currency.EURO) };

		Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);
		
		List<Product> products = createProductListWithAmounts(amounts);

		Amount actual = clientBO.getClientProductsSum(products);

		assertAmount(actual, expected);
	}

	@Test(expected = DifferentCurrenciesException.class)
	public void testClientProductSum_DifferentCurrencies_ThrowsException()
			throws DifferentCurrenciesException {

		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
				new AmountImpl(new BigDecimal("6.0"), Currency.INDIAN_RUPEE) };

		List<Product> products = createProductListWithAmounts(amounts);

		@SuppressWarnings("unused")
		Amount actual = clientBO.getClientProductsSum(products);

	}

	@Test
	public void testClientProductSum_NoProducts()
			throws DifferentCurrenciesException {

		Amount[] amounts = {};
		Amount expected = new AmountImpl(BigDecimal.ZERO, Currency.EURO);

		List<Product> products = createProductListWithAmounts(amounts);

		Amount actual = clientBO.getClientProductsSum(products);


		assertAmount(actual, expected);
	}

	private void assertAmount(Amount actual, Amount expected) {
		assertEquals(expected.getCurrency(), actual.getCurrency());
		assertEquals(expected.getValue(), actual.getValue());
	}

	private List<Product> createProductListWithAmounts(Amount[] amounts) {
		List<Product> products = new ArrayList<Product>();
		for (Amount amount : amounts) {
			products.add(new ProductImpl(100, "Product 15",
					ProductType.BANK_GUARANTEE, amount));
		}
		return products;
	}

}