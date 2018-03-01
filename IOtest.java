package com.example.a2theot10.fileio;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class IOtest {
    @Test
    public void addition_isCorrect() throws Exception {
        File f = null;

        DataOutputStream ds = null;
        FileOutputStream fs = null;
        try {
            // creating a temporary directory if doesn't exist
            f = new File("./temp/data.bin");
            if (!f.exists()) {
                f.getParentFile().mkdirs();
            }
            System.out.println("writing to:" + f.getAbsolutePath());
            fs = new FileOutputStream(f);
            ds = new DataOutputStream(fs);
            ds.writeInt(1);
            ds.writeChar('b');
            ds.writeDouble(3.1415927);

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (ds != null) ds.close(); // close the file to ensure data is flushed to file
        }
        // read file
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {

            System.out.println("reading from:" + f.getAbsolutePath());
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
            Integer i = dis.readInt();
            Character c = dis.readChar();
            Double d = dis.readDouble();

            System.out.println(" integer: " + i +
                    " character: " + c +
                    " double " + d);

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (ds != null) ds.close(); // close the file to ensure data is flushed to file
        }

    }

    @Test
    public void fileCharacterStreamExample() throws Exception {
        File f = null;
        PrintWriter pw = null;
        try {
            // creating a temporary directory if doesn't exist
            f = new File("./temp/data.txt");
            if (!f.exists()) {
                f.getParentFile().mkdirs();
            }
            System.out.println("writing to:" + f.getAbsolutePath());
            pw =
                    new PrintWriter(new FileWriter(f));

            pw.println("Hello");
            pw.println("It's a nice day!");
            pw.close(); // close the file to ensure data is flushed to file
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            if (pw != null) pw.close(); // close the file to ensure data is flushed to file
        }

        // read from file
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        } finally {
            if (reader != null) reader.close(); // close the file to ensure data is flushed to file
        }
    }

    @Test
    public void csvexample() throws Exception {
        File f = null;
        PrintWriter pw = null;
        try {
            // creating a temporary directory if doesn't exist
            f = new File("./temp/csvexample.txt");
            if (!f.exists()) {
                f.getParentFile().mkdirs();
            }
            System.out.println("writing to:" + f.getAbsolutePath());
            pw =
                    new PrintWriter(new FileWriter(f));

            pw.println("Tony,Rees,RM601,3456\n" +
                    "David,Osguthorpe,RM602,3334\n" +
                    "Mark,Cranshaw,RM603,3122");
            pw.close(); // close the file to ensure data is flushed to file
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            if (pw != null) pw.close(); // close the file to ensure data is flushed to file
        }

        // read from file
        BufferedReader reader = null;
        try {
            ArrayList<Staff> staff = new ArrayList<Staff>();
            reader = new BufferedReader(new FileReader(f));
            String line ;

            while((line = reader.readLine()) != null)
            {
                String[] components = line.split(",");
                if(components.length==4)
                {
                    Staff currentStaff = new Staff (components[0], components[1], components[2], components[3]);
                    staff.add(currentStaff);
                }
            }

            for (Staff current: staff){
                System.out.println(current);
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        } finally {
            if (reader != null) reader.close(); // close the file to ensure data is flushed to file
        }
    }
}

