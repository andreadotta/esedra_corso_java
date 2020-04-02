package it.esedra.areariservata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayMaxMin {

	public static Results run(List<Double> values) {
		Results res = new Results();
		try {
			double sum = 0;
			Iterator<Double> iterable = values.iterator();
			while (iterable.hasNext()) {
				sum += iterable.next();
			}
			res.setSum(sum);
			res.setAvg(sum / values.size());
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
		List<Double> values = new ArrayList<Double>();
		values.add(Double.valueOf(1));
		values.add(Double.valueOf(2));
		values.add(Double.valueOf(3));
		values.add(Double.valueOf(4));
		values.add(Double.valueOf(5));
		values.add(Double.valueOf(6));
		ArrayMaxMin.run(values);
	}
}