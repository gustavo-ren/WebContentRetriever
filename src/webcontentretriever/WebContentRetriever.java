package webcontentretriever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Gustavo
 */
public class WebContentRetriever {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            URL url = new URL("https://en.wikipedia.org/wiki/Data_science");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.connect();

            out.println("Response Code: " + connection.getResponseCode());
            out.println("Content Type: " + connection.getContentType());
            out.println("Content Length: " + connection.getContentLength());

            InputStreamReader streamReader = new InputStreamReader((InputStream) connection.getContent());
            BufferedReader br = new BufferedReader(streamReader);
            StringBuilder builder = new StringBuilder();

            String line;

            do {
                line = br.readLine();
                builder.append(line + "\n");
            } while (line != null);
            
            out.println(builder.toString());

        } catch (MalformedURLException u) {
            System.out.println("Malformed");
        } catch (IOException i) {
            System.out.println("IO");
        }
    }

}
