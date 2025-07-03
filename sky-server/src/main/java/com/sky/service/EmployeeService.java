package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * New Employee
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);


    /**
     * employee page search
     * @param employeePageQueryDTO
     * @return
     */

    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    void statOrStop(Integer status, Long id);

    /**
     * search user by ID
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * update employee infor
     * @param employeeDTO
     */
    void update(EmployeeDTO employeeDTO);
}
