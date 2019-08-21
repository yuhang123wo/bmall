/**
 * 
 */
package cn.yh.st.config;

import java.net.InetAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @author yuhang
 * @date 2019年8月1日
 * @desc
 */
@Configuration
public class ElasticConfigration {

	@Value("${elasticsearch.host}")
	private String esHost;

	@Value("${elasticsearch.port}")
	private int esPort;

	@Value("${elasticsearch.clusterName}")
	private String esClusterName;

	private TransportClient client;

	@PostConstruct
	public void initialize() throws Exception {
		Settings esSettings = Settings.builder().put("cluster.name", esClusterName).put("client.transport.sniff", true)
				.build();
		client = new PreBuiltTransportClient(esSettings);

		String[] esHosts = esHost.trim().split(",");
		for (String host : esHosts) {
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), esPort));
		}
	}

	@Bean
	public Client client() {
		return client;
	}

	@Bean
	public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client);
	}

	@PreDestroy
	public void destroy() {
		if (client != null) {
			client.close();
		}
	}

}
