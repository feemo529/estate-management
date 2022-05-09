package com.estate.estatemanagement.service;

import com.estate.estatemanagement.domain.Building;
import com.estate.estatemanagement.domain.Community;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    public List<Building> finAll();
    public Page<Building> search(Map searchMap);
    public Boolean add(Building building);
    public Building findById(Integer id);
    public Boolean update(Building building);
    public Boolean del(List<Integer> ids);
}
