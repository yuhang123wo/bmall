/**
 * 
 */
package cn.yh.st.merchant.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.merchant.util.GetFolderUtil;
import cn.yh.st.upload.FileUtil;

/**
 * @author yuhang
 * @date 2019年7月12日
 * @desc
 */
@RestController
@RequestMapping("upload")
public class UploadController {

	@Value("${web.upload-path}")
	private String baseUploadPath;

	@ResponseBody
	@RequestMapping(value = "/fileUpload")
	public ApiResponseEnity<?> fileUpload(HttpServletRequest request, String name, MultipartFile file)
			throws Exception {
		// 日期文件夹
		String destPath = GetFolderUtil.getName();
		// 后缀
		String ext = name.substring(name.lastIndexOf("."));
		// 文件名
		String fileName = UUID.randomUUID().toString() + ext;
		FileUtil.saveFile(baseUploadPath + destPath, fileName, file);
		return new ApiResponseEnity<>(destPath + fileName);
	}

	@ResponseBody
	@RequestMapping("/uploadImg")
	public JSONObject uploadImg(@RequestParam("uploadFile") MultipartFile multipartFile) throws Exception {
		// 日期文件夹
		String destPath = GetFolderUtil.getName();
		// 后缀
		String ext = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		// 文件名
		String fileName = UUID.randomUUID().toString() + ext;
		FileUtil.saveFile(baseUploadPath + destPath, fileName, multipartFile);
		JSONObject jsonObject = new JSONObject();
		// 这里必须是小数类型，
		jsonObject.put("error", 0);
		jsonObject.put("url",destPath + fileName);
		return jsonObject;
	}

}
