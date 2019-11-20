package main;

public class ItemData {

    private String itemText;
    private String itemPrice;
    private String imageLink;


    public ItemData(String itemText, String itemPrice, String imageLink){

        this.itemText = itemText;
        this.itemPrice = itemPrice;
        this.imageLink = imageLink;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
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
}
