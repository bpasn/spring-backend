package com.ecommerce.backend;

import java.util.Map;

public class ModelSeed {
    private Map<String,String[]> categories;

    public Map<String, String[]> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String[]> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ModelSeed{" +
                "categories=" + categories +
                '}';
    }
}
