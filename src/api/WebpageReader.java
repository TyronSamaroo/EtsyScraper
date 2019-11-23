package api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/**
 * This class purpose is to read the given webpage
 */
public class WebpageReader {

    public  final String USER_AGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2) Gecko/20100115 Firefox/3.6";
    private String website;


    public  WebpageReader(){
        this.website = null;
    }

    public WebpageReader(String website){
        this.website = website;

    }

    /**
     * Sets the website
     * @param website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    /**
     * Helper Function
     * @param sURL Takes in given website and connects
     * @return an input stream that reads from this open connection
     * @throws Exception if cant connect
     */
    public  InputStream getURLInputStream(String sURL) throws Exception {

        URLConnection oConnection = (new URL(sURL)).openConnection();
        oConnection.setRequestProperty("User-Agent", USER_AGENT);
        return oConnection.getInputStream();

    }

    /**
     * Reads the given URL Reads text from a character-input stream, buffering characters so
     * as to provide for the efficient reading of characters, arrays, and lines.
     * @param url Provided URL
     * @return Retu
     * @throws Exception
     */
    public  BufferedReader read(String url) throws Exception {
        InputStream content = (InputStream)getURLInputStream(url);
        return new BufferedReader (new InputStreamReader(content));

    }

    /**
     *THis function takes a given website and outputs it in a text file
     * @return the html response is returned as a String
     * @throws Exception If it was not able to read the webpage
     */
    public StringBuilder rawHTMLFile() throws Exception {
        StringBuilder contents = new StringBuilder();
        try {
            BufferedReader reader = read(this.website);

            while (reader.readLine() != null) {
                contents.append(reader.readLine());
            }
        }catch (Exception e){
            System.out.println(e);
        }

//        return text;
        return contents;
    }

    public static void main (String[] args) throws Exception{

        Etsy etsy = new Etsy("car");
        etsy.getWebpage();
        WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
        System.out.println(webpageReader.rawHTMLFile());



    }

}
