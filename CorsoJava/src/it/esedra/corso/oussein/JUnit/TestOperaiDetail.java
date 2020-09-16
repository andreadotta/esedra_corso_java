package it.esedra.corso.oussein.JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOperaiDetail {
	OperaiBusiness operaiBusiness = new OperaiBusiness();
	OperaiDetail operai = new OperaiDetail();

	@Test
	public void testCalculateMediaSalary() {
		operai.setNome("oussein");
		operai.setSalaryMensile(8000.0);
		operai.setAge(25);

	}

	@Test
	public void testCalculateSalaryAnnuale() {
		operai.setNome("oussein");
		operai.setSalaryMensile(8000.0);
		operai.setAge(25);

		double salary = operaiBusiness.CalculateSalaryAnnuale(operai);
		assertEquals(96000, salary, 0.0);
	}
}
