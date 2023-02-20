package Logica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Pedido 
{
	private ArrayList<Producto> itemsPedido;
	
	private String nombreCliente;
	private String direccionCliente;
	private static int numeroPedidos=0;
	private static int idPedido;
	
	public Pedido(String nombreCliente, String direccionCliente) 
	{
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		Random rd= new Random();
		idPedido= rd.nextInt(10000);
		this.itemsPedido = new ArrayList<Producto>();
		numeroPedidos += 1;
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
	
	private int getCaloriasNetas()
	{
		int calorias = 0;
		for (Producto item: itemsPedido)
		{
			calorias += item.getCalorias();
		}
		return calorias;
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
	
	public void guardarFactura(String nombre_archivo) 
	{
		 try {
		        File data = new File(nombre_archivo+Integer.toString(idPedido)+".txt");
		        if (data.createNewFile()) 
		        {
		          System.out.println("Archivo creado: " + data.getName());
		        } 		    
		        else 	        	
		        {
		          System.out.println("El archivo ya existe.");
		        }
		      } catch (IOException e) {
		        System.out.println("Ocurrió un error.");
		        e.printStackTrace();
		      }
		 try 
		 {
		      FileWriter factura = new FileWriter(nombre_archivo+Integer.toString(idPedido)+".txt");
		      factura.write("La información de su factura es la siguiente:\n Direccion cliente: "+ direccionCliente +"\n"+"Nombre del cliente: "+ nombreCliente +"\n"+"Numero de pedidos :"+numeroPedidos+"\n");
		      factura.write("La orden realizada es "+generarTextoFactura()+"\n"+"Precio: "+Integer.toString(getPrecioTotalPedido())+"\n"+"Calorias: "+Integer.toString(getCaloriasNetas()));
		      factura.close();
		      
		    } 
		 catch (IOException e) {
		      System.out.println("Ocurrió un error.");
		      e.printStackTrace();
		    }
	}
	
}
