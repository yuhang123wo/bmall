package cn.yh.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, MybatisPlusAutoConfiguration.class })
@EnableDiscoveryClient
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
