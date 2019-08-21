/**
 * 
 */
package cn.yh.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yuhang
 * @date 2019年4月15日
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class SearchApplication{

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}
}
