package co.edu.uniquindio.programaprestamoobjeto.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * esta clase representa el prestamo, contiene la información del
 * prestamo a solicitar
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 */
public class Prestamo {
	
	private String codigo;
    
	private boolean estado;	
    
	private Calendar fechaPrestamo;
	private Calendar fechaEntrega;
	
	private int    TotalObtejosPrestados;
	
	private double valor;
	
	private double valorUnitario;
	
	private Cliente cliente=null;
	
	private Empleado empleado=null;
	
	private ArrayList<DetallePrestamo> listaDetallesPrestamos;
	
	
	
	public Prestamo(String codigo,  Calendar fechaPrestamo, Calendar fechaEntrega,
			double valor, double valorUnitario, Cliente cliente, Empleado empleado
			) {

		this.codigo = codigo;
		this.estado = true;
		this.fechaPrestamo = Calendar.getInstance();
		this.fechaEntrega = fechaEntrega;
		this.TotalObtejosPrestados =0;
		this.valor =0;
		this.cliente = cliente;
		this.empleado = empleado;
		this.listaDetallesPrestamos = new ArrayList<>();
	}
	public void actualizarObjetosPrestados() {
		int total=0;
		for(DetallePrestamo detallePrestamosAux:listaDetallesPrestamos)
		{
			total+=detallePrestamosAux.getUnidadesPrestadas();
		}
		this.TotalObtejosPrestados=total;
	}
	public  void actualizarValorPrestamo() {
		int total=0;
		for(DetallePrestamo detallePrestamosAux:listaDetallesPrestamos)
		{
			total+=detallePrestamosAux.getSubTotal();
		}
		this.TotalObtejosPrestados=total;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Calendar getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Calendar fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Calendar getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Calendar fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getTotalObtejosPrestados() {
		return TotalObtejosPrestados;
	}
	public void setTotalObtejosPrestados(int totalObtejosPrestados) {
		TotalObtejosPrestados = totalObtejosPrestados;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public ArrayList<DetallePrestamo> getListaDetallesPrestamos() {
		return listaDetallesPrestamos;
	}
	public void setListaDetallesPrestamos(ArrayList<DetallePrestamo> listaDetallesPrestamos) {
		this.listaDetallesPrestamos = listaDetallesPrestamos;
	}
	/**
	 * metodo toString de la clase Prestamo
	 */
	@Override
	public String toString() {
		return "Prestamo [codigo=" + codigo + ", estado=" + estado + ", fechaPrestamo=" + fechaPrestamo
				+ ", fechaEntrega=" + fechaEntrega + ", TotalObtejosPrestados=" + TotalObtejosPrestados + ", valor="
				+ valor + ", valorUnitario=" + valorUnitario + ", cliente=" + cliente + ", empleado=" + empleado
				+ ", listaDetallesPrestamos=" + listaDetallesPrestamos + "]";
	}
	/**
	 * método que verifica si el nomnbre de un objeto ingresado 
	 * como parametro está asociado con un detalle prestamo.
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
	 * método que crea un detalle prestamo.
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
}

	

