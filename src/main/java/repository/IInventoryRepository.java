package repository;

/* IInventoryRepository.java
IInventoryRepository class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import Domain.Inventory;

import java.util.List;

public interface IInventoryRepository extends IRepository<Inventory, String> {
    List<Inventory> getAll();
}
