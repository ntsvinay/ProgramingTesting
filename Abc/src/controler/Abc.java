package controler;

public class Abc {
	String value="-158.072500";
	double latiutde=19.225910;
	double logtitude=-157.8651;
	double value1=Double.parseDouble(value);
	public double abcd()
	{
		System.out.println(value1);
		
		if (latiutde < 60.00 && latiutde > 22.00 && logtitude > -97.00 && logtitude < -47.00) {
			System.out.println("lat and long match from east eca");
		} else if (latiutde < 61.00 && latiutde > 32.00 && logtitude > -153.00 && logtitude < -117.00) {
			System.out.println("lat and long match from 'west' eca");
			
		} else if (latiutde < 25.00 && latiutde > 15.00 && logtitude > -163.00 && logtitude < -115.00) {
			System.out.println("lat and long match from hawai eca");
			
		}
		else
		{
			System.out.print("ship is not in eca");
		}
		return value1;
	}
	public String hindi()
	{
		System.out.println("fdnvlfdij");
		return "from abc class";
	}
}