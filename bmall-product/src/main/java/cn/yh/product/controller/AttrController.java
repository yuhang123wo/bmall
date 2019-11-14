/**
 * 
 */
package cn.yh.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Attr;
import cn.yh.product.base.BaseController;
import cn.yh.product.service.IAttrService;
import cn.yh.product.vo.BaseVO;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.api.CommonResult;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.AddAttrVo;
import cn.yh.vo.product.QueryAttrVo;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
@RestController
@RequestMapping("attr")
public class AttrController extends BaseController {

	@Autowired
	private IAttrService attrService;

	/**
	 * 按条件查询属性列表
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listAttr")
	public ApiResponseEnity<Page<Attr>> listAttr(@RequestBody QueryAttrVo vo) {
		QueryWrapper<Attr> queryWrapper = SearchToQuery.getQuery(vo);
		Page<Attr> page = new Page<Attr>(vo.getPageNo(), vo.getPageSize());
		IPage<Attr> attrList = attrService.page(page, queryWrapper);
		return new ApiResponseEnity<Page<Attr>>((Page<Attr>) attrList);
	}

	/**
	 * 根据ID获取
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("getAttrById")
	public ApiResponseEnity<Attr> getAttrById(@Validated BaseVO vo) {
		return new ApiResponseEnity<Attr>(attrService.getById(vo.getId()));
	}

	/**
	 * 属性添加及值
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addAttrAndValue")
	public ApiResponseEnity<?> addAttrAndValue(@Validated @RequestBody AddAttrVo vo) {
		CommonResult result = attrService.addAttrAndValues(vo);
		return getReturnData(result);
	}

}
