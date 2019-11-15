/**
 * 
 */
package cn.yh.st.back.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.yh.st.common.api.ApiResponseEnity;

/**
 * @author yuhang
 * @date 2019年5月27日
 * @desc
 */
@RestController
@RequestMapping("upload")
public class UploadController {

	@PostMapping("uploadFile")
	public ApiResponseEnity<String> uploadFile(@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		String path = "E:/" + new Date().getTime() + file.getOriginalFilename();
		File newFile = new File(path);
		// 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
		file.transferTo(newFile);
		return new ApiResponseEnity<String>(path);
	}

}
