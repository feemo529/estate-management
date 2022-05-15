package com.estate.estatemanagement.controller;

import com.estate.estatemanagement.common.MessageConstant;
import com.estate.estatemanagement.common.PageResult;
import com.estate.estatemanagement.common.Result;
import com.estate.estatemanagement.common.StatusCode;
import com.estate.estatemanagement.domain.Car;
import com.estate.estatemanagement.service.CarService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auth: zhuan
 * @Desc: 车辆管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/find")
    public Result find() {
        List<Car> all = carService.finAll();
        return new Result(false,200,"请求成功car",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Car> page = carService.search(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.CAR_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Car car){
        Boolean add = carService.add(car);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Car car = carService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_FIND_BY_ID_SUCCESS,car);
    }
    @RequestMapping("/update")
    public Result update(@RequestBody Car car){
        Boolean add = carService.update(car);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids) {
        Boolean flag = carService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_DELETE_SUCCESS);
    }
}
