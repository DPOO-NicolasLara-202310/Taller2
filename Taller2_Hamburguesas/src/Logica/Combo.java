package Logica;
import java.util.ArrayList;

public class Combo implements Producto
{
	
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;


	public Combo(double descuento, String nombreCombo, ArrayList<ProductoMenu> itemsCombo) 
	{
		super();
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.itemsCombo = itemsCombo;
	}

	public void agregarItemACombo(ProductoMenu itemCombo) 
	{
		itemsCombo.add(itemCombo);
	}

	@Override
	public int getPrecio() 
	{
		int precio = 0;
		for (ProductoMenu item: itemsCombo)
		{
			int precio_ing = item.getPrecio();
			precio += precio_ing;
		}
		
		return (int) (precio*(1-descuento));
		
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
		String str_price = Integer.toString(precio);
		String textofactura = "El precio es " + str_price;
		return textofactura;
	}

}
