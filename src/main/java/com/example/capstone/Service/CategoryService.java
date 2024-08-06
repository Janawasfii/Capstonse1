package com.example.capstone.Service;

import com.example.capstone.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class CategoryService {
    ArrayList<Category> categories = new ArrayList<Category>();
    public ArrayList<Category> getCategories() {
        return categories;
    }
    public void addCategories(Category category) {
        categories.add(category);

    }
   public boolean updateCategory(String categoryID, Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(categoryID)) {
                categories.set(i, category);
                return true;}}
        return false;}

    public boolean deleteCategory(String categoryID) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(categoryID)) {
                categories.remove(i);
                return true;}}
        return false;}

}
