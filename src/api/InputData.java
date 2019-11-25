package api;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Put Data Into A File
 * @author tyronsamaroo
 */
public class InputData {


    /**
     * Reads from a file
     */
    private BufferedReader reader;

    /**
     * Name of the file to open
     */
    private String inputFileName;

    public InputData(){
        inputFileName = null;
    }

    /**
     * Constructs a new FileWriter and FileReader
     * @param inputFileName The name of the file to be read
     */
    public InputData(String inputFileName){

        try {
            reader = new BufferedReader(new FileReader(inputFileName));
        }catch ( IOException e ){
            System.out.println("Error opening input file!");
        }
        this.inputFileName = inputFileName;
    }


    /**
     * @return Input File name
     */
    public String getInputFileName(){
        return this.inputFileName;
    }

    /**
     *
     * @param inputFileName Sets the Input File
     */
    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    /**
     * Closes input file
     */
    public void close() {
        try {
            reader.close();
        }catch ( IOException e ){
            System.out.println("Error Closing input file!");
        }
    }

    public static void main(String[] args) {
        InputData input = new InputData("websitecar.txt");
        System.out.println(input.getInputFileName());


    }
}
