////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import java.utils.date*;

public class RealUser implements User {

	private long id;

	private String name;

	private Date dataNascita;

	public ClientImpl(long id, String name, Date dataNascita) {
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
	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

}
