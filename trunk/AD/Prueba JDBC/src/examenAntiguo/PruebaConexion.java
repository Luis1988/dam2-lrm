package examenAntiguo;

import java.sql.SQLException;
import java.util.Scanner;

public class PruebaConexion {

	public static void menu(){
		System.out.println("______________________________");
		System.out.println();
		System.out.println("1. Datos de la tabla");
		System.out.println("2. Buscar filas en \"alumnos\"");
		System.out.println("3. Insertar fila en \"alumnos\"");
		System.out.println("4. Borrar fila en \"alumnos\"");
		System.out.println("5. Navegar");
		System.out.println("6. Salir");
		System.out.println();
		System.out.println("______________________________");
		System.out.println();
		System.out.print("Elija una opción (1 - 6): ");
	}
	
	public static void menuTablas(){
		System.out.println("______________________________");
		System.out.println();
		System.out.println("1. ALUMNOS");
		System.out.println("2. ASIGNATURAS");
		System.out.println("3. ALUMNOS_ASIGNATURAS");
		System.out.println();
		System.out.print("Elija una opción (1 - 3): ");
	}
	
	public static void menuBuscar(){
		System.out.println("Buscar:");
		System.out.println();
		System.out.println("______________________________");
		System.out.println();
		System.out.println("1. cadenas que empiecen por...");
		System.out.println("2. cadenas que contengan...");
		System.out.println();
		System.out.println("______________________________");
		System.out.println();
		System.out.print("Opción (1 - 2): ");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner teclado = new Scanner(System.in);
		BDAlumnos bda = new BDAlumnos();
		boolean salir1 = false;
		while(salir1 == false){
			int op1 = 0;
			while(op1 < 1 || op1 > 6){
				menu();
				op1 = teclado.nextInt();
				System.out.println();
			}
			switch(op1){
			case 1:
				int opTablas = 0;
				while(opTablas < 1 || opTablas > 3){
					menuTablas();
					opTablas = teclado.nextInt();
					System.out.println();
				}
				switch(opTablas){
				case 1:
					bda.mostrarTabla("ALUMNOS");
					break;
				case 2:
					bda.mostrarTabla("ASIGNATURAS");
					break;
				case 3:
					bda.mostrarTabla("ALUMNOS_ASIGNATURAS");
					break;
				}
				System.out.println();
				break;
			case 2:
				int opBuscar = 0;
				while(opBuscar < 1 || opBuscar > 2){
					menuBuscar();
					opBuscar = teclado.nextInt();
				}
				System.out.print("> ");
				String apellidos = teclado.nextLine();
				switch(opBuscar){
				case 1:
					bda.mostrarFilasDeAlumnos(apellidos, 0);
					break;
				case 2:
					bda.mostrarFilasDeAlumnos(apellidos, 1);
					break;
				}
				System.out.println();
				break;
			case 3:
				System.out.print("ID: ");
				int id = teclado.nextInt();
				System.out.print("Apellidos: ");
				String ap = teclado.nextLine();
				System.out.print("Nombre: ");
				String nom = teclado.nextLine();
				System.out.print("Curso: ");
				int cur = teclado.nextInt();
				System.out.print("Titulación: ");
				int tit = teclado.nextInt();
				bda.insertarFilasEnAlumnos(id, ap, nom, cur, tit);
				System.out.println();
				break;
			case 4:
				System.out.print("Identificador: ");
				id = teclado.nextInt();
				bda.borrarFilaEnAlumnos(id);
				System.out.println();
				break;
			case 5:
				opTablas = 0;
				while(opTablas < 1 || opTablas > 3){
					menuTablas();
					opTablas = teclado.nextInt();
					System.out.println();
				}
				switch(opTablas){
				case 1:
					bda.obtenerTabla("ALUMNOS");
					break;
				case 2:
					bda.obtenerTabla("ASIGNATURAS");
					break;
				case 3:
					bda.obtenerTabla("ALUMNOS_ASIGNATURAS");
					break;
				}
				// TODO Falta lo de navegar
				System.out.println();
				break;
			case 6:
				bda.cerrarConexion();
				salir1 = true;
				break;
			}
		}
	}

}
