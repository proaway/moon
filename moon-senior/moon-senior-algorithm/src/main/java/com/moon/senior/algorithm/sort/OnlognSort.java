package com.moon.senior.algorithm.sort;

public class OnlognSort {

	/**
	 * 归并排序
	 * 
	 * @author Tobias
	 * @date 2019年1月25日 下午10:13:47
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] mergeSort(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			// 左右归并
			mergeSortMerge(a, low, mid, high);
		}
		return a;
	}

	/**
	 * 合并
	 */
	public static void mergeSortMerge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = a[j++];
		}
		// 把新数组中的数覆盖nums数组
		for (int x = 0; x < temp.length; x++) {
			a[x + low] = temp[x];
		}
	}

	public void quickSort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];

		while (end > start) {
			// 从后往前比较
			while (end > start && a[end] >= key) // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				end--;
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;	
			}
			// 从前往后比较
			while (end > start && a[start] <= key) // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		// 递归
		if (start > low)
			quickSort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
		if (end < high)
			quickSort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
	}

}
