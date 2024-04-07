/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.monitor.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.monitor.domain.SysDemandTask;
import com.example.monitor.domain.SysEmployee;
import com.example.monitor.service.SysDemandTaskService;
import com.example.monitor.service.SysEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 需求下发接口
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class SysUserController {

    private final SysEmployeeService sysEmployeeService;

    /**
     * 分页条件查询接口
     */
    @GetMapping("/page")
    public Page<SysEmployee>  queryDemand(@RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size", defaultValue = "10") int size,
                                            SysEmployee sysEmployee) {
        Page<SysEmployee> taskPage = new Page<>(page, size);
        return sysEmployeeService.queryUser(taskPage, sysEmployee);
    }


    @PostMapping("/save")
    public void saveDemand(@RequestBody SysEmployee sysEmployee) {
        sysEmployeeService.saveOrUpdateUser(sysEmployee);
    }


}
