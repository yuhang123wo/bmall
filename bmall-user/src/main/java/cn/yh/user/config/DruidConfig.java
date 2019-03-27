package cn.yh.user.config;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

	@Value("${connection.url}")
	private String connectionUrl;
	@Value("${connection.username}")
	private String username;
	@Value("${connection.password}")
	private String password;
	@Value("${druid.initialSize}")
	private Integer initialSize;
	@Value("${druid.minIdle}")
	private Integer minIdle;
	@Value("${druid.maxActive}")
	private Integer maxActive;
	@Value("${druid.maxWait}")
	private Integer maxWait;
	@Value("${druid.timeBetweenEvictionRunsMillis}")
	private Integer timeBetweenEvictionRunsMillis;
	@Value("${druid.minEvictableIdleTimeMillis}")
	private Integer minEvictableIdleTimeMillis;
	@Value("${druid.validationQuery}")
	private String validationQuery;
	@Value("${druid.testWhileIdle}")
	private Boolean testWhileIdle;
	@Value("${druid.testOnBorrow}")
	private Boolean testOnBorrow;
	@Value("${druid.testOnReturn}")
	private Boolean testOnReturn;
	@Value("${druid.poolPreparedStatements}")
	private Boolean poolPreparedStatements;
	@Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
	private Integer maxPoolPreparedStatementPerConnectionSize;
	@Value("${druid.filters}")
	private String filters;

	// 配置数据源
	@Bean(name = "basisDataSource", initMethod = "init", destroyMethod = "close")
	public DruidDataSource initDataSource() {
		logger.info("初始化DruidDataSource");
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dds.setUrl(connectionUrl);
		dds.setUsername(username);
		dds.setPassword(password);
		dds.setInitialSize(initialSize);
		dds.setMinIdle(minIdle);
		dds.setMaxActive(maxActive);
		dds.setMaxWait(maxWait);
		dds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dds.setValidationQuery(validationQuery);
		dds.setTestWhileIdle(testWhileIdle);
		dds.setTestOnBorrow(testOnBorrow);
		dds.setTestOnReturn(testOnReturn);
		dds.setPoolPreparedStatements(poolPreparedStatements);
		dds.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		try {
			dds.setFilters(filters);
		} catch (SQLException e) {
			logger.error("druidDataSource init...", e);
		}
		return dds;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
		reg.addInitParameter("loginUsername", "root");
		reg.addInitParameter("loginPassword", "123456");
		return reg;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.addInitParameter("profileEnable", "true");
		return filterRegistrationBean;
	}
}