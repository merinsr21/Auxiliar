package uiMain.funcionalidades;
import java.util.*;
import gestorAplicacion.logic.Calificacion;
import gestorAplicacion.logic.Comida;
import gestorAplicacion.logic.DetallePedido;
import gestorAplicacion.logic.Pedido;
import gestorAplicacion.users.Usuario;
import uiMain.*;

public class Calificar extends OpcionDeMenu {
	
	public Calificar(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		System.out.println("Ingrese la fecha de su factura: ");
		String fecha = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		Pedido pedido = null;
		for(Pedido r: usuario.getPedidosU()) {
			if(r.getFactura().getFecha().equals(fecha)){
				pedido = r;
			}
		}
		System.out.print("Ingrese el código de la comida que desea calificar: ");
		String codigo = entrada.next();
		String print = "La comida que dese calificar debe estar en su pedido";
		for(DetallePedido z: pedido.getDetallesP()) {
			if(z.getComida().getCodigo().equals(codigo)) {
				System.out.print("Ingrese la calificación de la comida: ");
				String puntaje = entrada.next();
				Calificacion.crearCalificacion(codigo, puntaje, usuario);
				print = "Gracias por calificar, vuelva pronto.";
				break;
			}
		}
		System.out.println(print);
	}
	
	//SE PUEDE CALIFICAR MAS DE UNA VEZ LA MISMA COMIDA  //REVISAR
	
	public String toString(){
		return "Calificar una comida";
	}
}
