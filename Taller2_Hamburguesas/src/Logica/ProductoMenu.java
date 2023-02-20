package Logica;
public class ProductoMenu implements Producto
{
	private String nombre;
	private int precioBase;
	private int calorias;
	
	public ProductoMenu(String nombre, int precioBase, int calorias) 
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.calorias = calorias;
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
	public int getCalorias() 
	{
		return calorias;
	}

	@Override
	public String generarTextoFactura() 
	{
		String precio_str = Integer.toString(precioBase);
		String calorias_str = Integer.toString(calorias);
		String textofactura = "El precio es " + precio_str + " con " + calorias_str + " calorias.";
		return textofactura;
	}	
	

}
