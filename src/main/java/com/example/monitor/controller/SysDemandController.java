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
import com.example.monitor.domain.SysDemandRecord;
import com.example.monitor.domain.SysDemandTask;
import com.example.monitor.service.SysDemandRecordService;
import com.example.monitor.service.SysDemandTaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 需求接口
 */
@RestController
@RequestMapping("/mo")
@AllArgsConstructor
public class SysDemandController {

    private final SysDemandTaskService sysDemandTaskService;

    private final SysDemandRecordService sysDemandRecordService;

    /**
     * 分页条件查询接口
     */
    @GetMapping("/task/page")
    public Page<SysDemandTask> queryDemand(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "10") int size,
                                           SysDemandTask sysDemandRecord) {
        Page<SysDemandTask> taskPage = new Page<>(page, size);
        return sysDemandTaskService.queryDemand(taskPage, sysDemandRecord);
    }

    /**
     * 保存修改需求下发接口
     * @param sysDemandTask 需求
     * @return 是否成功
     */
    @PostMapping("/task/save")
    public Boolean saveOrUpdateDemand(@RequestBody SysDemandTask sysDemandTask) {
        return sysDemandTaskService.saveOrUpdateDemand(sysDemandTask);
    }

    /**
     * 保存需求下发记录
     * @param sysDemandRecord 需求下发记录
     */
    @PostMapping("/record/save")
    public void saveDemandRecord(@RequestBody SysDemandRecord sysDemandRecord) {
        sysDemandRecordService.saveOrUpdateRecord(sysDemandRecord);
    }

    /**
     * 根据工位查询接口
     * @param workstation 工位
     * @return 需求
     */
    @GetMapping("/info/{workstation}")
    public SysDemandTask getInfoByWorkstation(@PathVariable(value = "workstation")  String workstation) {
        return sysDemandTaskService.getInfoByWorkstation(workstation);
    }

    /**
     * 分页条件查询接口
     */
    @GetMapping("/record/page")
    public Page<SysDemandRecord> queryDemandRecord(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "10") int size,
                                           SysDemandRecord sysDemandRecord) {
        Page<SysDemandRecord> taskPage = new Page<>(page, size);
        return sysDemandRecordService.queryRecord(taskPage, sysDemandRecord);
    }


}
