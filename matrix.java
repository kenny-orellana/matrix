package matrix;
import java.util.Scanner;

public class matrix{
//matrices
public static int[][]one;
public static int[][]two;
//public ints for rows and columns
public static int m; //rows of fm
public static int n; //columns of fm
public static int n2; //columns of sm
public static int s; //Part of mult
    
//matrix markers and fillers 
   public static int[][] makematrix(int ro, int co) {
        int[][] makematrix = new int[ro][co];
        gv(makematrix, ro, co);
        System.out.println("\n Initial matrix: ");
        pt(makematrix);
        return makematrix;
   } 


//give values to every element
static void gv(int[][]input, int r,int c){
	Scanner l = new Scanner(System.in);
	for(int i=0; i<r; i++){
	for(int j=0; j<c; j++){
	System.out.print(" Insert element "+(i+1)+(j+1)+":   ");
	input[i][j]=l.nextInt();
	}
	}
}

//Transposion
public static int[][] Trans(int[][] input) {
    System.out.println("\n");
    int Trans[][]=new int[input[0].length][input.length];
    for (int i = 0; i < input.length; i++) {
        for (int j = 0; j < input[0].length; j++) {
           Trans[j][i]=input[i][j];
        }
    }
   System.out.println("Transpose: ");
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
        System.out.println("Which operation do you want to perform?");
        System.out.println("1.- Addition");
        System.out.println("2.- Substraction");
        System.out.println("3.- Multiplication");
        System.out.println("4.- Transposition");
        System.out.println("5.- Exit");
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
    




//          operations

//addition

public static void sum() {
 Scanner sc = new Scanner(System.in);
 System.out.println("First matrix");
        System.out.println("Insert number of rows");
        m= sc.nextInt();
        System.out.println("Insert number of columns");        
        n= sc.nextInt();
        System.out.println();

one=makematrix(m, n);
System.out.println("Second matrix \n The dimensions will be the same as the last one");
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

//substraction
public static void sub() {
 Scanner sc = new Scanner(System.in);
 System.out.println("First matrix");
        System.out.println("Insert number of rows");
        m= sc.nextInt();
        System.out.println("Insert number of columns");        
        n= sc.nextInt();
        System.out.println();

one=makematrix(m, n);
System.out.println("Second matrix \n The dimensions will be the same as the last one");
two=makematrix(m, n);

int[][]sub2= new int[m][n];
for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
		sub2[i][j]=one[i][j]-two[i][j];
        }

System.out.println("Matrix result:");
pt(sub2);

        }
        sc.close();
}
//Void for Transposition
public static void transp() {
 Scanner sc = new Scanner(System.in);
 System.out.println("Transposition");
        System.out.println("Insert number of rows");
        m= sc.nextInt();
        System.out.println("Insert number of columns");        
        n= sc.nextInt();
        System.out.println();
	int[][]out=makematrix(m,n);
	Trans(out);

    
}
//multiplication
public static void mult(){
 Scanner sc = new Scanner(System.in);
        System.out.println("First matrix");
        System.out.println("Insert number of rows");
        m= sc.nextInt();
        System.out.println("Insert number of columns");        
        n= sc.nextInt();
        one=makematrix(m, n);
        System.out.println();
        System.out.println("Second matrix \nThe rows will be "+n+"\nInsert columns");
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