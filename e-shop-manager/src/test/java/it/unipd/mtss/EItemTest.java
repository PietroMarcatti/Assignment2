////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.RealEItem;
import it.unipd.mtss.model.EItemType;

public class EItemTest {
    
    @Test
    public void eitem_getEItemTypeTest() {
        EItemType type = EItemType.KEYBOARD;
        EItem item = new RealEItem("Tastiera Bella", type, 13.3);
        EItemType expected = EItemType.KEYBOARD;
        EItemType actual = item.getEItemType();

        assertEquals(expected, actual);
    }

    @Test
    public void eitem_getNameTest() {
        EItemType type = EItemType.KEYBOARD;
        EItem item = new RealEItem("Tastiera Bella", type, 13.3);
        String expected = "Tastiera Bella";
        String actual = item.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void eitem_getPriceTest() {
        EItemType type = EItemType.KEYBOARD;
        EItem item = new RealEItem("Tastiera Bella", type, 13.3);
        double expected = 13.3;
        double actual = item.getPrice();

        assertEquals(expected, actual, 0.001);
    }
}
