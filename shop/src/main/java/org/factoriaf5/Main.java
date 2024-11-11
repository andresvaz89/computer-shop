package org.factoriaf5;

import org.factoriaf5.model.Computer;
import org.factoriaf5.model.Store;

public class Main {

    public static void main(String[] args) {
        Store store = new Store("Tienda de Andrés", "Andrés", "123-456-789");

        Computer computer1 = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.00);
        Computer computer2 = new Computer("Apple", 8, "M1", "macOS", 1500.00);
        Computer computer3 = new Computer("HP", 32, "AMD Ryzen 7", "Windows 11", 1000.00);

        store.addComputer(computer1);
        store.addComputer(computer2);
        store.addComputer(computer3);

        // Esto es lo que hace el método findAndRemoveComputer
        findAndRemoveComputer(store);
    }

    public static void findAndRemoveComputer(Store store) {
        // Buscar la computadora por marca
        System.out.println("Searching for Dell:");
        store.findComputerByBrand("Dell").ifPresent(System.out::println);

        // Eliminar la computadora Apple
        System.out.println("\nRemoving Apple computer:");
        store.removeComputerByBrand("Apple");

        // Listar todos los computadores después de la eliminación
        System.out.println("\nAll Computers after removal:");
        store.listAllComputers().forEach(System.out::println);
    }
}
