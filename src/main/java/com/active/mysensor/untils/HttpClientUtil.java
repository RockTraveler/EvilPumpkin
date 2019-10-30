package com.active.mysensor.untils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

   private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

   private static HttpClientContext context = HttpClientContext.create();




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





   public static void main(String[] args) {
      Map<String, String> map = new HashMap<>();
      map.put("text", "活跃网络C");
      map.put("desp", "这里也是中文");

      doPost("https://sc.ftqq.com/SCU48981T4fb6e368a395cf49b26f8bec99fe6cbf5cb93aed4ba36.send",map);

      JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
//      doPostJson("https://sc.ftqq.com/SCU48981T4fb6e368a395cf49b26f8bec99fe6cbf5cb93aed4ba36.send",JSON.toJSONString(map));
   }


}