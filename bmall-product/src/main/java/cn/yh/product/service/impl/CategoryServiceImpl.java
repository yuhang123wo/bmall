package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.CateBrand;
import cn.yh.pojo.product.Category;
import cn.yh.product.config.ProductConstant;
import cn.yh.product.mapper.CateBrandMapper;
import cn.yh.product.mapper.CategoryMapper;
import cn.yh.product.service.ICateBrandService;
import cn.yh.product.service.ICategoryService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.st.common.util.MallUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

	@Autowired
	private ICateBrandService cateBrandService;

	@Transactional
	@Override
	public void processAddCategory(Category vo) {
		if (MallUtil.longGtZero(vo.getpId())) {
			Category category = this.getById(vo.getpId());
			if (category == null) {
				throw new DefaultException("错误的父分类");
			}
			if (category.getLevel() >= ProductConstant.MAX_LIMIT_CATEGORY_LEVEL) {
				throw new DefaultException("分类最多三级");
			}
			vo.setLevel(category.getLevel() + 1);
		} else {
			// 没有父ID则为第一级
			vo.setLevel(1);
		}
		vo.setUpdateTime(new Date());
		vo.setCreateTime(new Date());
		boolean flag = this.save(vo);
		if (!flag) {
			throw new DefaultException("添加失败");
		}
		if (!CollectionUtils.isEmpty(vo.getBrand())) {
			List<CateBrand> list = new ArrayList<CateBrand>();
			for (int i = 0; i < vo.getBrand().size(); i++) {
				CateBrand cb = new CateBrand();
				cb.setBrandId(vo.getBrand().get(i));
				cb.setCategoryId(vo.getId());
				list.add(cb);
			}
			cateBrandService.saveBatch(list, list.size());
			
		}
	}

}
