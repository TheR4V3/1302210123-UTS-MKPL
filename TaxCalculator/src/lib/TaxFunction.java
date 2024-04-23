package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 private int calculateBaseTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible) {
		return (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));
	}
	
	public int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		int tax;
		if (isMarried) {
			tax = calculateBaseTax(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible) - (4500000 + (numberOfChildren * 1500000));
		} else {
			tax = calculateBaseTax(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible);
		}
		return Math.max(tax, 0);
	}
	
	
}
