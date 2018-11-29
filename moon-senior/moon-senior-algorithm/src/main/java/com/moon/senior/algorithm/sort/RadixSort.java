package com.moon.senior.algorithm.sort;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arrays = new int[] { 5, 13, 33, 15, 123, 132, 434, 19, 89, 78, 67, 56, 45, 435, 90, 16, 7, 12, 2, 23, 65, 17, 87, 9, 84, 134, 234, 25, 6, 76, 3, 34, 32 };
		insertionSort(arrays);
		System.out.println(Arrays.toString(arrays));
	}

	/**
	 * 选择排序
	 * <p>
	 * 1.找到数组中最小的那个元素; <br/>
	 * 2.将最小的这个元素和数组中第一个元素交换位置; <br/>
	 * 3.在剩下的元素中找到最小的的元素，与数组第二个元素交换位置
	 * </p>
	 */
	static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			/** 1.找到数组中最小的那个元素 */
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					minIndex = j;
				}
			}

			/** 2.将最小的这个元素和数组中第一个元素交换位置 */
			int tmp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = tmp;
		}
	}

	static void selectionSort2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			/** 1.找到数组中最小的那个元素 */
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					/** 2.将最小的这个元素和数组中第一个元素交换位置 */
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	/**
	 * 插入排序
	 * <p>
	 * 插入排序类似整理扑克牌，将每一张牌插到其他已经有序的牌中适当的位置。<br/>
	 * 插入排序总共需要排序N-1趟，从index为1开始，将该位置上的元素与之前的元素比较，放入合适的位置，这样循环下来之后，即为有序数组。<br/>
	 * </p>
	 */
	static void insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			/** 1.拿到剩余没有排序的队列元素 */
			for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
				/** 2.前面已经有序的数组中，找到适当的位置 */
				int tmp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = tmp;
			}
		}
	}

	/**
	 * 希尔排序
	 * <p>
	 * 把记录按步长gap分组，对每组记录采用直接插入排序方法进行排序。<br/>
	 * 随着步长逐渐减小，所分成的组包含的记录越来越多，当步长的值减小到1时，整个数据合成为一组，构成一组有序记录，则完成排序。
	 * </p>
	 */
	static void shellSort(int[] array) {
		for (int gap = 0; gap < array.length / 2; gap++) {

			for (int j = gap; j > 0 && array[j] < array[j - 1]; j--) {
				/** 2.前面已经有序的数组中，找到适当的位置 */
				int tmp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = tmp;
			}
		}
	}
}
