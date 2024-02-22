package model.bean;

import java.time.LocalDateTime;

public class UtenteBean {
	private Long idUtente;
	private String nomeUtente;
	private String cognomeUtente;
	private String emailUtente;
	private int eta;
	private String passwordUtente;
	private LocalDateTime dataCreazioneUtente;
	private LocalDateTime dataModificaUtente;
	private Boolean flgCancellatoUtente;
	private Long ruoloUtente;
	private int libriAcquistati;
	private boolean isGiovane;
	

	
	public UtenteBean(Long idUtente, String nomeUtente, String cognomeUtente, String emailUtente, int eta,
			String passwordUtente, LocalDateTime dataCreazioneUtente, LocalDateTime dataModificaUtente,
			Boolean flgCancellatoUtente, Long ruoloUtente, int libriAcquistati, boolean isGiovane) {
		this.idUtente = idUtente;
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.emailUtente = emailUtente;
		this.eta = eta;
		this.passwordUtente = passwordUtente;
		this.dataCreazioneUtente = dataCreazioneUtente;
		this.dataModificaUtente = dataModificaUtente;
		this.flgCancellatoUtente = flgCancellatoUtente;
		this.ruoloUtente = ruoloUtente;
		this.libriAcquistati = libriAcquistati;
		this.isGiovane = isGiovane;
	}

	public UtenteBean() {
		
	}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getPasswordUtente() {
		return passwordUtente;
	}

	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}

	public LocalDateTime getDataCreazioneUtente() {
		return dataCreazioneUtente;
	}

	public void setDataCreazioneUtente(LocalDateTime dataCreazioneUtente) {
		this.dataCreazioneUtente = dataCreazioneUtente;
	}

	public LocalDateTime getDataModificaUtente() {
		return dataModificaUtente;
	}

	public void setDataModificaUtente(LocalDateTime dataModificaUtente) {
		this.dataModificaUtente = dataModificaUtente;
	}

	public Boolean getFlgCancellatoUtente() {
		return flgCancellatoUtente;
	}

	public void setFlgCancellatoUtente(Boolean flgCancellatoUtente) {
		this.flgCancellatoUtente = flgCancellatoUtente;
	}

	public Long getRuoloUtente() {
		return ruoloUtente;
	}

	public void setRuoloUtente(Long ruoloUtente) {
		this.ruoloUtente = ruoloUtente;
	}

	public int getLibriAcquistati() {
		return libriAcquistati;
	}

	public void setLibriAcquistati(int libriAcquistati) {
		this.libriAcquistati = libriAcquistati;
	}

	public boolean isGiovane() {
		return isGiovane;
	}

	public void setGiovane(boolean isGiovane) {
		this.isGiovane = isGiovane;
	}
	

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "UtenteBean [idUtente=" + idUtente + ", nomeUtente=" + nomeUtente + ", cognomeUtente=" + cognomeUtente
				+ ", emailUtente=" + emailUtente + ", eta=" + eta + ", passwordUtente=" + passwordUtente
				+ ", dataCreazioneUtente=" + dataCreazioneUtente + ", dataModificaUtente=" + dataModificaUtente
				+ ", flgCancellatoUtente=" + flgCancellatoUtente + ", ruoloUtente=" + ruoloUtente + ", libriAcquistati="
				+ libriAcquistati + ", isGiovane=" + isGiovane + "]";
	}



}
