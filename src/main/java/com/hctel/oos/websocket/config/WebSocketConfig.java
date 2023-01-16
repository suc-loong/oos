package com.hctel.oos.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
     * Description
	 * @Author wcloong 
	 * @Date 2023/1/10 9:40
	 * @Version 0.1.0
	 */

@Configuration
public class WebSocketConfig {

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {

		return new ServerEndpointExporter();
	}


}
