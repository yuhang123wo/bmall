package cn.yh.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.yh.dto.SpecValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.SpecValue;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
public interface SpecValueMapper extends BaseMapper<SpecValue> {

	List<SpecValueDto> listSpecValueDto(@Param("specIds") String[] specIds, @Param("state") State state);
}
