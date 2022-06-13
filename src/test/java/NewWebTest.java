import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class NewWebTest {
    private static final String BASE_URL = "http://www.99-bottles-of-beer.net/";

    /**
     * Подтвердите, что в меню BROWSE LANGUAGES, подменю  J, пользователь
     * может найти описание страницы, на которой перечеслены все программные языки,
     * начинающиеся с буквы J, отсортированные по названию
     */
    @Test
    public void testPageDescription() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

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
        String expectedResult = "MySQL";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

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
        String[] expectedResult = {"Language", "Author", "Date", "Comments", "Rate"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();

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
    public void testMathematicaLanguageInformation() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String expectedResultLanguage = "Mathematica";
        String expectedResultAuthor = "Brenton Bostick";
        String expectedResultDate = "03/16/06";
        String expectedResultComments = "1";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);
        driver.findElement(By.linkText("Browse Languages")).click();
        driver.findElement(By.linkText("M")).click();

        List<WebElement> trs = driver.findElements(By.xpath("//table[@id='category']/tbody/tr"));

        List<String> actualResult = new ArrayList<>();

        for (WebElement tr : trs) {
            if (tr.getText().contains(expectedResultLanguage)) {
                actualResult.add(tr.getText());
            }
        }

        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append(expectedResultLanguage)
                .append(" ")
                .append(expectedResultAuthor)
                .append(" ")
                .append(expectedResultDate)
                .append(" ")
                .append(expectedResultComments);

        Assert.assertEquals(actualResult.size(), 1);
        Assert.assertFalse(actualResult.get(0).isEmpty());
        Assert.assertEquals(actualResult.get(0), expectedResult.toString());

        driver.quit();
    }

    /**
     * Подтвердите, что на сайте существует 10 языков, названия которых начинаются с цифр.
     */
    @Test
    public void testDigitBeginning() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        int expectedResult = 10;

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();
        driver.findElement(By.xpath("//a[@href='0.html']")).click();

        int actualResult = driver.findElements(By.xpath("//tbody/tr")).size() - 1;

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * Выберите любой язык программирования (из меню BROWSE LANGUAGES) и любую версию решения
     * (из раздела Alternative Versions, если такой раздел существует  для выбранного языка)
     * Подтвердите, что пользователь может сделать закладку на это решение на сайте Reddit
     * (нажав на иконку сайта Reddit, пользователь перейдет на Логин страницу сайта Reddit)
     */
    @Test
    public void testBookmarkReddit() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();
        driver.findElement(By.xpath("//a[@href='b.html']")).click();
        driver.findElement(By.linkText("BASIC")).click();
        driver.findElement(By.linkText("Atari 8Bit")).click();
        driver.findElement(By.xpath("//div[@id='voting']/p/a[@title='reddit']")).click();
        String actualResult = driver.findElement(By
                .xpath("//div[@class='BottomText login-bottom-text register hideable']")).getText();

        Assert.assertTrue(actualResult.contains("Reddit"));

        driver.quit();
    }

    /**
     * Подтвердите, что решение на языке Shakespeare:
     *      - входит в топ 20 всех решений
     *      - входит в топ 10 решений на Esoteric Languages и
     *      - входит в топ 6 решений-хитов.
     *      - НЕ входит в список топовых решений на реальных языках программирования.
     */
    @Test
    public void testShakespearePlace() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        driver.findElement(By.xpath("//li/a[@href='/toplist.html']")).click();
        List<WebElement> tableRowsAll = driver.findElements(By.xpath("//table[@id='category']/tbody/tr/td/a"));
        String actualResultTop20All = "";
        for (int i = 0; i < 20; i++) {
            actualResultTop20All += tableRowsAll.get(i + 1).getText();
        }

        driver.findElement(By.xpath("//ul[@id='submenu']/li/a[@href='./toplist_esoteric.html']")).click();
        List<WebElement> tableRowsEsoteric = driver.findElements(By.xpath("//table[@id='category']/tbody/tr/td/a"));
        String actualResultTop10Esoteric = "";
        for (int i = 0; i < 10; i++) {
            actualResultTop10Esoteric += tableRowsEsoteric.get(i + 1).getText();
        }

        driver.findElement(By.xpath("//ul[@id='submenu']/li/a[@href='./tophits.html']")).click();
        List<WebElement> tableRowsHits = driver.findElements(By.xpath("//table[@id='category']/tbody/tr/td/a"));
        String actualResultTop6Hits = "";
        for (int i = 0; i < 6; i++) {
            actualResultTop6Hits += tableRowsHits.get(i + 1).getText();
        }

        driver.findElement(By.xpath("//ul[@id='submenu']/li/a[@href='./toplist_real.html']")).click();
        List<WebElement> tableRowsReal = driver.findElements(By.xpath("//table[@id='category']/tbody/tr/td/a"));
        List<String> actualResultTopReal= new ArrayList<>();
        for (WebElement trr : tableRowsReal) {
            actualResultTopReal.add(trr.getText());
        }

        Assert.assertTrue(actualResultTop20All.contains("Shakespeare"));
        Assert.assertTrue(actualResultTop10Esoteric.contains("Shakespeare"));
        Assert.assertTrue(actualResultTop6Hits.contains("Shakespeare"));
        Assert.assertFalse(actualResultTopReal.contains("Shakespeare"));

        driver.quit();
    }
}