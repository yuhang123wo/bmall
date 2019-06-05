/**
 * 
 */
package cn.yh.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.ProductAttr;
import cn.yh.pojo.product.ProductAttrValue;
import cn.yh.product.service.IProductAttrService;
import cn.yh.product.service.IProductAttrValueService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.BasePage;
import cn.yh.vo.product.ProductAttrVo;

/**
 * @author yuhang
 * @date 2019年5月30日
 * @desc
 */
@RestController
@RequestMapping("attr")
public class AttrController {

	@Autowired
	private IProductAttrService productAttrService;
	@Autowired
	private IProductAttrValueService productAttrValueService;

	@GetMapping("listAttr")
	public ApiResponseEnity<Page<ProductAttr>> listAttr(BasePage vo) {
		Page<ProductAttr> page = new Page<ProductAttr>(vo.getPageNo(), vo.getPageSize());
		Page<ProductAttr> list = (Page<ProductAttr>) productAttrService.page(page);
		return new ApiResponseEnity<Page<ProductAttr>>(list);
	}

	@GetMapping("listAttrValue")
	public ApiResponseEnity<List<ProductAttrValue>> listAttrValue(Long attrId) {
		return new ApiResponseEnity<List<ProductAttrValue>>(
				productAttrValueService.list(new QueryWrapper<ProductAttrValue>().eq("attr_id", attrId)));
	}

	@PostMapping("updateAttrValueState")
	public ApiResponseEnity<Boolean> updateAttrValueState(Long id, State state) {
		ProductAttrValue attr = productAttrValueService.getById(id);
		if (attr == null) {
			return new ApiResponseEnity<Boolean>().fail("属性值不存在");
		}

		attr.setState(state);
		boolean flag = productAttrValueService.updateById(attr);
		if (flag)
			return new ApiResponseEnity<Boolean>();
		return new ApiResponseEnity<Boolean>().fail("修改失败");
	}

	@PostMapping("updateAttrState")
	public ApiResponseEnity<Boolean> updateAttrState(Long id, State state) {
		ProductAttr attr = productAttrService.getById(id);
		if (attr == null) {
			return new ApiResponseEnity<Boolean>().fail("属性不存在");
		}

		attr.setState(state);
		boolean flag = productAttrService.updateById(attr);
		if (flag)
			return new ApiResponseEnity<Boolean>();
		return new ApiResponseEnity<Boolean>().fail("修改失败");
	}

	@PostMapping("addAttr")
	public ApiResponseEnity<Boolean> addAttr(@RequestBody ProductAttr attr) {
		productAttrService.save(attr);

		return new ApiResponseEnity<Boolean>();

	}

	@PostMapping("addAttrValue")
	public ApiResponseEnity<Boolean> addAttrValue(@RequestBody ProductAttrValue attrValue) {
		
		
		productAttrValueService.save(attrValue);

		return new ApiResponseEnity<Boolean>();

	}
	@GetMapping("listAttrByCategory")
	public ApiResponseEnity<List<ProductAttrVo>> listAttrByCategory(Long categoryId) {
		List<ProductAttr> list = productAttrService.list(new QueryWrapper<ProductAttr>().eq("category_id", categoryId));
		List<ProductAttrVo> result = ConvertUtil.convert(list, ProductAttrVo.class);
		if(result==null) {
			return new ApiResponseEnity<List<ProductAttrVo>>(new ArrayList<ProductAttrVo>());
		}
		for (int i = 0; i < result.size(); i++) {
			ProductAttrVo p = result.get(i);
			p.setList(productAttrValueService.list(new QueryWrapper<ProductAttrValue>().eq("attr_id", p.getId())));
		}
		return new ApiResponseEnity<List<ProductAttrVo>>(result);
	}

}
