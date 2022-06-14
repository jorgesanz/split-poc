package io.split.tutorial.config;

import io.split.client.SplitClient;
import io.split.client.SplitClientConfig;
import io.split.client.SplitFactory;
import io.split.client.SplitFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeoutException;

@Configuration
public class SplitConfig {


    public static final String KEY_STAGE = "25kuhesp7oj926tu6dafq9egoq6kctir4vp4";

    public static final String KEY_PROD = "4t1vv7kgf60ehqooddmsea74hkaodp1mp1eu";


    @Bean(name = "stage")
    public SplitClient getStageSplitClient() throws InterruptedException, TimeoutException, IOException, URISyntaxException {

        SplitFactory splitFactory = getSplitFactory(KEY_STAGE);
        SplitClient client = splitFactory.client();
        client.blockUntilReady();
        return client;
    }

    @Bean(name = "pro")
    public SplitClient getProSplitClient() throws InterruptedException, TimeoutException, IOException, URISyntaxException {

        SplitFactory splitFactory = getSplitFactory(KEY_PROD);
        SplitClient client = splitFactory.client();
        client.blockUntilReady();
        return client;
    }

    public static SplitFactory getSplitFactory(String key) throws IOException, URISyntaxException {
        SplitClientConfig config = SplitClientConfig.builder()
                .setBlockUntilReadyTimeout(10000)
                .build();

        SplitFactory splitFactory = SplitFactoryBuilder.build(key, config);

        return splitFactory;
    }

}
