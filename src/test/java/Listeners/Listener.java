package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BasePack.BaseClass;

public class Listener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String TestName= result.getMethod().getMethodName();
		System.out.println(TestName);
		try {
			screenShot(TestName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		
		String TestName= result.getMethod().getMethodName();
		System.out.println(TestName);
		try {
			screenShot(TestName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
