package repository;

/* InventoryRepository.java
InventoryRepository class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import Domain.Inventory;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository implements IInventoryRepository {
    private static InventoryRepository repository = null;
    private List<Inventory> inventory = new ArrayList<>();

    public static synchronized InventoryRepository getRepository() {
        if (repository == null) {
            repository = new InventoryRepository();
        }
        return repository;
    }

    @Override
    public Inventory create(Inventory entity) {
        boolean success = inventory.add(entity);
        if (success) {
            return entity;
        }
        return null;
    }

    @Override
    public Inventory read(String inventoryId) {
        for (Inventory inv : inventory) {
            if (inv.getInventoryId().equals(inventoryId)) {
                return inv;
            }
        }
        return null;
    }

    @Override
    public Inventory update(Inventory entity) {
        String id = entity.getInventoryId();
        Inventory oldInventory = read(id);
        if (oldInventory == null) {
            return null;
        }
        boolean success = inventory.remove(oldInventory);
        if (!success) {
            return null;
        }
        if (inventory.add(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(String inventoryId) {
        Inventory inventoryToDelete = read(inventoryId);
        if (inventoryToDelete == null) {
            return false;
        }
        return inventory.remove(inventoryToDelete);
    }

    @Override
    public List<Inventory> getAll() {
        return new ArrayList<>(inventory);
    }
}