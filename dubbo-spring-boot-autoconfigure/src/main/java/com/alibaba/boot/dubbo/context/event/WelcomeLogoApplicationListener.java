/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.boot.dubbo.context.event;

import com.alibaba.dubbo.common.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

import static com.alibaba.boot.dubbo.util.DubboUtils.*;
import static com.alibaba.dubbo.qos.server.DubboLogo.dubbo;

/**
 * Dubbo Welcome Logo {@link ApplicationListener}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 1.0.0
 */
@Order(LoggingApplicationListener.DEFAULT_ORDER + 1)
public class WelcomeLogoApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        /**
         * Gets Logger After LoggingSystem configuration ready
         * @see LoggingApplicationListener
         */
        final Logger logger = LoggerFactory.getLogger(getClass());

        String bannerText = buildBannerText();

        if (logger.isInfoEnabled()) {
            logger.info(bannerText);
        } else {
            System.out.print(bannerText);
        }

    }


    String buildBannerText() {

        StringBuilder bannerTextBuilder = new StringBuilder();

        bannerTextBuilder
                .append(LINE_SEPARATOR)
                .append(LINE_SEPARATOR)
                .append(dubbo)
                .append(" :: Dubbo Spring Boot (v").append(Version.getVersion(getClass(), "1.0.0")).append(") : ")
                .append(DUBBO_SPRING_BOOT_GITHUB_URL)
                .append(LINE_SEPARATOR)
                .append(" :: Dubbo (v").append(Version.getVersion()).append(") : ")
                .append(DUBBO_GITHUB_URL)
                .append(LINE_SEPARATOR)
                .append(" :: Google group : ")
                .append(DUBBO_GOOGLE_GROUP_URL)
                .append(LINE_SEPARATOR)
        ;

        return bannerTextBuilder.toString();

    }

}
