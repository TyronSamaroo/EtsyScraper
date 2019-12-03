package api;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This Will Clean Response From Etsy.
 *
 * @author tyronsamaroo
 */
public class EtsyCleanData {

    StringBuilder fileToClean;

    public EtsyCleanData() {
        fileToClean = null;
    }

    public EtsyCleanData(StringBuilder fileToClean) {
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
     *
     * @return A string of all the prices
     */
    public String cleanFileForPrice() {
       // Pattern p = Pattern.compile("<span\\s+class=\\'currency-value'\\>(\\d*.\\d*)</span>");
        Pattern p = Pattern.compile("<span\\s+class=\"n-listing-card__price text-gray mt-xs-0 strong display-block\\s+text-body-larger\\s+\">\\s+.*?<span class=[^\\d]*(\\d*.\\d*)");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();
        //int count = 0;

        while (m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(1));
            output.append("\n");

            //System.out.println(count++);
        }
        return output.toString();
    }

    /**
     * Clean the RawHTML from Website and display all the Description
     *
     * @return A string of all the Description
     */
    public String cleanFileForDescription() {
       // Pattern p = Pattern.compile("<h2\\s+class=\"text-gray\\s+text-truncate\\s+mb-xs-0\\s+text-body\">\\s+([^>]*)\\s+</h2>");
        //Pattern p = Pattern.compile("<h2\\s+class=\\\"text-gray\\s+text-truncate\\s+mb-xs-0\\s+text-body\\\">\\s+[^<]*(?<=\\w)");
        Pattern p = Pattern.compile("<h2\\s+class=\\\"text-gray\\s+text-truncate\\s+mb-xs-0\\s+text-body\\\">\\s+([^<]*)(?<=\\w)");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();
        int count = 0;

        while (m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(1));
            output.append("\n");
            //System.out.println(count++);
        }
        return output.toString().trim();
    }

    /**
     * Clean the RawHTML from Website and display all the Images
     *
     * @return String of all the links to the Images
     */
    public String cleanFileForImageSrc() {
        Pattern p = Pattern.compile("<img\\s+data-listing-card-listing-image\\s+[src|data\\-src]*=\"([^\"]*)\"");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();
        //int count = 0;

        while (m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(1));
            output.append("\n");
            //System.out.println(count++);

        }
        return output.toString();
    }

    ;

    public static void main(String[] args) throws Exception {
        Etsy etsy = new Etsy("car");
        //etsy.getWebpage();
        //System.out.println(etsy.getWebpage());
        WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
        //System.out.println(webpageReader.rawHTMLFile());

        EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
        File f = new File("data/website/" + etsy.getQuery()+".txt");
        OutputData outputData = new OutputData(webpageReader.rawHTMLFile(),f);
        outputData.storeOutput();


        // System.out.println(data.getFileToClean());

        //System.out.println(webpageReader.rawHTMLFile());
        //System.out.println(data.cleanFileForPrice());
        //System.out.println(data.cleanFileForImageSrc());

        //System.out.println(data.cleanFileForDescription());
        //System.out.print(data.cleanFileForDescription() + data.cleanFileForImageSrc() + data.cleanFileForPrice());
        //System.out.println(data.cleanFileForPrice());
        //System.out.println(data.cleanFileForPrice().split("\n").length);

        String stringToSplitPrice = data.cleanFileForPrice();
        String stringToSplitDescription = data.cleanFileForDescription();
        String stringToSplitImageSrc = data.cleanFileForImageSrc();

        String[] priceArray;
        String[] descriptionArray;
        String[] imageLinkArray;

        priceArray = stringToSplitPrice.split("\n");
        descriptionArray = stringToSplitDescription.split("\n");
        imageLinkArray = stringToSplitImageSrc.split("\n");
        ArrayList<ItemData> itemData = new ArrayList<>();
        for (int i = 0; i < priceArray.length; i++) {
            String price = priceArray[i];
            String description = descriptionArray[i];
            String image = imageLinkArray[i];
            ItemData item = new ItemData(description,price,image);
            itemData.add(item);
        }


        System.out.println("test" + priceArray[0]);
        Hashtable<Integer,ArrayList<String>> table = new Hashtable<>();

        for (int i = 0; i < data.cleanFileForPrice().split("\n").length; i++) {
            ArrayList<String> params = new ArrayList<>();
            params.add(descriptionArray[i]);
            params.add(priceArray[i]);
            params.add(imageLinkArray[i]);

            table.put(i,params);
            //System.out.println(priceArray[i]);
           System.out.println(params);
        }

        System.out.println(data.cleanFileForPrice().split("\n").length);
        System.out.println(data.cleanFileForDescription().toString().split("\n").length);
        System.out.println(data.cleanFileForImageSrc().split("\n").length);
//        System.out.println(table.entrySet());
//        System.out.println(table.entrySet().size());


//        for (int i = 0; i < table.entrySet().size() - 1; i++) {
//            System.out.println(table.elements().asIterator().next().get(i));
//
//        }
        System.out.println(table.entrySet());


//        input.put(1, "a");
//        System.out.println(input.entrySet());

       // System.out.println(table.entrySet());
//        ArrayList<String> test = new ArrayList<>();
//        test.add("2");
//        test.add("3");
//        System.out.println(test);
//        Hashtable<Integer,ArrayList<String >> testing = new Hashtable<>();
//        ArrayList<String> info = new ArrayList<>();
//        info.add("Discrip");info.add("image");info.add("price");
//        testing.put(1,info);
//        System.out.println(testing.toString());
        //System.out.println(testing.elements().asIterator().next().get(2));










    }

}
