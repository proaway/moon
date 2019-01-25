package com.moon.senior.algorithm.search;

public class BinarySearch {

	public static void binarySearch(int num, int[] a, int start, int end) {
		if (start == end) {
			if (num == a[start]) {
				System.out.println("a[" + start + "]=" + num);
			} else {
				System.out.println("不存在");
			}
			return;
		}
		int mid = (start + end) >> 1;
		if (num > a[mid]) {
			binarySearch(num, a, mid + 1, end);
		} else if (num < a[mid]) {
			binarySearch(num, a, start, mid - 1);
		} else {
			System.out.println("a[" + mid + "]=" + num);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int num = 1;
		System.out.println("搜索：" + num);
		BinarySearch.binarySearch(num, a, 0, a.length - 1);
	}

	public int bsearch(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (low < n && a[low] == value)
			return low;
		else
			return -1;
	}

	public int bsearch2(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				if ((mid == 0) || (a[mid - 1] != value))
					return mid;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

	public int bsearch3(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				if ((mid == n - 1) || (a[mid + 1] != value))
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	public int bsearch4(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				if ((mid == 0) || (a[mid - 1] < value))
					return mid;
				else
					high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public int bsearch7(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else {
				if ((mid == n - 1) || (a[mid + 1] > value))
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	public int bsearch9(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else {
				if ((mid == n - 1) || (a[mid + 1] > value))
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

}
