/**
 * 
 */
package cn.yh.st.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.st.common.annotation.SearchFieldAnnotation;
import cn.yh.st.common.annotation.SearchType;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
public class SearchToQuery {

	/**
	 * 构造查询条件
	 * 
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> QueryWrapper<T> getQuery(Object vo) {
		QueryWrapper<T> query = new QueryWrapper<T>();
		Field[] fields = vo.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			boolean flag = f.isAnnotationPresent(SearchFieldAnnotation.class);
			if (!flag) {
				continue;
			}
			Object obj = getFieldValue(f, vo);
			if (obj != null) {
				SearchFieldAnnotation sf = f.getAnnotation(SearchFieldAnnotation.class);
				String cloumnName = sf.column();
				SearchType type = sf.type();
				if (type == SearchType.eq) {
					query.eq(cloumnName, obj);
				}
				if (type == SearchType.ne) {
					query.ne(cloumnName, obj);
				}
				if (type == SearchType.gt) {
					query.gt(cloumnName, obj);
				}
				if (type == SearchType.ge) {
					query.ge(cloumnName, obj);
				}
				if (type == SearchType.lt) {
					query.lt(cloumnName, obj);
				}
				if (type == SearchType.le) {
					query.le(cloumnName, obj);
				}
				if (type == SearchType.like) {
					query.like(cloumnName, obj);
				}
				if (type == SearchType.likeLeft) {
					query.likeLeft(cloumnName, obj);
				}
				if (type == SearchType.likeRight) {
					query.likeRight(cloumnName, obj);
				}
				if (type == SearchType.in) {
					query.in(cloumnName, obj);
				}

			}

		}
		return query;
	}

	private static Object getFieldValue(Field f, Object vo) {
		try {
			// 设置可以访问私有变量
			f.setAccessible(true);
			return f.get(vo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
