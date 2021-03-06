package co.edu.uniquindio.programaprestamoobjeto.model;
/**
 * esta clase representa el detale del prestamo, 
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public class DetallePrestamo {
	private int unidadesPrestadas;
	private double subTotal;
	
	private Objeto objeto=null; 
	/**
	 * método constructor de la clase detalle prestamo
	 * @param unidadesPrestadas
	 * @param subTotal
	 */
	public DetallePrestamo(int unidadesPrestadas, double subTotal) {
		this.unidadesPrestadas = unidadesPrestadas;
		this.subTotal = subTotal;
	}
	/**
	 * getters y setters de la clase detalle prestamo
	 * 
	 */
	public int getUnidadesPrestadas() {
		return unidadesPrestadas;
	}
	public void setUnidadesPrestadas(int unidadesPrestadas) {
		this.unidadesPrestadas = unidadesPrestadas;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * método toString de la clase detalle prestamo
	 */
	public String toString() {
		return "DetallePrestamo [unidadesPrestadas=" + unidadesPrestadas + ", subTotal=" + subTotal + "]";
	}
	/**
	 * método que verifica si un objeto pertenece a detalle prestamo 
	 * usando el nombre como identificador, retorna un booleano
	 * @param nombre
	 * @return respuesta
	 */
	public boolean verificarObjetoNombre(String nombre) {
		String nombreObjeto="";
		boolean respuesta=false;
		if(objeto!=null)
		{
			nombreObjeto=objeto.getNombre();
			if(nombreObjeto.equalsIgnoreCase(nombre))
			{
				respuesta=true;
				return respuesta;
			}
		}
		return respuesta;
	}
	/**
	 * método que obtiene la cantidad prestada de un objeto
	 * 
	 * @param nombre
	 * @return unidades prestadas
	 */
	public int obtenerUnidadesPrestadas(String nombre) {
		int unidadesPrestadas=0;
		String nombreObjeto="";
		if(objeto!=null)
		{
			nombreObjeto=objeto.getNombre();
			if(nombreObjeto.equalsIgnoreCase(nombre))
			{
				unidadesPrestadas=this.unidadesPrestadas;
			}
		}
		return unidadesPrestadas;
	}
	/**
     * Metodo para dar unidades disponibles
     * del objeto
     * @return Las unidades disponibles del objeto
     */
    public int darUnidadesDisponibles() {
        return objeto.getUnidadesDisponibles();
    }
    /**
     * Metodo para dar el subtotal del prestamo a realizar
     * @return subtotal
     */
    public double calcularTotal(){
        double resultado;
        double precioAlquiler;
        int    unidadesPrestadas;
        precioAlquiler=objeto.getPrecioAlquiler();
        unidadesPrestadas=this.unidadesPrestadas;
        resultado=precioAlquiler*unidadesPrestadas;     		
        return resultado;
    }
	public void setObjeto(Objeto objetoAux) {
		this.objeto=objetoAux;
		
	}
	/**
	 * método en el que un detalle de prestamo obtiene y restorna el 
	 * subtotal, el cual es el valor de alquiler del objeto
	 * @return
	 */
	public double calcularSubtotal() {
		double precioAlquiler;
		int    unidadesPrestadas;
		double resultado;
		precioAlquiler=objeto.getPrecioAlquiler();
		unidadesPrestadas=this.unidadesPrestadas;
		resultado=unidadesPrestadas*precioAlquiler;
		return resultado;
	}
	public String getCodigoObjeto() {
		String codigoObjeto;
		codigoObjeto=objeto.getCodigo();
		return codigoObjeto;
	}
	/**
	 * método que calcula el subtotal de un objeto con retraso
	 * @return
	 */
	public double getSubTotalRetraso() {
		
		double valorProducto;
		double valorIncremento;
		int    cantidad;
		double resultado;
		
		cantidad=this.unidadesPrestadas;
		valorProducto=objeto.getPrecioAlquiler();
		valorIncremento=valorProducto*0.7;
		valorProducto+=valorIncremento;
		resultado=valorProducto*cantidad;
		return resultado;
	}

	/**Punto 1
     * Metodo que verifica si el objeto está asociado al detalle prestamo
     *  para comparar el codigo del objeto debe usar el equals()
     * @param codigoObjeto
     * @return
     */
    public boolean validarObjetoPrestado(String codigoObjeto){
    	String  codigoObjetoRegistrado;
        boolean encontro = false;
        
        codigoObjetoRegistrado=objeto.getCodigo();
        if(codigoObjetoRegistrado.equalsIgnoreCase(codigoObjeto))
        {
        	encontro=true;
        }
        return encontro;
    }


	

    /**Punto 2
     * Este metodo verifica si las unidades
     *  prestadas estan en el rango mayor igual 5 a 15 unidades
     * @return cumple Rango
     */
    public boolean verificarRangoUnidades() {
    	int     unidadesPrestadas;
    	boolean cumpleRango=false;
    	
    	unidadesPrestadas=this.unidadesPrestadas;
    	
    	if(unidadesPrestadas>=5 && unidadesPrestadas<15)
    		cumpleRango=true;
    	
    	return cumpleRango;
    }

    /**Punto 3.b
     * Este metodo retorna las unidades prestadas si
     * el objeto es del tipo indicado de lo contrario retorna cero.
     * @param tipoObjeto
     * @return
     */
    public int consutarUnidadesPrestadas(TipoObjeto tipoObjeto) {
    	int unidadesPrestadas=0;
    	TipoObjeto tipoObjetoRegistrado=null;
    	
    	tipoObjetoRegistrado=objeto.getTipoObjeto();
    	
    	if(tipoObjetoRegistrado==tipoObjeto)
    	{
    		unidadesPrestadas+=this.unidadesPrestadas;
    	}
    	return unidadesPrestadas;
    }

}
