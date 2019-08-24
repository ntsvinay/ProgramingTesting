package test;

class Abc {
	public static void main(String ar[]) {

		int i;
		int n = 100;
		int sum = 0;
		int r, sq;
		int a;
		for (i = 1; i <= n; i++) {
			sq = i * i;

			while (sq != 0) {
				r = sq % 10;
				sum = sum + r;
				sq = sq / 10;
			}
			if (sq == sum)
				System.out.println("abc");
		}
	}
}
