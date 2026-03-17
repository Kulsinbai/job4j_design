package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleIsAdmin() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleIsAdmin() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.add(new Role("1", "Manager"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    @Test
    void whenReplaceThenRoleIsManager() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.replace("1", new Role("1", "Manager"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Manager");
    }

    @Test
    void whenNoReplaceRoleThenNoChange() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.replace("10", new Role("10", "Boss"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.delete("1");
        Role result = roleStore.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleStillExists() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.delete("8");
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        boolean result = roleStore.replace("1", new Role("1", "Editor"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        boolean result = roleStore.replace("10", new Role("10", "Boss"));
        assertThat(result).isFalse();
    }
}