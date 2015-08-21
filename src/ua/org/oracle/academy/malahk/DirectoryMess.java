package ua.org.oracle.academy.malahk;

import ua.org.oracle.academy.malahk.Solution2.LinkedListQueue;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Admin on 30.06.2015.
 */
public class DirectoryMess extends Thread implements Runnable {

    public static LinkedBlockingQueue<File> lbq = new LinkedBlockingQueue<>();
    public static final String DIRECTORY_NAME = "C:\\Users\\Admin\\workspace_idea\\DirectoryMess\\";
    private File file;

    public DirectoryMess(File file) {
        this.file = file;
        Thread myThread = new Thread();
        myThread.start();
    }

    @Override
    public void run() {

        //readFromFile(this.file);
        printInSuperFile(this.file);
   }

    public class DirectoryReader implements Runnable {

        @Override
        public void run () {
            try {
                int i = 0;
                while(i < 10){
                    lbq.take();
                    System.out.println(file.getName() + " removed.");
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void createAllDirectories() {

        for (int name = 0; name < 10; ++name) {

            new File(String.format("%s%d", DIRECTORY_NAME, name)).mkdir();

            try {
                String path = String.format("%s%d\\\\", DIRECTORY_NAME, name);
                File file = new File(String.format("%s%d.txt", path, name));
                file.createNewFile();
                printInFile(file);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void printInFile(File file) {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Character c = file.getName().charAt(0);

            for (int i = 0; i < 100; ++i) {
                for (int j = 0; j < 100; ++j) {

                    writer.write(c);
                }
                writer.write("\r\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFromFile(File file, LinkedListQueue queue) {

        try (BufferedReader myReader = new BufferedReader(new FileReader(file))) {

            for (int i = 0; i < 100; ++i) {
               String line = myReader.readLine();

                for (int j = 0; j < line.length(); ++j) {
                    queue.push(line.charAt(j));
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printInSuperFile(File file) {

            try (InputStream myFile = new FileInputStream(file.getPath())) {

                byte[] myByte = new byte[myFile.available()];
                myFile.read(myByte);

                String path = String.format("%s%s\\\\", DIRECTORY_NAME, "RESULT.txt");

                OutputStream result = new FileOutputStream(path, true);
                result.write(myByte);

                myFile.close();
                result.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//    public static void printInSuperFile1(File file) {
//
//        String data = new BufferedReader(file.);
//
//        String path = String.format("%s%s\\\\", DIRECTORY_NAME, "RESULT.txt");
//
//        File result = new File(path);
//
//       try (FileWriter myFw = new FileWriter(result,true)) {
//
//           BufferedWriter myBw = new BufferedWriter(myFw);
//
//           myBw.write(data);
//           myBw.newLine();
//           myBw.close();
//
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
//
//    }



    public static void generateExactFilledFile(String path) {

        try (FileOutputStream myFile = new FileOutputStream(path)) {

            for (int i = 0; i < 100; ++i) {
                for (int j = 0; j < 100; ++j) {
                    String temp = path;
                    byte[] myByte = temp.getBytes();
                    myFile.write(myByte);
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static void move () {
//
//        Path pathSource = Paths.get("Вставьте сюда путь к файлу/директории, который надо переместить");
//        Path pathDestination = Paths.get("Вставьте сюда путь для нового местоположения файла/директории");
//        try {
//            Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("Source file copied successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void createFileInDirectory () {
//
//        try {
//
//            File file = new File(DIRECTORY_NAME + "newfile2.txt");
//
//            if (file.createNewFile()){
//                System.out.println("File is created!");
//            }else{
//                System.out.println("File already exists.");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}

