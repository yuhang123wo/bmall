package cn.yh.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.product.Attr;
import cn.yh.vo.product.AddAttrVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
public interface IAttrService extends IService<Attr> {
	/**
	 * 添加属性
	 * 
	 * @param vo
	 */
	void addAttrValue(AddAttrVo vo);
}
