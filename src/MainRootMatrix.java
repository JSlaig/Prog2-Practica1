import java.util.*;

public class MainRootMatrix {

	public static void main(String args[]) throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hola, introduzca un tamaño de matriz:\n");
		
		int size = scanner.nextInt();
		
		//Creacion de la matriz
		RootMatrix rootMatrix = new RootMatrix(size);
		
		System.out.println("Matriz creada\n");
		
		
		Thread.sleep(500);
		
	
		System.out.println("Introduzca los valores de la matriz:\n");
		
		//Asignacion de los valores de la matriz
		rootMatrix.ask4Values();
		
		scanner.close();
	}
	
}
