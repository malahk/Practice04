package ua.org.oracle.academy.malahk;

import java.io.*;
import java.util.*;

/**
 * Created by Admin on 26.06.2015.
 */
public class IOStreamsUtils {

    public static void generateRandomFilledFile(String path) {

        try (FileOutputStream myFile = new FileOutputStream(path)) {

            Random randomNumber = new Random();

            for (int i = 0; i <= 10; ++i) {
                String temp = randomNumber.nextInt() + "\n";
                byte[] myByte = temp.getBytes();
                myFile.write(myByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortRandom(String path) {

        List<Integer> myList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("gen.txt")); BufferedWriter myWriter = new BufferedWriter(new FileWriter(path))){

            String line = null;
            while ((line = reader.readLine())!= null) {
                myList.add(Integer.parseInt(line));
            }
            Collections.sort(myList);

            for (Integer current : myList) {
                myWriter.write(current);
                myWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> printRatedStudents(String path, int rating) {

        List<String> myList = new ArrayList<>();

        try (BufferedReader myReader = new BufferedReader(new FileReader(path))) {

            String line = null;
            while ((line = myReader.readLine())!= null) {
                myList.add(myReader.readLine());
            }
            for (String student : myList) {
                if (Integer.parseInt(student.substring(student.indexOf("=") + 2)) >= rating) {
                    System.out.println(student.substring(0, student.indexOf("=") - 1));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myList;
    }


    public static void fileCopy(String path, String targetPath) {

        try (InputStream myFile = new FileInputStream(path); OutputStream myFileCopy = new FileOutputStream(targetPath)) {

            byte[] myByte = new byte[myFile.available()];
            myFile.read(myByte);
            myFileCopy.write(myByte);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
