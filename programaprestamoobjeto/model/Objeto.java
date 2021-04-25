package co.edu.uniquindio.programaprestamoobjeto.model;
/**
 * Esta clase representa al objeto, sus datos y estado
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public class Objeto {
	private String nombre;
	private String codigo;
	private String estado;
	private int    unidadesDisponibles;
	private double precioAlquiler;
	TipoObjeto tipoObjeto=null;
	/**
	 * método constructor de la clase objeto
	 * @param nombre
	 * @param codigo
	 * @param estado
	 * @param unidadesDispobles
	 * @param precioAlquiler
	 */
	public Objeto(String nombre, String codigo, String estado, int unidadesDisponibles, double precioAlquiler,
			TipoObjeto tipoObjeto) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.estado = estado;
		this.unidadesDisponibles = unidadesDisponibles;
		this.precioAlquiler = precioAlquiler;
		this.tipoObjeto = tipoObjeto;
	}
	/**
	 * setters y getters de la clase objeto
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}
	public void setUnidadesDispobles(int unidadesDispobles) {
		this.unidadesDisponibles = unidadesDispobles;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	
	public TipoObjeto getTipoObjeto() {
		return tipoObjeto;
	}
	public void setTipoObjeto(TipoObjeto tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}
	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}
	/**
	 * método toString para la clase objeto
	 */
	public String toString() {
		return "Objeto [nombre=" + nombre + ", codigo=" + codigo + ", estado=" + estado + ", unidadesDisponibles="
				+ unidadesDisponibles + ", precioAlquiler=" + precioAlquiler + ", tipoObjeto=" + tipoObjeto + "]";
	}
	/**
	 * método que verifica si el código recibido como parametro es 
	 * igual al codigo del objeto, si lo es retorna un true, sino 
	 * retorna un false
	 * @param codigo
	 * @return centinela
	 */
	public boolean verificarCodigo(String codigo) {
        boolean centinela = false;

        if (this.codigo.equals( codigo ))
        {
            centinela= true;
        }


        return centinela;
    }
	
	/**
	 * método que verifica la existencia de un objeto usando su codigo
	 * @param codigoObjetoBuscar
	 * @return
	 */
	public boolean verificarExistencia(String codigoObjetoBuscar) {
		boolean respuesta=false;
		String codigoObjeto=this.codigo;
		if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
		{
			respuesta=true;
			return respuesta;
		}
		return false;
	}
	/**
	 * método que verifica la existencia de un objeto
	 * usando su nombre
	 * @param nombreObjetoBuscar
	 * @return
	 */
	public boolean verificarExistenciaNombre(String nombreObjetoBuscar) {
		boolean respuesta=false;
		String nombreObjeto=this.nombre;
		if(nombreObjeto.equalsIgnoreCase(nombreObjetoBuscar))
		{
			respuesta=true;
			return respuesta;
		}
		return false;
	}
	/**
	 * método que define el tipo del documento y lo setea
	 * @param tipoDocumento
	 */
	public void definirTipoObjeto(int tipoObjeto) {
		TipoObjeto tipoObjetoAux=null;
		if(tipoObjeto==TipoObjeto.ELECTRODOMESTICOS.getNumTipo())
		{
			tipoObjetoAux=TipoObjeto.ELECTRODOMESTICOS;
			setTipoObjeto(tipoObjetoAux);
		}
		else
		{
			if(tipoObjeto==TipoObjeto.MUEBLES.getNumTipo())
			{
				tipoObjetoAux=TipoObjeto.MUEBLES;
				setTipoObjeto(tipoObjetoAux);			}
			else
			{
				tipoObjetoAux=TipoObjeto.CONSTRUCCION;
				setTipoObjeto(tipoObjetoAux);			}
				
		}
		
		
	}

	
	
	

}
