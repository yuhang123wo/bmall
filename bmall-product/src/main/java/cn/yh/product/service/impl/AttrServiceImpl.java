package cn.yh.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.AttrValue;
import cn.yh.product.mapper.AttrMapper;
import cn.yh.product.service.IAttrService;
import cn.yh.product.service.IAttrValueService;
import cn.yh.st.common.api.CommonResult;
import cn.yh.vo.product.AddAttrVo;

/**
 * <p>
 * 属性 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {

	@Autowired
	private IAttrValueService attrValueService;

	@Transactional
	@Override
	public CommonResult addAttrAndValues(AddAttrVo vo) {
		int n = baseMapper
				.selectCount(new QueryWrapper<Attr>().eq("name", vo.getName()).eq("category_id", vo.getCategoryId()));
		if (n >= 1) {
			return new CommonResult(CommonResult.CODE_FAIL, "属性名重复");
		}
		Attr attr = new Attr();
		attr.setName(vo.getName());
		attr.setCategoryId(vo.getCategoryId());
		attr.setState(State.ENABLE);
		baseMapper.insert(attr);
		// 添加属性
		List<AttrValue> list = new ArrayList<AttrValue>();
		for (int i = 0; i < vo.getList().size(); i++) {
			AttrValue v = new AttrValue();
			v.setAttrId(attr.getId());
			v.setState(State.ENABLE);
			v.setvName(vo.getList().get(i));
			list.add(v);
		}
		attrValueService.saveBatch(list, list.size());
		return null;
	}

}
