package ru.ozon;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class FirstTest {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\study\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("test start");
        driver.get("https://www.ozon.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static int equal1(String count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length(); i++)
            if (Character.isDigit(count.charAt(i)))
                sb.append(count.charAt(i));
        return Integer.parseInt(sb.toString());
    }

    public void createScreenshot(String name)
    {
        Allure.addAttachment(name,
                new ByteArrayInputStream(((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Открытие каталога")
    public void OpenCatalog() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[2]/div/div[1]/button").click();
        createScreenshot("openCatalog");
    }
    @Step("Открытие \"Бытовой техники\"")
    public void OpenTech() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[1]/div/a[6]").click();
        createScreenshot("openAppliances");
    }
    @Step("Открытие \"Кофеварки и кофемашины\"")
    public void OpenCofe() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[4]/div/div[1]/aside/div[2]/div[1]/a").click();
        createScreenshot("openCoffeeMaker");
    }
    @Step("Выбор нижней границы стоимости и ввод от 10 000")
    public void choiseFirstTextAndSet10000() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[3]/div[2]/div[2]/div[1]/input").sendKeys(Keys.CONTROL + "a");
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[3]/div[2]/div[2]/div[1]/input").sendKeys(Keys.DELETE);
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[3]/div[2]/div[2]/div[1]/input").sendKeys("10000");
        createScreenshot("choiseFirstTextAndSet10000");
    }
    @Step("Выбор Верхней границы стоимости")
    public void choiseSecondText() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[3]/div[2]/div[2]/div[2]/input").click();
    }
    @Step("Ввод до 11 000")
    public void set11000() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[3]/div[2]/div[2]/div[2]/input").sendKeys(Keys.CONTROL + "a");
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[3]/div[2]/div[2]/div[2]/input").sendKeys(Keys.DELETE);
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[3]/div[2]/div[2]/div[2]/input").sendKeys("11000");
        createScreenshot("set10000");
    }
    @Step("Выбор сортировки списка по цене")
    public void clickOnDropMenu() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input").click();
        createScreenshot("clickOnDropMenu");
    }
    @Step("В списке выбираем сначала дешевые")
    public void choiseCheap() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input").sendKeys(Keys.ARROW_DOWN);
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input").sendKeys(Keys.ARROW_DOWN);
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input").sendKeys(Keys.ENTER);
        createScreenshot("choiseCheap");
    }
    @Step("Добавляем товар в корзину")
    public void addToCart() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div[2]/div/div[1]/div/button/div").click();
    }
    @Step("Переход в корзину")
    public void toCart() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[4]/a[2]").click();
        createScreenshot("toCart");
    }
    @Step("Нажатие на выпадающий список, для выбора количетсва товара")
    public void choiseDropInCart() {
        driver.findElementByXPath("//*[@id=\"split-Main-0\"]/div[3]/div[4]/div/div[1]/div/div[1]/div/div/input").click();
        createScreenshot("choiseDropInCart");
    }

    public String costOneCofe() {
        return driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div/div/div[3]/div[4]/div[2]/div/section/div[2]/div[4]/span[2]").getText();
    }

    public String costAllCofe() {
        return driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div/div/div[3]/div[4]/div[2]/div/section/div[2]/div[4]/span[2]").getText();
    }
    @Step("Выбор в списке трех товаров")
    public void choiseThreeCofeInDrop() {
        driver.findElementByXPath("//*[@id=\"split-Main-0\"]/div[3]/div[4]/div/div[1]/div/div[1]/div/div/input").sendKeys(Keys.ARROW_DOWN);
        driver.findElementByXPath("//*[@id=\"split-Main-0\"]/div[3]/div[4]/div/div[1]/div/div[1]/div/div/input").sendKeys(Keys.ARROW_DOWN);
        driver.findElementByXPath("//*[@id=\"split-Main-0\"]/div[3]/div[4]/div/div[1]/div/div[1]/div/div/input").sendKeys(Keys.ENTER);
        createScreenshot("choiseThreeCoffeeInDrop");
    }
    @Step("Выбор \"Тип кофеварки=рожковая\"")
    public void choiseСarobCofe() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[5]/div[2]/div/span[2]/label/div[1]").click();
        createScreenshot("choiseСarobCofe");
    }
    @Step("Выбор \"Приготовление напитка=подогрев чашек\"")
    public void choiseWarmingCups() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/aside/div[9]/div[2]/div/span[2]/label/div[1]").click();
        createScreenshot("choiseWarmingCups");
    }
    @Step("Добавить в избранное")
    public void addFavorites() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div[1]/div/div/button/div").click();
        createScreenshot("addFavorites");
    }
    @Step("Перейти в избранное")
    public void goToFavorites() {
        driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[4]/a[1]").click();
        createScreenshot("goToFavorites");
    }

    @Test
    public void firstTest() {
        try {
            OpenCatalog();
            Thread.sleep(2000);
            OpenTech();
            Thread.sleep(2000);
            OpenCofe();
            Thread.sleep(2000);
            choiseFirstTextAndSet10000();
            Thread.sleep(2000);
            choiseSecondText();
            Thread.sleep(3500);
            set11000();
            Thread.sleep(2000);
            clickOnDropMenu();
            Thread.sleep(2000);
            choiseCheap();
            Thread.sleep(3000);
            addToCart();
            Thread.sleep(2000);
            toCart();
            Thread.sleep(3000);
            choiseDropInCart();
            Thread.sleep(2000);
            String money = costOneCofe();
            choiseThreeCofeInDrop();
            Thread.sleep(4000);
            String moneyFinish = costAllCofe();
            if (equal1(money)*3 != equal1(moneyFinish))
                fail("Кол-во товваров меньше 3, либо цена некорректна");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void secondTest() {
        try {
            OpenCatalog();
            Thread.sleep(2000);
            OpenTech();
            Thread.sleep(2000);
            OpenCofe();
            Thread.sleep(2000);
            choiseFirstTextAndSet10000();
            Thread.sleep(2000);
            choiseSecondText();
            Thread.sleep(3500);
            set11000();
            Thread.sleep(3000);
            choiseСarobCofe();
            Thread.sleep(5000);
            choiseWarmingCups();
            Thread.sleep(4000);
            clickOnDropMenu();
            Thread.sleep(2000);
            choiseCheap();
            Thread.sleep(3000);
            addToCart();
            Thread.sleep(2000);
            toCart();
            Thread.sleep(3000);
            choiseDropInCart();
            Thread.sleep(2000);
            String money = costOneCofe();
            choiseThreeCofeInDrop();
            Thread.sleep(4000);
            String moneyFinish = costAllCofe();
            if (equal1(money)*3 != equal1(moneyFinish))
                fail("Кол-во товаров меньше 3, либо цена некорректна");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void thirdTest() {
        try {
            OpenCatalog();
            Thread.sleep(2000);
            OpenTech();
            Thread.sleep(2000);
            OpenCofe();
            Thread.sleep(2000);
            choiseFirstTextAndSet10000();
            Thread.sleep(2000);
            choiseSecondText();
            Thread.sleep(3500);
            set11000();
            Thread.sleep(3000);
            clickOnDropMenu();
            Thread.sleep(2000);
            choiseCheap();
            Thread.sleep(3000);
            String nameCofe = driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[2]/div/a").getText();
            String price = driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/a/div[2]/span[1]").getText();
            String priceWithoutDisc = driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/a/div[2]/span[2]").getText();
            addFavorites();
            Thread.sleep(3000);
            goToFavorites();
            Thread.sleep(3000);
            String nameCofe2 = driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/a[2]").getText();
            String price2 = driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/a[1]/div[1]/span[1]").getText();
            String priceWithoutDisc2 = driver.findElementByXPath("//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/a[1]/div[1]/span[2]").getText();
            Assert.assertTrue(nameCofe.equals(nameCofe2));
            Assert.assertTrue(price.equals(price2));
            Assert.assertTrue(priceWithoutDisc.equals(priceWithoutDisc2));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @After
    public void close() {
        System.out.println("test completed");
        driver.quit();
    }
}
