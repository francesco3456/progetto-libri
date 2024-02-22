package model.bean;

import java.util.Objects;

public class RuoloBean {
	
	private Long idRuolo;
	private String nomeRuolo;
	
	public RuoloBean() {}
	public RuoloBean(Long idRuolo, String nomeRuolo) {
		this.idRuolo = idRuolo;
		this.nomeRuolo = nomeRuolo;
	}
	
	public Long getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}
	public String getNomeRuolo() {
		return nomeRuolo;
	}
	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}
	
	@Override
    public String toString() {
        return "Ruolo: {" +
                "Id = " + getIdRuolo() +
                ", Nome = " + getNomeRuolo() + "}\n";
    }
	@Override
	public int hashCode() {
		return Objects.hash(idRuolo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuoloBean other = (RuoloBean) obj;
		return Objects.equals(idRuolo, other.idRuolo);
	}
}
