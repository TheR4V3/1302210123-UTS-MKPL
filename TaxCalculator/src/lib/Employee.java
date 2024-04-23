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

	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		children = new LinkedList<>();
	}
	public TaxInfo getTaxInfo() {
    TaxInfo taxInfo = new TaxInfo();
    taxInfo.setMonthlySalary(monthlySalary);
    taxInfo.setOtherMonthlyIncome(otherMonthlyIncome);
    taxInfo.setMonthWorkingInYear(monthWorkingInYear);
    taxInfo.setAnnualDeductible(annualDeductible);
    taxInfo.setHasSpouse(!spouseIdNumber.equals(""));
    taxInfo.setNumberOfChildren(childIdNumbers.size());
    return taxInfo;
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
		} else {
			monthWorkingInYear = 12;
		}
		return TaxFunction.calculateTax(getTaxInfo());
	}	
}

public class TaxInfo {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int monthWorkingInYear;
    private int annualDeductible;
    private boolean hasSpouse;
    private int numberOfChildren;

	public int getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public int getOtherMonthlyIncome() {
		return otherMonthlyIncome;
	}
	public void setOtherMonthlyIncome(int otherMonthlyIncome) {
		this.otherMonthlyIncome = otherMonthlyIncome;
	}
	public int getMonthWorkingInYear() {
		return monthWorkingInYear;
	}
	public void setMonthWorkingInYear(int monthWorkingInYear) {
		this.monthWorkingInYear = monthWorkingInYear;
	}
	public int getAnnualDeductible() {
		return annualDeductible;
	}
	public void setAnnualDeductible(int annualDeductible) {
		this.annualDeductible = annualDeductible;
	}
	public boolean isHasSpouse() {
		return hasSpouse;
	}
	public void setHasSpouse(boolean hasSpouse) {
		this.hasSpouse = hasSpouse;
	}
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

    
}