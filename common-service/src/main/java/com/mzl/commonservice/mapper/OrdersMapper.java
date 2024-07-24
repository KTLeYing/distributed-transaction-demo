package com.mzl.commonservice.mapper;

import com.mzl.commonservice.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表 Mapper 接口
 *
 * @author mzl
 * @since 2024-07-25
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
