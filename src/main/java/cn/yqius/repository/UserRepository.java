package cn.yqius.repository;

import cn.yqius.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Integer> {

    Users getUsersByUsernameAndPassword(String username,String password);
}
