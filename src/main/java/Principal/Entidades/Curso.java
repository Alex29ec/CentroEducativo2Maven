package Principal.Entidades;

public class Curso {
int id;
String descripcion;

public Curso() {
	super();
}


@Override
public String toString() {
	return descripcion;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
}
