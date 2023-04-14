package com.sample;

public class ArrayPractice1 {

	public static void main(String[] args) {
	int a[]= {5,0,1,4,3};
	for(int i=0;i<a.length;i++) {
		for(int j=i+1;j<a.length;j++) {
			if(a[i]>a[j]) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}

	}
	System.out.print("First min no in the array "+a[1]);
	}

}
