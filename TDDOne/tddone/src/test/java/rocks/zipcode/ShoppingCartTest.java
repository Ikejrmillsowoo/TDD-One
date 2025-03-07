package rocks.zipcode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// Student should write this test class

class ShoppingCartTest {
    // TODO: Write tests for the ShoppingCart class
    private ShoppingCart cart;


    @BeforeEach
    void setUp() {
        cart = new ShoppingCart(10.0);
    }
    // Make sure to test all functionality including:
    // - Adding and removing items
    @Test
    void testAddItem() {
        ShoppingCart.Item item = new ShoppingCart.Item("Banana", 5.0, 5);
        cart.addItem(item);
        assertEquals(1, cart.getItemCount());
        cart.addItem(item);
        assertEquals(2, cart.getItemCount());
        cart.addItem(item);
        assertEquals(3, cart.getItemCount());
    }

    @Test
    void testRemoveItem() {
        ShoppingCart.Item item = new ShoppingCart.Item("Banana", 1.0, 10);
        cart.addItem(item);
        assertEquals(1, cart.getItemCount());
        cart.removeItem(item);
        assertEquals(0, cart.getItemCount());
        cart.addItem(item);
        cart.addItem(item);
        cart.addItem(item);
        assertEquals(3, cart.getItemCount());
        cart.removeItem(item);
        cart.removeItem(item);
        assertEquals(1, cart.getItemCount());
    }
    // - Calculating subtotal, tax, and total
    @Test
    void testGetSubTotal(){
        ShoppingCart.Item item1 = new ShoppingCart.Item("Banana", 1.0, 10);
        ShoppingCart.Item item2 = new ShoppingCart.Item("Bread", 3.30, 5);
        ShoppingCart.Item item3 = new ShoppingCart.Item("Milk", 4.0, 20);
        cart.addItem(item1);
        assertEquals(10.0, cart.getSubtotal());
        cart.removeItem(item1);
        cart.addItem(item2);
        assertEquals(16.5, cart.getSubtotal());
        cart.addItem(item3);
        assertEquals(96.5, cart.getSubtotal());
    }

    @Test
    void testGetTaxAmount(){
        ShoppingCart.Item item1 = new ShoppingCart.Item("Banana", 1.0, 10);
        ShoppingCart.Item item2 = new ShoppingCart.Item("Bread", 3.30, 5);
        cart.addItem(item1);
        assertEquals(100.0, cart.getTaxAmount());
        cart.removeItem(item1);
       cart.addItem(item2);
       assertEquals(165.0, cart.getTaxAmount());

    }

    @Test
    void testGetTotal(){
        ShoppingCart.Item item1 = new ShoppingCart.Item("Banana", 1.0, 10);
        ShoppingCart.Item item2 = new ShoppingCart.Item("Bread", 3.30, 5);
        cart.addItem(item1);
        assertEquals(110.0, cart.getTotal());
        cart.removeItem(item1);
        cart.addItem(item2);
        assertEquals(181.5, cart.getTotal());
        cart.removeItem(item2);
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals(291.5, cart.getTotal());
    }

    // - Edge cases like an empty cart

    @Test
    void testClearCart(){
        ShoppingCart.Item item1 = new ShoppingCart.Item("Banana", 50.0, 33);
        ShoppingCart.Item item2 = new ShoppingCart.Item("Bread", 44.90, 150);
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals(8385.0, cart.getSubtotal());
        cart.clearCart();
        assertEquals(0.0, cart.getSubtotal());
        cart.addItem(item2);
        cart.addItem(item2);
        assertEquals(13470.0, cart.getSubtotal());
        cart.clearCart();
        assertEquals(0.0, cart.getSubtotal());

    }
    // - Invalid inputs (e.g., negative prices, zero quantity)
    @Test
    void testNegativeInputs() {
        Exception exception =assertThrows(IllegalArgumentException.class, () -> {
            ShoppingCart.Item item = new ShoppingCart.Item("Bread", -40, 10);
            cart.addItem(item);
        });
            String expectedMessage = "Price cannot be negative";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
            assertEquals(0.0, cart.getSubtotal());
    }

    @Test
    void testZeroQuantity(){
        Exception exception =assertThrows(IllegalArgumentException.class, () -> {
            ShoppingCart.Item item = new ShoppingCart.Item("Bread", -40, 0);
            cart.addItem(item);
        });
        String expectedMessage = "Quantity must be positive";
        String actualMessage = exception.getMessage();

        assertFalse(actualMessage.contains(expectedMessage));
        assertEquals(0.0, cart.getSubtotal());
    }

}
