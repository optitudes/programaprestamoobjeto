package co.edu.uniquindio.prestamoobjeto.model;
/**
 * Esta clase representa al cliente, su informacion personal y
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona-Brayan Tangarife
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
	private String profesion;
	private String correo;
	private TipoDocumento tipoDocumento=null;
	private String apellido;
	/**
	 * Método constructor de la clase cliente
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
	public Cliente(String apellido, String documento, String telResidencia, String telCelular, String nombre, String genero,
			String ciudadRecidencia, String departamento, String pais, String profesion, String correo,
			String tipoDocumento,String direccion) {
		super();
		this.apellido = apellido;
		this.documento = documento;
		this.telResidencia = telResidencia;
		this.telCelular = telCelular;
		this.nombre = nombre;
		this.genero = genero;
		this.ciudadRecidencia = ciudadRecidencia;
		this.departamento = departamento;
		this.pais = pais;
		this.profesion = profesion;
		this.correo = correo;
		this.tipoDocumento = definirTipoDocumento(tipoDocumento);
		this.direccion=direccion;
	}


	/**
	 * Metodo get del atributo documento
	 * @return documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * Metodo set se atributo documento
	 * @param documento
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * Metodo get del atributo telResidencia
	 * @return telResidencia
	 */
	public String getTelResidencia() {
		return telResidencia;
	}

	/**
	 * Metodo set se atributo telResidencia
	 * @param telResidencia
	 */
	public void setTelResidencia(String telResidencia) {
		this.telResidencia = telResidencia;
	}

	/**
	 * Metodo get del atributo telCelular
	 * @return telCelular
	 */
	public String getTelCelular() {
		return telCelular;
	}

	/**
	 * Metodo set se atributo telCelular
	 * @param telCelular
	 */
	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	/**
	 * Metodo get del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set se atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get del atributo genero
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Metodo set se atributo genero
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Metodo get del atributo ciudadRecidencia
	 * @return ciudadRecidencia
	 */
	public String getCiudadRecidencia() {
		return ciudadRecidencia;
	}

	/**
	 * Metodo set del atributo ciudadRecidencia
	 * @param ciudadRecidencia
	 */
	public void setCiudadRecidencia(String ciudadRecidencia) {
		this.ciudadRecidencia = ciudadRecidencia;
	}

	/**
	 * Metodo get del atributo departamento
	 * @return departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * Metodo set del atributo departamento
	 * @param departamento
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * Metodo get del atributo pais
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Metodo set del atributo pais
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Metodo get del atributo profesion
	 * @return profesion
	 */
	public String getProfesion() {
		return profesion;
	}

	/**
	 * Metodo set se atributo profesion
	 * @param profesion
	 */
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	/**
	 * Metodo get del atributo correo
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Metodo set se atributo correo
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Metodo get del atributo tipoDocumento
	 * @return tipoDocumento
	 */
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * Metodo set se atributo tipoDocumento
	 * @param tipoDocumento
	 */
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Metodo get del atributo direccion
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo set se atributo direccion
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo get del atributo apellido
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Metodo set se atributo apellido
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * ToString de la clase cliente
	 */

	@Override
	public String toString() {
		return "Cliente [documento=" + documento + ", telResidencia=" + telResidencia + ", telCelular=" + telCelular
				+ ", direccion=" + direccion + ", nombre=" + nombre + ", genero=" + genero + ", ciudadRecidencia="
				+ ciudadRecidencia + ", departamento=" + departamento + ", pais=" + pais + ", profesion=" + profesion
				+ ", correo=" + correo + ", tipoDocumento=" + tipoDocumento + ", apellido=" + apellido + "]";
	}

	/**
	 * Metodo para definir el tipo de documento
	 * @param tipoDocumento
	 * @return TipoDocumento
	 */
	public TipoDocumento definirTipoDocumento(String tipoDocumento) {
		TipoDocumento tipoDocumentoAux=null;
		if(tipoDocumento.equals("CEDULA"))
		{
			tipoDocumentoAux=TipoDocumento.CEDULA;
			return tipoDocumentoAux;
		}
		else
		{
			if(tipoDocumento.equals("PASAPORTE"))
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

	/**
	 * método que verifica si el documento ingresado por parametro
	 * es igual al documento de la clase
	 * @param documentoAux
	 * @return coinciden(true si coinciden, false de lo contrario)
	 */
	public boolean verificarDocumento(String documentoAux) {
		boolean coinciden=false;
		if(this.documento.equals(documentoAux))
			coinciden=true;
		return coinciden;
	}


	public void actualizarDatos(Cliente clienteAux) {
		setApellido(clienteAux.getApellido());
		setDocumento(clienteAux.getDocumento());
		setTelResidencia(clienteAux.getTelResidencia());
		setTelCelular(clienteAux.getTelCelular());
		setNombre(clienteAux.getNombre());
		setGenero(clienteAux.getGenero());
		setCiudadRecidencia(clienteAux.getCiudadRecidencia());
		setDepartamento(clienteAux.getDepartamento());
		setPais(clienteAux.getPais());
		setProfesion(clienteAux.getProfesion());
		setCorreo(clienteAux.getCorreo());
		setTipoDocumento(clienteAux.getTipoDocumento());
		setDireccion(clienteAux.getDireccion());
	}
}
