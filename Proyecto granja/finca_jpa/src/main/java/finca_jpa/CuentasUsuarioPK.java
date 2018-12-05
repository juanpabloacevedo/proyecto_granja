package finca_jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cuentas_usuario database table.
 * 
 */
@Embeddable
public class CuentasUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="usuario_id", insertable=false, updatable=false)
	private Integer usuarioId;

	@Column(name="rol_id", insertable=false, updatable=false)
	private Integer rolId;

	public CuentasUsuarioPK() {
	}
	public Integer getUsuarioId() {
		return this.usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getRolId() {
		return this.rolId;
	}
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CuentasUsuarioPK)) {
			return false;
		}
		CuentasUsuarioPK castOther = (CuentasUsuarioPK)other;
		return 
			this.usuarioId.equals(castOther.usuarioId)
			&& this.rolId.equals(castOther.rolId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuarioId.hashCode();
		hash = hash * prime + this.rolId.hashCode();
		
		return hash;
	}
}