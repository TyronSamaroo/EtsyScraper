package api;

public class UserQueryFileParser {
    private String inputFile;

    public UserQueryFileParser() {
        inputFile = null;
    }

    public UserQueryFileParser(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }


    public static void main(String[] args) {
        UserQueryFileParser userQueryFileParser = new UserQueryFileParser();
        // userQueryFileParser.setInputFile();

    }
}
