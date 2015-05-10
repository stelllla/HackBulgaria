package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PrintPeople {
    public static void printPeople(String uri) throws ClientProtocolException, IOException, JSONException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(uri);
        CloseableHttpResponse response = httpclient.execute(httpget);

        BufferedReader br = (new BufferedReader(new InputStreamReader(response.getEntity().getContent())));

        String line = br.readLine();

        JSONArray arr = new JSONArray(line);

        for (int i = 0; i < arr.length(); i++) {
            // System.out.println(arr.get(i));
            JSONObject json = (JSONObject) arr.get(i);
            JSONArray courses = new JSONArray(json.getString("courses"));
            if (courses.length() > 1) {
                byte[] byteName= json.getString("name").getBytes();
                String name = new String(byteName,"UTF-8");
                System.out.println(name);
            }

        }

    }

    public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
        printPeople("https://hackbulgaria.com/api/students/");
    }
}
