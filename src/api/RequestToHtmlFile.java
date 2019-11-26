package api;


/**
 * Provide the Html
 */
public class RequestToHtmlFile {
    private WebpageReader webpageReader;
    private OutputData outputData;
    private Etsy etsy;

    public RequestToHtmlFile() {
        this.webpageReader = null;
        this.outputData = null;
        this.etsy = null;
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
        RequestToHtmlFile requestToHtmlFile = new RequestToHtmlFile();
        requestToHtmlFile.setEtsy(new Etsy("car"));
        //requestToHtmlFile.setWebpageReader(new WebpageReader(requestToHtmlFile.getEtsy().getWebpage()));
        requestToHtmlFile.setWebpageReader(new WebpageReader(new Etsy("car").getWebpage()));
        requestToHtmlFile.setOutputData(new OutputData(new WebpageReader(new Etsy("car").getWebpage()).rawHTMLFile(), "test1234.txt"));


        //System.out.println(requestToHtmlFile.getEtsy().getWebpage());
    }
}
