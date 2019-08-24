
import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicate {
	public int[] getArray() {
		int n, sum = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter no. of elements you want in array:");
		n = s.nextInt();
		int a[] = new int[n];
		System.out.println("Enter all the elements:");
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		return a;
	}

	public int removeDup(int[] a, int len) {
		if (len == 0 && len == 1) {
			return len;
		}
		int[] temp = new int[len];
		int j = 0;
		for (int i = 0; i < len - 1; i++) {
			if (a[i] != a[i + 1]) {
				temp[j++] = a[i];
			}

		}
		temp[j++] = a[len - 1];

		for (int i = 0; i < j; i++) {
			a[i] = temp[i];
		}
		return j;
	}

	public static void main(String args[]) {
		RemoveDuplicate removeDuplicate = new RemoveDuplicate();
		int arr[] = removeDuplicate.getArray();
		Arrays.sort(arr);// sorting array
		int length = arr.length;
	
		int len = removeDuplicate.removeDup(arr, length);
		
		System.out.print("Return value: " + len +" ");
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + "\t ");
		}
	}
}