package finca_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rol_id")
	private Integer rolId;

	@Column(name="nombre_rol")
	private String nombreRol;

	//bi-directional many-to-one association to CuentasUsuario
	@OneToMany(mappedBy="role")
	private List<CuentasUsuario> cuentasUsuarios;

	public Role() {
	}

	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<CuentasUsuario> getCuentasUsuarios() {
		return this.cuentasUsuarios;
	}

	public void setCuentasUsuarios(List<CuentasUsuario> cuentasUsuarios) {
		this.cuentasUsuarios = cuentasUsuarios;
	}

	public CuentasUsuario addCuentasUsuario(CuentasUsuario cuentasUsuario) {
		getCuentasUsuarios().add(cuentasUsuario);
		cuentasUsuario.setRole(this);

		return cuentasUsuario;
	}

	public CuentasUsuario removeCuentasUsuario(CuentasUsuario cuentasUsuario) {
		getCuentasUsuarios().remove(cuentasUsuario);
		cuentasUsuario.setRole(null);

		return cuentasUsuario;
	}

}