/**
 * 
 */
package cn.yh.st.upload;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yuhang
 * @date 2019年6月18日
 * @desc
 */
@Controller
public class UpController {
	@ResponseBody
	@RequestMapping(value = "/BigFileUp")
	public String fileUpload(HttpServletRequest request, String guid, String md5value, String chunks, String chunk,
			String id, String name, String type, String lastModifiedDate, long size, MultipartFile file) {
				return lastModifiedDate;
//		String fileName;
//		JSONObject result = new JSONObject();
//		try {
//			int index;
//			String uploadFolderPath = "E:";
//			String mergePath = uploadFolderPath + "\\fileDate\\" + id + "\\";
////			String ext = name.substring(name.lastIndexOf("."));
////
////			// 判断文件是否分块
////			if (chunks != null && chunk != null) {
////				index = Integer.parseInt(chunk);
////				fileName = String.valueOf(index) + ext;
////				// 将文件分块保存到临时文件夹里，便于之后的合并文件
////				FileUtil.saveFile(mergePath, fileName, file, request);
////				// 验证所有分块是否上传成功，成功的话进行合并
////				FileUtil.Uploaded(md5value, guid, chunk, chunks, mergePath, fileName, ext, request);
////			} else {
////				SimpleDateFormat year = new SimpleDateFormat("yyyy");
////				SimpleDateFormat m = new SimpleDateFormat("MM");
////				SimpleDateFormat d = new SimpleDateFormat("dd");
////				Date date = new Date();
////				String destPath = uploadFolderPath + "\\fileDate\\" + "video" + "\\" + year.format(date) + "\\"
////						+ m.format(date) + "\\" + d.format(date) + "\\";// 文件路径
////				String newName = System.currentTimeMillis() + ext;// 文件新名称
////				// 上传文件没有分块的话就直接保存目标目录
////				FileUtil.saveFile(destPath, newName, file, request);
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			result.put("code", 0);
//			result.put("msg", "上传失败");
//			result.put("data", null);
//			return result.toString();
//		}
//		result.put("code", 1);
//		result.put("msg", "上传成功");
//		return result.toString();
	}
}
