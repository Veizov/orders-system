package com.notificationprovider.ordersconsumer.utils.appinfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.util.Objects;

@Slf4j
public class AppInfo {

    public static void logApplicationInfo(ConfigurableApplicationContext run) {
        ConfigurableEnvironment env = run.getEnvironment();

        String protocol = getProtocol(env);
        String hostAddress = getHostAddress();
        String applicationName = env.getProperty("spring.application.name");
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        String[] activeProfiles = env.getActiveProfiles();

        log.info("""
                        ----------------------------------------------------------
                        \tApplication '{}' is running! Access URLs:
                        \tLocal: \t\t{}://localhost:{}{}
                        \tExternal: \t{}://{}:{}{}
                        \tMemory: \t{}
                        \tProfile(s): \t{}
                        ----------------------------------------------------------""",
                applicationName,
                protocol,
                serverPort,
                Objects.isNull(contextPath) ? "" : contextPath,
                protocol,
                hostAddress,
                serverPort,
                Objects.isNull(contextPath) ? "" : contextPath,
                Memory.getInfo().toString(),
                activeProfiles
        );
    }

    private static String getHostAddress() {
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        return hostAddress;
    }

    private static String getProtocol(ConfigurableEnvironment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        return protocol;
    }

}
