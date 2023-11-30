package org.example.dao;

import org.example.service.User;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

@Component
@Transactional
public class UserDao extends AbstractDao<User>{
    public User fetchUserByEmail(String email) {
        List<User> users = getJdbcTemplate().query("SELECT * FROM users WHERE email = ? ", (rs, row) -> {
            return new User(
                    rs.getLong("id"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("name")
            );
        }, email);
        return users.isEmpty() ? null : users.get(0);
    }

    public User getUserByEmail(String email) {
        return getJdbcTemplate().queryForObject("SELECT * FROM users WHERE email = ? ", (rs, row) -> {
            return new User(
                    rs.getLong("id"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("name")
            );
        }, email);
    }

    public User login(String email, String password) {
        User user = getUserByEmail(email);
        if (password.equals(user.getPassword())) {
            return user;
        }
        throw new RuntimeException("login failed.");
    }

    public User createUser(String email, String password, String name) {
        KeyHolder holder = new GeneratedKeyHolder();
        if (1 != getJdbcTemplate().update((conn) -> {
            var ps = conn.prepareStatement("INSERT INTO users(email, password, name) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, email);
            ps.setObject(2, password);
            ps.setObject(3, name);
            return ps;
        }, holder)) {
            throw new RuntimeException("Insert failed...");
        }
        return new User(holder.getKey().longValue(), email, password, name);
    }

    public void updateUser(User user) {
        if (1 != getJdbcTemplate().update(
                "UPDATE users SET name = ? WHERE id = ?", user.getName(), user.getId())) {
            throw new RuntimeException("Update failed...");
        };
    }
}