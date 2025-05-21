package org.example.Repository;

import org.example.entity.Userinfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Userinfo, Long> {
    public Userinfo findByUsername(String username);
}
