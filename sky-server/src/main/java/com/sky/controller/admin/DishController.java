package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Dish Controller

 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "Dish related Api")
@Slf4j

public class DishController {
    @Autowired
    private DishService dishService;
    /**
     * Add Dish and Flavor
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("Add dishes")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("save dish: {}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }
    @GetMapping("/page")
    @ApiOperation("Category Page Search")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("page: {}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * Dish Delete Batch
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("Dish Delete Batch")
    public Result delete(@RequestParam List<Long> ids){
        log.info("delete: {}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get Dish By ID")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("getById: {}", id);
        DishVO dishVo=dishService.getByIdwithFlavor(id);
        return Result.success(dishVo);
    }


    @PutMapping
    @ApiOperation("Updata Dish")
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("update: {}", dishDTO);
        dishService.updatewithFlavor(dishDTO);
        return Result.success();
    }
}
