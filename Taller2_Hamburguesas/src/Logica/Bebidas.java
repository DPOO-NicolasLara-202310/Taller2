package Logica;

public class Bebidas implements Producto
{
	
	private String nombre;
	private int precioBase;
	private int calorias;
	public Bebidas(String nombre, int preciobase,int calorias)
	{
		this.nombre=nombre;
		this.precioBase=preciobase;
		this.calorias=calorias;
	}
	
	public String getNombre()
	{
		
		return nombre;
	}
	
	public int getPrecio()
	{
		return precioBase;
		
	}
	public int getCalorias()
	{
		return calorias;
	}
	public String generarTextoFactura()
	{
		String precio_str = Integer.toString(precioBase);
		String calorias_str = Integer.toString(calorias);
		String textofactura = "El precio es " + precio_str + " con " + calorias_str + " calorias.";
		return textofactura;
		
	}
	
}
