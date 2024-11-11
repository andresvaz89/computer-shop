package org.factoriaf5;

import org.factoriaf5.model.Computer;
import org.factoriaf5.model.Store;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Store store = new Store("Tienda de Andrés", "Andrés", "123-456-789");

        Computer computer1 = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.00);
        Computer computer2 = new Computer("Apple", 8, "M1", "macOS", 1500.00);
        Computer computer3 = new Computer("HP", 32, "AMD Ryzen 7", "Windows 11", 1000.00);

        store.addComputer(computer1);
        store.addComputer(computer2);
        store.addComputer(computer3);

        System.out.println("All Computers:");
        store.listAllComputers().forEach(System.out::println);

        System.out.println("\nSearching for Dell:");
        store.findComputerByBrand("Dell").ifPresent(System.out::println);

        System.out.println("\nRemoving Apple computer:");
        findAndRemoveComputer(store, "Apple");

        System.out.println("\nAll Computers after removal:");
        store.listAllComputers().forEach(System.out::println);
    }

    public static void findAndRemoveComputer(Store store, String brand) {
        Optional<Computer> computer = store.findComputerByBrand(brand);
        if (computer.isPresent()) {
            store.removeComputerByBrand(brand);  // Elimina el computador
            System.out.println("Removed: " + brand);
        } else {
            System.out.println("Computer not found: " + brand);
        }
    
        
        System.out.println("\nAll Computers after removal:");
        store.listAllComputers().forEach(System.out::println);
    }
}
