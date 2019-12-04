package api;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class ImageDownload {

     public Boolean downloadImage(String imgUrl, String destinationFile) {
        try {
            URL url = new URL(imgUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        try {




            Etsy etsy = new Etsy("car");
            WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
            EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
            File f = new File("data/website/" + "car" + ".txt");
            OutputData outputData = new OutputData(webpageReader.rawHTMLFile(), f);
            outputData.storeOutput();
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
                ItemData item = new ItemData(description, price, image);
                itemData.add(item);
            }
            String imageDir = "data/image/";
            System.out.println(itemData.get(0).getImageLink());

            ImageDownload imageDownload = new ImageDownload();


            imageDownload.downloadImage(itemData.get(0).getImageLink(),"2.jpg");




//            for (ItemData item : itemData) {
//
//                System.out.println(item.getImageLink());
//
//            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
