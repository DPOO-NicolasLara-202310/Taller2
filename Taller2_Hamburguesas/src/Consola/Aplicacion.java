package Consola;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Logica.*;


public class Aplicacion {
	
	private static Restaurante restaurante = new Logica.Restaurante();
	private static ArrayList<ProductoAjustado> productos_pedido =new ArrayList<>();
	private static ArrayList<Combo> combos_pedido =new ArrayList<>();
	
	

	
	public static void mostrar_menu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la informacion de un pedido dado su id");
		System.out.println("6. Salir de la aplicación");
		
	
	}
	public void ejecutarAplicacion(int opcion_seleccionada, boolean continuar) throws FileNotFoundException, IOException
	{
				
		if (opcion_seleccionada == 1)
		{
			boolean a=true;
			opcion1(a);
			a=false;
		}
		else if (opcion_seleccionada ==2)
			opcion2();
		else if (opcion_seleccionada ==3)
			opcion3();
		else if (opcion_seleccionada ==4)
			opcion4();
		else if (opcion_seleccionada ==5)
			System.out.println("Opcion aún no implementada");
		else if (opcion_seleccionada ==6)
		{
			System.out.println("Saliendo de la aplicación");
		}
		else
		{
			System.out.println("Por favor seleccione una opción válida.");
		}

	}	
	
	public static void opcion1(boolean a) throws FileNotFoundException, IOException{
		if (a==true);
		{
			
		restaurante.CargarInformacionRestaurante("C:\\Users\\soyyo\\eclipse-workspace\\Taller_2\\data");
		ArrayList<ProductoMenu> valor_menu=restaurante.getMenuBase();
		ArrayList<Ingrediente> valor_ingredientes=restaurante.getIngredientes();
		ArrayList<Combo> valor_combos=restaurante.getcombos();
		int j =1;
		System.out.println("Menú base\n");
		for (ProductoMenu i: valor_menu)
		{
			System.out.println(j+". "+i.getNombre()+" con precio de: "+i.getPrecio());
			j+=1;
			
		}
		System.out.println("\nIngredientes\n");
		j=1;
		for (Ingrediente i: valor_ingredientes)
		{
			System.out.println(j+". "+i.getNombre()+" con precio de: "+i.getCostoAdicional());
			j+=1;
			
		}
		System.out.println("\nCombos\n");
		j=1;
		for (Combo i: valor_combos)
		{
			System.out.println(j+". "+i.getNombre()+" con precio de: "+i.getPrecio());
			j+=1;
			
		}
		}
		
	}
	public static void opcion2()
	{
		boolean valor=restaurante.getexiste_producto();
		if (!valor)
		{
			productos_pedido=new ArrayList<>();
			combos_pedido=new ArrayList<>();
			
			Scanner input =new Scanner(System.in);
			System.out.println("Escriba su nombre");
			String nombre=input.nextLine();
			System.out.println("Escriba su direccion");
			String direccion=input.nextLine();
			restaurante.iniciarPedido(nombre, direccion);
			System.out.println("\nQue tipo de producto desea agregar\n");
			System.out.println("1. Producto del Menú");
			System.out.println("2. Combo");
			System.out.println("Escriba su opción");
			int number=input.nextInt();
			if (number==1)
			{
				System.out.println("Escriba un número de los productos del menú de la opción 1");
				int number1=input.nextInt();
				Pedido pedido_curso=restaurante.getPedidoEnCurso();
				ArrayList<ProductoMenu> producto=restaurante.getMenuBase();
				ProductoMenu producto_sel=producto.get(number1-1);
				ProductoAjustado nuevo_ajustado= new Logica.ProductoAjustado();
				productos_pedido.add(nuevo_ajustado);
				pedido_curso.agregarProducto(producto_sel);
				
				
				
			}
			else if (number==2)
			{
				System.out.println("Escriba un número de los combos del menú de la opción 1");
				int number2=input.nextInt();
				Pedido pedido_curso=restaurante.getPedidoEnCurso();
				ArrayList<Combo> producto=restaurante.getcombos();
				Combo producto_sel=producto.get(number2-1);
				combos_pedido.add(producto_sel);
				pedido_curso.agregarProducto(producto_sel);
			}
		}
		else
			{
				System.out.println("Hay un pedido en curso, no puede iniciar otro");
			}

			
		
				
		

		
		

		
	}
	
	public static void opcion3()
	{
		boolean valor=restaurante.getexiste_producto();
		if (valor)
		
		{
			Scanner input =new Scanner(System.in);
			System.out.println("\nQue desea agregar a su pedido\n");
			System.out.println("1. Nuevo Producto del Menú");
			System.out.println("2. Nuevo Combo");
			System.out.println("3. Ingredientes");
			System.out.println("4. Quitar ingrediente");
			int number3=input.nextInt();
			switch (number3) {
				case 1:
					System.out.println("Escriba un número de los productos del menú de la opción 1");
					int number4=input.nextInt();
					Pedido pedido_curso=restaurante.getPedidoEnCurso();
					ArrayList<ProductoMenu> producto=restaurante.getMenuBase();
					ProductoMenu producto_sel=producto.get(number4-1);
					ProductoAjustado nuevo_ajustado= new Logica.ProductoAjustado();
					productos_pedido.add(nuevo_ajustado);
					pedido_curso.agregarProducto(producto_sel);
					break;
				case 2:	
					System.out.println("Escriba un número de los combos del menú de la opción 1");
					int number5=input.nextInt();
					Pedido pedido_curso2=restaurante.getPedidoEnCurso();
					ArrayList<Combo> producto2=restaurante.getcombos();
					Combo producto_sel2=producto2.get(number5-1);
					combos_pedido.add(producto_sel2);
					pedido_curso2.agregarProducto(producto_sel2);
					break;
				case 3:
					System.out.println("A cual producto desea agregar los ingredientes");
					int m=0;
					for (ProductoAjustado i: productos_pedido) 
					{
							int k=m+1;
							System.out.println(k+". "+i.getNombre());
							m+=1;
					}
					System.out.println("Escoja su opción: ");
					int number6=input.nextInt();
					ProductoAjustado producto_agregar=productos_pedido.get(number6-1);
					System.out.println("Escriba el número del ingrediente que desea agregar de acuerdo a la opción 1: ");
					int number7=input.nextInt();
					ArrayList<Ingrediente> lista_ingredientes=restaurante.getIngredientes();
					Ingrediente ingrediente1=lista_ingredientes.get(number7-1);
					producto_agregar.agregar(ingrediente1);
					break;
				case 4:
					System.out.println("A cual producto desea quitar los ingredientes");
					int m1=0;
					for (ProductoAjustado i: productos_pedido) 
					{
							int k=m1+1;
							System.out.println(k+". "+i.getNombre());
							m1+=1;
					}
					System.out.println("Escoja su opción: ");
					int number8=input.nextInt();
					ProductoAjustado producto_agregar2=productos_pedido.get(number8-1);
					System.out.println("Escriba el número del ingrediente que desea quitar de acuerdo a la opción 1: ");
					int number9=input.nextInt();
					ArrayList<Ingrediente> lista_ingredientes2=restaurante.getIngredientes();
					Ingrediente ingrediente2=lista_ingredientes2.get(number9-1);
					producto_agregar2.quitar(ingrediente2);
					
					break;
					
					
						
					
					
				
			
			}

			
		
		}
		else {
			System.out.println("Primero cree una orden por favor");
		}
			
		
		
	}
	public static void opcion4()
	{
		restaurante.cerrarYGuardarPedido();
		System.out.println("La factura se guardo revise la carpeta de facturas");
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Aplicacion aplicacion = new Aplicacion();
		Scanner input =new Scanner(System.in);
		
		
		
		boolean continuar=true;
		while (continuar)
	
		{
			mostrar_menu();
			System.out.println("Escriba su opción");
			int number=input.nextInt();
			aplicacion.ejecutarAplicacion(number,continuar);
			if (number ==6)
			{
				continuar = false;
			}
		}	
//		}
//		catch (NumberFormatException e)
//		{
//			System.out.println("Debe seleccionar uno de los números de las opciones.");
//		}	
		input.close();
	}
}
	
	

