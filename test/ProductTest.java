import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3;
    @BeforeEach
    void setUp() {

        p1 = new Product("00000A","Pipeweed", "Long Bottom Leaf", 600.0);
        p2 = new Product("00000A","Lembas", "Elven Wayfare Bread", 200.0);
        p3 = new Product("00000A","Wine", "Woodland Elf Wine", 400.0);


    }

    @Test
    void setIDSeed() {
    }

    @Test
    void setID() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setpName() {
        p1.setpName("Pipeweed");
        assertEquals("Pipeweed", p1.getpName());
    }

    @Test
    void setpDescription() {
        p2.setpDescription("Elven Wayfar Bread");
        assertEquals("Elven Wayfar Bread", p2.getpDescription());
    }

    @Test
    void setpPrice() {
        p3.setpPrice(400.0);
        assertEquals(400.0, p3.getpPrice());
    }

    @Test
    void toCSV() {
        p1.toCSV();
        assertEquals("00000A, Pipeweed, Long Bottom Leaf, 600.0", p1.toCSV());
    }
}