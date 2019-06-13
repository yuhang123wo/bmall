package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.dto.AttrValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.AttrValue;
import cn.yh.product.mapper.AttrValueMapper;
import cn.yh.product.service.IAttrValueService;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue> implements IAttrValueService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yh.product.service.IAttrValueService#listAttrValueDto(java.lang.String[],
	 * cn.yh.pojo.eumn.State)
	 */
	@Override
	public List<AttrValueDto> listAttrValueDto(String[] attrIds, State state) {
		return baseMapper.listAttrValueDto(attrIds, state);
	}

}
