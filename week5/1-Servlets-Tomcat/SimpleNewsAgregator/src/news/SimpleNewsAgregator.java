package news;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * Servlet implementation class SimpleNewsAgregator
 */
@WebServlet("/SimpleNewsAgregator")
public class SimpleNewsAgregator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType(MediaType.TEXT_HTML);
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();

		URL dnevnikRSS = new URL("http://www.dnevnik.bg/rssc/?rubrid=1657");
		URL sportalRSS = new URL("http://www.sportal.bg/uploads/rss_category_2.xml");
		URL sinoptikRSS = new URL("http://sinoptik.bg/rss/100727011");

		writer.append("<h2> Времето </h2>");
		extractNewsFromURL(sinoptikRSS, writer);
		writer.append("<h2> Новини </h2>");
		extractNewsFromURL(dnevnikRSS, writer);
		writer.append("<h2> Спорт </h2>");
		extractNewsFromURL(sportalRSS, writer);

	}

	private void extractNewsFromURL(URL feedUrl, PrintWriter writer)
			throws IOException {
		SyndFeedInput input = new SyndFeedInput();

		try {
			SyndFeed feed = input.build(new XmlReader(feedUrl));
			Iterator iter = feed.getEntries().iterator();

			while (iter.hasNext()) {
				SyndEntry curr = (SyndEntry) iter.next();
				String title = curr.getTitle();
				String link = curr.getLink();
				writer.append("<a href=\"" + link + "\">" + title + "</a>");
				writer.append("<p> </p>" + curr.getDescription().getValue());
			}

		} catch (IllegalArgumentException | FeedException e) {
			e.printStackTrace();
		}
	}

}
