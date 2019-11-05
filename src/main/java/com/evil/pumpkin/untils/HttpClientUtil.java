package com.evil.pumpkin.untils;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

   private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

   private static HttpClientContext context = HttpClientContext.create();

   public static HttpResponse get(String url) throws ClientProtocolException, IOException {


      Request request = Request.Get(url);
      HttpResponse response = request.execute().returnResponse();


      return response;
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
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      return resultString;
   }





   public static void main(String[] args) throws Exception {

   }


}