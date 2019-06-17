package com.stevelee.java.control;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Comptest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //int result = compiler.run(null, System.out, System.out, sourceFile.getPath());
        
        int result = compiler.run(System.in, System.out, System.out, "DynamicClass.java");
        
	        if(result == 0) {
	        	System.out.println("컴파일 성공");
	        }else {
	        	System.out.println("컴파일 에러");
	        }

	}

}
