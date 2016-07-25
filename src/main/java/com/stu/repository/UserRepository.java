package com.stu.repository;

import com.stu.model.StudentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * Created by laizuhong on 2016/7/15.
 */
@Repository
public interface UserRepository extends JpaRepository<StudentBean,Integer>{

    @Modifying
    @Transactional
    @Query("update StudentBean us set us.nickname=:nickname,us.username=:username,us.password=:password where us.id=:id")
    void updateUser(@Param("nickname") String nickname, @Param("username") String username,
                           @Param("password") String password, @Param("id") Integer id);

}
