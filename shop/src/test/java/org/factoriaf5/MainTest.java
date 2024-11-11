package org.factoriaf5;

import org.factoriaf5.model.Computer;
import org.factoriaf5.model.Store;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.Assert.*;

public class MainTest {

    private Store store;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        store = new Store("Tienda de Andrés", "Andrés", "123-456-789");
        Computer dellComputer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.00);
        Computer appleComputer = new Computer("Apple", 8, "M1", "macOS", 1500.00);
        Computer hpComputer = new Computer("HP", 32, "AMD Ryzen 7", "Windows 11", 1000.00);

        store.addComputer(dellComputer);
        store.addComputer(appleComputer);
        store.addComputer(hpComputer);

        // Prepare the stream to capture output
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testFindAndRemoveComputer() {
        // Call the method to simulate the store operation
        Main.findAndRemoveComputer(store);

        // Verifying that Apple was removed from the store
        assertEquals(2, store.listAllComputers().size());  // The store should now have 2 computers

        // Verify that "Apple" is no longer in the store
        assertFalse(store.listAllComputers().stream()
                .anyMatch(computer -> computer.getBrand().equalsIgnoreCase("Apple")));

        // Capture the output from System.out
        String output = outputStream.toString();
        
        // Depurar la salida completa
        System.out.println("Captured output: " + output);

        // Check that the output contains "Dell" (Dell should still be in the store)
        assertTrue("Expected to find 'Dell' in the output", output.contains("Dell"));

        // Check that the output does NOT contain "Apple" (Apple should be removed)
        assertFalse("Expected not to find 'Apple' in the output", output.contains("Apple"));

        // Verify that the correct message was printed after the removal
        assertTrue("Expected 'All Computers after removal' in the output", output.contains("All Computers after removal:"));
    }

    @Test
    public void testFindAndRemoveComputerNotFound() {
        // Simulate a situation where "NonExistentBrand" is searched and removed
        Main.findAndRemoveComputer(store);

        // Capture the output from System.out
        String output = outputStream.toString();
        
        // Check that "NonExistentBrand" was not found
        assertFalse("Expected not to find 'NonExistentBrand' in the output", output.contains("NonExistentBrand"));

        // Check that all computers still exist after attempting to remove a non-existent brand
        assertTrue("Expected 'Dell' to still be in the list", output.contains("Dell"));
        assertTrue("Expected 'HP' to still be in the list", output.contains("HP"));

        // Verify that the store size remains the same (no removal)
        assertEquals(3, store.listAllComputers().size());
    }
}
