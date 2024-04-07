package com.example.monitor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.monitor.domain.SysDemandRecord;
import com.example.monitor.service.SysDemandRecordService;
import com.example.monitor.mapper.SysDemandRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author exzhang
* @description 针对表【sys_demand_record】的数据库操作Service实现
* @createDate 2024-04-01 15:57:01
*/
@Service
public class SysDemandRecordServiceImpl extends ServiceImpl<SysDemandRecordMapper, SysDemandRecord>
    implements SysDemandRecordService {

    @Override
    public void saveOrUpdateRecord(SysDemandRecord sysDemandRecord) {
        this.saveOrUpdate(sysDemandRecord);
    }
}




