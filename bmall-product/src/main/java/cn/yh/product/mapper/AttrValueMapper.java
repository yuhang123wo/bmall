package cn.yh.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.yh.dto.AttrValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.AttrValue;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
public interface AttrValueMapper extends BaseMapper<AttrValue> {

	List<AttrValueDto> listAttrValueDto(@Param("attrIds") String[] attrIds, @Param("state") State state);
}
