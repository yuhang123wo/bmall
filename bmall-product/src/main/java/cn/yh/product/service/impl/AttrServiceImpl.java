package cn.yh.product.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.Attr;
import cn.yh.product.mapper.AttrMapper;
import cn.yh.product.service.IAttrService;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.vo.product.AddAttrVo;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yh.product.service.IAttrService#addAttrValue(cn.yh.vo.product.AddAttrVo)
	 */
	@Transactional
	@Override
	public void addAttrValue(AddAttrVo vo) {
		// 新增attr
		Attr attr = new Attr();
		attr.setCategoryId(vo.getCategoryId());
		attr.setCreateTime(new Date());
		attr.setName(vo.getName());
		attr.setState(vo.getState());
		attr.setUpdateTime(attr.getCreateTime());
		attr.setUserId(vo.getUserId());
		attr.setData(StringUtils.join(vo.getList(),","));
		int n = baseMapper.insert(attr);
		if (n != 1) {
			throw new DefaultException("新增属性失败");
		}
	}

}
