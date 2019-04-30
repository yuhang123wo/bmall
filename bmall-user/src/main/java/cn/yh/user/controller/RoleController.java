/**
 * 
 */
package cn.yh.user.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.user.MRole;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.user.service.IMRoleService;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.user.AddRoleVo;
import cn.yh.vo.user.RoleVo;

/**
 * @author yuhang
 * @date 2019年4月29日
 * @desc
 */
@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private IMRoleService mRoleService;

	/**
	 * 按条件搜索所有角色
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listRole")
	public List<MRole> listRole(@RequestBody @Validated RoleVo vo) {
		QueryWrapper<MRole> queryWrapper = SearchToQuery.getQuery(vo);
		queryWrapper.orderByDesc("id");
		return mRoleService.list(queryWrapper);
	}

	/**
	 * 添加用户角色
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addRole")
	public ApiResponseEnity<Boolean> addRole(@Validated AddRoleVo vo) {
		MRole m = ConvertUtil.convert(vo, MRole.class);
		m.setCreateTime(new Date());
		m.setUpdateTime(m.getCreateTime());

		QueryWrapper<MRole> queryWrapper = SearchToQuery.getQuery(vo);
		MRole v = mRoleService.getOne(queryWrapper);
		if (v != null) {
			return new ApiResponseEnity<Boolean>().fail("角色名存在");
		}
		boolean flag = mRoleService.save(m);
		if (flag) {
			return new ApiResponseEnity<Boolean>();
		}
		return new ApiResponseEnity<Boolean>().fail("添加失败");
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("updateRole")
	public ApiResponseEnity<Boolean> updateRole(@Validated MRole vo) {
		MRole m = mRoleService.getById(vo.getId());
		if (m == null) {
			return new ApiResponseEnity<Boolean>().fail("角色不存在");
		}
		if (StringUtils.isNotBlank(vo.getRemark())) {
			m.setRemark(vo.getRemark());
		}

		if (vo.getState() != null) {
			m.setState(vo.getState());
		}

		boolean flag = mRoleService.updateById(m);
		if (flag) {
			return new ApiResponseEnity<Boolean>();
		}
		return new ApiResponseEnity<Boolean>().fail("修改失败");
	}

}
