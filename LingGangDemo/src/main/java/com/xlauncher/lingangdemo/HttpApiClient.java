package com.xlauncher.lingangdemo;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;

/**
 * AliyunApi
 *
 * @author Vic
 * @date 2019/5/29
 */
public class HttpApiClient  extends ApacheHttpClient {

    /**
     * 初始化请求参数
     * @param isHttps 是否为https请求
     * @param host
     * @param appKey
     * @param appSecret
     */
    public HttpApiClient(boolean isHttps, String host, String appKey, String appSecret){
        // HTTP/HTTPS Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setHost(host);
        httpParam.setAppKey(appKey);
        httpParam.setAppSecret(appSecret);
        if(isHttps){
            initHttpsClient(httpParam);
        } else {
            initHttpClient(httpParam);
        }
        super.init(httpParam);
    }

    /**
     * 初始化HTTP请求参数
     * @param httpParam
     */
    private void initHttpClient(HttpClientBuilderParams httpParam){
        httpParam.setScheme(Scheme.HTTP);
    }



}
