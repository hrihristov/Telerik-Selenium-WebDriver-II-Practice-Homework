package saucedemotests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

public class ProductsTests extends SauceDemoBaseWebTest {
    public final String BACKPACK_TITLE = "Sauce Labs Backpack";
    public final String SHIRT_TITLE = "Sauce Labs Bolt T-Shirt";

    @BeforeEach
    public void beforeTest(){
        authenticateWithUser(TestData.STANDARD_USER_USERNAME.getValue(), TestData.STANDARD_USER_PASSWORD.getValue());
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){
        Integer expectedItemsCount = 2;

        inventoryPage.addProductsByTitle(BACKPACK_TITLE, SHIRT_TITLE);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        var items = shoppingCartPage.getShoppingCartItems();

        Assertions.assertEquals(expectedItemsCount, items.size(), "Items count not as expected");

        Assertions.assertEquals(BACKPACK_TITLE, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(SHIRT_TITLE, items.get(1).getText(), "Item title not as expected");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        Integer expectedItemsCount = 2;
        inventoryPage.addProductsByTitle(BACKPACK_TITLE, SHIRT_TITLE);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        shoppingCartPage.clickCheckout();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");

        checkoutYourInformationPage.clickContinue();


        // Assert Cart Items number
        var cartItems = checkoutOverviewPage.getShoppingCartItems();
        Assertions.assertEquals(expectedItemsCount, cartItems.size(), "Items count not as expected");

        // Calculate expected total cost
        var total = checkoutOverviewPage.getTotalLabelText();
        double expectedPrice = 29.99 + 15.99 + 3.68;
        String expectedTotal = String.format("Total: $%.2f", expectedPrice);

        // Assert Cart Items Titles and total cost
        Assertions.assertEquals(BACKPACK_TITLE, cartItems.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(SHIRT_TITLE, cartItems.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedTotal, total, "Items total price not as expected");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        Integer expectedItemsCount = 2;

        // Add Backpack and T-shirt to shopping cart
        inventoryPage.addProductsByTitle(BACKPACK_TITLE, SHIRT_TITLE);

        // Click on shopping Cart
        inventoryPage.clickShoppingCartLink();

        // Go to Billing Info
        shoppingCartPage.clickCheckout();

        // Fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");

        checkoutYourInformationPage.clickContinue();

        // Assert Items removed from Shopping Cart
        var cartItems = checkoutOverviewPage.getShoppingCartItems();
        Assertions.assertEquals(expectedItemsCount, cartItems.size(), "Items count not as expected");

        // Complete Order
        checkoutOverviewPage.clickFinish();

        // Assert Shopping cart is empty
        Assertions.assertEquals(0, inventoryPage.getShoppingCartItemsNumber(), "Shopping cart is not empty");
        inventoryPage.clickShoppingCartLink();
        Assertions.assertEquals(0, shoppingCartPage.getShoppingCartItems().size(), "Shopping cart is not empty");
    }
}