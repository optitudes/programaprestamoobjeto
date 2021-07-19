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
	private String telResidencia;
	private String telCelular;
	private String direccion;
	private String nombre;
	private String genero;
	private String ciudadRecidencia;
	private String departamento;
	private String pais;
	private String profeccion;
	private String correo;
	private TipoDocumento tipoDocumento=null;
	/**
	 * método constructor de la clase cliente
	 * @param documento
	 * @param telResidencia
	 * @param telCelular
	 * @param nombre
	 * @param genero
	 * @param ciudadRecidencia
	 * @param departamento
	 * @param pais
	 * @param profeccion
	 * @param correo
	 * @param tipoDocumento
	 */
	public Cliente(String documento, String telResidencia, String telCelular, String nombre, String genero,
			String ciudadRecidencia, String departamento, String pais, String profeccion, String correo,
			int tipoDocumento,String direccion) {
		super();
		this.documento = documento;
		this.telResidencia = telResidencia;
		this.telCelular = telCelular;
		this.nombre = nombre;
		this.genero = genero;
		this.ciudadRecidencia = ciudadRecidencia;
		this.departamento = departamento;
		this.pais = pais;
		this.profeccion = profeccion;
		this.correo = correo;
		this.tipoDocumento = definirTipoDocumento(tipoDocumento);
		this.direccion=direccion;
	}
	/**
	 * getters y setters de la clase
	 * @return
	 */
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelResidencia() {
		return telResidencia;
	}

	public void setTelResidencia(String telResidencia) {
		this.telResidencia = telResidencia;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProfeccion() {
		return profeccion;
	}

	public void setProfeccion(String profeccion) {
		this.profeccion = profeccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * ToString de la clase cliente
	 */
	public String toString() {
		return "Cliente [documento=" + documento + ", telResidencia=" + telResidencia + ", telCelular=" + telCelular
				+ ", nombre=" + nombre + ", genero=" + genero + ", ciudadRecidencia=" + ciudadRecidencia
				+ ", departamento=" + departamento + ", pais=" + pais + ", profeccion=" + profeccion + ", correo="
				+ correo + ", tipoDocumento=" + tipoDocumento + "]";
	}

	/**
	 * Metodo para definir el tipo de documento
	 * @param tipoDocumento
	 * @return TipoDocumento
	 */
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
