package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {
    /**
     * Add dish and flavor
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

    /**
     * dish Category Search
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * Dish Delete Batch
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * Get dish and flavor by id
     * @param id
     */
    DishVO getByIdwithFlavor(Long id);
    /**
     * Update dish and related flavor
     * @param dishDTO
     */
    void updatewithFlavor(DishDTO dishDTO);
}
