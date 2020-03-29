import com.sun.deploy.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/xiao230/Desktop/soft/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://su.lianjia.com/ditu/");

        String title = driver.getTitle();
        System.out.println(title);

//        String pageSource = driver.getPageSource();
//        System.out.print(pageSource);
        Thread.sleep(1000);

        List<WebElement> elementList = driver.findElements(By.xpath("//label"));

        elementList.forEach(ele -> {
            String text = ele.getText();
            text = text.replace("\n", "->");
            if (StringUtil.isNotBlank(text)) {
                System.out.println(text);
            }
        });

        WebElement gusu = elementList.get(0);
        gusu.click();

        String pageSource = driver.getPageSource();
        System.out.print(pageSource);

        driver.close();
    }
}
