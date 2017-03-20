/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chinamobile.iot.lightapp.mysql.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.transaction.PlatformTransactionManager;
import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * @author jitendra on 3/3/16.
 */
@EnableRedisHttpSession
public class SessionConfig {

    private static RedisServer redisServer;

    @Bean
    public JedisConnectionFactory connectionFactory() throws IOException {
        redisServer = new RedisServer(Protocol.DEFAULT_PORT);
        redisServer.start();
        return new JedisConnectionFactory();
    }

    @PreDestroy
    public void destroy() {
        redisServer.stop();
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        HeaderHttpSessionStrategy headerHttpSessionStrategy = new HeaderHttpSessionStrategy();
        headerHttpSessionStrategy.setHeaderName(Constant.SESSION_NAME);
        return headerHttpSessionStrategy;
    }
}
