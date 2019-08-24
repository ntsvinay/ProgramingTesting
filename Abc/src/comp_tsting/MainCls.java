package comp_tsting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MainCls {
	public static void main(String srg[]) {
		ArrayList<Emp> al = new ArrayList<>();
		al.add(new Emp("vinay", "B S Baghel", 01, 23));
		al.add(new Emp("Ajay", "Veru Dev", 02, 55));
		al.add(new Emp("Sunny", "Dharmanedra", 03, 65));
		al.add(new Emp("yalmaan Khan", "Zakir khan", 04, 56));

		// Collections.sort(al, new Name_comp());
		int i = 0;
		/*
		 * for (Emp st : al) { i++;
		 * 
		 * System.out.println(i + "-----\n" + st.emp_id + "\n" + st.age + "\n" + st.name
		 * + "\n" + st.f_name);
		 * 
		 * }
		 */
		System.out.println("sorting using age");
		/*
		 * Collections.sort(al, new Age_comp()); for (Emp st : al) { i++;
		 * 
		 * System.out.println(i + "-----\n" + st.emp_id + "\n" + st.age + "\n" + st.name
		 * + "\n" + st.f_name);
		 * 
		 * }
		 */
		Collections.sort(al);
		Iterator as = al.iterator();
		while (as.hasNext()) {
			Emp s = (Emp) as.next();
			System.out.println(s.emp_id + "\n" + s.age + "\n" + s.name + "\n" + s.f_name);
		}

	}

}
