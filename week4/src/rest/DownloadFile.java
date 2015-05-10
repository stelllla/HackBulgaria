package rest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DownloadFile {
    
    public static void downloadFileUsingURL ( String url, String filePath) throws ClientProtocolException, IOException {
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        
       
      
        HttpUriRequest request =  new HttpGet(url);
        HttpResponse response = httpclient.execute(request);
        
        HttpEntity entity = response.getEntity();
        
        if (entity != null) {
            long len = entity.getContentLength();
            InputStream input = entity.getContent();
            
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            int inByte;
            while((inByte = input.read()) != -1) {
                fos.write(inByte);
            }
            input.close();
            fos.close();
            
        }
}
    
    public static void main(String[] args) throws ClientProtocolException, IOException {
       downloadFileUsingURL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg",
                            "C:\\Users\\Stella\\Documents\\omg.jpg");
    }
}
