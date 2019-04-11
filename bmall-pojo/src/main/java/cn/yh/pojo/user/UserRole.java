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
@TableName("user_role")
@ApiModel(value="UserRole对象", description="")
public class UserRole extends Entity {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
