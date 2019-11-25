package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This Will Clean Response From Etsy.
 * @author tyronsamaroo
 */
public class EtsyCleanData {

    StringBuilder fileToClean;

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

    public String cleanFileForPrice() {
        Pattern p = Pattern.compile("<span\\s+class=\\'currency-value'\\>(\\d*.\\d*)</span>");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();

        while(m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(1));
            output.append("\n");
        }
        return output.toString();
    }

    public String cleanFileForDescription() {
        Pattern p = Pattern.compile("<h2\\s+class=\"text-gray\\s+text-truncate\\s+mb-xs-0\\s+text-body\">\\s+(.*)\\s+<\\/h2>");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();

        while(m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(0));
            output.append("\n");
        }
        return output.toString();
    }

    public String cleanFileForImageSrc(){
        Pattern p = Pattern.compile("<img\\s+.*?\\s+src=(\".*?\")");
        Matcher m = p.matcher(fileToClean);
        StringBuilder output = new StringBuilder();

        while(m.find()) {
            //System.out.println(m.group(1));
            output.append(m.group(0));
            output.append("\n");
        }
        return output.toString();};

    public static void main(String[] args) throws Exception {
        Etsy etsy = new Etsy("car");
        etsy.getWebpage();
        System.out.println(etsy.getWebpage());
        WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
        //webpageReader.rawHTMLFile());

        EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
        //System.out.println(webpageReader.rawHTMLFile());
        //System.out.println(data.cleanFileForPrice());
        System.out.println(data.cleanFileForImageSrc());
        //System.out.println(data.cleanFileForDescription());
    }

}
