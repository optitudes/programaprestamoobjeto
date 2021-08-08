package co.edu.uniquindio.prestamoobjeto.model;
/**
 * Esta clase representa al empleado, su informacion personal y
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona brayan tamgarife
 *
 */
public class Empleado {

	/**
	 * Atributos de la clase
	 */
	private String documento;
	private String nombre;
	private String apellido;
	private String telResidencia;
	private String telCelular;
	private String direccion;
	private String ciudadResidencia;
	private String departamento;
	private String pais;
	private String correo;
	private int    aniosExperiencia;
	private TipoDocumento tipoDocumento=null;
	private TipoEmpleado tipoEmpleado=null;

	/**
	 * Constructor de la clase Empleado
	 * @param documento
	 * @param nombre
	 * @param telResidencia
	 * @param telCelular
	 * @param direccion
	 * @param ciudadResidencia
	 * @param departamento
	 * @param pais
	 * @param correo
	 * @param tipoDocumento
	 * @param tipoEmpleado
	 */
	public Empleado(String nombre, String apellido, String documento, String direccion, String ciudad,
			String departamento, int aniosExperiencia, String pais, String telResidencia, String telCelular,
			String correo, String tipoDocumento, String tipoEmpleado) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telResidencia = telResidencia;
		this.telCelular = telCelular;
		this.direccion = direccion;
		this.ciudadResidencia = ciudad;
		this.departamento = departamento;
		this.pais = pais;
		this.correo = correo;
		this.tipoDocumento = definirTipoDocumento(tipoDocumento);
		this.tipoEmpleado = definirTipoEmpleado(tipoEmpleado);
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * Metodo get del atributo apillido
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Metodo set del atributo apellido
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Metodo get del atributo años de experiencia
	 * @return años de experiencia
	 */
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	/**
	 * Metodo set del atributo años de experiencia
	 * @param aniosExperiencia
	 */
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}


	/**
	 * Metodo get del atributo documento
	 * @return documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * Metodo set del atributo documento
	 * @param documento
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * Metodo get del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set del atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get del atributo tel residencia
	 * @return telResidencia
	 */
	public String getTelResidencia() {
		return telResidencia;
	}

	/**
	 * Metodo set del atributo tel residencia
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
	 * Metodo set del atributo celular
	 * @param telCelular
	 */
	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	/**
	 * Metodo get del atributo direccion
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo set del atributo direccion
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo get del atributo cuidadResidencia
	 * @return cuidadResidencia
	 */
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	/**
	 * Metodo set del atributo cuidad residencia
	 * @param ciudadResidencia
	 */
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
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
	 * Metodo get del atributo correo
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Metodo set del atributo correo
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Metodo get del atributo tipo documento
	 * @return tipoDocumento
	 */
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * Metodo set del atributo tipoDocumento
	 * @param tipoDocumento
	 */
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Metodo get del atributo tipo empleado
	 * @return tipoEmpleado
	 */
	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	/**
	 * Metodo set del atributo tipoEmpleado
	 * @param tipoEmpleado
	 */
	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	/**
	 * metodo toString de la clase empleado
	 */
	public String toString() {
		return "Empleado [documento=" + documento + ", nombre=" + nombre + ", telResidencia=" + telResidencia
				+ ", telCelular=" + telCelular + ", direccion=" + direccion + ", ciudadResidencia=" + ciudadResidencia
				+ ", departamento=" + departamento + ", pais=" + pais + ", correo=" + correo + ", tipoDocumento="
				+ tipoDocumento + ", tipoObjeto=" + tipoEmpleado + "]";
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

	/**
	 * Metodo para definir el tipo de empleado
	 * @param tipoEmpleado
	 * @return tipoEmpleado
	 */
	private TipoEmpleado definirTipoEmpleado(String tipoEmpleado) {
		TipoEmpleado tipoEmpleadoAux=null;
		if(tipoEmpleado.equals("ADMINISTRADOR"))
		{
			tipoEmpleadoAux=TipoEmpleado.ADMINISTRADOR;
			return tipoEmpleadoAux;
		}
		else
		{
				tipoEmpleadoAux=TipoEmpleado.OFICINISTA;
				return tipoEmpleadoAux;

		}
	}

	public void actualizar(Empleado empleadoAux) {
		setDocumento(empleadoAux.getDocumento());
		setNombre(empleadoAux.getNombre());
		setApellido(empleadoAux.getApellido());
		setTelResidencia(empleadoAux.getTelResidencia());
		setTelCelular(empleadoAux.getTelCelular());
		setDireccion(empleadoAux.getDireccion());
		setCiudadResidencia(empleadoAux.getCiudadResidencia());
		setDepartamento(empleadoAux.getDepartamento());
		setPais(empleadoAux.getPais());
		setCorreo(empleadoAux.getCorreo());
		setTipoDocumento(empleadoAux.getTipoDocumento());
		setTipoEmpleado(empleadoAux.getTipoEmpleado());
		setAniosExperiencia(empleadoAux.getAniosExperiencia());

	}

}
