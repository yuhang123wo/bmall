package cn.yh.product.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.yh.dto.AttrValueDto;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.AttrValue;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
public interface IAttrValueService extends IService<AttrValue> {

	List<AttrValueDto> listAttrValueDto(String[] attrIds, State state);
}
