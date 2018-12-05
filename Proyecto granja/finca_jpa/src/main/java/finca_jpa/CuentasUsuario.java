package finca_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cuentas_usuario database table.
 * 
 */
@Entity
@Table(name="cuentas_usuario")
@NamedQuery(name="CuentasUsuario.findAll", query="SELECT c FROM CuentasUsuario c")
public class CuentasUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CuentasUsuarioPK id;

	@Column(name="grant_date")
	private Timestamp grantDate;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rol_id")
	private Role role;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public CuentasUsuario() {
	}

	public CuentasUsuarioPK getId() {
		return this.id;
	}

	public void setId(CuentasUsuarioPK id) {
		this.id = id;
	}

	public Timestamp getGrantDate() {
		return this.grantDate;
	}

	public void setGrantDate(Timestamp grantDate) {
		this.grantDate = grantDate;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}