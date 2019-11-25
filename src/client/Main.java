package client;


import api.Etsy;
import api.EtsyCleanData;
import api.WebpageReader;

/**
 * This is where client can run the program.
 * @author tyronsamaroo
 */
public class Main {

    public static void main(String[] args) throws Exception {

        //Call Etsy and provide it with the query;

        Etsy etsy = new Etsy("car");
        //This is the webpage that you will provide
        etsy.getWebpage();

        //Calls Webpage reader to read the given webpage
        WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());

        //This returns the entire htmlfile remember this type StringBuilder
        webpageReader.rawHTMLFile();

        //EtsyCleanData cleanData = new EtsyCleanData(webpageReader.rawHTMLFile());






    }

}
