package it.paradisogiuseppe.model;

import java.io.Serializable;

public class ContactModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	
	
	public ContactModel(){
		setId(0);
		nome="Sample";
		cognome="Sample";
		telefono="Sample";
		email="Sample";
	}
	
	
	public ContactModel(int id, String nome, String cognome, String telefono, String email) {
		super();
		this.setId(id);
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}
}
