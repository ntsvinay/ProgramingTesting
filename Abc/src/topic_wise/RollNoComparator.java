package topic_wise;

import java.util.Comparator;

public class RollNoComparator implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		if (s1.rollno > s2.rollno)

			return 1;

		else

			return -1;

	}

}
