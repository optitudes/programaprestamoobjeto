package co.edu.uniquindio.prestamoobjeto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Calendar;

/**
 * esta clase representa el prestamo, contiene la informacion del
 * prestamo a solicitar
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona Brayan felipe Tangarife Rios
 */
public class Prestamo {

	/**
	 * Atributos de la clase
	 */
	private String   codigo;
	private String   estado;
	private int      TotalObtejosPrestados;
	private long      diasTranscurridos;
	private long      diasSolicitados;
	private double   valor;
	private LocalDate fechaPrestamo;
	private LocalDate fechaEntrega;
	private Cliente cliente=null;
	private Empleado empleado=null;

	private ArrayList<DetallePrestamo> listaDetallesPrestamos;
	public ArrayList<DetallePrestamo> obtenerDetallePrestamo;

	/**
	 *
	 * @param codigoPrestamo
	 * @param fechaEntrega2
	 * @param documentoCliente
	 * @param documentoEmpleado
	 */
	public Prestamo(String codigoPrestamo, LocalDate fechaEntrega, Cliente cliente, Empleado empleado) {
		this.codigo = codigoPrestamo;
		this.estado = "";
		this.fechaPrestamo = LocalDate.now();
		this.fechaEntrega = fechaEntrega;
		this.TotalObtejosPrestados =0;
		this.diasTranscurridos=0;
		this.cliente = cliente;
		this.empleado = empleado;
		this.listaDetallesPrestamos = new ArrayList<>();
		this.diasSolicitados=0;
		this.valor =0;
	}


	public void actualizarDatos(){
		setEstado(definirEstado(fechaEntrega));
		setTotalObtejosPrestados(obtenerTotalObjetosPrestados());
		setDiasTranscurridos(obtenerDiasTranscurridos(fechaPrestamo));
		setValor(obtenerValor(diasSolicitados));


	}
	private long obtenerDiasTranscurridos(LocalDate fechaPrestamo) {
		LocalDate fechaActual=LocalDate.now();
		long diasTranscurridos;

		diasTranscurridos=DAYS.between(fechaActual,fechaPrestamo);
		return diasTranscurridos;
	}


	private double obtenerValor(long diasSolicitados) {
		double valor=0;
		double valorTotal;


		for (DetallePrestamo detallePrestamo : listaDetallesPrestamos) {
			valor+=detallePrestamo.getSubTotal();
		}
		valorTotal=valor*diasSolicitados;
		return valorTotal;
	}

	private long calcularDiasSolicitados(LocalDate fechaPrestamo, LocalDate fechaEntrega) {
		long diasSolicitados;

		diasSolicitados=DAYS.between(fechaPrestamo,fechaEntrega);
		return diasSolicitados;
	}

	private int obtenerTotalObjetosPrestados() {
		int total=0;

		for (DetallePrestamo detallePrestamo : listaDetallesPrestamos) {

			total+=detallePrestamo.getUnidadesPrestadas();

		}
		return total;
	}

	/**
	 *
	 * @param fechaEntrega2
	 * @return
	 */
	private String definirEstado(LocalDate fechaEntrega) {
		LocalDate fechaActual=LocalDate.now();



		if(fechaEntrega.isAfter(fechaActual))
			return "Vigente";
		return"En mora";
	}

	/**
	 * Metodo que calcula los dias solicitados
	 * @param fechaPrestamo
	 * @param fechaEntrega
	 * @return dias solicitados
	 */
	private int calcularDiasSolicitados(Calendar fechaPrestamo, Calendar fechaEntrega) {
	// TODO Auto-generated method stub
	return 0;
	}

	/**
	 *metodo para actualizar objetos prestados
	 */
	public void actualizarObjetosPrestados() {
		int total=0;
		for(DetallePrestamo detallePrestamosAux:listaDetallesPrestamos)
		{
			total+=detallePrestamosAux.getUnidadesPrestadas();
		}
		this.TotalObtejosPrestados=total;
	}

	/**
	 * metodo para actualizar el valor del prestamo
	 */
	public  void actualizarValorPrestamo() {
		int total=0;
		for(DetallePrestamo detallePrestamosAux:listaDetallesPrestamos)
		{
			total+=detallePrestamosAux.getSubTotal();
		}
		this.TotalObtejosPrestados=total;
	}

	/**
	 * metodo get del codigo del prestamo
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * metodo set del codigo del prestamo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * metodo is del estado del prestamo
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * metodo set del estado del prestamo
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * metodo calendar get de la fecha del prestamo
	 * @return fecha prestamo
	 */
	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	/**
	 * metodo set de la fecha del prestamo
	 * @param fechaPrestamo
	 */
	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	/**
	 * metodo calendar get de la fecha de entrega del prestamo
	 * @return fecha entrega
	 */
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * metodo set de la fecha de entrega del prestamo
	 * @param fechaEntrega
	 */
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * metodo get del total de objetos prestados del prestamo
	 * @return totalObjetosPrestados
	 */
	public int getTotalObtejosPrestados() {
		return TotalObtejosPrestados;
	}

	/**
	 * metodo set del total de objetos prestados del prestamo
	 * @param totalObtejosPrestados
	 */
	public void setTotalObtejosPrestados(int totalObtejosPrestados) {
		TotalObtejosPrestados = totalObtejosPrestados;
	}
	/**
	 * metodo get del valor de la clase prestamo
	 * @return valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * metodo set del valor de la clase prestamo
	 * @param valor
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}


	/**
	 * metodo get cliente de la clase prestamo
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * metodo set cliente de la clase prestamo
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * metodo get de empleado de la clase prestamo
	 * @return empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * metodo set de empleado de la clase prestamo
	 * @param empleado
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	/**
	 * Metodo get del atributo dias transcurridos
	 * @return
	 */
	public long getDiasTranscurridos() {
		return diasTranscurridos;
	}

	/**
	 * Metodo set del atributo dias transcurridos
	 * @param diasTranscurridos
	 */
	public void setDiasTranscurridos(long diasTranscurridos) {
		this.diasTranscurridos = diasTranscurridos;
	}

	/**
	 * Metodo get del atributo dias solicitados
	 * @return diasSolicitados
	 */
	public long getDiasSolicitados() {
		return diasSolicitados;
	}

	/**
	 * Metodo set del atributo dias solicitados
	 * @param diasSolicitados
	 */
	public void setDiasSolicitados(long diasSolicitados) {
		this.diasSolicitados = diasSolicitados;
	}

	/**
	 * metodo get de la Array detallePrestamo de la clase prestamo
	 * @return
	 */
	public ArrayList<DetallePrestamo> getListaDetallesPrestamos() {
		return listaDetallesPrestamos;
	}

	/**
	 * metodo set de la Array detallePrestamo de la clase prestamo
	 * @param listaDetallesPrestamos
	 */
	public void setListaDetallesPrestamos(ArrayList<DetallePrestamo> listaDetallesPrestamos) {
		this.listaDetallesPrestamos = listaDetallesPrestamos;
	}

	/**
	 * metodo toString de la clase Prestamo
	 */
	@Override
	public String toString() {
		return "Prestamo [codigo=" + codigo + ", estado=" + estado + ", TotalObtejosPrestados=" + TotalObtejosPrestados
				+ ", diasTranscurridos=" + diasTranscurridos + ", diasSolicitados=" + diasSolicitados + ", valor="
				+ valor + ", fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", cliente=" + cliente
				+ ", empleado=" + empleado + ", listaDetallesPrestamos=" + listaDetallesPrestamos + "]";
	}

	/**
	 * metodo que verifica si el nomnbre de un objeto ingresado
	 * como parametro esta asociado con un detalle prestamo.
	 * @param nombreObjeto
	 * @return respuesta(true si pertenece, false si no pertenece)
	 */
	public boolean verificarPertenciaPrestamo(String nombreObjeto) {
		boolean respuesta=false;

		for(DetallePrestamo detalleAux: listaDetallesPrestamos)
		{
			respuesta=detalleAux.verificarObjetoNombre(nombreObjeto);
			if(respuesta==true)
				return respuesta;
		}
		return respuesta;
	}

	/**
	 * metodo que crea un detalle prestamo.
	 * @param unidadesPrestadas
	 * @param valor
	 * @param objetoAux
	 * @throws SinCupoDetallePrestamo
	 */
	public void crearOActualizarDetallePrestamo(int unidadesPrestadas, double valor, Objeto objetoAux) {

		DetallePrestamo detalleAux;

		String  codigoObjetoBuscar;
		String  codigoObjeto;

		int     unidadesRegistradas;
		int     unidadesAgregar;

		boolean error=true;

		double  subtotal;

		codigoObjetoBuscar=objetoAux.getCodigo();

		detalleAux=new DetallePrestamo(unidadesPrestadas, objetoAux);
		listaDetallesPrestamos.add(detalleAux);
	}

	/**
	 * método que verifica si un cliente existe en el prestamo
	 * usando el documento del clinete
	 * @param documento
	 * @return existeCliente(true si el cliente existe, fasle de lo contrario)
	 */
	public boolean verificarExistenciaCliente(String documento) {
		boolean existeCliente=false;
		existeCliente=cliente.verificarDocumento(documento);
		return existeCliente;
	}
/**
 * metodo que verifica si el el objeto pertenece a almenos
 * un detalle prestamo
 * @param codigoAux
 * @return existe(true si pertenece, false de lo contrario)
 */
	public boolean verificarExistenciaObjeto(String codigoAux) {
		boolean existe=false;
		for (DetallePrestamo detallePrestamo : listaDetallesPrestamos) {
			existe=detallePrestamo.validarObjetoPrestado(codigoAux);
			if(existe==true)
				return existe;
		}
		return existe;
	}
/**
 * métodoq eu verifica si un codigo ingresado
 * por parametro es igual al codigo del prestamo
 * @param codigoPrestamoAux
 * @return true si son iguales, false si no
 */
public boolean verificarCodigo(String codigoPrestamoAux) {

	if(this.codigo.equals(codigoPrestamoAux))
		return true;

	return false;
}

/**
 * metodo que obtiene el documento del empleado
 * registrado
 * @return
 */
public String obtenerDocumentoEmpleado() {
	return empleado.getDocumento();
}

/**
 * mjetodo que obtiene el documento del cliente
 * @return
 */
public String obtenerDocumentoCliente() {
	return cliente.getDocumento();
}

/**
 * MEtodo que actualiza el prestamo
 * @param prestamoAux
 */
public void actualizar(Prestamo prestamoAux) {
	setCodigo(prestamoAux.getCodigo());
	setEstado(prestamoAux.getEstado());
	setFechaPrestamo(prestamoAux.getFechaPrestamo());
	setFechaEntrega(prestamoAux.getFechaEntrega());
	setTotalObtejosPrestados(prestamoAux.getTotalObtejosPrestados());
	setDiasTranscurridos(prestamoAux.getDiasTranscurridos());
	setCliente(prestamoAux.getCliente());
	setEmpleado(prestamoAux.getEmpleado());
	setListaDetallesPrestamos(prestamoAux.getListaDetallesPrestamos());
	setDiasSolicitados(prestamoAux.getDiasSolicitados());
	setValor(prestamoAux.getValor());

}

/**
 * metodo que agrega un detalle prestamo al prestamo
 * @param objetoAux
 * @param unidadesPrestadasAux
 */
public void agregarDetalle(Objeto objetoAux, int unidadesPrestadasAux) {
	DetallePrestamo detallePrestamoAux=null;
	detallePrestamoAux= new DetallePrestamo(unidadesPrestadasAux, objetoAux);
	listaDetallesPrestamos.add(detallePrestamoAux);

}

/**
 * Metodo que toma la lista de detalles prestamos
 * @return listaDetallesPrestamos
 */
public ArrayList<DetallePrestamo> obtenerDetallePrestamo() {

	return listaDetallesPrestamos;
}
}



