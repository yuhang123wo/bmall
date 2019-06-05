package cn.yh.pojo.product;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.yh.pojo.eumn.State;
import cn.yh.st.common.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
@TableName("product_attr")
@ApiModel(value = "ProductAttr对象", description = "")
public class ProductAttr extends Entity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品类别编号")
	private Integer categoryId;

	@ApiModelProperty(value = "属性名称")
	private String name;

	@ApiModelProperty(value = "排列次序")
	private Integer sort;

	@ApiModelProperty(value = "自定义标识（0：否，1：是）")
	private Integer customTag;

	private Date createTime;

	private Long createUser;

	private State state;

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getCustomTag() {
		return customTag;
	}

	public void setCustomTag(Integer customTag) {
		this.customTag = customTag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

}
