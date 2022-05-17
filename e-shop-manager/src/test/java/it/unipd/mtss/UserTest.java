////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import org.junit.Test;

import it.unipd.mtss.model.RealUser;
import it.unipd.mtss.model.User;

public class UserTest {
    
    @Test
    public void user_getIdTest() {
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        double expected = 1;
        double actual = user.getId();

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void user_getNameTest() {
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        User user = new RealUser(1, "Davide", date);
        String expected = "Davide";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void user_getDataNascitaTest() {
        Calendar date= Calendar.getInstance();
        User user = new RealUser(1, "Davide", date);
        Calendar expected= date;
        Calendar actual = user.getDataNascita();

        assertEquals(expected, actual);
    }
}
