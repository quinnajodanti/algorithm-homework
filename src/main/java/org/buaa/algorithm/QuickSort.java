package org.buaa.algorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort
{
	public static void quickSort(int[] A)
	{
		quickSort(A, 0, A.length - 1);
	}

	public static void quickSort(int[] A, int left, int right)
	{

		if (left < right)
		{
			// 一次划分
			int mid = partion(A, left, right);
			quickSort(A, 0, mid - 1);
			quickSort(A, mid + 1, right);
		}
	}

	public static void swap(int[] A, int l, int r)
	{
		int tmp = A[l];
		A[l] = A[r];
		A[r] = tmp;

	}

	public static int partion(int[] a, int left, int right)
	{
		// 轴值，默认选取数组的第一个数字
		while (left < right)
		{
			while (left < right && a[left] <= a[right])
			{
				right--;
			}
			if (left < right)
			{
				swap(a, left, right);
			}
			while (left < right && a[left] <= a[right])
			{
				left++;
			}
			if (left < right)
			{
				swap(a, left, right);
			}
		}
		return left;
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
		quickSort(array);
		System.out.println("After sort:" + Arrays.toString(array));
	}
}