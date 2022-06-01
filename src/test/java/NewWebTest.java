import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWebTest {

    /**
     * Подтвердите, что в меню BROWSE LANGUAGES, подменю  J, пользователь
     * может найти описание страницы, на которой перечеслены все программные языки,
     * начинающиеся с буквы J, отсортированные по названию
     */
    @Test
    public void testPageDescription() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();

        WebElement submenuJ = driver.findElement(By.xpath("//a[@href='j.html']"));
        submenuJ.click();

        WebElement text = driver.findElement(By.xpath("//p[strong]"));
        String actualResult = text.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * Подтвердите, что в меню BROWSE LANGUAGES, подменю  M, последний программный язык в таблице -  MySQL
     */
    @Test
    public void testLastLanguage() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "MySQL";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();

        WebElement submenuM = driver.findElement(By.xpath("//a[@href='m.html']"));
        submenuM.click();

        WebElement text = driver.findElement(By.xpath("//tr[last()]/td/a"));
        String actualResult = text.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * Подтвердите, что в меню BROWSE LANGUAGES существует таблица
     * с заголовками Language, Author, Date, Comments, Rate
     */
    @Test
    public void testTableHeaders() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String[] expectedResult = {"Language", "Author", "Date", "Comments", "Rate"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();

        String[] actualResult = new String[5];
        for (int i = 1; i <= 5; i++) {
            actualResult[i - 1] = driver.findElement(By.xpath("//tr/th[" + i + "]")).getText();
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * Подтвердите, что создатель решения на языке Mathematica - Brenton Bostick,
     * дата обновления решения на этом языке - 03/16/06, и что это решение имеет 1 комментарий
     */
    @Test
    public void testMathematicaLanguage() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultAuthor = "Brenton Bostick";
        String expectedResultDate = "03/16/06";
        String expectedResultNumber = "1";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();
        WebElement submenuM = driver.findElement(By.xpath("//a[@href='m.html']"));
        submenuM.click();

        WebElement author = driver.findElement(By.xpath("//tr[22]/td[2]"));
        String actualResultAuthor = author.getText();
        WebElement date = driver.findElement(By.xpath("//tr[22]/td[3]"));
        String actualResultDate = date.getText();
        WebElement number = driver.findElement(By.xpath("//tr[22]/td[4]"));
        String actualResultNumber = number.getText();

        Assert.assertEquals(actualResultAuthor, expectedResultAuthor);
        Assert.assertEquals(actualResultDate, expectedResultDate);
        Assert.assertEquals(actualResultNumber, expectedResultNumber);

        driver.quit();
    }

    /**    Подтвердите, что на сайте существует 10 языков, названия которых начинаются с цифр. */
    @Test
    public void testDigitBeginning() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        int expectedResult = 10;

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();
        WebElement submenuM = driver.findElement(By.xpath("//a[@href='0.html']"));
        submenuM.click();

        int actualResult = driver.findElements(By.xpath("//tbody/tr")).size() - 1;

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}