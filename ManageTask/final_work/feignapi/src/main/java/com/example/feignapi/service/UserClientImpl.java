package com.example.feignapi.service;

import com.example.feignapi.uilt.User;
import com.example.feignapi.uilt.Result;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient{




    @Override
    public Result getAll() {
        return  Result.queryFail("查询失败");
    }




    @Override
    public Result add(User user) {
        return  Result.error("增加失败");
    }

    @Override
    public Result update(int id, User user) {
        return  Result.error("更新失败");
    }

    @Override
    public Result delete(int id) {
        return  Result.Fail("删除失败");
    }


    @Override

    public Result findByUserName(String name) {
        return  Result.queryFail("查询失败");
    }

    @Override
    public Result findById(int id) {
        return Result.queryFail("查询失败");
    }

}
