package repository;

/* CategoryRepository.java
CategoryRepositoryImpl class
Author: Jayden Avontuur (222032278)
Date: 21 March 2026*/

import Domain.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {

    private static CategoryRepository repository = null;
    private List<Category> category = new ArrayList<>();

//    private CategoryRepository() {
//        categoryDB = new HashSet<>();
//    }

    public static CategoryRepository getRepository() {
        if (repository == null) {
            repository = new CategoryRepository();
        }
        return repository;
    }

    @Override
    public Category create(Category entity) {
        boolean success = category.add(entity);
        if (success) {
            return entity;
        }
        return null;
    }

//    @Override
//    public Category create(Category category) {
//        category.add(category);
//        return category;
//    }

    @Override
    public Category read(String categoryId) {
        for (Category c : category) {
            if (c.getCategoryId().equals(categoryId)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Category update(Category entity) {
        String id = entity.getCategoryId();
        Category oldCategory = read(id);
        if (oldCategory == null) {
            return null;
        }
        boolean success = category.remove(oldCategory);
        if (!success) {
            return null;
        }
        if (category.add(entity)) {
            return entity;
        }
        return null;
    }
//    @Override
//    public Category update(Category category) {
//        Category oldCategory = read(category.getCategoryId());
//        if (oldCategory != null) {
//            categoryDB.remove(oldCategory);
//            categoryDB.add(category);
//            return category;
//        }
//        return null;
//    }

    @Override
    public boolean delete(String categoryId) {
        Category categoryToDelete = read(categoryId);
        if (categoryToDelete == null) {
            return false;
        }
        return category.remove(categoryToDelete);
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(category);
    }
}