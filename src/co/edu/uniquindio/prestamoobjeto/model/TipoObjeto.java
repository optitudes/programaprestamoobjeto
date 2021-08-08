package co.edu.uniquindio.prestamoobjeto.model;
/**
 * esta enumeracion representa el tipo de  objeto 1 electrodomesticos, 2 muebles y 3 construccion
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public enum TipoObjeto
{

	ELECTRODOMESTICOS(1),MUEBLES(2),CONSTRUCCION(3);
	private int numTipo;

    /**
     * Constructor de la enumeracion TipoObjeto
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

