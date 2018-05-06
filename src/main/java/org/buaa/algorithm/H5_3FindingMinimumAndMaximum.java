package org.buaa.algorithm;

import java.util.Random;

public class H5_3FindingMinimumAndMaximum {
    public static void main(String[] args) {
        int number = 20;
        new H5_3FindingMinimumAndMaximum().test(number);
    }

    public void test(int number) {
        int[] array = getArray(number);
        System.out.println("数组：");
        printArray(array);
        MinMax result = findMaxMin(array, 0, array.length - 1);
        System.out.println();
        System.out.println("最小值：" + result.getMin());
        System.out.println("最大值：" + result.getMax());
    }

    public MinMax findMaxMin(int[] array, int begin, int end) {
        if (end - begin <= 1) {
            if (array[begin] > array[end]) {
                return new MinMax(array[end], array[begin]);
            } else {
                return new MinMax(array[begin], array[end]);
            }
        } else {
            int mid = (begin + end) / 2;
            MinMax left = findMaxMin(array, begin, mid);
            MinMax right = findMaxMin(array, mid, end);
            int min = 0, max = 0;
            min = left.getMin() > right.getMin() ? right.getMin() : left.getMin();
            max = left.getMax() > right.getMax() ? left.getMax() : right.getMax();
            return new MinMax(min, max);
        }

    }

    class MinMax {

        private int min;
        private int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int value) {
            min = value;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int value) {
            max = value;
        }
    }

    public static int[] getArray(int number) {
        int[] array = new int[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
    }
}