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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Calendar getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Calendar dataNascita) {
		this.dataNascita = dataNascita;
	}

}
