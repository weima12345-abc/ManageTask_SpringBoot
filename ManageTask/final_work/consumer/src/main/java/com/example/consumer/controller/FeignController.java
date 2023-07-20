package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import com.example.feignapi.User;
import com.example.feignapi.uilt.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class FeignController {

//
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public Result getAll(){

        return consumerService.getAll();
    }


//    ConsumerService consumer=new ConsumerService();
//    @RequestMapping(value = "/port",method = RequestMethod.GET)
//    public Result port(){
//        return consumerService.port();
//    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        return consumerService.add(user);
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable("id") int id, @RequestBody User user){

        return consumerService.update(id,user);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") int id){

        return consumerService.delete(id);
    }

    @RequestMapping(value = "/findByUserName/{name}",method = RequestMethod.GET)
    public Result findByUserName(@PathVariable("name") String name){
      return   consumerService.findByUserName(name);
    }

    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") int id){
        return   consumerService.findById(id);
    }

}
