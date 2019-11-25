package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This Will Clean Response From Etsy.
 * @author tyronsamaroo
 */
public class EtsyCleanData {

    StringBuilder  fileToClean;

    public EtsyCleanData(){
        fileToClean = null;
    }
    public EtsyCleanData(StringBuilder fileToClean){
        this.fileToClean = fileToClean;
    }

    public StringBuilder clean() {
        return null;
    }

    public void setFileToClean(StringBuilder fileToClean) {
        this.fileToClean = fileToClean;
    }

    public StringBuilder getFileToClean() {
        return fileToClean;
    }

    /**
     * Clean the RawHTML from Website and display all the Prices
     * @return A string of all the prices
     */
    public String cleanFileForPrice() {
        Pattern p = Pattern.compile("<span\\s+class=\\'currency-value'\\>(\\d*.\\d*)</span>");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();
        //int count = 0;

        while(m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(1));
            output.append("\n");
            //System.out.println(count++);
        }
        return output.toString();
    }

    /**
     * Clean the RawHTML from Website and display all the Description
     * @return A string of all the Description
     */
    public StringBuilder cleanFileForDescription() {
        Pattern p = Pattern.compile("<h2\\s+class=\"text-gray\\s+text-truncate\\s+mb-xs-0\\s+text-body\">\\s+([^>]*)\\s+</h2>");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();
        int count = 0;

        while(m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(1));
            output.append("\n");
            //System.out.println(count++);
        }
        return output;
    }

    /**
     * Clean the RawHTML from Website and display all the Images
     * @return String of all the links to the Images
     */
    public String cleanFileForImageSrc(){
        Pattern p = Pattern.compile("<img\\s+data-listing-card-listing-image\\s+[src|data\\-src]*=\"([^\"]*)\"");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();
        //int count = 0;

        while(m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(1));
            output.append("\n");
            //System.out.println(count++);

        }
        return output.toString();};

    public static void main(String[] args) throws Exception {
        Etsy etsy = new Etsy("car");
        //etsy.getWebpage();
        //System.out.println(etsy.getWebpage());
        WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
        //System.out.println(webpageReader.rawHTMLFile());

        EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
        OutputData outputData = new OutputData(webpageReader.rawHTMLFile(), "testnov25125pm.txt");
        outputData.storeOutput();


       // System.out.println(data.getFileToClean());

        //System.out.println(webpageReader.rawHTMLFile());
       // System.out.println(data.cleanFileForPrice());
       //System.out.println(data.cleanFileForImageSrc());

        //System.out.println(data.cleanFileForDescription());
        //System.out.print(data.cleanFileForDescription() + data.cleanFileForImageSrc() + data.cleanFileForPrice());
        //System.out.println(data.cleanFileForPrice());
        //System.out.println(data.cleanFileForPrice().split("\n").length);

        String stringToSplit = data.cleanFileForPrice();
        String[] tempArray;
        tempArray = stringToSplit.split("\n");



        for (int i = 0; i < data.cleanFileForPrice().split("\n").length; i++) {
            System.out.println(tempArray[i]);


        }

    }

}
