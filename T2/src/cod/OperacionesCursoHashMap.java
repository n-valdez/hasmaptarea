package cod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class OperacionesCursoHashMap {
	 private HashMap<Integer, Curso> mapaCursos = new HashMap<>();
	    private Queue<Curso> colaCursos = new PriorityQueue<>();

	    private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	    public void Menu() throws IOException {

	        int opcion = 0;

	        while (opcion != 5) {

	            System.out.println("Selecione una opcion");
	            System.out.println("1- Agregar Curso");
	            System.out.println("2- Actualizar Curso");
	            System.out.println("3- Modificar Curso ");
	            System.out.println("4- Eliminar Curso");
	            System.out.println("5- Salir");

	            System.out.println("Ingrese una opcion:");

	            opcion = Integer.parseInt(entrada.readLine());

	            switch (opcion) {
	                case 1:
	                    agregarCurso();
	                    break;
	                case 2:
	                    consultarCurso();
	                    break;
	                case 3:
	                    modificarCurso();
	                    break;
	                case 4:
	                	eliminarCurso();
	                    break;
	                case 5:
	                    System.out.println("Hasta luego");
	                    break;
	                default:
	                    System.out.println("Opcion incorrecta");
	            }

	        }

	    }
	    
	    private void agregarCurso() {
	    	Producto productoNuevo = new Producto();

	        System.out.println("Ingrese codigo");
	        productoNuevo.setCodigo(Integer.parseInt(entrada.readLine()));

	        System.out.println("Ingrese nombre");
	        productoNuevo.setNombre(entrada.readLine());

	        System.out.println("Ingrese procedencia");
	        productoNuevo.setProcedencia(entrada.readLine());

	        System.out.println("Ingrese la cantidad en Stock");
	        productoNuevo.setCantidadStock(Integer.parseInt(entrada.readLine()));

	        System.out.println("Ingrese el precio");
	        productoNuevo.setPrecio(Integer.parseInt(entrada.readLine()));

	        System.out.println("Ingrese el estado (A=activo, I=inactivo)");
	        productoNuevo.setEstado(entrada.readLine().charAt(0));

	        if (mapaProductos.containsKey(productoNuevo.getCodigo())) {
	            System.out.println("Producto existente, desea sobreescribir los datos (SI/NO)");
	            String respuesta = entrada.readLine();
	            if (respuesta.equalsIgnoreCase("NO")) {
	                return;
	            }
	        }
	        mapaProductos.put(productoNuevo.getCodigo(), productoNuevo);
	        System.out.println("Producto agregado");

			
		}

	    private void consultarCurso() {
			// TODO Auto-generated method stub
			
		}

	    private void modificarCurso() {
			// TODO Auto-generated method stub
			
		}
	    
		private void eliminarCurso() {
			// TODO Auto-generated method stub
			
		}

		

}
