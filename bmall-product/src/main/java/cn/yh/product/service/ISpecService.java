package cn.yh.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.pojo.product.Spec;
import cn.yh.vo.product.AddSpecVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
public interface ISpecService extends IService<Spec> {
	/**
	 * 
	 * @param vo
	 */
	void addSpecValue(AddSpecVo vo);
}
