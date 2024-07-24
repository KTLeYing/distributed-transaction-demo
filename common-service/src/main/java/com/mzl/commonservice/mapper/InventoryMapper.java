package com.mzl.commonservice.mapper;

import com.mzl.commonservice.entity.Inventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存表 Mapper 接口
 *
 * @author mzl
 * @since 2024-07-25
 */
@Mapper
public interface InventoryMapper extends BaseMapper<Inventory> {

}
