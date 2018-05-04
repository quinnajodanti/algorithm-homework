package org.buaa.algorithm;

import java.util.Arrays;

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
		int[] array = new int[]{6, 2, 7, 3, 4, 1, 9, 0, 5, 8};
		System.out.println("Before sort:" + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("After sort:" + Arrays.toString(array));
	}
}