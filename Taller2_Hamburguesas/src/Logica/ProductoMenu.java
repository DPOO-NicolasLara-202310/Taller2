package Logica;
public class ProductoMenu implements Producto
{
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String nombre, int precioBase) 
	{
		super();
		this.nombre = nombre;
		this.precioBase = precioBase;
	}

	
	

	@Override
	public int getPrecio() 
	{
		return precioBase;
	}

	@Override
	public String getNombre() 
	{
		return nombre;
	}

	@Override
	public String generarTextoFactura() 
	{
		String str_price = Integer.toString(precioBase);
		String textofactura = "El precio es " + str_price;
		return textofactura;
	}	
	

}
