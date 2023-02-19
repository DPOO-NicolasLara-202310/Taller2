package Logica;
import java.util.ArrayList;

public class ProductoAjustado implements Producto

{

	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;	
	
	
	public void agregar(Ingrediente adicion)
	{
		agregados.add(adicion);
		eliminados.remove(adicion);
		
	}
	
	public void quitar(Ingrediente adicion)
	{
		eliminados.add(adicion);
		agregados.remove(adicion);
		
	}
	
	@Override
	public int getPrecio() 
	{
		int precio_base = base.getPrecio();
		
		for (Ingrediente adicion:agregados)
		{
			precio_base += adicion.getCostoAdicional();
		}
		return precio_base;
	}
	@Override
	public String getNombre() 
	{
		String nombrePMenu = base.getNombre();
		for (Ingrediente adicion: agregados)
		{
			nombrePMenu += " con adición de " + adicion;
		}
		
		for (Ingrediente adicion: eliminados)
		{
			nombrePMenu += " sin " + adicion;
		}
		
		return nombrePMenu;
	}
	@Override
	public String generarTextoFactura() 
	{
		int precio = getPrecio();
		String str_price = Integer.toString(precio);
		String textofactura = "El precio es " + str_price;
		return textofactura;
	}
	
	
	
	
}
