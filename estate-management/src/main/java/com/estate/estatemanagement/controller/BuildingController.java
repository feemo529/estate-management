package com.estate.estatemanagement.controller;

import com.estate.estatemanagement.common.MessageConstant;
import com.estate.estatemanagement.common.PageResult;
import com.estate.estatemanagement.common.Result;
import com.estate.estatemanagement.common.StatusCode;
import com.estate.estatemanagement.domain.Building;
import com.estate.estatemanagement.domain.Community;
import com.estate.estatemanagement.service.BuildingService;
import com.estate.estatemanagement.service.CommunityService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//import com.estate.estatemanagement.service.CommunityService;

/**
 * @Auth: zhuan
 * @Desc: 楼栋管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/find")
    public Result find() {
        List<Building> all = buildingService.finAll();
        return new Result(false,200,"请求成功building",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Building> page = buildingService.search(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.BUILDING_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Building building){
        Boolean add = buildingService.add(building);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Building building = buildingService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_FIND_BY_ID_SUCCESS,building);
    }
    @RequestMapping("/update")
    public Result update(@RequestBody Building building){
        Boolean add = buildingService.update(building);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_UPDATE_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids) {
        Boolean flag = buildingService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_DELETE_SUCCESS);
    }
}
