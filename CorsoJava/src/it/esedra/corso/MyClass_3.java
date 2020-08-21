package it.esedra.corso;

import java.util.ArrayList;
import java.util.List;

public class MyClass_3<T> {


	public <U extends T> void foo(U t) {
		
		List<U> list = new ArrayList<>();
	}

}
