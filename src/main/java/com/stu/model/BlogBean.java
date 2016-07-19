package com.stu.model;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by laizuhong on 2016/7/19.
 */
@Entity
@Table(name = "Blog", schema = "dbo", catalog = "test")
public class BlogBean {
    private int id;
    private String title;
    private String content;
    private Date pubDate;
    private StudentBean studentByUserId;

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
    @Column(name = "title", nullable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "conent", nullable = true, length = 200)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pub_date", nullable = true)
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogBean blogBean = (BlogBean) o;

        if (id != blogBean.id) return false;
        if (title != null ? !title.equals(blogBean.title) : blogBean.title != null) return false;
        if (content != null ? !content.equals(blogBean.content) : blogBean.content != null) return false;
        if (pubDate != null ? !pubDate.equals(blogBean.pubDate) : blogBean.pubDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public StudentBean getStudentByUserId() {
        return studentByUserId;
    }

    public void setStudentByUserId(StudentBean studentByUserId) {
        this.studentByUserId = studentByUserId;
    }
}
