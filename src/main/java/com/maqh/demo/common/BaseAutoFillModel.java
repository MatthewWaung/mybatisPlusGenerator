package com.maqh.demo.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 带自动填充字段的基础实体类
 *
 * @author Dunvida
 * @date 2022年03月3日 16:16
 */
public abstract class BaseAutoFillModel<T extends BaseAutoFillModel<?>> extends Model<T> {
    private static final long serialVersionUID = 1L;
    /**
     * 租户人ID
     */
    @JsonIgnore
    @TableField(updateStrategy = FieldStrategy.NOT_NULL, value = "tenant_id", fill = FieldFill.INSERT, select = true)
    private Long tenantId;

    /**
     * 创建人ID
     */
    @JsonIgnore
    @TableField(updateStrategy = FieldStrategy.NOT_NULL, value = "create_by", fill = FieldFill.INSERT, select = true)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(updateStrategy = FieldStrategy.NOT_NULL, value = "create_time", fill = FieldFill.INSERT, select = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新人ID
     */
    @JsonIgnore
    @TableField(updateStrategy = FieldStrategy.NOT_NULL, value = "update_by", fill = FieldFill.UPDATE, select = true)
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField(updateStrategy = FieldStrategy.NOT_NULL, value = "update_time", fill = FieldFill.UPDATE, select = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @XmlTransient
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @XmlTransient
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * 获取主键值
     *
     * @return
     */
    public String getPkVal() {
        Serializable pkVal = pkVal();
        if (pkVal != null) {
            return pkVal.toString();
        }
        return null;
    }

    protected Serializable pkVal() {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(getClass());
        if (tableInfo != null) {
            return (Serializable) ReflectionKit.getMethodValue(this, tableInfo.getKeyProperty());
        }
        return null;
    }


    @Override
    public String toString() {
        return "BaseModel{" +
                ", createBy=" + createBy +
                //", createOrgId=" + createOrgId +
                ", createTime=" + createTime +
                ", tenantId=" + tenantId +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                "}";
    }
}
