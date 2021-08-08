package co.edu.uniquindio.prestamoobjeto.model;
/**
 * esta enumeracion representa el tipo de documento, siendo 1 = cedula, 2 = pasaporte
 * 3=cedula extranjera
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona brayan tangarife
 *
 */
public enum TipoDocumento
{

	CEDULA(1),PASAPORTE(2),CEDULA_EXTRANJERA(3);
	private int numTipo;

    /**
     * Constructor de la enumeracion TipoDocumento
     * @param numTipo
     */
    private TipoDocumento(int numTipo) {
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


