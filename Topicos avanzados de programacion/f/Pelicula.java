package Proyecto3;
// Fig. 25.30: Persona.java
// La clase Persona representa una entrada en una libreta de direcciones.
public class Pelicula
{
   private int idPeliculas;
   private String Titulo;
   private String Genero;
   private String Directores;
   private String Escritores;
   private String Duracion;
   private boolean Activo;
   // constructor sin argumentos
   public Pelicula()
   {
   } // fin del constructor de Persona sin argumentos
   public Pelicula(int id,String titulo,String genero,String directores,String escritores,String duracion ,boolean activo)
   {
	   setIdPeliculas(id);
	   setTitulo(titulo);
	   setGenero(genero);
	   setDirectores(directores);
	   setEscritores(escritores);
	   setDuracion(duracion);
	   setActivo(activo);
   }
   // constructor
public int getIdPeliculas() {
	return idPeliculas;
}
public void setIdPeliculas(int idPeliculas) {
	this.idPeliculas = idPeliculas;
}
public String getTitulo() {
	return Titulo;
}
public void setTitulo(String titulo) {
	Titulo = titulo;
}
public String getGenero() {
	return Genero;
}
public void setGenero(String genero) {
	Genero = genero;
}
public String getDirectores() {
	return Directores;
}
public void setDirectores(String directores) {
	Directores = directores;
}
public String getEscritores() {
	return Escritores;
}
public void setEscritores(String escritores) {
	Escritores = escritores;
}
public String getDuracion() {
	return Duracion;
}
public void setDuracion(String duracion) {
	Duracion = duracion;
}
public boolean isActivo() {
	return Activo;
}
public void setActivo(boolean activo) {
	Activo = activo;
}
  
   
} // fin de la clase Persona


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/



 