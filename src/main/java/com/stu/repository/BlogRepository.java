package com.stu.repository;

import com.stu.model.BlogBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *
 * Created by laizuhong on 2016/7/18.
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogBean,Integer>{
    @Modifying
    @Transactional
    @Query("update BlogBean b set b.title=:title,b.content=:content,b.studentByUserId=:userId,b.pubDate=:date where b.id=:id")
    void update(@Param("title") String title, @Param("content") String content, @Param("userId")Integer userId,
                @Param("date")Date date, @Param("id")Integer id);
}
