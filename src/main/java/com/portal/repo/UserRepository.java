package com.portal.repo;

import com.portal.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("select u from User u WHERE u.email = :userEmail")
    User getUserByMail(@Param("userEmail") String userEmail);

    @Transactional
    @Modifying
    @Query("delete from User where role != 1")
    void deleteAllEmployees();

    @Query("select u from User u where u.role = 0")
    List<User> getEmployeeDetails();
}
