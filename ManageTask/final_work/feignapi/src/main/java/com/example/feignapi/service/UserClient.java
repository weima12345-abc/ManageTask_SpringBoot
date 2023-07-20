package com.example.feignapi.service;

import com.example.feignapi.uilt.User;
import com.example.feignapi.config.LogConfiguration;
import com.example.feignapi.uilt.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "providers",configuration = LogConfiguration.class,fallback = UserClientImpl.class)
@Service
public interface UserClient {

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public Result add(@RequestBody User user);


    @RequestMapping(value = "/user/update/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable("id") int id, @RequestBody User user);

    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") int id);

    @RequestMapping(value = "/user/getAll",method = RequestMethod.GET)
    public Result getAll();

    @RequestMapping(value = "/user/findByUserName/{name}",method = RequestMethod.GET)
    public Result findByUserName(@PathVariable("name") String name);

    @RequestMapping(value = "/user/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") int id);

}
