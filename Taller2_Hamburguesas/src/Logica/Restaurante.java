package Logica;
import java.util.ArrayList;


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
		// Se llama al constructor de la clase pedido y se crea una instancia a partir de este
		Pedido pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
		int idPedido = pedidoEnCurso.getIdPedido();
		System.out.println(idPedido);
		
		String ruta_guardar_pedidos = 
		
	}

	
	
	
}