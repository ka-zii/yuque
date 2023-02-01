package com.bkood.yuque;

import com.bkood.yuque.common.Config;

public class TestConfig {

    public static final String id = "";

    public static final String login  = "";


    public static Config getConfig() {
        return Config.builder()
                .token("YjEWbvQs2eDttl8MWpDPXN2KrQPuWTLYGCYWlRuq")
//                .userAgent("")
                .build();
    }
}
