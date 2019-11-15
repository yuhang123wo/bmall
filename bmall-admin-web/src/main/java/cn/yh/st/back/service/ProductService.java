/**
 * 
 */
package cn.yh.st.back.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Attr;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.vo.BaseVO;
import cn.yh.vo.product.AddAttrVo;
import cn.yh.vo.product.QueryAttrVo;
import cn.yh.vo.product.UpdateStateVO;

/**
 * @author yuhang
 * @date 2019年5月21日
 * @desc
 */
@FeignClient(value = "service-product")
public interface ProductService {

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("attr/listAttr")
	public ApiResponseEnity<Page<Attr>> listAttr(@RequestBody QueryAttrVo vo);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("attr/getAttrById")
	public ApiResponseEnity<Attr> getAttrById(@RequestBody BaseVO vo);

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("attr/addAttrAndValue")
	public ApiResponseEnity<?> addAttrAndValue(@RequestBody AddAttrVo vo);

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("attr/updateAttrState")
	public ApiResponseEnity<?> updateAttrState(@RequestBody UpdateStateVO vo);
}
