package ru.job4j.generic;

public class RoleStore implements Store<Role> {
    private final Store<Role> roleName = new MemStore<>();

    @Override
    public void add(Role model) {
        roleName.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return roleName.replace(id, model);
    }

    public void delete(String id) {
        roleName.delete(id);
    }

    public Role findById(String id) {
        return roleName.findById(id);
    }
}
