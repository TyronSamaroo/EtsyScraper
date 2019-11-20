package main;

import java.util.Scanner;

public class EtsyParser {


    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Enter Search Term");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            System.out.println("You are searching for  " + input);
        }else{
            String search = args[0];
            System.out.println(search);
        }


    }
}
