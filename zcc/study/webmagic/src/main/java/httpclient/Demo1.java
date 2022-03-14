package httpclient;

import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class Demo1 {

    public static void main(String[] args) throws URISyntaxException {

        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建httget对象  设置访问uri

        //uri后不带参数
        //https://www.huya.com/11352915
        //HttpGet httpGet = new HttpGet("https://www.huya.com/11352915");

        //带参数
        //https://www.bilibili.com/video/BV1cE411u7RA?p=5
        URIBuilder uriBuilder = new URIBuilder("https://www.bilibili.com/video/BV1cE411u7RA");
        uriBuilder.addParameter("p","5");
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //使用httpclient执行请求  获取响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            //相应结果处理
            if (response.getStatusLine().getStatusCode() == 200){

                HttpEntity entity = response.getEntity();

                String content = EntityUtils.toString(entity);

                System.out.println(content);

            }else if (response.getStatusLine().getStatusCode() == 403){
                System.out.println("权限禁止");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
                httpClient.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
