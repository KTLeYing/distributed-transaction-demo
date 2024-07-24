package com.mzl.commonservice.mapper;

import com.mzl.commonservice.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品表 Mapper 接口
 *
 * @author mzl
 * @since 2024-07-25
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
