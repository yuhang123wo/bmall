/**
 * 
 */
package cn.yh.st.back.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author yuhang
 * @date 2019年5月21日
 * @desc
 */
@FeignClient(value = "service-product")
public interface ProductService {
}
