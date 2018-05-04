package org.buaa.algorithm;

import java.util.Arrays;

public class MergeSort
{
	private static void mergeSort(int[] arr)
	{
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] temp, int left, int right)
	{
		if (left < right)
		{
			int center = (left + right) / 2;
			mergeSort(arr, temp, left, center);
			mergeSort(arr, temp, center + 1, right);
			merge(arr, temp, left, center + 1, right);
		}
	}

	private static void merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd)
	{
		int leftEnd = rightPos - 1;
		int tempPos = leftPos;
		int numEle = rightEnd - leftPos + 1;
		while (leftPos <= leftEnd && rightPos <= rightEnd)
		{
			if (arr[leftPos] <= arr[rightPos])
			{
				temp[tempPos++] = arr[leftPos++];
			}
			else
			{
				temp[tempPos++] = arr[rightPos++];
			}
		}
		while (leftPos <= leftEnd)
		{
			temp[tempPos++] = arr[leftPos++];
		}
		while (rightPos <= rightEnd)
		{
			temp[tempPos++] = arr[rightPos++];
		}
		// 将temp复制到arr
		for (int i = 0; i < numEle; i++)
		{
			arr[rightEnd] = temp[rightEnd];
			rightEnd--;
		}
	}

	public static void main(String[] args)
	{
		int[] array = new int[]{6, 2, 7, 3, 4, 1, 9, 0, 5, 8};
		System.out.println("Before sort:" + Arrays.toString(array));
		MergeSort.mergeSort(array);
		System.out.println("After sort:" + Arrays.toString(array));
	}
}