package cn.yh.product.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Spec;
import cn.yh.pojo.product.SpecValue;
import cn.yh.product.mapper.SpecMapper;
import cn.yh.product.service.ISpecService;
import cn.yh.product.service.ISpecValueService;
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

	@Autowired
	private ISpecValueService specValueService;

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
		int n = baseMapper.insert(attr);
		if (n != 1) {
			throw new DefaultException("新增规格失败");
		}
		List<SpecValue> list = vo.getList();
		for (int i = 0; i < list.size(); i++) {
			SpecValue v = list.get(i);
			v.setCreateTime(new Date());
			v.setState(State.ENABLE);
			v.setSpecId(attr.getId());
			v.setUpdateTime(v.getCreateTime());
			v.setUserId(vo.getUserId());
			v.setId(null);
		}
		specValueService.saveBatch(list, list.size());
	}

}
