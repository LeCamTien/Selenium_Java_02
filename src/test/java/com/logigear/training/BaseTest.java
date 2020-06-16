package com.logigear.training;

import com.logigear.training.common.Constant;
import com.logigear.training.drivermanager.DriverManager;
import com.logigear.training.utils.BrowserHelper;
import org.testng.annotations.*;

public class BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        BrowserHelper.setUpBrowser(browser);
    }

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getDriver().get(Constant.URL);
    }

    @AfterClass
    public void afterClass() {
        DriverManager.getDriver().quit();
    }
}
