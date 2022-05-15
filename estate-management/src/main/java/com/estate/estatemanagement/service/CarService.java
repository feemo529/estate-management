package com.estate.estatemanagement.service;

import com.estate.estatemanagement.domain.Car;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface CarService {
    public List<Car> finAll();
    public Page<Car> search(Map searchMap);
    public Boolean add(Car car);
    public Car findById(Integer id);
    public Boolean update(Car car);
    public Boolean del(List<Integer> ids);
}
