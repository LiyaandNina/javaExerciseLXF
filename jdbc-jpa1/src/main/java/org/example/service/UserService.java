package org.example.service;

import jakarta.persistence.*;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserService {
    @PersistenceContext
    EntityManager em;

    public User getUserById(long id) {
        User user = em.find(User.class, id);
        if (user == null) {
            throw new RuntimeException("User not found by id: " + id);
        }
        return user;
    }

    public User fetchUserByEmail(String email) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :e", User.class);
        query.setParameter("e", email);
        List<User> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public User getUserByEmail(String email) {
        User user = fetchUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found by email.");
        }
        return user;
    }

    public List<User> getUsers(int pageIndex) {
        int pageSize = 100;
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        query.setFirstResult((pageIndex - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public User login(String email, String password) {
        TypedQuery<User> query = em.createNamedQuery("login", User.class);
        query.setParameter("e", email);
        query.setParameter("pwd", password);
        List<User> list = query.getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    public User register(String email, String password, String name) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        em.persist(user);
        return user;
    }

    public void updateUser(Long id, String name) {
        User user = getUserById(id);
        user.setName(name);
        em.refresh(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        em.remove(user);
    }
}
