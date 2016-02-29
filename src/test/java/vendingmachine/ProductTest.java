package vendingmachine;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class ProductTest {

    @Test
    public void coke() {
        Optional<Product> product = Product.find(1);
        assertTrue(product.isPresent());
        assertEquals(Product.COKE, product.get());        
    }

    @Test
    public void chips() {
        Optional<Product> product = Product.find(2);
        assertTrue(product.isPresent());
        assertEquals(Product.CHIPS, product.get());        
    }

    @Test
    public void candy() {
        Optional<Product> product = Product.find(3);
        assertTrue(product.isPresent());
        assertEquals(Product.CANDY, product.get());        
    }

    @Test
    public void invalidProduct() {
        Optional<Product> product = Product.find(4);
        assertFalse(product.isPresent());
    }
}
