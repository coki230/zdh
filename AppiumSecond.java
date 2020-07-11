import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class AppiumSecond {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumSecond selenium = new AppiumSecond();
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


        capabilities.setCapability("appPackage", "com.android.dialer");
        capabilities.setCapability("appActivity", ".main.impl.MainActivity t41");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//        driver.findElement(By.name("1")).click();
//        driver.findElement(By.name("5")).click();
//        driver.findElement(By.name("9")).click();
//        driver.findElement(By.name("delete")).click();
//        driver.findElement(By.name("+")).click();
//        driver.findElement(By.name("6")).click();
//        driver.findElement(By.name("=")).click();
//        Thread.sleep(2000);
//        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
//        System.out.println(result);

        driver.launchApp();
        driver.findElementById("com.android.dialer:id/fab").click();
        Thread.sleep(2000);
        driver.findElementById("com.android.dialer:id/one").click();
        driver.findElementById("com.android.dialer:id/two").click();
        driver.findElementById("com.android.dialer:id/three").click();
        driver.findElementById("com.android.dialer:id/dialpad_floating_action_button").click();
        Thread.sleep(2000);

        // 安装app
        driver.installApp("xxx");

        // 卸载app
        driver.removeApp("xxx");

        // 判断是否安装app
        driver.isAppInstalled("xxx");

        // 启动应用
        driver.launchApp();

        // 后台运行
        driver.runAppInBackground(Duration.ofHours(1));


        // 关闭应用
        driver.closeApp();

        // 获取上下文
        driver.getContext();

        driver.pressKey(new KeyEvent().withKey(AndroidKey.A));


        driver.quit();




    }
}
