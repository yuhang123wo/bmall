package cn.yh.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.yh.pojo.user.MAuth;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-04-11
 */
public interface MAuthMapper extends BaseMapper<MAuth> {

	@Select("select mr.id,mr.auth_name authName,mr.remark,mr.state,mr.update_time updateTime mr.p_id pId from m_auth mr,role_auth ur where mr.id = ur.auth_id and ur.role_id=#{roleId}")
	List<MAuth> getAuthsByRoleId(@Param("roleId") long roleId);
}
