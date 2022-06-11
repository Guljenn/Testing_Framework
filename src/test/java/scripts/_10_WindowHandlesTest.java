package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TGHomePage;
import utilities.Waiter;

import javax.sound.midi.Soundbank;

public class _10_WindowHandlesTest extends Base {

    /*
    TEST CASE 1: Validate social media icon for TechGlobal School
    1. Go to https://www.techglobalschool.com/
    2. Click on Facebook Icon in the footer
    3. Validate user is routed to https://www.facebook.com/techglobalschool
    */

    @Test(priority = 1, description = "TEST CASE 1: Validate social media icon for TechGlobal School")
    public void testTechGlobalSchoolFaceBookIcon() {

        // After clicking on facebook you have 2 tabs
        // To get to a specific URl you have to use windowHandle

        driver.get("https://www.techglobalschool.com/"); // go to url
        String tgWindow = driver.getWindowHandle();  // store url in a string before you click on the page

        tgHomePage.faceBookIcon.click();   // click on the icon


        for (String windowHandle : driver.getWindowHandles()) {     // create a loop to handle the switch
            if (!windowHandle.equals(tgWindow)) driver.switchTo().window(windowHandle);
        }

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.facebook.com/techglobalschool"));

        // switching back to techGlobal

        driver.switchTo().window(tgWindow);

        System.out.println(driver.getCurrentUrl());  // https://www.techglobalschool.com/
    }

    /*
    Test Case 2 Multiple Windows
    1. Go to http://the-internet.herokuapp.com/
    2. Click on “Multiple Windows” link
    3. Click on “Click Here” link
    4. Validate the heading3 as “New Window”
    5. Navigate back to previous window
    6. Validate the heading3 as “Opening a new
    window
     */

    @Test(priority = 2, description = "TEST CASE 2: Multiple Windows")
    public void testWindowHandle2() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Multiple Windows");

        String mainWindow = driver.getWindowHandle();

        heroAppPage.clickHereLink.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) driver.switchTo().window(windowHandle);
        }

        Assert.assertEquals(heroAppPage.newWindowH3.getText(), "New Window");
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(heroAppPage.windowsH3.getText(), "Opening a new window");
    }

    /*
    1. Go to https://www.techglobalschool.com/
    2. Click on Instagram icon on the footer
    3. Validate a new tab opened with URL as
    “https://www.instagram.com/techglobal.school/”
    4. Navigate back to previous tab
    5. Validate the URL as “https://www.techglobalschool.com/
     */

    @Test(priority = 3, description = "Task 3: Validate TechGlobal URL" )
    public void testTechGlobalURL(){
        driver.get("https://www.techglobalschool.com");
        String mainWindow = driver.getWindowHandle();
        tgHomePage.instagramIcon.click();



        for(String windowHandle : driver.getWindowHandles()){
            if(!windowHandle.equals(mainWindow)) driver.switchTo().window(windowHandle);
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.instagram.com/techglobal.school/");
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.techglobalschool.com/");
    }

    /*
    1. Go to “https://comfyelite.com/”
    2. Click on Facebook icon at the bottom of the
    page
    3. Validate a new tab opened with URL as
    “https://www.facebook.com/comfyelite/”
    4. Navigate back to previous tab
    5. Validate the URL as “https://comfyelite.com/”
     */

    @Test(priority = 4, description = "TASK 4: Validate comfy elite URL")
    public void testComfyEliteURL(){

        driver.get("https://comfyelite.com/");
        String mainWindow = driver.getWindowHandle();
        comfyEliteHomePage.facebookIcon.click();

        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(mainWindow)) driver.switchTo().window(windowHandle);
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/comfyelite/");
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(driver.getCurrentUrl(), "https://comfyelite.com/");

    }



}
