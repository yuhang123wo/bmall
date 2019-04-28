package cn.yh.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.yh.pojo.user.MRole;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-04-11
 */
public interface MRoleMapper extends BaseMapper<MRole> {

	@Select("select mr.id,mr.role_name roleName,mr.remark,mr.state,mr.update_time updateTime,mr.create_time createTime from m_role mr,user_role ur where mr.id = ur.role_id and ur.user_id=#{userId}")
	List<MRole> getRolesByUserId(@Param("userId") long userId);
}
