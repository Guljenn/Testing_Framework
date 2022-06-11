package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _11_FileUploads extends Base{

    /*
    1. Create a MS-Word file on your desktop called
    “myFile.docx”
    2. Go to http://the-internet.herokuapp.com/
    3. Click on “File Upload” link
    4. Choose created file to be uploaded to the page
    5. Click on “Upload” button
    6. Validate “File Uploaded!” heading3 text
    7. Validate ”myFile.docx” in the uploaded file list
     */

    @Test(priority = 1, description = "File Upload")
    public void testFileUpload() {
        driver.get(" http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("File Upload");

        Waiter.pause(2);

        heroAppPage.chooseFileInputBox.sendKeys("C:\\Users\\jenni\\IdeaProjects\\testng_framework\\myFileGul2.xls");
        heroAppPage.uploadFileInputBox.click();
        Waiter.pause(5);

        Assert.assertEquals(heroAppPage.fileUploadedHeading.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.confirmationUploadedMessage.getText(), "myFileGul2.xls");

    }

    /*
    1. Go to http://the-internet.herokuapp.com/
    2. Click on "File Download" link
    3. Click on "myFileGul2.xls" link
    4. Validate "myFileGul2.xls" file is Downloaded in your downloads folder
     */

    @Test(priority = 2, description = "Validate file download")
    public void testFileDownload(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("File Download");
        heroAppPage.myFileDownload.click();

    }
}
