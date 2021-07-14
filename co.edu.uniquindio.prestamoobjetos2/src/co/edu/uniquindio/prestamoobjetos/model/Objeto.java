package co.edu.uniquindio.prestamoobjetos.model;

public class Objeto {

	//Declaración de atributos
	private String codigo;
	private String nombre;
	private int unidadesDisponibles;
	private String estado;
	private double precioAlquiler;

	/**
	 *
	 */
	public Objeto() {

	}

	/**
	 * Constructor clase objeto
	 * @param codigo, nombre, unidadesDisponibles, estado, precioAlquiler
	 */
	public Objeto(String codigo, String nombre, int unidadesDisponibles, double precioAlquiler) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.unidadesDisponibles = unidadesDisponibles;
		this.precioAlquiler = precioAlquiler;
	}

	//Métodos Getters and Setters------------------------------------------------>
	public Objeto(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}
	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	//------------------------------------------------------------------------------------|

	@Override
	public String toString() {
		return "Código: " + codigo + "\nNombre: " + nombre + "\nUnidadesDisponibles: " + unidadesDisponibles
			     + "\nPrecioAlquiler: " + precioAlquiler;
	}
}
