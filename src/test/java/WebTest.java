import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class WebTest {

    //1. Открыть страницу http://www.99-bottles-of-beer.net/
    //2. Нажать пункт меню Browse Languages
    //3. Нажать пункт меню Start
    //4. Подтвердить, что пользователь видит заголовок "Welcome to 99 Bottles of Beer"
    //5. Закрыть браузер

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrouserLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrouserLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));
        String actualResult = h2.getText();
//        sleep(1000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    Подтвердите, что на странице по базовой ссылке в правом верхнем
//    углу пользователь видит заголовок 99 Bottles of Beer
    @Test
    public void testHeader() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement header = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));
        String actualResult = header.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    Подтвердите, что на странице по базовой ссылке
//    последний пункт меню называется Submit new Language
    @Test
    public void testLastMenuItem() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "SUBMIT NEW LANGUAGE";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastMenuItem = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));
        String actualResult = lastMenuItem.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    Подтвердите, что на странице по базовой ссылке
//    последний пункт меню имеет подзаголовок Submit new Language
    @Test
    public void testLastSubtitle() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));
        menuSubmitNewLanguages.click();

        WebElement lastSubtitle = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"));
        String actualResult = lastSubtitle.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html ,
//    первый пункт подменю называется 0-9
    @Test
    public void testFirstSubmenu() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement firstSubmenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));
        String actualResult = firstSubmenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    Подтвердите, что имена создателей сайта:
//    Oliver Schade, Gregor Scheithauer, Stefan Scheler
    @Test
    public void testTeamNames() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Oliver Schade" +
                "Gregor Scheithauer" +
                "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        menuTeam.click();

        WebElement os = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]"));
        String actualResult = os.getText();

        WebElement gs = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));
        actualResult += gs.getText();

        WebElement ss = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));
        actualResult += ss.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    // Проверить что в первой строке раздела History упоминается Tim Robinson
    @Test
    public void test() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        Boolean expectedResult = true;

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenuHistory = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='info.html']"));
        submenuHistory.click();

        WebElement firstString = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));
        String timRobinson = firstString.getText();

        Boolean actualResult = timRobinson.contains("Tim Robinson");

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}


//    @Test
//    public void test() {
//
//        String chromeDriver = "webdriver.chrome.driver";
//        String driverPath = "/Applications/chromedriver";
//        String url = "http://www.99-bottles-of-beer.net/";
//        String expectedResult = "";
//
//        System.setProperty(chromeDriver, driverPath);
//        WebDriver driver = new ChromeDriver();
//
//        driver.get(url);
//
//        WebElement xxx = driver.findElement(
//                By.xpath(""));
//        String actualResult = xxx.getText();
//
//        Assert.assertEquals(actualResult, expectedResult);
//
//        driver.quit();
//    }




