////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.unipd.mtss.model.EItemType;

public class EItemTypeTest{
    
    @Test
    public void eitemtype_toStringTest(){
        EItemType type = EItemType.KEYBOARD;
        String expected = "KB";
        String actual = type.toString();
        assertEquals(expected, actual);
    }
}