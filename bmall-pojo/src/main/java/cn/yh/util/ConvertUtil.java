package cn.yh.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author yuhang
 * @date 2019年3月29日
 * @desc po->vo
 */
public class ConvertUtil {

	private static Logger logger = LoggerFactory.getLogger(ConvertUtil.class);

	/**
	 * po->vo 单个对象转换
	 * 
	 * @param from
	 * @param clazz
	 * @return
	 */
	public static <PO, VO> VO convert(PO from, Class<VO> clazz) {
		if (from == null) {
			return null;
		}
		VO to = null;
		try {
			to = clazz.newInstance();
		} catch (Exception e) {
			logger.error("初始化{}对象失败。", clazz, e);
		}
		copyBean(from, to);
		return to;
	}

	/**
	 * poList-> voList 批量对象转换
	 */
	public <PO, VO> List<VO> convert(List<PO> fromList, Class<VO> clazz) {
		if (CollectionUtils.isEmpty(fromList)) {
			return null;
		}
		List<VO> toList = new ArrayList<VO>();
		for (PO from : fromList) {
			toList.add(convert(from, clazz));
		}
		return toList;
	}

	/**
	 * 属性拷贝方法，有特殊需求时子类覆写此方法
	 */
	private static <PO, VO> void copyBean(PO from, VO to) {
		BeanUtils.copyProperties(from, to);
	}
}
