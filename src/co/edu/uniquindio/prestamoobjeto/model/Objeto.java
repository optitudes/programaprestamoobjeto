package co.edu.uniquindio.prestamoobjeto.model;

import co.edu.uniquindio.prestamoobjeto.exception.SinCantidadDisponibleException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Esta clase representa al objeto, sus datos y estado
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public class Objeto {

	/**
	 * Atributos de clase
	 */
	private String  nombre;
	private String  codigo;
	private String  descripcion;
	private String  color;
	private Image   foto;
	private String estado;
	private int     unidadesDisponibles;
	private int     unidadesPrestadas;
	private double  valorUnitario;
	private double  peso;
	TipoObjeto      tipoObjeto;

	/**
	 * metodo constructor de la clase Objeto
	 * @param nombre
	 * @param codigo
	 * @param descripcion
	 * @param color
	 * @param estado
	 * @param unidadesDisponibles
	 * @param valorUnitario
	 * @param peso
	 * @param valorAlquiler
	 * @param tipoObjeto
	 */
	public Objeto(String nombre, String codigo, String descripcion, String color,
			int unidadesDisponibles, double valorUnitario, double peso,  TipoObjeto tipoObjeto, Image foto) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.color = color;
		this.estado = definirEstado();
		this.unidadesDisponibles = unidadesDisponibles;
		this.valorUnitario = valorUnitario;
		this.peso = peso;
		this.tipoObjeto = tipoObjeto;
		this.foto = foto;
		this.unidadesPrestadas=0;
	}

	/**
	 * Metodo get del atributo foto
	 * @return foto
	 */
	public Image getFoto() {
		return foto;
	}

	/**
	 * Metodo set del atributo foto
	 * @param foto
	 */
	public void setFoto(Image foto) {
		this.foto = foto;
	}


	/**
	 * metodo get del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * metodo set del atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * metodo get del atributo codigo
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * metodo set del atributo codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * metodo get del atributo descripcion
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * metodo set del atributo descripcion
	 * @param descripción
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo get del atributo color
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Metodo set del color
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Metodo get del estado
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo get del atributo unidades prestadas
	 * @return unidadesPrestadas
	 */
	public int getUnidadesPrestadas() {
		return unidadesPrestadas;
	}

	/**
	 * Metodo set del atributo unidades prestadas
	 * @param unidadesPrestadas
	 */
	public void setUnidadesPrestadas(int unidadesPrestadas) {
		this.unidadesPrestadas = unidadesPrestadas;
	}

	/**
	 * Metodo set del atributo estado
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Metodo get del atributo unidadesDisponibles
	 * @return unidadesDisponibles
	 */
	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	/**
	 * Metodo set del atributo unidadesDisponibles
	 * @param unidadesDisponibles
	 */
	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	/**
	 * Metodo get del atributo valorUnitario
	 * @return valorUnitario
	 */
	public double getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * Metodo set del valor unitario
	 * @param valorUnitario
	 */
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
	 * Metodo get del atributo peso
	 * @return peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Metodo set del atributo peso
	 * @param peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Metodo get del atributo tipoObjeto
	 * @return tipoObjeto
	 */
	public TipoObjeto getTipoObjeto() {
		return tipoObjeto;
	}

	/**
	 * Metodo set del atributo tipoObjeto
	 * @param tipoObjeto
	 */
	public void setTipoObjeto(TipoObjeto tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

	/**
	 * ToString de la clase
	 */
	@Override
	public String toString() {
		return "Objeto [nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", color=" + color
				+ ", foto=" + foto + ", estado=" + estado + ", unidadesDisponibles=" + unidadesDisponibles
				+ ", valorUnitario=" + valorUnitario + ", peso=" + peso + ", tipoObjeto=" + tipoObjeto + "]";
	}

	/**
	 * Metoo que define el estado del objeto
	 * @param estadoAux
	 * @return boolean
	 */
	private String definirEstado()
	{
		if(this.unidadesDisponibles<=5)
		{
			return "No disponible";
		}else{
			return "Disponible";

		}

	}

	/**
	 * metodo que verifica si el código recibido como parametro es
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
	 * metodo que verifica la existencia de un objeto usando su codigo
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
	 * metodo que verifica la existencia de un objeto
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
 * metodo que actualiza el objeto usando los atributos
 * de otro que ingresa por parametro
 * @param objetoAux
 */
	public void actualizar(Objeto objetoAux) {

		setNombre(objetoAux.getNombre());
		setCodigo(objetoAux.getCodigo());
		setDescripcion(objetoAux.getDescripcion());
		setCodigo(objetoAux.getColor());
		setEstado(objetoAux.getEstado());
		setUnidadesDisponibles(objetoAux.getUnidadesDisponibles());
		setValorUnitario(objetoAux.getValorUnitario());
		setPeso(objetoAux.getPeso());
		setTipoObjeto(objetoAux.getTipoObjeto());
		setFoto(objetoAux.getFoto());
		setUnidadesPrestadas(objetoAux.getUnidadesPrestadas());
	}
/**
 * metodoq que reduce la cantidad de unidades disponibles
 * @param unidadesPrestadasAux
 * @throws SinCantidadDisponibleException
 */
	public void reducirUnidades(int unidadesPrestadasAux) throws SinCantidadDisponibleException {
		if(this.unidadesDisponibles>=unidadesPrestadasAux){
			this.unidadesDisponibles-=unidadesPrestadasAux;
		}else{

			throw new SinCantidadDisponibleException("no hay suficientes objetos");
		}
	}
}