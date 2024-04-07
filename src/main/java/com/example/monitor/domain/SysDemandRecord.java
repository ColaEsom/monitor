package com.example.monitor.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName sys_demand_record
 */
@TableName(value ="sys_demand_record")
@Data
public class SysDemandRecord implements Serializable {
    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 产品名称
     */
    private String product;

    /**
     * 员工
     */
    private String employee;

    /**
     * 工位
     */
    private String workstation;

    /**
     * 需求量
     */
    private Integer demandNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态  submit已提交  finish完成 
     */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysDemandRecord other = (SysDemandRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProduct() == null ? other.getProduct() == null : this.getProduct().equals(other.getProduct()))
            && (this.getEmployee() == null ? other.getEmployee() == null : this.getEmployee().equals(other.getEmployee()))
            && (this.getWorkstation() == null ? other.getWorkstation() == null : this.getWorkstation().equals(other.getWorkstation()))
            && (this.getDemandNumber() == null ? other.getDemandNumber() == null : this.getDemandNumber().equals(other.getDemandNumber()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProduct() == null) ? 0 : getProduct().hashCode());
        result = prime * result + ((getEmployee() == null) ? 0 : getEmployee().hashCode());
        result = prime * result + ((getWorkstation() == null) ? 0 : getWorkstation().hashCode());
        result = prime * result + ((getDemandNumber() == null) ? 0 : getDemandNumber().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", employee=").append(employee);
        sb.append(", workstation=").append(workstation);
        sb.append(", demandNumber=").append(demandNumber);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}