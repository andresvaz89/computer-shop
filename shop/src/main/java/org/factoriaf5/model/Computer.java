package org.factoriaf5.model;

public class Computer {
    private String brand;
    private int memory;
    private String processor;
    private String operatingSystem;
    private double price;
    private Store store; 

    public Computer(String brand, int memory, String processor, String operatingSystem, double price) {
        this.brand = brand;
        this.memory = memory;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    
    public String getBrand() {
        return brand;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", memory=" + memory +
                ", processor='" + processor + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", price=" + price +
                ", store=" + (store != null ? store.getStoreName() : "Sin tienda asignada") +
                '}';
    }
}
