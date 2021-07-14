package co.edu.uniquindio.prestamoobjetos.model;

public class Empleado {


	//Declaracion de atributos
	private String nombre;
	private String codigo;
	private String correo;
	private String aniosExperiencia;


	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Construtor Empleado
	 * @param nombre, codigo, correo, aniosExperiencia
	 */
	public Empleado(String nombre, String codigo, String correo, String aniosExperiencia) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.correo = correo;
		this.aniosExperiencia = aniosExperiencia;
	}

	//Metodos Getters and Setters-------------------------------------------->
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
	public String getAniosExperiencia() {
		return aniosExperiencia;
	}
	public void setAniosExperiencia(String aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return "Empleado: " + nombre + "\nCódigo: " + codigo + "\nCorreo: " + correo + "\nAños de Experiencia: "
				+ aniosExperiencia;
	}


}
