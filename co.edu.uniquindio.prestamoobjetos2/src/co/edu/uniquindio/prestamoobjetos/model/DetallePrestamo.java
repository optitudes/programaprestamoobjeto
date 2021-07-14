package co.edu.uniquindio.prestamoobjetos.model;

public class DetallePrestamo {

	private int unidadesPrestadas;
	private double subTotal;
	private Objeto objeto;

	/**
	 * Constructor de DetallePrestamo
	 * @param unidadesPrestadas, subTotal, objeto
	 */
	public DetallePrestamo() {
		// TODO Auto-generated constructor stub
	}

	public DetallePrestamo(int unidadesPrestadas, Objeto objeto) {
		this.unidadesPrestadas = unidadesPrestadas;
		this.objeto = objeto;
	}

	//Métodos Getters and Setters --------------------------------->
	public int getUnidadesPrestadas() {
		return unidadesPrestadas;
	}
	public void setUnidadesPrestadas(int unidadesPrestadas) {
		this.unidadesPrestadas = unidadesPrestadas;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public Objeto getObjeto() {
		return objeto;
	}
	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
	//-------------------------------------------------------------|

	@Override
	public String toString() {
		return "DetallePrestamo [unidadesPrestadas=" + unidadesPrestadas + ", subTotal=" + subTotal + ", objeto="
				+ objeto + "]";
	}

}
