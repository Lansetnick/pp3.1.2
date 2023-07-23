package com.example.pp_3122.repository;

import com.example.pp_3122.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u left join fetch u.roles where u.id=:id")
    User findUserById(Long id);
}
