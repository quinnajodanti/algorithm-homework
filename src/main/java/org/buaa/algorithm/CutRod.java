package org.buaa.algorithm;

import java.util.Arrays;

public class CutRod
{
	/**
	 * 动态规划，自底向上求解。
	 *
	 * @param p 钢条的价格数组，
	 * @param n 钢条的长度，这里的划分是以 1 为单位
	 * @return 最大收益
	 */
	public static int bottomUpCutRod(int[] p, int n)
	{
		//一个数组，用r[i] 来保存 钢条长度为 i 的时候的最优值，初始值赋为 0.
		int[] r = new int[n + 1];
		for (int i = 0; i < r.length; i++)
		{
			r[i] = 0;
		}

		//循环,外层依次求解 1....n的最优值
		for (int j = 1; j <= n; j++)
		{
			int q = -1;
			//内层，依次在 1 .. j 中求出最大值，
			//例如
			// 当 j =1 的时候，q=max(q,p[1]+r[0]) .求的r[1]的最优值
			// 当 j =2 的时候，q=max(q,p[1]+r[1])，然后再是 q=max(q,p[2]+r[0])  ，求的r[2]的最优值
			//  ... 以此类推
			for (int i = 1; i <= j; i++)
			{
				q = Math.max(q, p[i - 1] + r[j - i]);
			}
			//记录 j 的最优值
			r[j] = q;
		}
		//最终返回 n 的最优值
		return r[n];
	}

	public static void main(String[] args)
	{
		int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24};
		int length = 8;
		System.out.println("价格数组:" + Arrays.toString(price));
		System.out.println("钢条长度:" + length);
		System.out.println("最优收益:" + bottomUpCutRod(price, length));
	}
}