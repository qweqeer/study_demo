package com.java8.util;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2019/1/4
 * @Description:
 * @Modify :
 */
public class HttClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttClientUtil.class);

    // 浏览器Agent
    public static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.151 Safari/535.19";


    public static Object getRedictUrls(String requestUrl) {
        CloseableHttpClient httpClient = HttpClients.custom()
            .setUserAgent(USER_AGENT)
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)
                    .build())
            .build();
        List <URI> redirectLocations = null;
        CloseableHttpResponse response = null;
        try {
            HttpClientContext context = HttpClientContext.create();
            HttpGet httpGet = new HttpGet(requestUrl);
            response = httpClient.execute(httpGet, context);
            // 获取所有的重定向位置
            redirectLocations = context.getRedirectLocations();
        }catch (Exception e){
            LOGGER.error("get redirect url happend a error",e);
        }finally {
            if (response != null) {
                try{
                    response.close();
                }catch (IOException e){
                    LOGGER.error("close httpClient 数据流发生异常");
                }

            }
        }
        return redirectLocations;
    }

}
