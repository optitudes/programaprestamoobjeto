package co.edu.uniquindio.programaprestamoobjeto.model;
/**
 * Esta clase representa al empleado, su informacion personal y
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public class Empleado {

	//Atributos de la clase
	private String documento;
	private String nombre;
	private String telResidencia;
	private String telCelular;
	private String direccion;
	private String ciudadResidencia;
	private String departamento;
	private String pais;
	private String correo;
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
	public Empleado(String documento, String nombre, String telResidencia, String telCelular, String direccion,
			String ciudadResidencia, String departamento, String pais, String correo, int tipoDocumento,
			int tipoEmpleado) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.telResidencia = telResidencia;
		this.telCelular = telCelular;
		this.direccion = direccion;
		this.ciudadResidencia = ciudadResidencia;
		this.departamento = departamento;
		this.pais = pais;
		this.correo = correo;
		this.tipoDocumento = definirTipoDocumento(tipoDocumento);
		this.tipoEmpleado = definirTipoEmpleado(tipoEmpleado);
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
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

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

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
	 * Metodo para definir el tipo de objeto
	 * @param tipoObjeto
	 * @return TipoObjeto
	 */
//	private TipoObjeto definirTipoObjeto(int tipoObjeto) {
//		TipoObjeto tipoObjetoAux=null;
//		if(tipoObjeto==TipoObjeto.ELECTRODOMESTICOS.getNumTipo())
//		{
//			tipoObjetoAux=TipoObjeto.ELECTRODOMESTICOS;
//			return tipoObjetoAux;
//		}
//		else
//		{
//			if(tipoObjeto==TipoObjeto.MUEBLES.getNumTipo())
//			{
//				tipoObjetoAux=TipoObjeto.MUEBLES;
//				return tipoObjetoAux;
//			}
//			else
//			{
//				tipoObjetoAux=TipoObjeto.CONSTRUCCION;
//				return tipoObjetoAux;
//			}
//
//		}
//	}

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

	/**
	 * Metodo para definir el tipo de empleado
	 * @param tipoEmpleado
	 * @return tipoEmpleado
	 */
	private TipoEmpleado definirTipoEmpleado(int tipoEmpleado) {
		TipoEmpleado tipoEmpleadoAux=null;
		if(tipoEmpleado==TipoEmpleado.EMPLEADO1.getNumTipo())
		{
			tipoEmpleadoAux=TipoEmpleado.EMPLEADO1;
			return tipoEmpleadoAux;
		}
		else
		{
			if(tipoEmpleado==TipoEmpleado.EMPLADO2.getNumTipo())
			{
				tipoEmpleadoAux=TipoEmpleado.EMPLADO2;
				return tipoEmpleadoAux;
			}
			else
			{
				tipoEmpleadoAux=TipoEmpleado.EMPLEADO3;
				return tipoEmpleadoAux;
			}

		}
	}

}
