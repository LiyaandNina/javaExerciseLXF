package org.example.service;

import org.example.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserService {

    @Autowired
    private SessionFactory sessionFactory;

    public User register(String email, String password, String name) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        sessionFactory.getCurrentSession().persist(user);
        return user;
    }

    public List<User> getUsers(int pageIndex) {
        int pageSize = 100;
        return sessionFactory.getCurrentSession().createQuery("from User u", User.class).setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize)
                             .list();
    }

    public User login(String email, String password) {
        List<User> list = sessionFactory.getCurrentSession().createNamedQuery("login", User.class) // named query
                                        .setParameter("e", email).setParameter("pwd", password).list();
        return list.isEmpty() ? null : list.get(0);
    }

    public void updateUser(Long id, String name) {
        User user = getUserById(id);
        user.setName(name);
        sessionFactory.getCurrentSession().merge(user);
    }

    public boolean deleteUser(Long id) {
        User user = fetchUserById(id);
        if (user != null) {
            sessionFactory.getCurrentSession().remove(user);
            return true;
        }
        return false;
    }

    public User fetchUserByEmail(String email) {
        User example = new User();
        example.setEmail(email);
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User u where u.email = ?1", User.class)
                                        .setParameter(1, email).list();
        return list.isEmpty() ? null : list.get(0);
    }

    public User fetchUserById(Long id) {
        return sessionFactory.getCurrentSession().byId(User.class).load(id);
    }

    public User getUserById(long id) {
        User user = fetchUserById(id);
        if (user == null) {
            throw new RuntimeException("user not found by id: " + id);
        }
        return user;
    }
}
