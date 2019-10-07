import java.util.*;

public class RootMatrix {
	
	Scanner scanner = new Scanner(System.in);
	
	int matrix[][];
	int rootMatrix[][];
	int size;
	int column = 0;
	int row = 0;
	int i = 1;
	
	
	/**
	 * Constructor de la clase que crea una matriz cuadrada de numeros enteros
	 * @param size orden de la matriz cuadrada
	 */
	public RootMatrix(int size) {
		this.matrix = new int[size][size];
		this.rootMatrix = new int[size][size];
		this.size = size;
	}	
	
	/*
	 * Metodo que usa el scanner para preguntar y asignar los valores de cada posicion de la matriz
	*/ 
	public void ask4Values() {	
		
		if(this.row < this.size && this.column < this.size) {
			System.out.print("Fila " +(this.row + 1) + " ");
		}
		
		if(this.column < this.size && this.row < this.size) {
			System.out.println("Valor " +(column+1)+ ": ");
			this.matrix[row][column] = this.scanner.nextInt();
			this.column++;
			//Realizamos recurrencia para que se llenen todos las columnas de la primera fila en este if
			ask4Values();		
		}
		else if(this.row < this.size) {
			//Aumentamos la posicion de la fila en uno y reseteamos la de las columnas
			this.row++;
			this.column = 0;
			ask4Values();
		}
		
		else if(this.row == this.size) {
			//Cerramos el scanner ya que en lo que queda de ejecucion del programa no se necesitara leer mas valores por el teclado 
			//Reseteamos los valores auxiliares que actuan como indice de columnas y filas
			this.column = 0;
			this.row = 0;
			scanner.close();
			
			System.out.println("Matriz introducida: \n");
			printMatrix(this.matrix);
			getNumber();
		}		 
	}
	
	/*
	 * Metodo que se encarga de recorrer todas las posiciones de rootMatrix y de asignarle los valores que devuelve la funcion getRoot
	 */
	public void getNumber() {		
		if(this.column < this.size && this.row < this.size) {			
			this.rootMatrix[row][column] = getRoot(this.matrix[row][column]);
			this.column++;
			//Realizamos recurrencia para que se recorran todos las columnas de la primera fila en este if
			getNumber();
		}
		
		else if(this.row < this.size) {
			//Aumentamos la posicion de la fila en uno y reseteamos la de las columnas
			this.row++;
			this.column = 0;
			getNumber();
		}
		
		else if(this.row == this.size) {
			//Cerramos el scanner ya que en lo que queda de ejecucion del programa no se necesitara leer mas valores por el teclado 
			//Reseteamos los valores auxiliares que actuan como indice de columnas y filas
			this.column = 0;
			this.row = 0;			
			
			System.out.println("Matriz de raices cuadradas de la introducida: \n");
			printMatrix(this.rootMatrix);
		}
	}
	
	/*
	 * Metodo que se encarga de calcular la aproximacion entera de la raiz de un numero
	 */
	public int getRoot(int value) {
		if(this.i * this.i <= value) {
			this.i++;
			return getRoot(value);
		}
		
		else {
			return (this.i-1);
		}
	}
	
	/*
	 * Metodo que se encarga de previsualizar la matriz por pantalla que se le pase como parametro
	 */
	public String printMatrix(int matrix[][]) {		
		if(this.column < this.size && this.row < this.size) {
			System.out.print(" "+matrix[this.row][this.column]+" ");			
			this.column++;
			//Realizamos recurrencia para imprimir todas las columnas de la primera fila
			printMatrix(matrix);		
		}
		else if(this.row < this.size) {
			//Aumentamos la posicion de la fila en uno y reseteamos la de las columnas
			this.row++;
			this.column = 0;
			System.out.println("\n");
			printMatrix(matrix);
		}
		
		if(this.row == this.size) {			
			//Reseteamos los valores auxiliares que actuan como indice de columnas y filas
			this.column = 0;
			this.row = 0;
		}
		return "";
	}
}
