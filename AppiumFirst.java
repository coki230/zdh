import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumFirst {
    public static void main(String[] args) throws MalformedURLException {
        AppiumFirst selenium = new AppiumFirst();
        selenium.android();

    }

    /**
     * 用手机访问百度网页
     * @throws MalformedURLException
     */
    private void android() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.android();
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("browserName","Chrome");
        desiredCapabilities.setCapability("deviceName","emulator");
        desiredCapabilities.setCapability("chromedriverExecutable","/Users/xiao230/Desktop/soft/74.0.3729/chromedriver");


        WebDriver webDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        webDriver.get("http://www.baidu.com");
        String title = webDriver.getTitle();

        System.out.println(title);

    }
}
