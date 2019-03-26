package cn.yh.st.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.yh.st.pojo.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-03-26
 */
@TableName("user_meta")
@ApiModel(value="UserMeta对象", description="")
public class UserMeta extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别(0:未知,1:男,2:女)")
    private Integer sex;

    @ApiModelProperty(value = "省ID")
    private Integer provinceId;

    @ApiModelProperty(value = "省")
    private String provinceName;

    @ApiModelProperty(value = "市ID")
    private Integer cityId;

    @ApiModelProperty(value = "市")
    private String cityName;

    @ApiModelProperty(value = "区ID")
    private Integer countryId;

    @ApiModelProperty(value = "区")
    private String countryName;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "积分")
    private Integer score;

    @ApiModelProperty(value = "证件类型(1:身份证，2:军官证)")
    private Boolean idType;

    @ApiModelProperty(value = "证件号码")
    private String idNo;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    public Boolean getIdType() {
        return idType;
    }

    public void setIdType(Boolean idType) {
        this.idType = idType;
    }
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Override
    public String toString() {
        return "UserMeta{" +
        "nickName=" + nickName +
        ", sex=" + sex +
        ", provinceId=" + provinceId +
        ", provinceName=" + provinceName +
        ", cityId=" + cityId +
        ", cityName=" + cityName +
        ", countryId=" + countryId +
        ", countryName=" + countryName +
        ", address=" + address +
        ", score=" + score +
        ", idType=" + idType +
        ", idNo=" + idNo +
        "}";
    }
}
