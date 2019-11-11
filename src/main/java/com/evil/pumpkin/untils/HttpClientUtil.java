package com.evil.pumpkin.untils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

   private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

   private static HttpClientContext context = HttpClientContext.create();

   private static PoolingHttpClientConnectionManager pool;

   private static RequestConfig requestConfig;

   public static final String CHARSET_UTF_8 = "utf-8";



   public static HttpResponse get(String url) {

      try {
         Request request = Request.Get(url);
         log.info("BEGIN =Try to exeute the http request");
         HttpResponse response = request.execute().returnResponse();
         log.info("END = Try to exeute the http request");
         return response;
      }catch (Exception e){
         e.printStackTrace();
      }
      return null;
   }

   public static String doGet(String url) {

      CloseableHttpClient httpclient = HttpClients.createDefault();

      String resultString = "";
      CloseableHttpResponse response = null;
      try {
         URIBuilder builder = new URIBuilder(url);
         URI uri = builder.build();

         HttpGet httpGet = new HttpGet(uri);

         try {
            response = httpclient.execute(httpGet);
         } catch (Exception e) {
            log.warn("【GET请求失败】,请求地址：{}", url);
            e.printStackTrace();
         }
         if (response.getStatusLine().getStatusCode() == 200) {
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (response != null) {
               response.close();
            }
            httpclient.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      return resultString;
   }



   public static String doPost(String url, Map<String, String> param) {
      CloseableHttpClient httpClient = HttpClients.createDefault();
      CloseableHttpResponse response = null;
      String resultString = "";
      try {
         HttpPost httpPost = new HttpPost(url);
         if (param != null) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : param.keySet()) {
               paramList.add(new BasicNameValuePair(key, param.get(key)));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
            httpPost.setEntity(entity);
         }
         response = httpClient.execute(httpPost);
         resultString = EntityUtils.toString(response.getEntity(), "utf-8");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            response.close();
            httpClient.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      return resultString;
   }

   public static String sendHttpGet(String httpUrl) {
      HttpGet httpGet = new HttpGet(httpUrl);
      return sendHttpGet(httpGet);
   }

   private static String sendHttpGet(HttpGet httpGet) {

      CloseableHttpClient httpClient = null;
      CloseableHttpResponse response = null;
      String responseContent = null;
      try {
         httpClient = getHttpClient();
         httpGet.setConfig(requestConfig);
         response = httpClient.execute(httpGet);
         HttpEntity entity = response.getEntity();

         if (response.getStatusLine().getStatusCode() >= 300) {
            throw new Exception(
                    "HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode());
         }

         if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
            responseContent = EntityUtils.toString(entity, CHARSET_UTF_8);
            EntityUtils.consume(entity);
         }

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (response != null) {
               response.close();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      return responseContent;
   }

   public static CloseableHttpClient getHttpClient() {

      CloseableHttpClient httpClient = HttpClients.custom()
              .setConnectionManager(pool)
              .setDefaultRequestConfig(requestConfig)
              .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
              .build();

      return httpClient;
   }


   public static void main(String[] args) throws Exception {
      System.out.println(sendHttpGet("http://checkip.amazonaws.com/"));
   }


}