package it.esedra.areariservata;

public class Results {

	private int sum = 0;

	private double avg = 0;

	private int max = 0;
	
	private int min = 0;
	
	private int size = 0;

	public double getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setSum(int inputSum) {
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

	public void setMax(int max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public double getSum() {
		return sum;
	}
}
