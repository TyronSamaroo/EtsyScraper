package api;

/**
 * Parses Search Results From Search Result
 *
 * @author tyronsamaroo
 */
public class EtsyParser {

    StringBuilder RawHTML;

    public EtsyParser() {
        RawHTML = null;
    }

    public EtsyParser(StringBuilder RawHTML) {
        this.RawHTML = RawHTML;
    }

    public StringBuilder getRawHTML() {
        return RawHTML;
    }

    public void setRawHTML(StringBuilder rawHTML) {
        RawHTML = rawHTML;
    }

    public static void main(String[] args) {


//        if (args.length == 0){
//            System.out.println("Enter Search Term");
//            Scanner in = new Scanner(System.in);
//            String input = in.nextLine();
//            System.out.println("You are searching for  " + input);
//        }else{
//            String search = args[0];
//            System.out.println(search);
//        }


    }
}
