package co.edu.uniquindio.programaprestamoobjeto.model;
/**
 * esta enumeración representa el tipo de documento, siendo 1 = cedula, 2 = pasaporte
 * 3=cedula extranjera
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public enum TipoDocumento 
{	
	
	CEDULA(1),PASAPORTE(2),CEDULA_EXTRANJERA(3);
	private int numTipo;

    /**
     * Constructor de la enumeración TipoDocumento
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


