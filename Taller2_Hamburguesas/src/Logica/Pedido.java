package Logica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Pedido 
{
	private ArrayList<Producto> itemsPedido;
	private static int numeroPedidos;
	private static int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	public Pedido(String nombreCliente, String direccionCliente) 
	{
		super();
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		Random random= new Random();
		idPedido= random.nextInt(10000);
		this.itemsPedido = new ArrayList<Producto>();
	}

	public int getIdPedido() 
	{
		return idPedido;
	}

	public void agregarProducto (Producto nuevoItem) 
	{
		itemsPedido.add(nuevoItem);
	}
	
	private int getPrecioNetoPedido() 
	{
		int precio = 0;
		for (Producto item: itemsPedido)
		{
			precio += item.getPrecio();
		}
		return precio;
	}
	
	private int getPrecioIVAPedido() 
	{
		int precio = getPrecioNetoPedido();
		return (int) (precio*0.19);
	}
	
	private int getPrecioTotalPedido() 
	{
		int neto = getPrecioNetoPedido();
		int iva = getPrecioIVAPedido();
		return neto+iva;
	}
	

	private String generarTextoFactura() 
	{
		String texto = "";
		int c = 0;
		
		for (Producto item: itemsPedido)
		{
			if (c == 0)
			{
				texto += "\n" + item.getNombre() + " y " + item.generarTextoFactura();
			}
			
			else
			{
				texto += "\n con " + item.getNombre() + " y " + item.generarTextoFactura();
			}
			
			c ++;
			
		}
		return texto;
		
	}
	
	public void guardarFactura(String archivo) 
	{
		 try {
		        File myObj = new File(archivo+Integer.toString(idPedido)+".txt");
		        if (myObj.createNewFile()) {
		          System.out.println("File created: " + myObj.getName());
		        } else {
		          System.out.println("File already exists.");
		        }
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
		 try 
		 {
		      FileWriter factura = new FileWriter(archivo+Integer.toString(idPedido)+".txt");
		      factura.write("La factura es:\n Direccion cliente: "+ direccionCliente +"\n"+"Nombre del cliente: "+ nombreCliente +"\n"+"Numero de pedidos :"+numeroPedidos+"\n");
		      factura.write("La orden realizada es "+generarTextoFactura()+"\n"+"Precio: "+Integer.toString(getPrecioTotalPedido()));
		      factura.close();
		      System.out.println("Successfully wrote to the file.");
		      
		    } 
		 catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
}
