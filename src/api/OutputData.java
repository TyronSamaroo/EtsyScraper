package api;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * Output Data to a File
 *
 * @author tyronsamaroo
 */
public class OutputData {

    private StringBuilder text;
    private File fileName;

    public OutputData(StringBuilder text, File fileName) {
        this.fileName = fileName;
        this.text = text;

    }

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    /**
     * This stores the output. This MUST BE done after declare Object with given Params.
     * @throws IOException
     */
    public void storeOutput() throws IOException {
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
        System.out.println("card");
        File f = new File("data/website/" + "timmy.txt");
        System.out.println(f.getAbsolutePath());

        OutputData out = new OutputData(reader.rawHTMLFile(),f);
        out.storeOutput();



        //Need to output it to a file
    }
}
