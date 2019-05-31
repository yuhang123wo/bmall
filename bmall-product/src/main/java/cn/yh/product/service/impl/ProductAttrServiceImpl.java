package cn.yh.product.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.ProductAttr;
import cn.yh.pojo.product.ProductAttrValue;
import cn.yh.product.mapper.ProductAttrMapper;
import cn.yh.product.mapper.ProductAttrValueMapper;
import cn.yh.product.service.IProductAttrService;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.st.common.util.MallUtil;
import cn.yh.vo.product.ProductAttrVo;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
@Service
public class ProductAttrServiceImpl extends ServiceImpl<ProductAttrMapper, ProductAttr> implements IProductAttrService {

	@Autowired
	private ProductAttrValueMapper productAttrValueMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yh.product.service.IProductAttrService#saveOrderUpdateAttrAndValue(cn.yh.
	 * vo.product.ProductAttrVo)
	 */
	@Transactional
	@Override
	public void saveOrderUpdateAttrAndValue(ProductAttrVo vo) {
		if (MallUtil.longGtZero(vo.getId())) {
			// 修改
			ProductAttr attr = baseMapper.selectById(vo.getId());
			if (null == attr) {
				throw new DefaultException("修改的属性不存在");
			}
			for (int i = 0; i < vo.getList().size(); i++) {
				ProductAttrValue v = vo.getList().get(i);
				productAttrValueMapper.insertAttrValue(v.getName(), vo.getId());
			}
		} else {
			// 新增
			ProductAttr attr = new ProductAttr();
			attr.setCategoryId(vo.getCategoryId());
			attr.setCreateTime(new Date());
			attr.setCustomTag(vo.getCustomTag());
			attr.setCreateUser(vo.getCreateUser());
			attr.setName(vo.getName());
			baseMapper.insert(attr);
			for (int i = 0; i < vo.getList().size(); i++) {
				ProductAttrValue v = vo.getList().get(i);
				productAttrValueMapper.insertAttrValue(v.getName(), vo.getId());
			}
		}
	}

}
