package Logica;
import java.util.ArrayList;

public class Combo implements Producto
{
	
	private double descuento;
	private String nombreCombo;
	private ArrayList<Producto> itemsCombo;


	public Combo(double descuento, String nombreCombo) 
	{
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.itemsCombo = new ArrayList<Producto>();
	}

	public void agregarItemACombo(Producto itemCombo) 
	{
		itemsCombo.add(itemCombo);
	}

	@Override
	public int getPrecio() 
	{
		int precio = 0;
		for (Producto item: itemsCombo)
		{
			int precio_ing = item.getPrecio();
			precio += precio_ing;
		}
		
		return (int) (precio*(1-descuento));
		
	}
	
	@Override
	public int getCalorias()
	{
		int calorias = 0;
		for (Producto item: itemsCombo)
		{
			calorias += item.getCalorias();
		}
		return calorias;
	}
		

	@Override
	public String getNombre() 
	{
		return nombreCombo;
	}

	@Override
	public String generarTextoFactura() 
	{
		int precio = getPrecio();
		int calorias = getCalorias();
		
		String precio_str = Integer.toString(precio);
		String calorias_str = Integer.toString(calorias);
		String textofactura = "El precio es " + precio_str + " con " + calorias_str + " calorias.";
		return textofactura;
	}

}
