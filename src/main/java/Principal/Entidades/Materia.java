package Principal.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia extends Entidad{
@Override
	public String toString() {
		return  nombre;
	}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int cursoId;
private String nombre;
private String acronimo;

public Materia() {
	super();
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCursoId() {
	return cursoId;
}
public void setCursoId(int cursoId) {
	this.cursoId = cursoId;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getAcronimo() {
	return acronimo;
}
public void setAcronimo(String acronimo) {
	this.acronimo = acronimo;
}
}
