package co.edu.uniquindio.programaprestamoobjeto.model;

public enum TipoEmpleado {

	EMPLEADO1(1),EMPLADO2(2),EMPLEADO3(3);
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
