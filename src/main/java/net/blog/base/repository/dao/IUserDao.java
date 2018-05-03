package net.blog.base.repository.dao;


import net.blog.base.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by drsnkrt on 16.01.2018.
 */
public interface IUserDao extends CrudRepository<User, Integer> {

    User findById(int id);
}
