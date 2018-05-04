package org.buaa.algorithm;

import java.util.Arrays;

public class MajorityElement
{
	public static int majorityElement(int[] a)
	{
		int counter = 0, majority = a[0];
		for (int i = 0; i < a.length; ++i)
		{
			if (counter == 0)
			{
				majority = a[i];
				++counter;
			}
			else
			{
				counter += (a[i] == majority) ? 1 : -1;
			}
		}
		return majority;
	}

	public static void main(String[] args)
	{
		int[] a = new int[]{9, 9, 2, 8, 9, 5, 6, 9, 9, 1, 9, 6, 9, 4, 9, 7, 9};
		System.out.println("Original array is:" + Arrays.toString(a));
		System.out.println("The majority element is:" + majorityElement(a));
	}
}