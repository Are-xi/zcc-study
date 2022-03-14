package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient httpclient = HttpClients.createDefault();


        HttpPost httpPost = new HttpPost("https://www.huya.com/11352915");

        //带参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("p","5"));
        //创建表单对象 把参数放进去
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs,"utf-8");
        //把表单放进post请求中
        httpPost.setEntity(urlEncodedFormEntity);

        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == 200){
                System.out.println("抓取成功");
                HttpEntity entity = response.getEntity();

                String content = EntityUtils.toString(entity);

                System.out.println(content);

            }else if (response.getStatusLine().getStatusCode() == 403){
                System.out.println("权限不足");
            }

            response.close();
            httpclient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
