/**
 * 
 */
package cn.yh.st.upload;

/**
 * @author yuhang
 * @date   2019年6月18日 
 * @desc   
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static void saveFile(String savePath, String fileFullName, MultipartFile file) throws Exception {
		File fileDirectory = new File(savePath);
		if (!fileDirectory.exists()) {
			if (!fileDirectory.mkdirs()) {
				throw new Exception("文件夹创建失败！路径为：" + savePath);
			}
		}
		File destFile = new File(savePath + fileFullName);
		file.transferTo(destFile);
	}

	private static byte[] readInputStream(InputStream inStream) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		// 每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len;
		// 使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		// 关闭输入流
		inStream.close();
		// 把outStream里的数据写入内存
		return outStream.toByteArray();
	}

}