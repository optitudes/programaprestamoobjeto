package co.edu.uniquindio.programaprestamoobjeto.model;
/**
 * esta enumeración representa el tipo de objeto, siendo 1 = cedula, 2 = pasaporte
 * 3=cedula extranjera
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public enum TipoObjeto
{	
	
	ELECTRODOMESTICOS(1),MUEBLES(2),CONSTRUCCION(3);
	private int numTipo;

    /**
     * Constructor de la enumeración TipoObjeto
     * @param numTipo
     */
    private TipoObjeto(int numTipo) {
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

