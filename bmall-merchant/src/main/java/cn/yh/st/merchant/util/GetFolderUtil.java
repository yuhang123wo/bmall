/**
 * 
 */
package cn.yh.st.merchant.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author yuhang
 * @date 2019年7月12日
 * @desc
 */
public class GetFolderUtil {

	public static String getName() {
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat m = new SimpleDateFormat("MM");
		SimpleDateFormat d = new SimpleDateFormat("dd");
		Date date = new Date();
		String destPath = "\\" + year.format(date) + "\\" + m.format(date) + "\\" + d.format(date) + "\\";
		return destPath;
	}
}
