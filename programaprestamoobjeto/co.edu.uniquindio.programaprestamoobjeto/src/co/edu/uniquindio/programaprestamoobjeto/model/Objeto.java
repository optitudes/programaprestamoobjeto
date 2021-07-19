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
	private String descripción;
	private String color;
	private boolean estado;
	private int    unidadesDisponibles;
	private double valorUnitario;
	private double peso;
	private double valorAlquiler;
	TipoObjeto tipoObjeto;
	/**
	 * método constructor de la clase Objeto
	 * @param nombre
	 * @param codigo
	 * @param descripción
	 * @param color
	 * @param estado
	 * @param unidadesDisponibles
	 * @param valorUnitario
	 * @param peso
	 * @param valorAlquiler
	 * @param tipoObjeto
	 */
	public Objeto(String nombre, String codigo, String descripción, String color,String estado,
			int unidadesDisponibles, double valorUnitario, double peso, double valorAlquiler, int tipoObjeto) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripción = descripción;
		this.color = color;
		this.estado = definirEstado(estado);
		this.unidadesDisponibles = unidadesDisponibles;
		this.valorUnitario = valorUnitario;
		this.peso = peso;
		this.valorAlquiler = valorAlquiler;
		this.tipoObjeto =definirTipoObjeto(tipoObjeto); 
	}
	/**
	 * método get del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * método set del atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * método get del atributo codigo
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * método set del atributo codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * método get del atributo descripcion
	 * @return
	 */
	public String getDescripción() {
		return descripción;
	}
	/**
	 * método set del atributo descripcion
	 * @param descripción
	 */
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}
	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getValorAlquiler() {
		return valorAlquiler;
	}
	public void setValorAlquiler(double valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}
	public TipoObjeto getTipoObjeto() {
		return tipoObjeto;
	}
	public void setTipoObjeto(TipoObjeto tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}
	
	@Override
	public String toString() {
		return "Objeto [nombre=" + nombre + ", codigo=" + codigo + ", descripción=" + descripción + ", color=" + color
				+ ", estado=" + estado + ", unidadesDisponibles=" + unidadesDisponibles + ", valorUnitario="
				+ valorUnitario + ", peso=" + peso + ", valorAlquiler=" + valorAlquiler + ", tipoObjeto=" + tipoObjeto
				+ "]";
	}
	private static boolean definirEstado(String estadoAux)
	{
		String estadoAux2="disponible";
		boolean estadoAux3=false;
		if(estadoAux.equalsIgnoreCase(estadoAux2))
			estadoAux3=true;
		return estadoAux3;
		
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
	 * @return 
	 */
	public TipoObjeto definirTipoObjeto(int tipoObjeto) {
		TipoObjeto tipoObjetoAux=null;
		if(tipoObjeto==TipoObjeto.ELECTRODOMESTICOS.getNumTipo())
		{
			tipoObjetoAux=TipoObjeto.ELECTRODOMESTICOS;
		}
		else
		{
			if(tipoObjeto==TipoObjeto.MUEBLES.getNumTipo())
			{
				tipoObjetoAux=TipoObjeto.MUEBLES;
			}else
				{
					tipoObjetoAux=TipoObjeto.CONSTRUCCION;
				}

		}
		return tipoObjetoAux;
	}
	/**
	 * método que verifica si el precio del alquiler es mayor al
	 * precio mayor,
	 * @param precioMayor
	 * @return esMayor
	 */
	public boolean validarPrecioMayor(double precioMayor) {
		boolean esMayor=false;
		if(valorAlquiler>precioMayor)
			esMayor=true;
		return esMayor;
	}

	
	
	

}
