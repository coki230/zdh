import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AppiumThree {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumThree selenium = new AppiumThree();
        selenium.android();

    }

    /**
     * 访问手机内的app
     * @throws MalformedURLException
     */
    private void android() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","817c9726");
        capabilities.setCapability("noReset","true");


        capabilities.setCapability("appPackage", "com.homelink.android");
        capabilities.setCapability("appActivity", ".SplashScreenActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.launchApp();
        // 二手房
        driver.findElementById("com.homelink.app.content:id/iv_entrance_icon").click();
        // 区域
        driver.findElementById("com.homelink.plugin.secondhouse:id/tv_tab_name").click();
        // 选择工业园区
        driver.findElementByXPath("//*[@text='工业园区']").click();
        // 确定按钮
        driver.findElementById("com.homelink.plugin.secondhouse:id/btn_confirm").click();

        // 内容信息://*/android.widget.LinearLayout[contains(@index,0)]
//        List<WebElement> elementsByXPath = driver.findElementsByXPath("//*/android.widget.LinearLayout/android.widget.TextView");
        List<WebElement> elementsByXPath = driver.findElementsByXPath("//*/android.widget.TextView");


        for (WebElement webElement : elementsByXPath) {
            List<WebElement> elements = webElement.findElements(By.xpath("./*"));
            for (WebElement element : elements) {
                System.out.println(element.getText());
            }

            System.out.println(webElement.getText());
        }

        Thread.sleep(2000);



        // 关闭应用
//        driver.closeApp();

        // 获取上下文
//        driver.getContext();
//
//
//
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.A));


        driver.quit();




    }
}
