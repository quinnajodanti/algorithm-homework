package org.buaa.algorithm;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/5/4.
 */
public class MultiplicationOfTwoMatrices
{
	public static int[][] matrix(int a[][], int b[][])
	{
		if (a[0].length != b.length)
		{
			return null;
		}
		int y = a.length;
		int x = b[0].length;
		int c[][] = new int[y][x];
		for (int i = 0; i < y; i++)
		{
			for (int j = 0; j < x; j++)
			{
				for (int k = 0; k < b.length; k++)
				{
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	public static void main(String[] args)
	{
		int[][] a = {{1, 0, 3}, {2, 1, 3}, {3, 5, 7}};
		int[][] b = {{4, 1}, {1, 1}, {2, 0}};
		System.out.println("Matrix a is:");
		for (int[] ints : a)
		{
			System.out.println(Arrays.toString(ints));
		}
		System.out.println("Matrix b is:");
		for (int[] ints : b)
		{
			System.out.println(Arrays.toString(ints));
		}
		System.out.println("a * b is :");
		for (int[] ints : matrix(a, b))
		{
			System.out.println(Arrays.toString(ints));
		}
	}
}