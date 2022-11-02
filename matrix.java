package matrix;
import java.util.Scanner;

public class matrix{
//matrices
public static int[][]one;
public static int[][]two;
//enteros que uso para dimensiones
public static int m; //filas de la primera matriz
public static int n; //columnas de la primera matriz
public static int n2; //columnas de la segunda matriz
public static int s; //entero utilizado como vriable para multiplicar
    
//Funcion para crear matrices 
   public static int[][] makematrix(int ro, int co) {
        int[][] makematrix = new int[ro][co];
        gv(makematrix, ro, co);
        System.out.println("\n Matriz inicial: ");
        pt(makematrix);
        return makematrix;
   } 


//Función para dar valores uno a uno a las matrices
static void gv(int[][]input, int r,int c){
	Scanner l = new Scanner(System.in);
	for(int i=0; i<r; i++){
	for(int j=0; j<c; j++){
	System.out.print(" Ingrese elemento"+(i++)+(j++)+":   "); //La razón por la que le sumo uno a los índices
    //es porque java comienza a contar desde cero, entonces comienza con elemento 00 si no le sumo 1
	input[i][j]=l.nextInt();
	}
	}
}

//Transpuesta
public static int[][] Trans(int[][] input) {
    System.out.println("\n");
    int Trans[][]=new int[input[0].length][input.length];
    for (int i = 0; i < input.length; i++) {
        for (int j = 0; j < input[0].length; j++) {
           Trans[j][i]=input[i][j];
        }
    }
   System.out.println("Transpuesta: ");
   pt(Trans); 
    System.out.println();
    return Trans;
}


//print matrix
static void pt(int[][]input){
 System.out.println();
	for(int i=0; i<input.length; i++){
		System.out.println();
	for(int j=0; j<input[0].length; j++){
System.out.print(input[i][j]+" ");
	}
	}
    System.out.println();
}

public static void main(String[]args) {
makeproblem();
}

public static void makeproblem() {
    int ans;
        Scanner sc= new Scanner(System.in);
        System.out.println("¿Qué operación quiere realizar?");
        System.out.println("1.- Suma");
        System.out.println("2.- Resta");
        System.out.println("3.- Multiplicación");
        System.out.println("4.- Transposición");
        System.out.println("5.- Salir");
       ans= sc.nextInt();
       switch(ans){
	       case 1:
            sum();
            break;
            case 2:
            sub();
            break;
            case 3:
            mult();
            break; 
            case 4:
            transp();
            break;
            case 5:
            System.exit(0);
            break;
       }
sc.close();
    }
    




//          Operaciones

//Suma

public static void sum() {
 Scanner sc = new Scanner(System.in);
 System.out.println("Primera matriz");
        System.out.println("Ingrese número de filas");
        m= sc.nextInt();
        System.out.println("Ingrese número de columnas");        
        n= sc.nextInt();
        System.out.println();

one=makematrix(m, n);
System.out.println("Segunda matriz \n Las dimensiones serán las mismas que las de la matriz anterior");
two=makematrix(m, n);

int[][]sum2= new int[m][n];
for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
		sum2[i][j]=one[i][j]+two[i][j];
        }

System.out.println(" Matrix result:");
pt(sum2);

        }
        sc.close();
}

//Resta
public static void sub() {
 Scanner sc = new Scanner(System.in);
 System.out.println("First matrix");
        System.out.println("Insert number of rows");
        m= sc.nextInt();
        System.out.println("Insert number of columns");        
        n= sc.nextInt();
        System.out.println();

one=makematrix(m, n);
System.out.println("Second matrix \n Las dimensiones serán las mismas de la matriz anterior");
two=makematrix(m, n);

int[][]sub2= new int[m][n];
for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
		sub2[i][j]=one[i][j]-two[i][j];
        }

System.out.println("Matriz resultante:");
pt(sub2);

        }
        sc.close();
}
//Función para transponer
public static void transp() {
 Scanner sc = new Scanner(System.in);
 System.out.println("Transposición");
        System.out.println("Ingrese número de filas");
        m= sc.nextInt();
        System.out.println("Ingrese número de columnas");        
        n= sc.nextInt();
        System.out.println();
	int[][]out=makematrix(m,n);
	Trans(out);

    
}
//multiplicación
public static void mult(){
 Scanner sc = new Scanner(System.in);
        System.out.println("Primera matriz");
        System.out.println("Ingrese número de filas");
        m= sc.nextInt();
        System.out.println("Ingrese número de columnas");        
        n= sc.nextInt();
        one=makematrix(m, n);
        System.out.println();
        System.out.println("Segunda matriz \n El número de filas será "+n+"\n Ingrese número de columnas");
        n2=sc.nextInt();
        two=makematrix(n, n2);
int[][]atb=new int[m][n2];
       for(int i=0; i<one.length; i++){
        for(int j=0; j<two[0].length; j++){
        for (int k = 0;k <two.length; k++) {
            s+=one[i][k]*two[k][j]; 
        }
        atb[i][j]+=s;
        s=0;
        }
       }
       pt(atb);
       sc.close();
}
}