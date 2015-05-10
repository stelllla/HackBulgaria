package rest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WebCrawler {
    private final Set<URI> visitedUrls = Collections.synchronizedSet(new HashSet<URI>());

    public URI crawl(URI current, final String needle) throws URISyntaxException, MalformedURLException,
            InterruptedException, ExecutionException {

        String urlContents = downloadContents(current);
        visitedUrls.add(current);

        if (urlContents.contains(needle)) {
            return current;
        } else {
            for (String link : getAllLinks(urlContents)) {
                final URI asUri = normalizeLink(current, link);
                if (!visitedUrls.contains(asUri) && isInsideDomain(current, asUri)) {
                    URI result = crawl(asUri, needle);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isInsideDomain(URI currentLocation, URI asUrl) throws URISyntaxException {
        return currentLocation.getHost().equals(asUrl.getHost());
    }

    private URI normalizeLink(URI currentLocation, String link) throws MalformedURLException, URISyntaxException {
        URI uri = new URI(link);
        if (uri.getScheme() != null && uri.getHost() != null) {
            return uri;
        }
        return URIUtils.resolve(currentLocation, uri);
    }

    private static String downloadContents(URI startLocation) throws URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        System.out.println("Crawling : " + startLocation);
        HttpGet get = new HttpGet(startLocation);

        try {
                HttpResponse response = httpClient.execute(get);
                String content = EntityUtils.toString(response.getEntity());

                return content;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }
}