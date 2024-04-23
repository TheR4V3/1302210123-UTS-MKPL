package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private Date yearJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private boolean gender; 
	
	private Salary Salary;
	
	public class Spouse {
		private String spouseName;
		private String spouseIdNumber;
	}

	public class Child {
		private String childName;
		private String childIdNumber;
	}
	private List<Child> children;

	public Employee() {
        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    public Employee employeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Employee firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Employee lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee idNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public Employee address(String address) {
        this.address = address;
        return this;
    }

    public Employee dateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
        return this;
    }

    public Employee isForeigner(boolean isForeigner) {
        this.isForeigner = isForeigner;
        return this;
    }

    public Employee gender(boolean gender) {
        this.gender = gender;
        return this;
    }

    public Employee monthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
        return this;
    }

    public Employee otherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
        return this;
    }

    public Employee annualDeductible(int annualDeductible) {
        this.annualDeductible = annualDeductible;
        return this;
    }

    public Employee spouseName(String spouseName) {
        this.spouseName = spouseName;
        return this;
    }

    public Employee spouseIdNumber(String spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
        return this;
    }
	
	public void setMonthlySalary(int grade) {	
		if (grade == 1) {
			monthlySalary = 3000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 2) {
			monthlySalary = 5000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 3) {
			monthlySalary = 7000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
