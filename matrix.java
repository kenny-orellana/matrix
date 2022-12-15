//package matrix;
import java.util.InputMismatchException;
import java.util.Scanner;

public class matrix{
// intial matrices
public static int[][]one;
public static int[][]two;
//dimensions of initial matrices
public static int m; //rows of fm first matrix
public static int n; //columns of fm second matrix
public static int n2; //columns of sm
public static int s; //Part of mult

public static void main(String[]args) {
makeproblem();
}

public static void makeproblem() {
    int ans = 0;
Scanner sc= new Scanner(System.in);
System.out.println("Which operation do you want to perform?\n 1.- Addition\n 2.- Substraction\n 3.- Multiplication\n 4.- Transposition\n 5.- Exit"); 
do{try{ans= sc.nextInt();}
catch(InputMismatchException e){
System.out.println("Insert a valid input (integer 1-5)");
makeproblem();
}
} while(ans==0);

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
    default:
     makeproblem();
}
sc.close();
    }
//          operations
public static void sum() { //addition
Scanner sc = new Scanner(System.in);
System.out.println(" First matrix\n");
row();
col();
one=makematrix(m, n);
System.out.println(" Second matrix \n The dimensions will be the same as the last one");
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

public static int[][] Trans(int[][] input) { //Transpose
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

public static void sub() { //substraction
Scanner sc = new Scanner(System.in);
System.out.println("First matrix\n");
row();
col();
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

public static void transp() { //Void for Transposition
System.out.println("Transpose");
row();
col();
System.out.println();
int[][]out=makematrix(m,n);
Trans(out);
}

public static void mult(){ //multiplication
Scanner sc = new Scanner(System.in);
row();
col();
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

//Other things
   public static int[][] makematrix(int ro, int co) { //matrix markers and fillers 
        int[][] makematrix = new int[ro][co];
        gv(makematrix, ro, co);
        System.out.println("\n Initial matrix: ");
        pt(makematrix);
        return makematrix;
   } 

static void gv(int[][]input, int r,int c){ //give values to every element
	for(int i=0; i<r; i++){
	for(int j=0; j<c; j++){
	System.out.print(" Insert element "+(i+1)+(j+1)+":   ");
 individual(input, i, j);
	}
	}
}

public static void individual(int[][]input, int r,int c) { //fill each individual element
	Scanner l = new Scanner(System.in);
	try{input[r][c]=l.nextInt();}
    catch(InputMismatchException e){
System.out.println("Insert a valid input (integer)");
individual(input, r, c);
    }
}

static void pt(int[][]input){ //print matrix
System.out.println();
for(int i=0; i<input.length; i++){
	System.out.println();
for(int j=0; j<input[0].length; j++){
 System.out.printf("%5d ",input[i][j]);
    }
    }
System.out.println();
}

public static void row() { //ask for the amount of rows
Scanner sc = new Scanner(System.in);
System.out.println("Insert number of rows");
try{m= sc.nextInt();}
catch(InputMismatchException e ){
System.out.println("Insert Matching Input (Integer)");
row();
}
}

public static void col() {//ask for the amount of columns
Scanner sc = new Scanner(System.in);
System.out.println("Insert number of columns");        
try{n= sc.nextInt();}
catch(InputMismatchException e){
System.out.println("Insert Matching Input (Integer)");
col();
}
}
}
