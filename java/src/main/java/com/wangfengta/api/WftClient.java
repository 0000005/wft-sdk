package com.wangfengta.api;


import com.wangfengta.api.exception.ApiException;
import com.wangfengta.api.model.Result;
import com.wangfengta.api.util.JsonUtil;
import com.wangfengta.api.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class WftClient {
    private static final String API_HOST="http://api.wangfengta.com";
//    private static final String API_HOST="http://127.0.0.1:8080";
    private static String SECRET_KEY;
    private static WftClient wftClient;
    private WftClient(){ }
    public static WftClient init(String secret){
        WftClient.SECRET_KEY =secret;
        if(wftClient==null)
        {
            wftClient = new WftClient();
        }
        return wftClient;
    }

    /**
     * 发送告警信息
     * @param appId 应用id
     * @param templateId 模版id
     * @param params 变量，可替换模版中标题和详情的内容
     */
    public Result alarm(String appId, String templateId, Map<String,String> params) throws ApiException {
        String path="/api/alarm";
        try
        {
            Map<String,String> alertParams = new HashMap<String, String>(20);
            alertParams.put("secretKey",SECRET_KEY);
            alertParams.put("appCode",appId);
            alertParams.put("templateCode",templateId);
            if(params!=null&&!params.isEmpty())
            {
                alertParams.put("params",JsonUtil.toJson(params));
            }
            String resultStr=HttpUtil.postForm(API_HOST+path,alertParams);
            Result alarmResult=JsonUtil.fromJson(resultStr,Result.class);
            return alarmResult;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ApiException("send alarm fail!"+e.getMessage());
        }
    }

    /**
     * 发送告警信息
     * @param appId 应用id
     * @param templateId 模版id
     */
    public void alarm(String appId,String templateId) throws ApiException {
        this.alarm(appId,templateId,new HashMap<String, String>(10));
    }
}
