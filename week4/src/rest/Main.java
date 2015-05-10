package rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException,
            ExecutionException {
        WebCrawler crawler = new WebCrawler();

        URI startLocation = new URI("http://ebusiness.free.bg");
        URI result = crawler.crawl(startLocation, "EMV");
        System.out.println("result :" + result.toString());
    }

}