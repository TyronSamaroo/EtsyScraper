package api;

public class StoreCleanDataToFile {

    private Etsy etsyQuery;
    private WebpageReader webpageReader;
    private OutputData outputData;
    private EtsyCleanData etsyCleanData;


    public StoreCleanDataToFile(){
        this.etsyQuery = null;
        this.webpageReader = null;
        this.outputData = null;
        this.etsyCleanData = null;
    }
    public StoreCleanDataToFile(EtsyCleanData etsyCleanData, OutputData data){
        this.outputData = getOutputData();
        this.etsyCleanData = etsyCleanData;

    }

    public StoreCleanDataToFile(Etsy etsyQuery, WebpageReader webpageReader, EtsyCleanData etsyCleanData, OutputData outputData){
        this.etsyQuery = etsyQuery;
        this.webpageReader = webpageReader;
        this.outputData = outputData;
        this.etsyCleanData = etsyCleanData;
    }


    public WebpageReader getWebpageReader() {
        return webpageReader;
    }

    public void setWebpageReader(WebpageReader webpageReader) {
        this.webpageReader = webpageReader;
    }

    public OutputData getOutputData() {
        return outputData;
    }

    public void setOutputData(OutputData outputData) {
        this.outputData = outputData;
    }

    public Etsy getEtsyQuery() {
        return etsyQuery;
    }

    public void setEtsyQuery(Etsy etsyQuery) {
        this.etsyQuery = etsyQuery;
    }

    public EtsyCleanData getEtsyCleanData() {
        return etsyCleanData;
    }

    public void setEtsyCleanData(EtsyCleanData etsyCleanData) {
        this.etsyCleanData = etsyCleanData;
    }

    public static void main(String[] args) throws Exception {
        StoreCleanDataToFile storeCleanDataToFile = new StoreCleanDataToFile();
        storeCleanDataToFile.setEtsyQuery(new Etsy("car"));
        storeCleanDataToFile.setWebpageReader(new WebpageReader(storeCleanDataToFile.getEtsyQuery().getWebpage()));
        //Clean this
        storeCleanDataToFile.setEtsyCleanData(new EtsyCleanData(storeCleanDataToFile.getWebpageReader().rawHTMLFile()));
        storeCleanDataToFile.getEtsyCleanData().cleanFileForPrice();
        storeCleanDataToFile.getEtsyCleanData().cleanFileForImageSrc();
        storeCleanDataToFile.getEtsyCleanData().cleanFileForDescription();

        storeCleanDataToFile.setOutputData(new OutputData(storeCleanDataToFile.getEtsyCleanData().fileToClean,"cleandata.txt"));
        System.out.println();

    }
}
