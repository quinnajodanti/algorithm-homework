package org.buaa.algorithm;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    /**
     * 构建大顶堆
     */
    public static void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) {
            // 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1]) {
                ++j; // j为关键字中较大记录的下标
            }
            if (temp >= a[j]) {
                break;
            }
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public static void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            adjustHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int b = r.nextInt(100);
            array[i] = b;
        }
        System.out.println("Before sort:" + Arrays.toString(array));
        heapSort(array);
        System.out.println("After sort:" + Arrays.toString(array));
    }
}