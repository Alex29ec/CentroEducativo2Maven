package Principal.Entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "valoracionmateria")
public class ValoracionMateria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idProfesor, idMateria, idEstudiante;
	@Column(name="fecha")
	Date date;
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	private float valoracion;


	public int getId() {

		return id;

	}


	public void setId(int id) {

		this.id = id;

	}


	public int getIdProfesor() {

		return idProfesor;

	}


	public void setIdProfesor(int idProfesor) {

		this.idProfesor = idProfesor;

	}


	public int getIdMateria() {

		return idMateria;

	}


	public void setIdMateria(int idMateria) {

		this.idMateria = idMateria;

	}


	public int getIdEstudiante() {

		return idEstudiante;

	}


	public void setIdEstudiante(int idEstudiante) {

		this.idEstudiante = idEstudiante;

	}


	public float getValoracion() {

		return valoracion;

	}


	public void setValoracion(float valoracion) {

		this.valoracion = valoracion;

	}



}
