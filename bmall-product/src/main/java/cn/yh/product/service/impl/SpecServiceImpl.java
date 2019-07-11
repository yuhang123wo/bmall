package cn.yh.product.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.Spec;
import cn.yh.product.mapper.SpecMapper;
import cn.yh.product.service.ISpecService;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.vo.product.AddSpecVo;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements ISpecService {

	@Transactional
	@Override
	public void addSpecValue(AddSpecVo vo) {
		// 新增attr
		Spec attr = new Spec();
		attr.setCategoryId(vo.getCategoryId());
		attr.setCreateTime(new Date());
		attr.setName(vo.getName());
		attr.setState(vo.getState());
		attr.setUpdateTime(attr.getCreateTime());
		attr.setUserId(vo.getUserId());
		attr.setData(StringUtils.join(vo.getList(), ","));
		int n = baseMapper.insert(attr);
		if (n != 1) {
			throw new DefaultException("新增规格失败");
		}
	}
}
