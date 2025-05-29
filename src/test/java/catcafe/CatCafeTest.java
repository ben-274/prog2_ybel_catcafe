package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatCafeTest {
	private CatCafe cafe;
	
	@BeforeEach
    void setUp() {
        cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Cat1", 2));
        cafe.addCat(new FelineOverLord("Cat2", 3));
        cafe.addCat(new FelineOverLord("Cat3", 3));
        cafe.addCat(new FelineOverLord("Cat4", 5));
    }
	
	@Test
    void testCatCount() {
        assertEquals(3, cafe.getCatCount());
    }
	
	@Test
	void testAddCat() {
		cafe.addCat(new FelineOverLord("Cat5", 4));
		assertEquals(4, cafe.getCatCount());
	}
	
	@Test
	void testGetCatByName_Existing() {
        Optional<FelineOverLord> cat = cafe.getCatByName("Cat4");
        assertTrue(cat.isPresent());
        assertEquals("Cat4", cat.get().name());
    }

	@Test
	void testGetCatByName_NotExisting() {
        Optional<FelineOverLord> cat = cafe.getCatByName("Cat5");
        assertTrue(cat.isEmpty());
    }
	
	@Test
	void testGetCatByName_Null() {
        Optional<FelineOverLord> cat = cafe.getCatByName(null);
        assertTrue(cat.isEmpty());
    }
	
	@Test
	void testGetCatByWeight_Existing() {
		Optional<FelineOverLord> cat = cafe.getCatByWeight(1, 3);
		assertTrue(cat.isPresent());
	}
	
	@Test
	void testGetCatByWeight_NotExisting() {
		Optional<FelineOverLord> cat = cafe.getCatByWeight(6, 10);
		assertTrue(cat.isEmpty());
	}
	
	@Test
	void testGetCatByWeight_Invalit() {
		Optional<FelineOverLord> cat = cafe.getCatByWeight(5, 2);
		assertTrue(cat.isEmpty());
	}
	
	@Test
	void testGetCatByWeight_Negative() {
		Optional<FelineOverLord> cat = cafe.getCatByWeight(-3, 3);
		assertTrue(cat.isEmpty());
	}
}
