package Principal.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor extends Entidad {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idSexo;
	private String nombre;
	@Column(name = "apellido1")
	private String apellido_1; 

	@Column(name = "apellido2")
	private String apellido_2;
	private String DNI,Direccion,email,telefono, colorpreferido;
	
	public String getColorpreferido() {
		return colorpreferido;
	}

	public void setColorpreferido(String colorpreferido) {
		this.colorpreferido = colorpreferido;
	}

	@Override
	public String toString() {
		return  nombre + " " + apellido_1 + " " + apellido_2 ;
	}

	private byte[] imagen;
 	
	public int getIdSexo() {
		return idSexo;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public String getApellido_1() {
		return apellido_1;
	}

	public void setApellido_1(String apellido_1) {
		this.apellido_1 = apellido_1;
	}

	public String getApellido_2() {
		return apellido_2;
	}

	public void setApellido_2(String apellido_2) {
		this.apellido_2 = apellido_2;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Profesor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
