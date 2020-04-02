package it.esedra.areariservata;

public class Results {

	private double sum = 0;

	private double avg = 0;

	private double max = 0;
	
	private double min = 0;

	public void setSum(double inputSum) {
		this.sum = inputSum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getSum() {
		return sum;
	}
}
