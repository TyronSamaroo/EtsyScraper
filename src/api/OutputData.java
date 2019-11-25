package api;



import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * Output Data to a File
 * @author tyronsamaroo
 */
public class OutputData {

    private StringBuilder text;
    private String fileName;

    public OutputData(StringBuilder text, String fileName){
        this.fileName = "data/website/"+ fileName;
        this.text = text;

    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public void storeOutput() throws IOException
    {
        RandomAccessFile stream = new RandomAccessFile(this.fileName, "rw");
        FileChannel channel = stream.getChannel();
        byte[] strBytes = this.text.toString().getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();
    }

    public static void main(String[] args) throws Exception {
        String Etsy = "https://www.etsy.com/search?q=";
        String Query = "car";
        String search = Etsy + Query;
        WebpageReader reader = new WebpageReader(search);
        reader.rawHTMLFile();
        //System.out.println(reader.rawHTMLFile());
        OutputData out = new OutputData(reader.rawHTMLFile(),"nov2511121.txt");
        out.storeOutput();


        //Need to output it to a file
    }
}
