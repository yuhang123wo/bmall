/**
 * 
 */
package cn.yh.product.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Props;
import cn.yh.product.service.IPropsService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.QueryAttrVo;

/**
 * @author yuhang
 * @date 2019年6月13日
 * @desc
 */
@RestController
@RequestMapping("props")
public class PropsController {

	@Autowired
	private IPropsService propsService;

	@GetMapping("listProps")
	public ApiResponseEnity<Page<Props>> listProps(QueryAttrVo vo) {
		QueryWrapper<Props> queryWrapper = SearchToQuery.getQuery(vo);
		Page<Props> page = new Page<Props>(vo.getPageNo(), vo.getPageSize());
		IPage<Props> attrList = propsService.page(page, queryWrapper);
		return new ApiResponseEnity<Page<Props>>((Page<Props>) attrList);
	}

	/**
	 * 
	 * @param props
	 * @return
	 */
	@PostMapping("addProps")
	public ApiResponseEnity<?> adddProps(Props props) {
		props.setCreateTime(new Date());
		props.setUpdateTime(props.getCreateTime());
		boolean flag = propsService.save(props);
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("新增失败");
	}

	/**
	 * 
	 * @param props
	 * @return
	 */
	@PostMapping("updateProps")
	public ApiResponseEnity<?> updateProps(Props props) {
		Props p = propsService.getById(props.getId());
		if (p == null) {
			return new ApiResponseEnity<>().fail("参数不存在");
		}
		p.setCategoryId(props.getCategoryId());
		p.setData(props.getData());
		p.setUpdateTime(new Date());
		boolean flag = propsService.updateById(p);
		if (flag) {
			return new ApiResponseEnity<>();
		}
		return new ApiResponseEnity<>().fail("修改失败");
	}
}
