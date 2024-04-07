package com.example.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.monitor.constant.MonitorConstants;
import com.example.monitor.domain.SysDemandTask;
import com.example.monitor.mapper.SysDemandTaskMapper;
import com.example.monitor.service.SysDemandTaskService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
* @author exzhang
* @description 针对表【sys_demand_task】的数据库操作Service实现
* @createDate 2024-04-01 15:57:01
*/
@Service
public class SysDemandTaskServiceImpl extends ServiceImpl<SysDemandTaskMapper, SysDemandTask>
    implements SysDemandTaskService{

    @Override
    public boolean saveOrUpdateDemand(SysDemandTask sysDemandTask) {
        boolean update = StringUtils.isNotBlank(sysDemandTask.getId());
        if (update) {
            // 修改
            sysDemandTask.setCompletedNumber(sysDemandTask.getCompletedNumber());
            if (sysDemandTask.getDemandNumber() <= sysDemandTask.getCompletedNumber()) {
                sysDemandTask.setStatus(MonitorConstants.DEMAND_TASK_STATUS_FINISH);
            }
        } else {
            // 新增
            sysDemandTask.setCreateTime(new Date());
            sysDemandTask.setId(String.valueOf(UUID.randomUUID()));
            sysDemandTask.setStatus(MonitorConstants.DEMAND_TASK_STATUS_SUBMIT);
        }
        return this.saveOrUpdate(sysDemandTask);

    }

    @Override
    public Page<SysDemandTask> queryDemand(Page<SysDemandTask> page, SysDemandTask taskPage) {
        LambdaQueryWrapper<SysDemandTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(SysDemandTask::getStatus);
        queryWrapper.orderByDesc(SysDemandTask::getCreateTime);
        // 使用MyBatis Plus的分页查询方法，传入Page对象和查询条件
        return this.baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public SysDemandTask getInfoByWorkstation(String workstation) {
        return this.baseMapper.selectOne(Wrappers.<SysDemandTask>lambdaQuery()
                .eq(SysDemandTask::getWorkstation, workstation)
                .eq(SysDemandTask::getStatus, MonitorConstants.DEMAND_TASK_STATUS_SUBMIT));
    }
}




