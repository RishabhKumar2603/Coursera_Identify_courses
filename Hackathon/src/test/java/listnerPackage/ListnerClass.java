package listnerPackage;

import org.testng.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
//import org.testng.ITestResult;

public class ListnerClass implements ITestListener{
	
	public void onTestStart(ITestResult a) {
		System.out.println("test is starting...........");
	}
	
public void onTestSuccess(ITestResult a) {
	System.out.println("test was success...........");
	}

public void onTestFailure(ITestResult a) {
	System.out.println("test has failed...........");
}


public void onTestSkipped(ITestResult a) {
	System.out.println("test is skipped...........");
}


public void onFinish(ITestContext a) {
	System.out.println("test has finished...........");
}


	
	
}
