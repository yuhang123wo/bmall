package cn.yh.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-04-11
 */
@TableName("role_auth")
@ApiModel(value="RoleAuth对象", description="")
public class RoleAuth extends Entity {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long authId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "RoleAuth{" +
        "roleId=" + roleId +
        ", authId=" + authId +
        "}";
    }
}
