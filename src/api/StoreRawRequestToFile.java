package api;


import java.io.File;

/**
 * Provide Etsy Object that has Query
 * Provide Webpage Reader that read webpage based on Etsy Query
 * Provide Output File to Place Data
 */
public class StoreRawRequestToFile {
    private WebpageReader webpageReader;
    private OutputData outputData;
    private Etsy etsy;

    public StoreRawRequestToFile() {
        this.webpageReader = null;
        this.outputData = null;
        this.etsy = null;
    }
    public StoreRawRequestToFile(Etsy etsy, WebpageReader webpageReader, OutputData outputData){
        this.webpageReader = webpageReader;
        this.outputData = outputData;
        this.etsy = etsy;

    }

    public void setEtsy(Etsy etsy) {
        this.etsy = etsy;
    }

    public void setOutputData(OutputData outputData) {
        this.outputData = outputData;
    }

    public void setWebpageReader(WebpageReader webpageReader) {
        this.webpageReader = webpageReader;
    }

    public Etsy getEtsy() {
        return etsy;
    }

    public OutputData getOutputData() {
        return outputData;
    }

    public WebpageReader getWebpageReader() {
        return webpageReader;
    }

    public static void main(String[] args) throws Exception {
        StoreRawRequestToFile storeRawRequestToFile = new StoreRawRequestToFile();
        storeRawRequestToFile.setEtsy(new Etsy("car"));
        //requestToHtmlFile.setWebpageReader(new WebpageReader(requestToHtmlFile.getEtsy().getWebpage()));
        storeRawRequestToFile.setWebpageReader(new WebpageReader(new Etsy("car").getWebpage()));
        File f = new File("data/website/" + "car" + "txt");
        storeRawRequestToFile.setOutputData(new OutputData(new WebpageReader(new Etsy("car").getWebpage()).rawHTMLFile(), f));


        //System.out.println(requestToHtmlFile.getEtsy().getWebpage());
    }
}
