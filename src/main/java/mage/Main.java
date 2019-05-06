package mage;

import java.io.*;

public class Main {

    /**
     *
     */

    private static final String NEW_LINE = "\n";
    private final static String LOOK_STATE = "PA";

    public static void main(String args[]) throws IOException {

        String readLine, State;
        String lineArray[];

        Long numberOfEntryies = (long) 0;

        System.out.println("starting");

        FileReader fr = new FileReader("test.csv");
        BufferedReader br = new BufferedReader(fr);
        FileWriter writer = new FileWriter("out.txt");
        BufferedWriter buffer = new BufferedWriter(writer);

        // Write header for csv file to output
        readLine = br.readLine();
        buffer.write(readLine + NEW_LINE);

        // read rest of the file
        readLine = br.readLine();
        while (readLine != null) {

            lineArray = readLine.split(",");
            State = lineArray[8];
            if (State.equals(LOOK_STATE)) {
                buffer.write(readLine + NEW_LINE);
            }
            numberOfEntryies++;
            readLine = br.readLine();
        }

        System.out.println("Fin, number of lines processed: " + numberOfEntryies.toString());

        // close all the file writers
        br.close();
        fr.close();
        buffer.close();
    }

}