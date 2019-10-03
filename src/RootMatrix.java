import java.util.*;

public class RootMatrix {
	
	Scanner scanner = new Scanner(System.in);
	
	int matrix[][];
	int size;
	int aux1 = 0;
	int aux2 = 0;
	
	public RootMatrix(int size) {
		this.matrix = new int[size][size];
		this.size = size;
	}
	
	public void ask4Values() throws InterruptedException {		
		if(this.aux1 < this.size && this.aux2 < this.size) {
			System.out.println("\nValor: ");
			this.matrix[aux2][aux1] = this.scanner.nextInt();
			this.aux1++;
			//Realizamos recurrencia para que se llenen todos las columnas de la primera fila en este if
			ask4Values();		
		}
		else if(this.aux2 < this.size) {
			//Aumentamos la posicion de la fila en uno y reseteamos la de las columnas
			this.aux2++;
			this.aux1 = 0;
			ask4Values();
		}
		
		else if(this.aux2 == this.size) {
			//Cerramos el scanner ya que en lo que queda de ejecucion del programa no se necesitara leer mas valores por el teclado 
			//Reseteamos los valores auxiliares que actuan como indice de columnas y filas
			this.aux1 = 0;
			this.aux2 = 0;
			scanner.close();
			
			Thread.sleep(500);
			
			System.out.println("Matriz introducida: \n");
			printMatrix();
		}		 
	}

	public void printMatrix() {		
		if(this.aux1 < this.size && this.aux2 < this.size) {
			System.out.print(" "+this.matrix[aux2][aux1]+" ");			
			this.aux1++;
			//Realizamos recurrencia para imprimir todas las columnas de la primera fila
			printMatrix();		
		}
		else if(this.aux2 < this.size) {
			//Aumentamos la posicion de la fila en uno y reseteamos la de las columnas
			this.aux2++;
			this.aux1 = 0;
			System.out.println("\n");
			printMatrix();
		}
		
		if(this.aux1 == this.size && this.aux2 == this.size) {
			//Cerramos el scanner ya que en lo que queda de ejecucion del programa no se necesitara leer mas valores por el teclado 
			//Reseteamos los valores auxiliares que actuan como indice de columnas y filas
			this.aux1 = 0;
			this.aux2 = 0;
		}		 
	}

}
