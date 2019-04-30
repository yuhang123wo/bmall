/**
 * 
 */
package cn.yh.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.eumn.State;
import cn.yh.pojo.user.MAuth;
import cn.yh.user.service.IAuthService;
import cn.yh.user.util.TreeNodeUtil;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.user.MAuthNodes;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
@RestController("auth")
public class AuthController {

	@Autowired
	private IAuthService authService;

	/**
	 * 取所有权限，并组装成treeNodes
	 * 
	 * @return
	 */
	@PostMapping("getAllAuth")
	public List<MAuthNodes> getAllAuth() {
		List<MAuth> list = authService.list(new QueryWrapper<MAuth>().eq("state", State.ENABLE));
		List<MAuthNodes> result = ConvertUtil.convert(list, MAuthNodes.class);
		return TreeNodeUtil.getZnodes(result);
	}
	
	
	
}
