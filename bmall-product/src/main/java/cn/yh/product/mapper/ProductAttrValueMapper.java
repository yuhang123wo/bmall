package cn.yh.product.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.yh.pojo.product.ProductAttrValue;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
public interface ProductAttrValueMapper extends BaseMapper<ProductAttrValue> {

	@Insert("insert ignore into product_attr_value(name,attr_id) values(#{name},#{attrId})")
	int insertAttrValue(@Param("name") String name, @Param("attrId") long attrId);
}
