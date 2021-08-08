package co.edu.uniquindio.prestamoobjeto.model;

/**
 * esta enumeracion representa el tipo de Empleado siendo 1 administrativo
 * y 2 oficinista
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona brayan tangarife
 *
 */
public enum TipoEmpleado {

	ADMINISTRADOR(1),OFICINISTA(2);
	private int numTipo;

	/**
	 * Constructor de la enumeración TipoEmpleado
	 * @param numTipo
	 */
	private TipoEmpleado(int numTipo) {
		this.numTipo = numTipo;
	}

	/**
	 * Metodo get del atributo numTipo
	 * @return numTipo
	 */
	public int getNumTipo() {
		return numTipo;
	}

}
