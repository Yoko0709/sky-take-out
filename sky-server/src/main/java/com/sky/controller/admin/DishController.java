package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
