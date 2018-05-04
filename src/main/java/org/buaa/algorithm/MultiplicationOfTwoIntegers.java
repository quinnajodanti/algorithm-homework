package org.buaa.algorithm;

/**
 * Created by zhangsw on 2018/5/4.
 */
public class MultiplicationOfTwoIntegers
{
	public static String multiply(String num1, String num2)
	{
		if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
		{
			return "";
		}
		if (num1.charAt(0) == '0')
		{
			return "0";
		}
		if (num2.charAt(0) == '0')
		{
			return "0";
		}
		StringBuilder res = new StringBuilder();
		int num = 0;
		for (int i = num1.length() + num2.length(); i > 0; i--)
		{
			for (int j = Math.min(i - 1, num1.length()); j > 0; j--)
			{
				if (i - j <= num2.length())
				{
					num += (num1.charAt(j - 1) - '0') * (num2.charAt(i - 1 - j) - '0');
				}
			}
			if (i != 1 || num > 0)
			{
				res.append(num % 10);
			}
			num = num / 10;
		}
		return res.reverse().toString();
	}

	public static void main(String[] args)
	{
		String a = "438602957";
		String b = "73060462945389";
		System.out.println(a + " * " + b + " = " + multiply(a, b));
	}
}
