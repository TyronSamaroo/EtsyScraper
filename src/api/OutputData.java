package api;



import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class OutputData {

    private String fileName;
    private String text;
    public OutputData(String text, String fileName){
        this.fileName = "data/website/"+ fileName;
        this.text = text;

    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void storeOutput() throws IOException
    {
        RandomAccessFile stream = new RandomAccessFile(this.fileName, "rw");
        FileChannel channel = stream.getChannel();
        byte[] strBytes = this.text.getBytes();
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
        //reader.rawHTMLFile();
        //System.out.println(reader.rawHTMLFile());
        OutputData out = new OutputData(reader.rawHTMLFile().toString(),"checkthis.txt");
        out.storeOutput();


        //Need to output it to a file
    }
}
