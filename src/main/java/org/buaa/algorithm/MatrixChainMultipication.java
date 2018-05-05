package org.buaa.algorithm;

public class MatrixChainMultipication
{
	private static String name = "ABCDEF";
	private static int[] a = {30, 35, 15, 5, 10, 20, 25};

	private static int len = a.length - 1;

	private static int[][] m = new int[len][len];
	private static int[][] s = new int[len][len];

	public static void main(String[] args)
	{
		System.out.println("矩阵的规模为:");
		for (int i = 0; i < a.length - 1; i++)
		{
			System.out.println(a[i] + "*" + a[i + 1]);
		}
		System.out.print("最少需要的计算次数：");
		Compute(a, m, s);
		System.out.println();

		System.out.print("矩阵相乘的顺序为： ");
		Display(s, name, 0, len - 1);
	}

	public static void Compute(int[] a, int[][] m, int[][] s)
	{
		int t = 0;
		int min = 0;
		int temp = 0;

		for (int i = 2; i < a.length; i++)
		{
			for (int j = 0; j < a.length - i; j++)
			{
				t = j + i - 1;

				m[j][t] = Integer.MAX_VALUE;

				for (int k = j; k < t; k++)
				{
					temp = m[j][k] + m[k + 1][t] + a[j] * a[k + 1] * a[t + 1];

					if (temp < m[j][t])
					{
						min = temp;
						m[j][t] = temp;
						s[j][t] = k;
					}
				}
			}
		}

		System.out.print(min);
	}

	public static void Display(int[][] s, String name, int i, int j)
	{
		if (i == j)
		{
			System.out.print(name.charAt(i));
		}
		else
		{
			System.out.print("(");
			Display(s, name, i, s[i][j]);
			Display(s, name, s[i][j] + 1, j);
			System.out.print(")");
		}
	}
}