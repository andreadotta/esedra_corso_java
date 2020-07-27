package it.esedra.corso.oussein;

import java.lang.reflect.Array;

public class Table {
	float N= 10;
	

	public  float[] TableArray (float[]a ) {
		
	float a[N];	
	int f;
	float max,min;	
	
	
	
	for(f=0;f<N;f++) {
		count(a[f]);
	}
		
	max=a[0];
for(f=0;f<N;f++)
	
	if(a[f]>max) max=a[f];
	
	min=a[0];
	for(f=0;f<N;f++)
		
		if(a[f]>min) min=a[f];
		
	}
	private void count(float a) {
		

	}
}

