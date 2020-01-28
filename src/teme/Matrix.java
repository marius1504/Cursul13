package teme;
import java.util.ArrayList;
import java.util.Scanner;
public class Matrix {

	private static int matrixDimension;
	private static int mainDiagValue;
	private static int sndDiagValue;
	private static int centerValue;
	private static int leftValue;
	private static int upValue;
	private static int bottomValue;
	private static int rightValue;
	
	public static int[][] generateMatrix(){
		int[][] result = new int[matrixDimension][matrixDimension];
				for(int i=0; i<matrixDimension; i++) {
			for(int j=0; j<matrixDimension; j++) {
				if(i == j) {
					result[i][j] = mainDiagValue;
				}else if(i < j) {
					if(i + j < (matrixDimension - 1)) {
						result[i][j] = upValue;
					}else if(i + j > (matrixDimension - 1)) {
						result[i][j] = rightValue;
					}else {
						result[i][j] = sndDiagValue;
					}
				}else {
					if(i + j < (matrixDimension - 1)) {
						result[i][j] = leftValue;
					}else if(i + j > (matrixDimension - 1)) {
						result[i][j] = bottomValue;
					}else {
						result[i][j] = sndDiagValue;
					}
				}
			}
		}
		if(matrixDimension % 2 == 1) {
			result[matrixDimension/2][matrixDimension/2] = centerValue;
		}	
		
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> generateMatrix(int n){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(matrixDimension);
		
			for(int i=0; i<matrixDimension; i++) {
				ArrayList<Integer> newRow = new ArrayList<Integer>(matrixDimension);
				
				for(int j=0; j<matrixDimension; j++) {
					if(i == j) {
						newRow.add(mainDiagValue);
					}else if(i < j) {
						if(i + j < (matrixDimension - 1)) {
							newRow.add(upValue);
						}else if(i + j > (matrixDimension - 1)) {
							newRow.add(rightValue);
						}else {
							newRow.add(sndDiagValue);
						}
					}else {
						if(i + j < (matrixDimension - 1)) {
							newRow.add(leftValue);
						}else if(i + j > (matrixDimension - 1)) {
							newRow.add(bottomValue);
						}else {
							newRow.add(sndDiagValue);
						}
					}
				}
				result.add(newRow);
		}
		if(matrixDimension % 2 == 1) {
			result.get(matrixDimension/2).set(matrixDimension/2, centerValue);
		}	
		
		return result;
	}
	
	public static void printMatrix(int[][] m) {
		for(int i=0; i<matrixDimension; i++) {
			for(int j=0; j<matrixDimension; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printMatrix(ArrayList<ArrayList<Integer>> m) {
		for(int i=0; i<m.size(); i++) {
			for(int j=0; j<m.get(i).size(); j++) {
				System.out.print(m.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t Introduceti dimensiunea matricei patratice (n = m), urmate de tasta ENTER. \n");
		Matrix.matrixDimension = sc.nextInt();
		
		System.out.println("\t Introduceti un numar intreg ce reprezinta valoarea "
							+ "elementelor de pe diagonala principala. \n");
		Matrix.mainDiagValue = sc.nextInt();
		
		System.out.println("\t Introduceti un numar intreg ce reprezinta valoarea "
				+ "elementelor de pe diagonala secundara. \n");
		Matrix.sndDiagValue = sc.nextInt();
		
		if(matrixDimension % 2 == 1) {
			System.out.println("\t Introduceti un numar intreg ce reprezinta valoarea elementului "
								+ "de pe pozitia din centru a matricei. \n");
			Matrix.centerValue = sc.nextInt();
		}
		
		System.out.println("\t Introduceti un numar intreg ce reprezinta valoarea "
				+ "elementelor din stanga. \n");
		Matrix.leftValue = sc.nextInt();
		
		System.out.println("\t Introduceti un numar intreg ce reprezinta valoarea "
				+ "elementelor din partea de sus. \n");
		Matrix.upValue = sc.nextInt();
		
		System.out.println("\t Introduceti un numar intreg ce reprezinta valoarea "
				+ "elementelor din dreapta. \n");
		Matrix.rightValue = sc.nextInt();
		
		System.out.println("\t Introduceti un numar intreg ce reprezinta valoarea "
				+ "elementelor din partea de jos. \n");
		Matrix.bottomValue = sc.nextInt();
		
		printMatrix(generateMatrix());
		
		printMatrix(generateMatrix(1));
	}

}
