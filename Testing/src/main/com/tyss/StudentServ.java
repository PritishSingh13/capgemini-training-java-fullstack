package main.com.tyss;
public class StudentServ {

    public String calculateGrade(int marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Invalid Marks");
        }

        if (marks >= 75) {
            return "Distinction";
        } else if (marks >= 60) {
            return "First Class";
        } else if (marks >= 50) {
            return "Second Class";
        } else {
            return "Fail";
        }
    }

    public boolean isPassed(int marks) {
        return marks >= 50;
    }
}
