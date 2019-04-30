/**
 * 
 */
package cn.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.yh.pojo.user.MRole;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.user.UserApplication;
import cn.yh.user.service.IMRoleService;
import cn.yh.vo.user.RoleVo;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class MyTest {

	@Autowired
	private IMRoleService mRoleService;

	@Test
	public void testFind() {

		RoleVo vo = new RoleVo();
		vo.setRoleName("sssss");
		vo.setState(1);
		QueryWrapper<MRole> queryWrapper = SearchToQuery.getQuery(vo);

		List<MRole> list = mRoleService.list(queryWrapper);
	}
}