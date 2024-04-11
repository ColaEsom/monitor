package com.example.monitor.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.monitor.domain.SysDemandTask;
import com.example.monitor.domain.SysEmployee;
import com.example.monitor.mapper.SysEmployeeMapper;
import com.example.monitor.service.SysEmployeeService;
import org.springframework.stereotype.Service;

/**
* @author exzhang
* @description 针对表【sys_employee】的数据库操作Service实现
* @createDate 2024-04-01 15:57:01
*/
@Service
public class SysEmployeeServiceImpl extends ServiceImpl<SysEmployeeMapper, SysEmployee>
    implements SysEmployeeService {

    @Override
    public void saveOrUpdateUser(SysEmployee sysEmployee) {
        this.saveOrUpdate(sysEmployee);
    }

    @Override
    public Page<SysEmployee> queryUser(Page<SysEmployee> taskPage, SysEmployee sysEmployee) {
        return baseMapper.selectPage(taskPage, Wrappers.lambdaQuery(sysEmployee));
    }

    /**
     * 根据姓名查询用户信息
     * @param name 名称
     * @return
     */
    @Override
    public SysEmployee getInfoByName(String name) {
        if (StringUtils.isNotBlank(name)) {
            return this.lambdaQuery().eq(SysEmployee::getEmployee, name).last("limit 1").one();
        }
        return null;
    }
}




