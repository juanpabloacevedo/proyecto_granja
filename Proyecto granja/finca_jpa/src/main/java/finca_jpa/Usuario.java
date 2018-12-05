package finca_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private Integer usuarioId;

	private String apellido;

	@Column(name="created_on")
	private Timestamp createdOn;

	private String documento;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="last_login")
	private Timestamp lastLogin;

	private String nombre;

	private String password;

	//bi-directional many-to-one association to CuentasUsuario
	@OneToMany(mappedBy="usuario")
	private List<CuentasUsuario> cuentasUsuarios;

	public Usuario() {
	}

	public Integer getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CuentasUsuario> getCuentasUsuarios() {
		return this.cuentasUsuarios;
	}

	public void setCuentasUsuarios(List<CuentasUsuario> cuentasUsuarios) {
		this.cuentasUsuarios = cuentasUsuarios;
	}

	public CuentasUsuario addCuentasUsuario(CuentasUsuario cuentasUsuario) {
		getCuentasUsuarios().add(cuentasUsuario);
		cuentasUsuario.setUsuario(this);

		return cuentasUsuario;
	}

	public CuentasUsuario removeCuentasUsuario(CuentasUsuario cuentasUsuario) {
		getCuentasUsuarios().remove(cuentasUsuario);
		cuentasUsuario.setUsuario(null);

		return cuentasUsuario;
	}

}