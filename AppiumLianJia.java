import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumLianJia {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumLianJia selenium = new AppiumLianJia();
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
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("noReset","true");


//        capabilities.setCapability("appPackage", "com.android.dialer");
//        capabilities.setCapability("appActivity", ".main.impl.MainActivity t41");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        // 安装app
        driver.installApp("/Users/xiao230/Desktop/soft/apk/lj.apk");
        Thread.sleep(20000);
//
//        // 安装app
//        driver.installApp("/Users/xiao230/Desktop/soft/apk/lj.apk");
//
//        // 卸载app
//        driver.removeApp("xxx");
//
//        // 判断是否安装app
//        driver.isAppInstalled("xxx");
//
//        // 启动应用
//        driver.launchApp();
//
//        // 后台运行
//        driver.runAppInBackground(Duration.ofHours(1));
//
//
//        // 关闭应用
//        driver.closeApp();
//
//        // 获取上下文
//        driver.getContext();
//
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.A));


        driver.quit();




    }
}
