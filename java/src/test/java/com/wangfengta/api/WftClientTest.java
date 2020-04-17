package com.wangfengta.api;

import com.wangfengta.api.exception.ApiException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WftClientTest {

    @Test
    public void alarmTest() throws ApiException {
        Map<String,String> param=new HashMap<String,String>();
        param.put("fail_count","1");
        WftClient client=WftClient.init("6487b2bd-6755-4ebc-afef-dce5e985a36c");
        client.alarm("446371538111025152","447494413647859712",param);
    }

}
