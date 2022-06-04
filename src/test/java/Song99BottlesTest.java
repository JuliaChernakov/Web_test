import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Song99BottlesTest {

    private String createLyrics() {
        final String BOTTLES_WALL_CS = " bottles of beer on the wall, ";
        final String BOTTLES_DOT_LN = " bottles of beer.\n";
        final String BOTTLES_WALL_DOT = " bottles of beer on the wall.";
        final String TAKE = "Take one down and pass it around, ";
        final String GO = "Go to the store and buy some more, ";
        final String NO_MORE = "No more";

        StringBuilder lyrics = new StringBuilder();
        lyrics
                .append(99)
                .append(BOTTLES_WALL_CS)
                .append(99)
                .append(BOTTLES_DOT_LN);

        for (int i = 98; i > -1; i--) {
            if (i == 1) {
                lyrics
                        .append(TAKE)
                        .append(i)
                        .append(BOTTLES_WALL_DOT.replace("s", ""))
                        .append(i)
                        .append(BOTTLES_WALL_CS.replace("s", ""))
                        .append(i)
                        .append(BOTTLES_DOT_LN.replace("s", ""));

            } else if (i == 0) {
                lyrics
                        .append(TAKE)
                        .append(NO_MORE.toLowerCase())
                        .append(BOTTLES_WALL_DOT)
                        .append(NO_MORE)
                        .append(BOTTLES_WALL_CS)
                        .append(NO_MORE.toLowerCase())
                        .append(BOTTLES_DOT_LN);

            } else {
                lyrics
                        .append(TAKE)
                        .append(i)
                        .append(BOTTLES_WALL_DOT)
                        .append(i)
                        .append(BOTTLES_WALL_CS)
                        .append(i)
                        .append(BOTTLES_DOT_LN);
            }
        }
        lyrics
                .append(GO)
                .append(99)
                .append(BOTTLES_WALL_DOT);

        return lyrics.toString();
    }

    @Test
    public void testSongLyricsText1() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = createLyrics();

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/" +
                "a[@href='lyrics.html']")).click();

        String[] textArray = new String[100];
        for (int i = 0; i < textArray.length; i++) {
            int index = i + 1;
            textArray[i] = driver
                    .findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/p[" + index + "]")).getText();
        }

        String actualResult = "";
        for (int i = 0; i < textArray.length; i++) {
            actualResult += textArray[i];
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}