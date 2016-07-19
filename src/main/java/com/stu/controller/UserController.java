package com.stu.controller;

import com.stu.model.StudentBean;
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
 * Created by laizuhong on 2016/7/15.
 */
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        List<StudentBean> studentEntities=userRepository.findAll();
        modelMap.addAttribute("userlist",studentEntities);
        return "redirect:admin/users";
    }

    @RequestMapping(value = "/admin/users",method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap){
        List<StudentBean> studentEntities=userRepository.findAll();
        modelMap.addAttribute("userlist",studentEntities);
        return "admin/users";
    }


    @RequestMapping(value = "/admin/users/add",method = RequestMethod.GET)
    public String addUser(){
        return "admin/addUser";
    }


    @RequestMapping(value = "/admin/users/addP",method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("student") StudentBean student){
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        //userRepository.save(userEntity);
        System.out.println(student.toString());
        // 数据库中添加一个用户，并立即刷新缓存
        userRepository.saveAndFlush(student);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "admin/users/show/{id}",method = RequestMethod.GET)
    public String showUser(@PathVariable("id")Integer userId, ModelMap modelMap){
        StudentBean student =userRepository.findOne(userId);
        modelMap.addAttribute("student", student);
        return "admin/userDetail";
    }


    @RequestMapping(value = "/admin/users/update/{id}",method = RequestMethod.GET)
    public String updateUser(@PathVariable("id")Integer userId,ModelMap modelMap){
        StudentBean student =userRepository.findOne(userId);
        modelMap.addAttribute("student", student);
        return "admin/updateUser";
    }

    @RequestMapping(value = "/admin/users/updateP",method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP")StudentBean student){
        System.out.println(student.toString());
        userRepository.updateUser(student.getNickname(), student.getUsername(), student.getPassword(), student.getId());
        userRepository.flush();
        return "redirect:/admin/users";
    }


    @RequestMapping(value = "/admin/users/delete/{id}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id")Integer userId){
        userRepository.delete(userId);
        userRepository.flush();
        return "redirect:/admin/users";
    }
}
