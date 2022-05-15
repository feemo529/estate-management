package com.estate.estatemanagement.dao;

import com.estate.estatemanagement.domain.Car;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CarMapper extends Mapper<Car> {
}
