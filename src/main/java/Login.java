import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;

    private String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private String loginExample = "webinar.test@gmail.com";
    private String passwordExample = "Xcg7299bnSmMuRLp9ITw";

    private By login = By.id("email");
    private By password = By.id("passwd");
    private By loginButton = By.name("submitLogin");
    private By employeeElement = By.id("employee_infos");
    private By logoutButton = By.id("header_logout");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl() {
        driver.get(url);
    }
    public void fillLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(login));
        driver.findElement(login).sendKeys(loginExample);
    }
    public void fillPassword() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys(passwordExample);
    }
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }
    public void clickEmployeeElement() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeElement));
        driver.findElement(employeeElement).click();
    }
    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
    public void doLogin() {
        openUrl();
        fillLogin();
        fillPassword();
        clickLoginButton();
    }
    public void doLogout() {
        clickEmployeeElement();
        clickLogoutButton();
    }
}