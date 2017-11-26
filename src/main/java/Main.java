import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Main {
    public static void main(String[] args) {
        /*
        1. Войти в Админ Панель
        2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        3. Нажать «Добавить категорию» для перехода к созданию новой категории.
        4. После загрузки страницы ввести название новой категории и сохранить изменения. На
        странице управления категориями должно появиться сообщение об успешном создании категории.
        5. Отфильтровать таблицу категорий по имени и дождаться там появления записи
        созданной категории.
        */
        WebDriver driver = initChromeDriver();
        driver.manage().window().maximize();

        //Пункт 1
        Login login = new Login(driver);
        login.doLogin();
        //Пункт 2-5
        MenuCatalog menuCatalog = new MenuCatalog(driver);
        if (menuCatalog.doAddCategory())
            System.out.println("Добавление категории отработано успешно");
        else System.out.println("Добавление категории отработано неуспешно");

        driver.quit();
    }
    public static WebDriver initChromeDriver() {
        String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        return getEventFiringWebDriver(new ChromeDriver());
    }
    public static WebDriver getEventFiringWebDriver(WebDriver webDriver) {
        EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);
        driver.register(new EventHandlerImpl());
        return driver;
    }
}
