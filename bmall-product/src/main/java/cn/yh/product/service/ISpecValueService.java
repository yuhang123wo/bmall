package cn.yh.product.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.dto.SpecValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.SpecValue;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
public interface ISpecValueService extends IService<SpecValue> {
	
	List<SpecValueDto> listSpecValueDto(String[] specIds, State state);
}
