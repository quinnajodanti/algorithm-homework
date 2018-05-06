package org.buaa.algorithm;

public class H5_1MultiplicationOfTwoIntegers {

    // 基本思想是把多项式A(x)与B(x)写成
    // A(x)=a*x^m+b
    // B(x)=c*x^m+d
    // 其中a,b,c,d为x的多项式。
    // 则A(x)*B(x)=(ac)*x^2m+(ad+bc)*x^m+bd
    // 由ad+bc=(a+b)(c+d)-ac-bd
    // 字符串模拟乘法操作

    public static String mut(String x, String y) {
//        符号位
        String sign = "";
        if ((x.startsWith("-") && !y.startsWith("-"))
                || (!x.startsWith("-") && y.startsWith("-"))) {
            sign = "-";
        }
//        消去符号
        x = x.replaceAll("-", "");
        y = y.replaceAll("-", "");

        // 如果长度都等于于1，相乘返回(带符号)
        if (x.length() == 1 && y.length() == 1) {
            // 计算乘积
            int tmp = (Integer.parseInt(x) * Integer.parseInt(y));
            if (tmp == 0) {
                return tmp + "";
            } else {
                return sign + tmp;
            }
        }

        // 公式里的abcd
        String a, b, c, d;
        if (x.length() == 1) {
            a = "0";
            b = x;
        } else {
            if (x.length() % 2 != 0) {
                x = "0" + x;
            }
            a = x.substring(0, x.length() / 2);
            b = x.substring(x.length() / 2);
        }
        if (y.length() == 1) {
            c = "0";
            d = y;
        } else {
            if (y.length() % 2 != 0) {
                y = "0" + y;
            }
            c = y.substring(0, y.length() / 2);
            d = y.substring(y.length() / 2);
        }

        // 按最大位数取值，以确定补零数目
        int n = x.length() >= y.length() ? x.length() : y.length();

        String t1, t2, t3;
        // 递归调用，根据公式计算出值。
        String ac = mut(a, c);
        String bd = mut(b, d);
        t1 = mut(sub(a, b), sub(d, c));
        t2 = add(add(t1, ac), bd);
        t3 = add(add(Power10(ac, n), Power10(t2, n / 2)), bd).replaceAll("^0+",
                "");
        if (t3 == "")
            return "0";
        return sign + t3;
    }

    private static String add(String x, String y) {

        if (x.startsWith("-") && !y.startsWith("-")) {
            return sub(y, x.replaceAll("^-", ""));
        } else if (!x.startsWith("-") && y.startsWith("-")) {
            return sub(x, y.replaceAll("^-", ""));
        } else if (x.startsWith("-") && y.startsWith("-")) {
            return "-" + add(x.replaceAll("^-", ""), y.replaceAll("^-", ""));
        }

        if (x.length() > y.length()) {
            y = format(y, x.length(), "0");
        } else {
            x = format(x, y.length(), "0");
        }
        int[] sum = new int[x.length() + 1];

        for (int i = x.length() - 1; i >= 0; i--) {
            int tmpsum = Integer.parseInt(x.charAt(i) + "")
                    + Integer.parseInt(y.charAt(i) + "") + sum[i + 1];
            if (tmpsum >= 10) {
                sum[i + 1] = tmpsum - 10;
                sum[i] = 1;// 表示进位
            } else {
                sum[i + 1] = tmpsum;
            }
        }

        StringBuilder returnvalue = new StringBuilder();

        for (int i : sum) {
            returnvalue.append(i);
        }

        if (sum[0] == 1) {
            return returnvalue.toString();
        } else {
            return returnvalue.replace(0, 1, "").toString();
        }

    }

    // 字符串模拟减法操作
    private static String sub(String x, String y) {
        // x是正数，y也是正数
        int flag = bigger(x, y);
        if (flag == 0) {
            return "0";
        } else if (flag == -1) {
            String tmp = y;
            y = x;
            x = tmp;
        }
        // 保证了x>=y
        y = format(y, x.length(), "0");// y补0与x对齐
        int[] difference = new int[x.length()];
        for (int i = x.length() - 1; i >= 0; i--) {
            int tmpdifference;
            tmpdifference = Integer.parseInt(x.charAt(i) + "")
                    - Integer.parseInt(y.charAt(i) + "") + difference[i];
            if (tmpdifference < 0) {
                tmpdifference += 10;
                difference[i - 1] = -1;// 表示进位
            }
            difference[i] = tmpdifference;
        }

        StringBuilder returnvalue = new StringBuilder();
        for (int i : difference) {
            returnvalue.append(i);
        }
        String rv = returnvalue.toString().replaceAll("^0+", "");
        if ("".equals(rv)) {
            return "0";
        }
        if (flag == -1) {
            rv = "-" + rv;
        }
        return rv;
    }

//    比较大小
    private static int bigger(String x, String y) {
        if (x.length() > y.length()) {
            return 1;
        } else if (x.length() < y.length()) {
            return -1;
        } else {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) > y.charAt(i)) {
                    return 1;
                } else if (x.charAt(i) < y.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }
    }

//    数据前补零
    private static String format(String str, int len, String fu) {
        len = len - str.length();
        for (int i = 0; i < len; i++) {
            str = fu + str;
        }
        return str;
    }


    //    *10
    public static String Power10(String num, int n) {
        for (int i = 0; i < n; i++) {
            num += "0";
        }
        return num;
    }

    public static void main(String[] args) {
        String x = "-938590480598490868509868047508947589857487584758094875890475984955624146039530798877974";
        String y = "22434344485940859047584753894603278473894578397598475984784";
        System.out.println("x:"+x);
        System.out.println("y:"+y);
        System.out.println("x*y:"+mut(x,y));

    }
}
