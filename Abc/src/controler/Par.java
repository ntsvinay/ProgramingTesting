package controler;

public class Par {
	int x=50;
	static void check(Par ref)
	{
		System.out.println("const of parent class");
		ref.m1(4);
	}
	
	void m1(int x)
	{
		System.out.println("para of const of parent class  m1 " + x);
	}
	public void abc()
	{
		System.out.println("he its abc from parent");
	}
	public void abcd()
	{
		System.out.println("he its abcd from parent");
	}

}
