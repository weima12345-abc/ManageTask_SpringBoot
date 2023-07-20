package com.example.provider.entiy.pojo;


import lombok.Data;

@Data
public class PageHelper {
    //一页记录数
    private  int pageSize=2;
    //当前页
    private  int currentPageNumber;
    //页总数量
    private  int pageCount;
    //总记录条数
    private int rowCount;
    //分页查询开始行号
    private int startRow;
    // 首页
    private int firstPage = 1 ;
}
