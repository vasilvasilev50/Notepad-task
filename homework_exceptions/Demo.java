package homework_exceptions;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {

		int[] array1 = { 8, 3, 10, 24, 0, 4, 7, 14 };
		int[] array2 = { 4, 0, 5, 3, 9, 4 };

		System.out.println(Arrays.toString(devideArrays(array1, array2)));

	}

	static int[] devideArrays(int[] a1, int[] a2) {
		int[] newArray;
		try {
			newArray = new int[a1.length];
			devideArrays(a1, a2, newArray);
		} catch (ArrayIndexOutOfBoundsException e) {
			newArray = new int[a2.length];
			devideArrays(a1, a2, newArray);
		}

		return newArray;
	}

	public static void devideArrays(int[] a1, int[] a2, int[] newArray) {
		for (int index = 0; index < newArray.length; index++) {
			try {
				newArray[index] = a1[index] / a2[index];
			} catch (ArithmeticException e) {
				newArray[index] = 0;
			}
		}
	}

}
