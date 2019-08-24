package comp_tsting;

import java.util.Comparator;

public class Name_comp implements Comparator<Emp>
{

	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}

}
