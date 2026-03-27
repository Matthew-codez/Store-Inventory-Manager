package repository;

/* ICategoryRepository.java
ICategoryRepository class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import Domain.Category;
import java.util.List;

public interface ICategoryRepository extends IRepository<Category, String> {
    List<Category> getAll();
}
