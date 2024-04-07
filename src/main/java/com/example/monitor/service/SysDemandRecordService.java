package com.example.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.monitor.domain.SysDemandRecord;

/**
* @author exzhang
* @description 针对表【sys_demand_record】的数据库操作Service
* @createDate 2024-04-01 15:57:01
*/
public interface SysDemandRecordService extends IService<SysDemandRecord> {

    void saveOrUpdateRecord(SysDemandRecord sysDemandRecord);
}
