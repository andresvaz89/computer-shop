package org.factoriaf5;

import org.factoriaf5.model.Computer;
import org.factoriaf5.model.Store;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        // Configuración para capturar la salida de System.out
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testFindAndRemoveComputer() {
      
        Main.findAndRemoveComputer(store, "Apple");

      
        assertEquals(2, store.listAllComputers().size());

      
        assertFalse(store.listAllComputers().stream()
                .anyMatch(computer -> computer.getBrand().equalsIgnoreCase("Apple")));

        
        String output = outputStream.toString();

    
        assertTrue(output.contains("Dell"));  
        assertFalse(output.contains("Apple"));  
        assertTrue(output.contains("All Computers after removal:"));  

     
        assertTrue(output.contains("Removed: Apple"));
    }

    @Test
    public void testFindAndRemoveComputerNotFound() {
  
        Main.findAndRemoveComputer(store, "Lenovo");

  
        assertEquals(3, store.listAllComputers().size());

        String output = outputStream.toString();

      
        assertTrue(output.contains("Computer not found: Lenovo"));
    }
}
