package controler;

public class Chil extends Par {
	int x = 20;

	void m1(int x) {
		System.out.println("mi of child");
	}

	public void ab() {
		System.out.println("he its ab from child" + x);
		int x = super.x;
		System.out.println("he its ab from child" + x);
	}

	public void abcd() {
		System.out.println("he its abcd from child");
	}

	public static void main(String arg[]) {
		Chil pp = new Chil();
		Chil ch = (Chil) pp;
		pp.ab();
		pp.abcd();
		ch.ab();

	}

}
