import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    /**
     * 1. Открыть страницу http://www.99-bottles-of-beer.net/
     * 2. Нажать пункт меню Browse Languages
     * 3. Нажать пункт меню Start
     * 4. Подтвердить, что пользователь видит заголовок "Welcome to 99 Bottles of Beer"
     * 5. Закрыть браузер
     */

    @Test
    public void testMenuStartTitle() {

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

    /**
     * Подтвердите, что на странице по базовой ссылке в правом верхнем
     * углу пользователь видит заголовок 99 Bottles of Beer
     */
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

    /**
     * Подтвердите, что на странице по базовой ссылке
     * последний пункт меню называется Submit new Language
     */
    @Test
    public void testLastMenuItem() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastMenuItem = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li[last()]"));
        String actualResult = lastMenuItem.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    /**
     * Подтвердите, что на странице по базовой ссылке
     * последний пункт меню имеет подзаголовок Submit new Language
     */
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

    /**
     * Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html ,
     * первый пункт подменю называется 0-9
     */
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

    /**
     * Подтвердите, что имена создателей сайта:
     * Oliver Schade, Gregor Scheithauer, Stefan Scheler
     */
    /**
     * Option 1 (String concatenation)
     */
    @Test
    public void testTeamNames1() {

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

    /**
     * Option 2 (Three asserts)
     */
    @Test
    public void testTeamNames2() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        menuTeam.click();

        WebElement os = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]"));
        String actualResult1 = os.getText();

        WebElement gs = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));
        String actualResult2 = gs.getText();

        WebElement ss = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));
        String actualResult3 = ss.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

    /**
     * Option3 (Array)
     */
    @Test
    public void testTeamNames3() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String[] expectedResult = {"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        menuTeam.click();

        String[] actualResult = new String[3];

        WebElement os = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]"));
        actualResult[0] = os.getText();

        WebElement gs = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));
        actualResult[1] = gs.getText();

        WebElement ss = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));
        actualResult[2] = ss.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * Проверить что в первой строке раздела History упоминается Tim Robinson
     */
    @Test
    public void testCreator() {

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

    /**
     * Подтвердите, что если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     * пользователь нажмет кнопку Submit Language,
     * не заполнив информацию в обязательных полях, будет показана ошибка
     * Error: Precondition failed - Incomplete Input.
     */
    @Test
    public void testSubmitLanguageError() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult1 = "Error:";
        String expectedResult2 = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']"));
        submitLanguage.click();

        WebElement error = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p/b/u"));
        String actualResult1 = error.getText();

        WebElement errorMessage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));
        String actualResult2 = errorMessage.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    /**
     * Подтвердите, что если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     * пользователь нажмет кнопку Submit Language,
     * не заполнив информацию в обязательных полях, будет показана ошибка с текстом
     * Error: Precondition failed - Incomplete Input.
     * Подтвердите, что в тексте ошибки слова Error, Precondition, Incomplete и Input
     * написаны с большой буквы, а слово failed написано с маленькой буквы.
     * Так же подтвердите, что в тексте ошибки содержатся знаки :"," "-" "."
     */

    @Test
    public void testSubmitLanguageErrorText() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult1 = "E";
        String expectedResult2 = "P";
        String expectedResult3 = "I";
        String expectedResult4 = "I";
        String expectedResult5 = "f";
        String expectedResult6 = ":";
        String expectedResult7 = "-";
        String expectedResult8 = ".";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']"));
        submitLanguage.click();

        WebElement error = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));
        String errorMessage = error.getText();

        String[] arrayOfWords = errorMessage.split(" ");
        String actualResult1 = String.valueOf(arrayOfWords[0].charAt(0));
        String actualResult2 = String.valueOf(arrayOfWords[1].charAt(0));
        ;
        String actualResult3 = String.valueOf(arrayOfWords[4].charAt(0));
        ;
        String actualResult4 = String.valueOf(arrayOfWords[5].charAt(0));
        ;
        String actualResult5 = String.valueOf(arrayOfWords[2].charAt(0));
        ;
        String actualResult6 = String.valueOf(arrayOfWords[0].charAt(arrayOfWords[0].length() - 1));
        String actualResult7 = arrayOfWords[3];
        String actualResult8 = String.valueOf(arrayOfWords[5].charAt(arrayOfWords[0].length() - 1));

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);
        Assert.assertEquals(actualResult4, expectedResult4);
        Assert.assertEquals(actualResult5, expectedResult5);
        Assert.assertEquals(actualResult6, expectedResult6);
        Assert.assertEquals(actualResult7, expectedResult7);
        Assert.assertEquals(actualResult8, expectedResult8);

        driver.quit();
    }

    /**
     * Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html
     * в первом пункте списка пользователь видит текст
     * IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name
     * and description), the easier it will be for us and the faster your language will show up on this page.
     * We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.
     */
    @Test
    public void testFirstPoint() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form (especially" +
                " the language name and description), the easier it will be for us and the faster your language" +
                " will show up on this page. We don't have the time to mess around with fixing your descriptions etc." +
                " Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement firstPoint = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li"));
        String actualResult = firstPoint.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу
     * со следующими названиями для первого и второго столбцов: Language Author
     */
    @Test
    public void testTableNames() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Language";
        String expectedResult2 = "Author";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));
        submitLanguage.click();

        WebElement tableName1 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/th[1]"));
        String actualResult1 = tableName1.getText();

        WebElement tableName2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/th[2]"));
        String actualResult2 = tableName2.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    /**
     * Подтвердите, что на странице по базовой ссылке пользователь НЕ увидит
     * новые комментарии, если нажмет на пункты меню Top List → New Comments
     */
    @Test
    public void testNoComments() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement topList = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/toplist.html']"));
        topList.click();

        WebElement newComments = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./newcomments.html']"));
        newComments.click();

        WebElement textComments = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));
        String actualResult = textComments.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html
     * пользователь видит предупреждение IMPORTANT:, написанное
     * белыми буквами bold шрифтом на красном фоне, и что все буквы - capital
     */
    /**
     * Option 1 (style, tag name)
     */
    @Test
    public void testImportant1() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResultText = "IMPORTANT:";
        String expectedResultStyle = "background-color: red; color: white;";
        String expectedResultBold = "b";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement important = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span"));

        String actualResultText = important.getText();
        String actualResultStyle = important.getAttribute("style");
        String actualResultBold = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span/b")).getTagName();

        Assert.assertEquals(actualResultText, expectedResultText.toUpperCase());
        Assert.assertEquals(actualResultStyle, expectedResultStyle);
        Assert.assertEquals(actualResultBold, expectedResultBold);

        driver.quit();
    }

    /**
     * Option 2 (css)
     */
    @Test
    public void testImportant2() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResultText = "IMPORTANT:";
        String expectedResultBold = "700";
        String expectedResultTextColor = "rgba(255, 0, 0, 1)";
        String expectedResultBackgroundColor = "rgba(255, 255, 255, 1)";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement important = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span"));
        String actualResultText = important.getText();
        String actualResultBold = important.getCssValue("font-weight");
        String actualResultTextColor = important.getCssValue("background-color");
        String actualResultBackgroundColor = important.getCssValue("color");

        Assert.assertEquals(actualResultText, expectedResultText.toUpperCase());
        Assert.assertEquals(actualResultBold, expectedResultBold);
        Assert.assertEquals(actualResultTextColor, expectedResultTextColor);
        Assert.assertEquals(actualResultBackgroundColor, expectedResultBackgroundColor);

        driver.quit();
    }
}







