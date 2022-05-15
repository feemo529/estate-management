package com.estate.estatemanagement.dao;

import com.estate.estatemanagement.domain.House;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface HouseMapper extends Mapper<House> {
}
