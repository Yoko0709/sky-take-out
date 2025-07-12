package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * insert batch of flavor datas
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * delete dish flavor by dish id
     * @param dishId
     */
    @Delete("delete from dish_flavor where dish_id = #{dish_id}")
    void deleteByDishId(Long dishId);
}
