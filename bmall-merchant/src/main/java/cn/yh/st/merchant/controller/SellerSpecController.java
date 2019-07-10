/**
 * 
 */
package cn.yh.st.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Spec;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.config.shiro.ShiroUser;
import cn.yh.st.fegin.service.ProductService;
import cn.yh.st.merchant.util.UserUtil;
import cn.yh.vo.product.AddAttrValueVo;
import cn.yh.vo.product.AddSpecVo;
import cn.yh.vo.product.QuerySpecVo;
import cn.yh.vo.product.UpdateStateVo;

/**
 * @author yuhang
 * @date 2019年7月3日
 * @desc
 */
@Controller
@RequestMapping("spec")
public class SellerSpecController {
	@Autowired
	private ProductService productService;

	@GetMapping("listView")
	public String productView() {
		return "product/spec-list";
	}

	@GetMapping("listData")
	@ResponseBody
	public ApiResponseEnity<Page<Spec>> listAttr(QuerySpecVo vo) {
		ShiroUser user = UserUtil.getUser();
		vo.setUserId(user.getId());
		return productService.listSpec(vo);
	}
}
