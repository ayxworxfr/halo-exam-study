package com.evildoer.exam.common.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 安羽兮
 * @Description 分页数据封装类
 * @Date 16:25 2019/10/10
 **/
@Data
public class CommonPage<T> {

    /**
     * pageNum 当前页
     */
    private Integer pageNum;

    /**
     * pageSize 当前分页总页数
     */
    private Integer pageSize;

    /**
     * totalPage 当前分页总页数
     */
    private Integer totalPage;
    /**
     * total 当前满足条件总行数
     */
    private Long total;

    /**
     * list 分页记录列表
     */
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
        return result;
    }

    /**
     * 将MybatisPlus分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(IPage<T> pageInfo) {
        CommonPage<T> result = new CommonPage<T>();
        result.setPageNum((int) pageInfo.getCurrent());
        result.setPageSize((int) pageInfo.getSize());
        result.setTotalPage((int) pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getRecords());
        return result;
    }
}
