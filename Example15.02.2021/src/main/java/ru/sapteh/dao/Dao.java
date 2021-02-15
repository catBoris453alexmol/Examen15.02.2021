package ru.sapteh.dao;

import java.security.Key;
import java.util.List;

public interface Dao<Entity, key> {
    void create(Entity entity);
    Entity read(Key key);
    List<Entity> readByAll();
    void update(Entity entity);
    void delete(Entity entity);
}
