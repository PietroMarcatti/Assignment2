////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.util.Calendar;

public class RealUser implements User {

    private long id;

    private String name;

    private Calendar dataNascita;

    public RealUser(long id, String name, Calendar dataNascita) {
        super();
        this.id = id;
        this.name = name;
        this.dataNascita = dataNascita;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Calendar getDataNascita() {
        return dataNascita;
    }

}
