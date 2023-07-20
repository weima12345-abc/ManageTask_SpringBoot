package com.example.consumer.service;

import com.example.feignapi.User;
import com.example.feignapi.service.UserClient;
import com.example.feignapi.uilt.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class ConsumerService {


    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public Result getAll(){

        return userClient.getAll();
    }
//    @RequestMapping(value = "/port",method = RequestMethod.GET)
//    public Result port(){
//        return userClient.sayHello();
//    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody com.example.feignapi.User user){
        return userClient.add(user);
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable("id") int id, @RequestBody com.example.feignapi.User user){

        return userClient.update(id,user);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") int id){

        return userClient.delete(id);
    }


    @RequestMapping(value = "/findByUserName/{name}",method = RequestMethod.GET)
    public Result findByUserName(@PathVariable("name") String name){
        return   userClient.findByUserName(name);
    }

    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") int id){
        return   userClient.findById(id);
    }


}
