package Logica;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 


public class Restaurante 
{
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Pedido> pedidos;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Bebidas> bebidasBase;
	private ArrayList<Combo> combos;
	private Pedido pedidoEnCurso=null;
	private boolean existe_producto;
	private HashMap <String, String> ProductoPrecio = new HashMap <String, String>();
	private HashMap <String, String> ProductoCalorias = new HashMap <String, String>();
	

	
	public Restaurante() 
	{
		this.ingredientes = new ArrayList<Ingrediente>();
		this.pedidos = new ArrayList<Pedido>();
		this.menuBase = new ArrayList<ProductoMenu>();
		this.bebidasBase = new ArrayList<Bebidas>();
		this.combos = new ArrayList<Combo>();
	}
	
	public ArrayList<Ingrediente> getIngredientes() 
	{
		return ingredientes;
	}

	public ArrayList<ProductoMenu> getMenuBase() 
	{
		return menuBase;
	}

	public void setpedido_curso() 
	{
		this.pedidoEnCurso=null;
	}
		

	public boolean getexiste_producto()
	{
		if (pedidoEnCurso==null)
		{
			existe_producto=false;
		}
		else
		{
			existe_producto=true;
		}
		return existe_producto;
	}
	
	
	public Pedido getPedidoEnCurso() {
		return pedidoEnCurso;
	}
	
	public ArrayList<Combo> getcombos()
	{
		return combos;
	}
	public ArrayList<Bebidas> getbebidas()
	{
		return bebidasBase;
	}
	
	public void cargarIngredientes(String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader data = new BufferedReader(new FileReader(nombreArchivo));
		String linea = data.readLine();
		while(linea!=null)
		{
			String[] x = linea.split(";");
			ProductoPrecio.put(x[0], x[1]);
			ProductoCalorias.put(x[0], x[2]);
			Ingrediente ingre = new Ingrediente(x[0],Integer.parseInt(x[1]),Integer.parseInt(x[2]));
			if  (!ingredientes.contains(ingre))
			{
			ingredientes.add(ingre);
			}
			linea = data.readLine();
			
		}
		data.close();
	}
	
	public void cargarBebidas(String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader data = new BufferedReader(new FileReader(nombreArchivo));
		String linea = data.readLine();
		while(linea!=null)
		{
			String[] x = linea.split(";");
			ProductoPrecio.put(x[0], x[1]);
			ProductoCalorias.put(x[0], x[2]);
			Bebidas bebida = new Bebidas(x[0],Integer.parseInt(x[1]),Integer.parseInt(x[2]));
			if  (!bebidasBase.contains(bebida))
			{
				bebidasBase.add(bebida);
			}
			linea = data.readLine();
			
		}
		data.close();
	}
	
	public void cargarMenu(String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader data = new BufferedReader(new FileReader(nombreArchivo));
		String linea = data.readLine();
		while(linea!=null)
		{
			String[] x = linea.split(";");
			ProductoPrecio.put(x[0], x[1]);
			ProductoCalorias.put(x[0], x[2]);
			ProductoMenu menu = new ProductoMenu(x[0],Integer.parseInt(x[1]),Integer.parseInt(x[2]));
			if  (!menuBase.contains(menu))
			{
				menuBase.add(menu);
			}
			linea = data.readLine();
			
		}
		data.close();
	}
	
	public void cargarCombos(String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader data = new BufferedReader(new FileReader(nombreArchivo));
		String linea = data.readLine();
		while(linea!=null)
		{
			String[] x = linea.split(";");
			String nombre_combo = x[0];
			String descuento = x[1].replace("%", "");
			double descuentoNew = Double.parseDouble(descuento)/100;
			
			String item1 = x[2];
			String item2 = x[3];
			String item3 = x[4];
			
			String precio1 = ProductoPrecio.get(item1);
			String precio2 = ProductoPrecio.get(item2);
			String precio3 = ProductoPrecio.get(item3);
			
			String calorias1 = ProductoCalorias.get(item1);
			String calorias2 = ProductoCalorias.get(item2);
			String calorias3 = ProductoCalorias.get(item3);
			
			ProductoMenu producto1 = new ProductoMenu(item1, Integer.parseInt(precio1),Integer.parseInt(calorias1));
			ProductoMenu producto2 = new ProductoMenu(item2, Integer.parseInt(precio2),Integer.parseInt(calorias2));
			Bebidas producto3 = new Bebidas(item3, Integer.parseInt(precio3),Integer.parseInt(calorias3));
			
			Combo combo = new Combo(descuentoNew, nombre_combo);
			combo.agregarItemACombo(producto1);
			combo.agregarItemACombo(producto2);
			combo.agregarItemACombo(producto3);
			
			if  (!combos.contains(combo))
			{
			combos.add(combo);
			}
			linea = data.readLine();
			
		}
		data.close();
	}
	
	public void CargarRestaurante(String archivo) throws FileNotFoundException, IOException
	{
		cargarMenu(archivo);
		cargarCombos(archivo);
		cargarBebidas(archivo);
		cargarIngredientes(archivo);	
	}

	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		Pedido pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
		int id = pedidoEnCurso.getIdPedido();
		System.out.println("Su pedido tiene ID: "+id);
		String archivo="Pedidos/pedido_#";
		Path path = Paths.get(archivo+Integer.toString(id)+".txt");
		if (!Files.exists(path))
		{
			this.pedidoEnCurso = pedidoEnCurso;
		}
		else
		{
			this.pedidoEnCurso = null;
		}
		pedidos.add(pedidoEnCurso);
	}

	public void cerrarYGuardarPedido()
	{
		if (pedidoEnCurso!=null)
		{
			String archivo="Pedidos/pedido_#";
			pedidoEnCurso.guardarFactura(archivo);
			pedidoEnCurso=null;
		}
		else
		{
			System.out.println("No hay pedidos en curso");
		}
	}
	



	
	
	
}