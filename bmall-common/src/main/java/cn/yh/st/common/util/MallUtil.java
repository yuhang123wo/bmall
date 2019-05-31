/**
 * 
 */
package cn.yh.st.common.util;

/**
 * @author yuhang
 * @date 2019年5月30日
 * @desc
 */
public class MallUtil {

	public static boolean longGtZero(Long target) {

		if (null == target) {
			return false;
		}

		if (target.longValue() <= 0) {
			return false;
		}
		return true;
	}

}
