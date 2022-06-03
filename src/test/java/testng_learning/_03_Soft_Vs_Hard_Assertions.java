package testng_learning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _03_Soft_Vs_Hard_Assertions {

    /*

    @Test(priority = 1, description = "practicing hard assertions")
    public void method1(){

        // Hard Assertions
        // When there is an error in any line, the program flow will break, and it will not continue

        Assert.assertTrue(true);
        Assert.assertTrue(false, "Failure");

        System.out.println("Hello World");  // it will not print because of the false test case
    }

    @Test(priority = 2, description = "Practicing Soft Assertions")
    public void method2(){

        // Soft Assertions
        // When there is an error in soft assertions, the code will still continue to execute the flow of the program
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(true);
        softAssert.assertTrue(false, "This is a failure");

        System.out.println("Hello World");





    }

     */
}
