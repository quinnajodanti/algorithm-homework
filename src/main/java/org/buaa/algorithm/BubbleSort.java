package org.buaa.algorithm;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort
{
	public static int[] bubbleSort(int[] A)
	{
		for (int i = 0; i < A.length; i++)
		{
			for (int j = i + 1; j < A.length; j++)
			{
				if (A[i] > A[j])
				{
					int tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
				}
			}
		}
		return A;
	}

	public static void main(String[] args)
	{
		int[] array = new int[10];
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int b = r.nextInt(100);
			array[i] = b;
		}
		System.out.println("Before sort:" + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("After sort:" + Arrays.toString(array));
	}
}