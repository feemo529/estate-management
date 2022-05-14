package com.estate.estatemanagement.controller;

import com.estate.estatemanagement.common.MessageConstant;
import com.estate.estatemanagement.common.PageResult;
import com.estate.estatemanagement.common.Result;
import com.estate.estatemanagement.common.StatusCode;
import com.estate.estatemanagement.domain.Building;
import com.estate.estatemanagement.domain.House;
import com.estate.estatemanagement.service.HouseService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//import com.estate.estatemanagement.service.CommunityService;

/**
 * @Auth: zhuan
 * @Desc: 房产管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/find")
    public Result find() {
        List<House> all = houseService.finAll();
        return new Result(false,200,"请求成功house",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<House> page = houseService.search(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.HOUSE_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }
    @RequestMapping("/add")
    public Result add(@RequestBody House house){
        Boolean add = houseService.add(house);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        House house = houseService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_FIND_BY_ID_SUCCESS,house);
    }
    @RequestMapping("/update")
    public Result update(@RequestBody House house){
        Boolean add = houseService.update(house);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids) {
        Boolean flag = houseService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_DELETE_SUCCESS);
    }
}
