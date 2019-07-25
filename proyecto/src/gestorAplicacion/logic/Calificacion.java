package gestorAplicacion.logic;
import java.util.ArrayList;

import BaseDatos.Datos;
import gestorAplicacion.users.*;

public class Calificacion {
	
	private String codigo;        //identificador = codigo comida a la que califica.
	private String puntaje;
	private Comida comida;
	private Usuario usuario;
	private String comentario;
	private static ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();  
	
	public Calificacion() {
		
	}
	
	public Calificacion (String codigo, String puntaje, Usuario usuario){
		this.codigo = codigo;
		this.puntaje=puntaje;
		this.usuario = usuario;
	}
	public Calificacion (String codigo, Comida comida, String puntaje, Usuario usuario){
		this.codigo = codigo;
		this.comida = comida;
		this.puntaje=puntaje;
		this.usuario = usuario;
	}
	public Calificacion (String codigo, String puntaje){
		this.codigo = codigo;
		this.puntaje=puntaje;
	}
	public Calificacion (String codigo, Comida comida, String puntaje, String comentario){
		this.codigo = codigo;
		this.comida = comida;
		this.puntaje=puntaje;
		this.comentario = comentario;
	}
	
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}
	
	public Comida getComida() {
		return comida;
	}
	
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public static ArrayList<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	public static void setCalificaciones(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	
	public static void crearCalificacion(String codigo, String puntaje, Usuario usuario) {                
		Calificacion calificacion = new Calificacion(codigo, puntaje, usuario);   //No podemos guardar datos en la hash(se sobreescriben)
		Datos.calificaciones.add(calificacion);	        
		Calificacion.setCalificaciones(calificacion);
	}
	
}
