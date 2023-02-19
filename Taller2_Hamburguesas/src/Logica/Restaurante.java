package Logica;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class Restaurante 
{
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Pedido> pedidos;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Combo> combos;
	private Pedido pedidoEnCurso=null;
	
	
	public Restaurante(ArrayList<Ingrediente> ingredientes, ArrayList<Pedido> pedidos, ArrayList<ProductoMenu> menuBase, ArrayList<Combo> combos) 
	{
		super();
		this.ingredientes = ingredientes;
		this.pedidos = pedidos;
		this.menuBase = menuBase;
		this.combos = combos;
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		// Se llama al constructor 
		Pedido pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
		
	}

	
	
	
}