package api;

/**
 * Relevent Information About Search Result
 *
 * @author tyronsamaroo
 */
public class ItemData {

    private String itemDescription;
    private String itemPrice;
    private String imageLink;


    public ItemData(String itemDescription, String itemPrice, String imageLink) {

        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.imageLink = imageLink;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "itemDescription: " + itemDescription + "itemPrice: " + itemPrice + "imageLink: " + imageLink;
    }

    public static void main(String[] args) {


        ItemData itemData = new ItemData("dda", "dawd", "dwad");
        System.out.println(itemData);



    }
}
