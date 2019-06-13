package cn.yh.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.dto.SpecValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.SpecValue;
import cn.yh.product.mapper.SpecValueMapper;
import cn.yh.product.service.ISpecValueService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@Service
public class SpecValueServiceImpl extends ServiceImpl<SpecValueMapper, SpecValue> implements ISpecValueService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yh.product.service.ISpecValueService#listAttrValueDto(java.lang.String[],
	 * cn.yh.pojo.eumn.State)
	 */
	@Override
	public List<SpecValueDto> listSpecValueDto(String[] specIds, State state) {
		return baseMapper.listSpecValueDto(specIds, state);
	}

}
