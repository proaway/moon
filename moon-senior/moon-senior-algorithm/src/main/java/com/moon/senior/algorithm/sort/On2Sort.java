package com.moon.senior.algorithm.sort;

public class On2Sort {

	/**
	 * 冒泡排序
	 * 
	 * @author Tobias
	 * @date 2019年1月25日 下午10:03:55
	 * 
	 * @param a
	 * @param n
	 */
	public void bubbleSort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 0; i < n; ++i) {
			// 提前退出冒泡循环的标志位
			boolean flag = false;
			for (int j = 0; j < n - i - 1; ++j) {
				if (a[j] > a[j + 1]) { // 交换
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = true; // 表示有数据交换
				}
			}
			if (!flag)
				break; // 没有数据交换，提前退出
		}
	}

	/**
	 * 插入排序，a 表示数组，n 表示数组大小
	 * 
	 * @author Tobias
	 * @date 2019年1月25日 下午10:05:46
	 * 
	 * @param a
	 * @param n
	 */
	public void insertionSort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 1; i < n; ++i) {
			int value = a[i];
			int j = i - 1;
			// 查找插入的位置
			for (; j >= 0; --j) {
				if (a[j] > value) {
					a[j + 1] = a[j]; // 数据移动
				} else {
					break;
				}
			}
			a[j + 1] = value; // 插入数据
		}
	}
	
	public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }
     
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组 
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

}
