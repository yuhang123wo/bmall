/**
 * 
 */
package cn.yh.st.common.util;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author yuhang
 * @date 2019年8月22日
 * @desc
 */
public class MapUtil {
	public static <T> T map2JavaBean(Map<String, Object> map, Class<T> clazz) throws Exception {
		T javabean = clazz.newInstance(); // 构建对象
		Method[] methods = clazz.getMethods(); // 获取所有方法
		for (Method method : methods) {
			if (method.getName().startsWith("set")) {
				String field = method.getName(); // 截取属性名
				field = field.substring(field.indexOf("set") + 3);
				field = field.toLowerCase().charAt(0) + field.substring(1);
				if (map.containsKey(field)) {
					try {
						method.invoke(javabean, map.get(field));
					} catch (Exception e) {

						System.out.println(map.get(field) + ":" + field);
						e.printStackTrace();
					}

				}
			}
		}
		return javabean;
	}
	
	
	
	
}
