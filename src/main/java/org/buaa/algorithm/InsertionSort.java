package org.buaa.algorithm;

import java.util.Arrays;

public class InsertionSort
{
	private static void insertSort(int[] arr)
	{
		int i, j;
		int n = arr.length;
		int target;

		for (i = 1; i < n; i++)
		{
			j = i;
			target = arr[i];

			while (j > 0 && target < arr[j - 1])
			{
				arr[j] = arr[j - 1];
				j--;
			}

			arr[j] = target;
		}
	}

	public static void main(String[] args)
	{
		int[] array = new int[]{6, 2, 7, 3, 4, 1, 9, 0, 5, 8};
		System.out.println("Before sort:" + Arrays.toString(array));
		InsertionSort.insertSort(array);
		System.out.println("After sort:" + Arrays.toString(array));
	}
}