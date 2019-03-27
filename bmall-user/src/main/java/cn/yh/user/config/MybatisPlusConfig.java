package cn.yh.user.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

@Configuration
@MapperScan("cn.yh.user.mapper")
public class MybatisPlusConfig {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${mybatis-plus.mapper-locations}")
	private String locations;

	@Value("${mybatis-plus.type-handlers-package}")
	private String handlersPackage;

	@Value("${mybatis-plus.type-aliases-package}")
	private String aliasesPackage;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "basisDataSource") DruidDataSource dataSource)
			throws Exception {
		logger.info("初始化SqlSessionFactory");
		MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
		MybatisConfiguration configuration = new MybatisConfiguration();
		configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		// *注册Map 下划线转驼峰*
		configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
		// 乐观锁插件
		configuration.addInterceptor(new OptimisticLockerInterceptor());
		// 分页插件
		configuration.addInterceptor(new PaginationInterceptor());
		configuration.setCacheEnabled(false);
		configuration.setMapUnderscoreToCamelCase(true);
		GlobalConfig globalConfig = new GlobalConfig();
		globalConfig.setDbConfig(new GlobalConfig.DbConfig());
		globalConfig.getDbConfig().setIdType(IdType.AUTO);
		sqlSessionFactory.setGlobalConfig(globalConfig);
		sqlSessionFactory.setConfiguration(configuration);
		sqlSessionFactory.setTypeEnumsPackage(handlersPackage);
		sqlSessionFactory.setTypeAliasesPackage(aliasesPackage);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(locations));
		sqlSessionFactory.setDataSource(dataSource);
		return sqlSessionFactory.getObject();
	}

	// TODO 这样添加过后会把mybatis-plus.mapper-locations 这些属性置空
	// @Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		logger.info("初始化MapperScannerConfigurer");
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		String basePackage = "cn.yh.user.mapper";
//		mapperScannerConfigurer.setBasePackage(basePackage);
//		return mapperScannerConfigurer;
//	}

	// 配置事务管理
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager(
			@Qualifier(value = "basisDataSource") DruidDataSource dataSource) {
		logger.info("初始化DataSourceTransactionManager");
		return new DataSourceTransactionManager(dataSource);
	}
}
