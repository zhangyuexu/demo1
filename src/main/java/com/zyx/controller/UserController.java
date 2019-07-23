package com.zyx.controller;

import com.zyx.pojo.User;
import com.zyx.service.UserService;
import com.zyx.task.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/v2/user")
public class UserController {

    //Logger的导入包一定是org.slf4j.Logger和org.slf4j.LoggerFactory
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("add")
    public String add(){
        User user = new User();
        user.setName("aaa");
        user.setAge(20);
        user.setCreateTime(new Date());
        user.setPhone("10000011");

        int id = userService.add(user);

        return String.valueOf(id);
//        return JsonData.buildSuccess(id);
    }

    @GetMapping("users")
    public Map<String, Object> findAllUser(){
        Map<String,Object> map = new HashMap<>();
        List<User> userList = userService.findAllUser();

        map.put("code",200);
        map.put("result",userList);

        return map;
    }


    @GetMapping("addaccout")
    public String addAccout(){

        int id = userService.addAccount();
        return String.valueOf(id);
//        return JsonData.buildSuccess(id);
    }

    @Autowired
    private AsyncTask asyncTask; //把自己写的异步类注入进来

    @GetMapping("asynctask")
    public String exeTask() throws InterruptedException {
        //模拟下单
        long begin = System.currentTimeMillis();
        //这是不需要返回结果的
//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();

        //这是需要返回结果的
        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();

        for(;;){
            if(task4.isDone()&&task5.isDone()&&task6.isDone()){
                break;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("异步任务总耗时："+(end-begin));
        return String.valueOf((end-begin));
    }


    @GetMapping("testlog")
    public String testLog(){
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        logger.warn("这是warn信息");
        logger.error("这是error信息");

        return "测试logback on slf4j";
    }

    @GetMapping("update")
    public String update(){
        User user = new User();
        user.setId(18);
        user.setName("zzz");
        user.setAge(30);
        user.setCreateTime(new Date());
        user.setPhone("20000022");

        int id = userService.update(user);

        return String.valueOf(id);
//        return JsonData.buildSuccess(id);
    }

    @GetMapping("delete")
    public String delete(Long id){
        int res = userService.delete(id);
        return String.valueOf(res);
    }
}
