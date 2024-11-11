package org.factoriaf5.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Store {
    private String storeName;
    private String owner;
    private String taxId;
    private List<Computer> computers;

    public Store(String storeName, String owner, String taxId) {
        this.storeName = storeName;
        this.owner = owner;
        this.taxId = taxId;
        this.computers = new ArrayList<>();
    }

    public void addComputer(Computer computer) {
        computer.setStore(this); 
        computers.add(computer);
    }

    public boolean removeComputerByBrand(String brand) {
        return computers.removeIf(computer -> computer.getBrand().equalsIgnoreCase(brand));
    }

    public Optional<Computer> findComputerByBrand(String brand) {
        return computers.stream()
                .filter(computer -> computer.getBrand().equalsIgnoreCase(brand))
                .findFirst();
    }

    public List<Computer> listAllComputers() {
        return new ArrayList<>(computers);
    }

    public String getStoreName() {
        return storeName;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", owner='" + owner + '\'' +
                ", taxId='" + taxId + '\'' +
                ", computers=" + computers +
                '}';
    }
}
