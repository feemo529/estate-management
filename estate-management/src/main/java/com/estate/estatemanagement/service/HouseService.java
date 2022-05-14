package com.estate.estatemanagement.service;

import com.estate.estatemanagement.domain.Building;
import com.estate.estatemanagement.domain.House;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface HouseService {
    public List<House> finAll();
    public Page<House> search(Map searchMap);
    public Boolean add(House building);
    public House findById(Integer id);
    public Boolean update(House house);
    public Boolean del(List<Integer> ids);
}
