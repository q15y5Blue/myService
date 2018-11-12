package cn.yqius.repository;

import cn.yqius.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Integer> {

}
