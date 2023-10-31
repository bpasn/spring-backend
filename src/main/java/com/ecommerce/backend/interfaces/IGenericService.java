package com.ecommerce.backend.interfaces;

import java.util.List;

public interface IGenericService<Entity> {
    List<Entity> getAll();
    Entity getById(Integer id);
    Entity create(Entity entity);

    Entity update(Entity e);
    void delete(Entity e);
    void deleteById(Integer id);

    long count();
}
