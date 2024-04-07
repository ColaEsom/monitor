package com.example.monitor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.monitor.domain.SysDemandTask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author exzhang
* @description 针对表【sys_demand_task】的数据库操作Service
* @createDate 2024-04-01 15:57:01
*/
public interface SysDemandTaskService extends IService<SysDemandTask> {

    /**
     * 保存需求下发接口
     * @param sysDemandTask 需求下发
     * @return 是否成功
     */
    boolean saveOrUpdateDemand(SysDemandTask sysDemandTask);

    /**
     * 分页查询需求下发
     * @param page 分页参数
     * @param taskPage 查询参数
     * @return 分页数据
     */
    Page<SysDemandTask> queryDemand(Page<SysDemandTask> page, SysDemandTask taskPage);

    /**
     * 根据工位查询需求下发
     * @param workstation 工位
     * @return 需求下发
     */
    SysDemandTask getInfoByWorkstation(String workstation);
}
