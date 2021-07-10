package co.edu.uniquindio.programaprestamoobjetos.model;
/**
 * Esta clase representa al empleado, su información personal y
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public class Empleado {
	private String nombre;
	private String codigo;
	private String correo;
	private String aniosExperiencia;
	/**
	 * constructor de la clase empleado
	 * @param nombre
	 * @param codigo
	 * @param correo
	 * @param aniosExperiencia
	 */
	public Empleado(String nombre, String codigo, String correo, String aniosExperiencia) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.correo = correo;
		this.aniosExperiencia = aniosExperiencia;
	}
	/**
	 * getters y setters de la clase
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getAniosExperiencia() {
		int aniosExperienciaInt;
		aniosExperienciaInt=Integer.parseInt(aniosExperiencia);
		return aniosExperienciaInt;
	}
	public void setAniosExperiencia(int aniosExperienciaInt) {
		this.aniosExperiencia =""+aniosExperiencia;
	}
	/**
	 * metodo toString de la clase empleado
	 */
	public String toString() {
		return "Empleado [nombre=" + nombre + ", codigo=" + codigo + ", correo=" + correo + ", aniosExperiencia="
				+ aniosExperiencia + "]";
	}


}
