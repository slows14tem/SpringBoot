package com.anno;

import java.lang.reflect.Method;

public class AnnoTestMain {

	@MyAnnotation(count=5)
	public static void print() {
		System.out.println("print입니다.");
	}
	
	public static void main(String[] args) throws Exception {
		
//		AnnoTestMain at = new AnnoTestMain();
//		at.getClass();
		
		Method m = AnnoTestMain.class.getMethod("print");
		if(m.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation method = m.getAnnotation(MyAnnotation.class);
			for(int i = 0; i<method.count();i++) {
				print();
			}
		} else {
			print();
		}
		
	}

}
