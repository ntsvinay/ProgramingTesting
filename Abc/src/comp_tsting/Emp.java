package comp_tsting;

public class Emp implements Comparable<Emp> {
	String name;
	String f_name;
	int emp_id;
	int age;

	public Emp(String name, String f_name, int emp_id, int age) {
		super();
		this.name = name;
		this.f_name = f_name;
		this.emp_id = emp_id;
		this.age = age;
	}

	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		
		if (o.age == o.age)
			return 0;
		else if (o.age < o.age)
			return -1;
		else
			return 1;
	}

}
