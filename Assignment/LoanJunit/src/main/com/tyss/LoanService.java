package main.com.tyss;


public class LoanService {
	public boolean isEligible(int age,double Salary) {
		return age>=21 && age <=60 && Salary>=25000;
	}
	
	public double calculateEMI(double loanAmount,int tenureYears) {
		if(loanAmount <= 0) {
			throw new IllegalArgumentException("INVALID amounr");
		}else if(tenureYears <= 0) {
			throw new IllegalArgumentException("Invalid years");
		}
		return loanAmount/(tenureYears*12);	
	}
	
	public String getLoanCategory(int credit) {
		if(credit >= 750) {
			return "Premium";
		}else if(credit >= 600 && credit <=749) {
			return "Standard";
		}
			return "High Risk";
	}
	

}
