package co.edu.uniquindio.programaprestamoobjeto.model;
/**
 * Esta clase representa al cliente, su información personnal y 
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public class Cliente {
	/**
	 * atributos de la clase
	 */
	private String documento;
	private String nombre;
	private String genero;
	private String ciudadRecidencia;
	private TipoDocumento tipoDocumento=null;
	/**
	 * método constructor de la clase
	 * @param documento
	 * @param nombre
	 * @param genero
	 * @param ciudadRecidencia
	 * @param tipoDocumento
	 */
	public Cliente(String documento, String nombre, String genero, String ciudadRecidencia,
			int tipoDocumento) {
		
		this.documento = documento;
		this.nombre    = nombre;
		this.genero    = genero;
		this.ciudadRecidencia = ciudadRecidencia;
		this.tipoDocumento    = definirTipoDocumento(tipoDocumento);
	}
	/**
	 * getters y setters de la clase 
	 */
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCiudadRecidencia() {
		return ciudadRecidencia;
	}
	public void setCiudadRecidencia(String ciudadRecidencia) {
		this.ciudadRecidencia = ciudadRecidencia;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * método toString de la clase
	 */
	public String toString() {
		return "Cliente [documento=" + documento + ", nombre=" + nombre + ", genero=" + genero + ", ciudadRecidencia="
				+ ciudadRecidencia + ", tipoDocumento=" + tipoDocumento + "]";
	}
	public static void crearCliente(String documento2, String nombre2, String genero2, String ciudadResidencia,
			int tipoDocumento2) {
		// TODO Auto-generated method stub
		
	}
	public TipoDocumento definirTipoDocumento(int tipoDocumento) {
		TipoDocumento tipoDocumentoAux=null;
		if(tipoDocumento==TipoDocumento.CEDULA.getNumTipo())
		{
			tipoDocumentoAux=TipoDocumento.CEDULA;
			return tipoDocumentoAux;
		}
		else
		{
			if(tipoDocumento==TipoDocumento.PASAPORTE.getNumTipo())
			{
				tipoDocumentoAux=TipoDocumento.PASAPORTE;
				return tipoDocumentoAux;
			}
			else
			{
				tipoDocumentoAux=TipoDocumento.CEDULA_EXTRANJERA;
				return tipoDocumentoAux;
			}
				
		}
		
		
	}
	
	public boolean verificarCodigoCiudad(String documentoVerificar, String ciudadVerificar) {
       boolean coinciden=false;
       String codigoClienteRegistrado;
       String ciudadClienteRegistrado;
       codigoClienteRegistrado=this.documento;
       ciudadClienteRegistrado=this.ciudadRecidencia;
       
       if(codigoClienteRegistrado.equalsIgnoreCase(documentoVerificar) && ciudadClienteRegistrado.equalsIgnoreCase(ciudadVerificar))
       {
       	coinciden=true;
       }
       return coinciden;

 }


}
