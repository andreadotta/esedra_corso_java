package it.esedra.areariservata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.util.MathUtils;

public class ArrayMaxMin {

	public static Results run(List<Integer> values) {
		Results res = new Results();
		try {
			res.setSize(values.size());
			res.setSum(values.stream().reduce(0, Integer::sum));
			res.setAvg(res.getSum() / values.size());
			res.setMin(Collections.min(values));
			res.setMax(Collections.max(values));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Si è verificato un errore");
			System.err.println(e.fillInStackTrace());
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
		Results res = ArrayMaxMin.run(values);
		System.out.println("Num values: " + res.getSize());
		System.out.println("Avg: " + res.getAvg());
		System.out.println("Max: " + res.getMax());
		System.out.println("Min: " + res.getMin());
		System.out.println("Sum: " + res.getSum());

	}
}