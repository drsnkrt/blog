package net.blog.base.repository.service;

import net.blog.base.entity.User;
import net.blog.base.repository.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by drsnkrt on 16.01.2018.
 */
@Service
public class UserService {

    @Autowired
    private IUserDao dao;

    public Iterable<User> getAllUsers() {
        return dao.findAll();
    }

    public User getUserById(int id) {
        return dao.findById(id);
    }

    public void saveOrUpdate(User user) {
        dao.save(user);
    }

}
