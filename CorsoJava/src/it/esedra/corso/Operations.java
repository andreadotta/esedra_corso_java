package it.esedra.corso;

import java.util.Random;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

import it.esedra.corso.helpers.PrintHelper;

class Math //
{
	public String toString() { return "[Math]"; }
}

class Operations extends Math 
	{
		private double result;
		private double data;
		
		public Operations() {
			
		}
		public double get(int min, int max) 
		{
			DoubleSupplier d_s = () -> {
				PrintHelper.out("Riferimento this in d_s dal metodo get: " + this + 
						" \n Riferimento a super in d_s dal metodo get :" + super.toString());

				Random r = new Random();
				Double d =r.nextDouble();
				result = min + (max -min) * d;
				return result;
			};
			
			return d_s.getAsDouble();
		}
		
		
		public void set(int min, int max) {
			
			class Consumer 
			{
				public String toString() { return "[Consumer]"; }
			}
			
			class MyDoubleConsumer extends Consumer  implements DoubleConsumer
			{

				@Override
				public void accept(double value) {
						PrintHelper.out("Riferimento this in m_d_c dal metodo set: " + this + 
								" \n Riferimento a super in m_d_c dal metodo set :" + super.toString());
					
				}
				
				public String toString() { return "[MyDoubleConsumer]"; }
				
			}
			
			MyDoubleConsumer m_d_c = new MyDoubleConsumer();
			m_d_c.accept(min/max);
			
		}
		
		public String toString() { return "[Operations]"; }
		
		
	}