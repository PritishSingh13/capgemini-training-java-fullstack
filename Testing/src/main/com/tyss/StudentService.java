package main.com.tyss;

public class StudentService {
	public boolean isEligible(int age) {
		if(age <= 0) {
			throw new ArithmeticException("Please enter valid age");
		}
		return age>=18;

		
	}

}
