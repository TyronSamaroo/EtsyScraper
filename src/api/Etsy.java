package api;


/**
 * Provide Query Specifically For Etsy. Will Also Provide The Search URL
 * @author tyronsamaroo
 */
public class Etsy {

    private String query;

    public Etsy(){
        query = null;
    }
    public Etsy(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    public String getWebpage(){
        String etsy = "https://www.etsy.com/search?q=";
        return  etsy + query;
    }

    public static void main(String[] args) {
        Etsy etsy = new Etsy("car");
        System.out.println(etsy.getQuery());
        System.out.println(etsy.getWebpage());


    }

}

