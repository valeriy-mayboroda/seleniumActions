import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MenuCatalog {
    private WebDriver driver;

    private By menuCatalog = By.id("subtab-AdminCatalog");
    private By menuCatalogCategory = By.id("subtab-AdminCategories");
    private By link = By.tagName("a");
    private By linkAddCategory = By.id("page-header-desc-category-new_category");
    private By categoryName = By.id("name_1");
    private By saveButton = By.id("category_form_submit_btn");
    private By successMessage = By.xpath("/html/body/div[1]/div[2]/div[3]/div");
    private By linkFilterByName = By.xpath("/html/body/div[1]/div[2]/div[6]/div/form[2]/div/div[2]/table/thead/tr[1]/th[3]/span/a[2]");
    private By categoryBody = By.xpath("/html/body/div[1]/div[2]/div[5]/div/form[2]/div/div[2]/table/tbody");

    private String categoryNameExample = "Example";
    private String message = "Создано";

    public MenuCatalog(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCatalogCategoryItem() {
        WebDriverWait waitMenuCatalog = new WebDriverWait(driver, 5);
        waitMenuCatalog.until(ExpectedConditions.visibilityOfElementLocated(menuCatalog));
        WebElement catalogCategoryIcon = driver.findElement(menuCatalog);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogCategoryIcon).build().perform();
        WebDriverWait waitMenuCatalogCategory = new WebDriverWait(driver, 5);
        waitMenuCatalogCategory.until(ExpectedConditions.visibilityOfElementLocated(menuCatalogCategory));
        catalogCategoryIcon.findElement(menuCatalogCategory).findElement(link).click();
    }
    public void clickAddCategory() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkAddCategory));
        driver.findElement(linkAddCategory).click();
    }
    public void fillCategoryName() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryName));
        driver.findElement(categoryName).sendKeys(categoryNameExample);
    }
    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
    }
    public boolean successMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        String successText = driver.findElement(successMessage).getText().trim();
        if (successText.matches("(.|\\s)*?" + message + "(.|\\s)*?"))
            return true;
        return false;
    }
    public void clickFilterByName() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkFilterByName));
        driver.findElement(linkFilterByName).click();
    }
    public int categorySum() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryBody));
        List<WebElement> list = driver.findElement(categoryBody).findElements(By.tagName("tr"));
        return list.size();
    }
    public boolean doAddCategory() {
        //Пункт 2
        clickCatalogCategoryItem();
        //Вычисление начальной суммы существующих категорий
        int sumBeforeAdding = categorySum();
        System.out.println("Начальная сумма категорий перед добавлением новой категории = " + sumBeforeAdding);
        //Пункт 3
        clickAddCategory();
        //Пункт 4
        fillCategoryName();
        clickSaveButton();
        //Проверка на вывод сообщения об успешном добавлении категории
        if (successMessage())
            System.out.println("Выводится сообщение об успешном добавлении категории");
        else System.out.println("Сообщение об успешном добавлении категории не выводится или выводится неверное");
        //Пункт 5
        clickFilterByName();
        int sumAfterAdding = categorySum();
        System.out.println("Сумма категорий после добавления новой категории = " + sumAfterAdding);
        //Проверка на добавление новой категории
        if (sumAfterAdding == sumBeforeAdding + 1)
            return true;
        return false;
    }
}
