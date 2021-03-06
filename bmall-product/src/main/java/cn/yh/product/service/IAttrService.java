package cn.yh.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.product.Attr;
import cn.yh.st.common.api.CommonResult;
import cn.yh.vo.product.AddAttrVo;

/**
 * <p>
 * 属性 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-11-13
 */
public interface IAttrService extends IService<Attr> {

	/**
	 * 添加属性及值
	 * 
	 * @param vo
	 */
	CommonResult addAttrAndValues(AddAttrVo vo);
}
