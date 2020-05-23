package com.practice.basic.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.File;

/**
 * @author : kai.dai
 * @date : 2020-05-23 10:08
 */
public class RedissonTest {
    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:7181");

// or read config from file
        config = Config.fromYAML(new File("config-file.yaml"));

        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("myLock");
        lock.lock();

    }
}
