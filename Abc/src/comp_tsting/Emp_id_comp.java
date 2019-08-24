package comp_tsting;

import java.util.Comparator;

public class Emp_id_comp implements Comparator<Emp> {

	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		if (o1.emp_id == o2.emp_id)
			return 0;
		else if (o1.emp_id > o2.emp_id)
			return -1;
		else
			return 1;
	}

}
