package it.esedra.areariservata;

public class ArrayMaxMinOld {

	public static void main(String[] args) {
		double[] num = { 1, 2, 3, 4, 5 };
		double[] rtval = ArrayMaxMinOld.run(num);
		System.out.println("Num values: " + rtval.length);
		System.out.println("Avg: " + rtval[1]);
		System.out.println("Max: " + rtval[2]);
		System.out.println("Min: " + rtval[3]);
		System.out.println("Sum: " + rtval[0]);
	}

	public static double[] run(double[] num) {

		double sum = 0;

		for (int i = 0; i < num.length; i++) {
			sum = sum + num[i];
		}
		double avg = sum / num.length;

		double max = num[0];
		double min = num[0];
		for (int i = 1; i < num.length; i++) {

			if (max < num[i]) {
				max = num[i];
			}
			if (min > num[i]) {
				min = num[i];
			}
		}
		double[] rtval = { sum, avg, max, min };

		return rtval;
	}
}