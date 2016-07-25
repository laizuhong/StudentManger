package com.stu.model;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 * Created by laizuhong on 2016/7/19.
 */
@Entity
@Table(name = "student", schema = "dbo", catalog = "test")
public class StudentBean {
    private int id;
    private String nickname;
    private String username;
    private String password;
    private Collection<BlogBean> blogsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 10)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 10)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentBean that = (StudentBean) o;

        if (id != that.id) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentByUserId")
    public Collection<BlogBean> getBlogsById() {
        return blogsById;
    }

    public void setBlogsById(Collection<BlogBean> blogsById) {
        this.blogsById = blogsById;
    }
}
