
package org.factoriaf5;

import org.factoriaf5.model.Computer;
import org.factoriaf5.model.Store;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class StoreTest {
    private Store store;
    private Computer dellComputer;
    private Computer appleComputer;
    private Computer hpComputer;

    @Before
    public void setUp() {
        store = new Store("Tienda de Andrés", "Andrés", "123-456-789");
        dellComputer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.00);
        appleComputer = new Computer("Apple", 8, "M1", "macOS", 1500.00);
        hpComputer = new Computer("HP", 32, "AMD Ryzen 7", "Windows 11", 1000.00);

        store.addComputer(dellComputer);
        store.addComputer(appleComputer);
        store.addComputer(hpComputer);
    }

    @Test
    public void testAddComputer() {
        Computer newComputer = new Computer("Asus", 16, "Intel i5", "Windows 10", 800.00);
        store.addComputer(newComputer);
        assertTrue(store.listAllComputers().contains(newComputer));
    }

    @Test
    public void testRemoveComputerByBrand() {
        boolean removed = store.removeComputerByBrand("Apple");
        assertTrue(removed);
        assertFalse(store.listAllComputers().contains(appleComputer));
    }

    @Test
    public void testRemoveComputerByBrandNotFound() {
        boolean removed = store.removeComputerByBrand("NonExistentBrand");
        assertFalse(removed);
    }

    @Test
    public void testFindComputerByBrand() {
        Optional<Computer> foundComputer = store.findComputerByBrand("Dell");
        assertTrue(foundComputer.isPresent());
        assertEquals(dellComputer, foundComputer.get());
    }

    @Test
    public void testFindComputerByBrandNotFound() {
        Optional<Computer> foundComputer = store.findComputerByBrand("NonExistentBrand");
        assertFalse(foundComputer.isPresent());
    }

    @Test
    public void testListAllComputers() {
        assertEquals(3, store.listAllComputers().size());
        assertTrue(store.listAllComputers().contains(dellComputer));
        assertTrue(store.listAllComputers().contains(appleComputer));
        assertTrue(store.listAllComputers().contains(hpComputer));
    }
    @Test
    public void testToString() {
        Store store = new Store("Andres's Tech Store", "Andrés", "123-ABC");

        Computer computer1 = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.00);
        Computer computer2 = new Computer("Apple", 8, "M1", "macOS", 1500.00);
        store.addComputer(computer1);
        store.addComputer(computer2);

        String expectedOutput = "Store{storeName='Andres's Tech Store', owner='Andrés', taxId='123-ABC', computers=["
                + "Computer{brand='Dell', memory=16, processor='Intel i7', operatingSystem='Windows 10', price=1200.0}, "
                + "Computer{brand='Apple', memory=8, processor='M1', operatingSystem='macOS', price=1500.0}"
                + "]}";

        assertEquals(expectedOutput, store.toString());
    }

}
