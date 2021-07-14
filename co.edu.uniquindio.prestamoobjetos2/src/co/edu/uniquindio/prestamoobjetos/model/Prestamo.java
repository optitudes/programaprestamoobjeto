package co.edu.uniquindio.prestamoobjetos.model;

import co.edu.uniquindio.prestamoobjetos.exception.NoCreadoException;

public class Prestamo {


	//Declaración de atributos
	private String codigo;
	private int diasSolicitados;
	private int diasTranscurridos = -1;
	private double valor;
	private Cliente cliente;
	private Empleado empleado;

	public Prestamo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase Prestamo
	 * @param codigo, diasSolicitados, diasTranscurridos,  cliente, empleado, detallePrestamo1, detallePrestamo2
	 * @throws NoCreadoException
	 */
	public Prestamo(String codigo, int diasSolicitados,  Cliente cliente, Empleado empleado, int unidadesPrestadas, Objeto objeto) throws NoCreadoException {
		this.codigo = codigo;
		this.diasSolicitados = diasSolicitados;
		this.cliente = cliente;
		this.empleado = empleado;
	}

	//Métodos Getters and Setters---------------------------------------------->
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getDiasSolicitados() {
		return diasSolicitados;
	}
	public void setDiasSolicitados(int diasSolicitados) {
		this.diasSolicitados = diasSolicitados;
	}
	public int getDiasTrascurridos() {
		return diasTranscurridos;
	}
	public void setDiasTranscurridos(int diasTranscurridos) {
		this.diasTranscurridos = diasTranscurridos;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
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


	public int getDiasTranscurridos() {
		return diasTranscurridos;
	}

	@Override
	public String toString() {
		return "Prestamo\n codigo: " + codigo + "\nDias Solicitados: " + diasSolicitados + "\nCliente:" + cliente + "\nEmpleado: " + empleado;
	}




}
