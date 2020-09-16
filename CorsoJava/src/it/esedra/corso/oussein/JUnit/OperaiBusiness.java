package it.esedra.corso.oussein.JUnit;

public class OperaiBusiness {

	public double CalculateSalaryAnnuale(OperaiDetail operaiDetail) {
		double salaryAnnuale = 0;
		salaryAnnuale = operaiDetail.getSalaryMensile() * 12;
		return salaryAnnuale;
	}

	double calculateMediaSalary(OperaiDetail operaiDetail) {
		double mediaSalary = 0;
		if (operaiDetail.getSalaryMensile() < 1000) {
			mediaSalary = 500;
		} else {
			mediaSalary = 1000;
		}
		return mediaSalary;
	}

}
