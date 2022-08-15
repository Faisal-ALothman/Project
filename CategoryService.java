package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    private ArrayList<Category> CategoryList= new ArrayList<>();

    public ArrayList<Category> getCategory(){
        return CategoryList;
    }
    public void addCategory(Category category){
        CategoryList.add(category);
    }
    public void updateCategory(int index, Category category) {
        CategoryList.set(index,category);
    }
    public void deleteCategory(int index) {
        CategoryList.remove(index);
    }
}