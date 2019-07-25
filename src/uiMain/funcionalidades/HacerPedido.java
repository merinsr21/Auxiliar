package uiMain.funcionalidades;

import uiMain.*; 
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.logic.*;
import gestorAplicacion.users.*;;

public class HacerPedido extends OpcionDeMenu {
	
	public HacerPedido(String pos) {
		super(pos);
	}
	
	public void ejecutar() {                                         //Hacer un pedido/ crea un objeto tipo pedido y se agrega en la lista de pedidos de usuario,lo mismo con factura, con el for se crean n objetos de tipo detallePedido que se almacenan en la lista del objeto pedido anteriormente creado.
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		if(Usuario.getUsuarioConNombreUsuario(nombreUsuario).getMesa() != null) {
			System.out.print("Ingrese la fecha actual: ");
			String fecha = entrada.next();
			Pedido pedido = new Pedido(codigo,null,Usuario.getUsuarioConNombreUsuario(nombreUsuario));
			Factura factura = new Factura(codigo,fecha,null);
			Usuario.getUsuarioConNombreUsuario(nombreUsuario).setPedidosU(pedido);
			Usuario.getUsuarioConNombreUsuario(nombreUsuario).setFacturasU(factura);
			pedido.setFactura(factura);
			factura.setPedidoF(pedido);
			Datos.pedidos.put(codigo,pedido);
			Datos.facturas.put(codigo,factura);
			System.out.print("Ingrese la cantidad de platos que desee pedir:");
			int ciclo = entrada.nextInt();
			for (int i = 1; i <= ciclo; i++) {
				System.out.print("Ingrese el código del plato que desea ordenar: ");
				String codigo = entrada.next();
				System.out.print("Ingrese la cantidad de unidades de este plato que desea ordenar: ");
				String cantidad = entrada.next();
				pedido.setDetallesP(DetallePedido.crearDetallePedido(codigoD,cantidad,codigo,pedido));
			}
		}
		else {
			System.out.println("Debes ocupar una mesa para realizar un pedido.");
		}
	}
	
	public String toString() {
		return "Hacer un pedido";
	}
}
