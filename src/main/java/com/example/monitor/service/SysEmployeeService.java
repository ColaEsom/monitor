package com.example.monitor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.monitor.domain.SysDemandTask;
import com.example.monitor.domain.SysEmployee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author exzhang
* @description 针对表【sys_employee】的数据库操作Service
* @createDate 2024-04-01 15:57:01
*/
public interface SysEmployeeService extends IService<SysEmployee> {

    void saveOrUpdateUser(SysEmployee sysEmployee);

    Page<SysEmployee> queryUser(Page<SysEmployee> taskPage, SysEmployee sysEmployee);

    // 根据名称查询用户
    SysEmployee getInfoByName(String name);
}
