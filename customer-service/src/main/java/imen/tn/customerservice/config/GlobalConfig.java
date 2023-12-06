package imen.tn.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@RefreshScope
//un bean immutable
public record GlobalConfig(int p1,int p2) {

}
