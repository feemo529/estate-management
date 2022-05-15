package com.estate.estatemanagement.service.impl;

import com.estate.estatemanagement.dao.CarMapper;
import com.estate.estatemanagement.domain.Car;
import com.estate.estatemanagement.service.CarService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> finAll() {
        List<Car> cars = carMapper.selectAll();
        return cars;
    }

    @Override
    public Page<Car> search(Map searchMap) {
        // 通用Mapper 多条件搜索，标准写法
        Example example = new Example(Car.class);
        // 1.初始化条件
        int pageNum = 1;
        int pageSize = 2;
        if(searchMap != null) {
            Example.Criteria criteria = example.createCriteria();
            // 时间区间
            if(StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                criteria.andGreaterThanOrEqualTo("createTime",searchMap.get("startTime"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
            }
            // 名称模糊搜索
            if(StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                criteria.andLike("name", "%"+(String) searchMap.get("name")+"%");
            }
            // 分页
            if(StringUtil.isNotEmpty((String) searchMap.get("pageNum"))) {
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("pageSize"))) {
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }

        }
        PageHelper.startPage(pageNum,pageSize); // 使用 pageHelper 插件完成分页
        Page<Car> cars = (Page<Car>) carMapper.selectByExample(example);
        return cars;
    }

    @Override
    public Boolean add(Car car) {
        int row =  carMapper.insert(car);
        if(row > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Car findById(Integer id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Car car) {
        int row =  carMapper.updateByPrimaryKey(car);
        if(row > 0) {
            return true;
        } else {
            return false;
        }
    }



    @Override
    public Boolean del(List<Integer> ids) {
        for(Integer id:ids) {
            carMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
