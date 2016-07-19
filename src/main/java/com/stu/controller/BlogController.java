package com.stu.controller;

import com.stu.model.BlogBean;
import com.stu.model.StudentBean;
import com.stu.repository.BlogRepository;
import com.stu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *
 * Created by laizuhong on 2016/7/18.
 */
@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/admin/blogs",method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap){
        List<BlogBean> list=blogRepository.findAll();
        modelMap.addAttribute("bloglist",list);
        return "admin/blogs";
    }

    @RequestMapping(value ="/admin/blogs/add",method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap){
        List list=userRepository.findAll();
        modelMap.addAttribute("userlist",list);
        return "admin/addBlog";
    }

    @RequestMapping(value = "/admin/blogs/addP",method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog")BlogBean blogEntity){

//        blogRepository.save(blogEntity);
        System.out.print(blogEntity.toString());
        blogRepository.saveAndFlush(blogEntity);
        return "redirect:/admin/blogs";
    }

    @RequestMapping(value ="/admin/blogs/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id")Integer id,ModelMap modelMap){
        blogRepository.delete(id);
        return "redirect:/admin/blogs";
    }

    @RequestMapping(value = "admin/blogs/show/{id}",method = RequestMethod.GET)
    public String showDetail(@PathVariable("id")Integer blogid,ModelMap modelMap){
        BlogBean blogBean=blogRepository.findOne(blogid);
        System.out.println(blogBean.toString());
        modelMap.addAttribute("blog",blogBean);
        return "admin/blogDetail";
    }

    @RequestMapping(value = "admin/blogs/update/{id}",method = RequestMethod.GET)
    public String updateBlog(@PathVariable("id")Integer blogid,ModelMap modelMap){
        BlogBean blogBean=blogRepository.findOne(blogid);
        List<StudentBean> list=userRepository.findAll();

        modelMap.addAttribute("blog",blogBean);
        modelMap.addAttribute("userList",list);
        return "admin/updateBlog";
    }

    @RequestMapping(value = "admin/blogs/updateP",method = RequestMethod.POST)
    public String updateBlogP(@ModelAttribute("blogP")BlogBean blogBean,ModelMap modelMap){
        System.out.println(blogBean.toString());
        blogRepository.update(blogBean.getTitle(),blogBean.getContent(),blogBean.getId(),blogBean.getPubDate(),blogBean.getId());
        blogRepository.flush();
        return "redirect:/admin/blogs";
    }
}
