package ua.org.oracle.academy.malahk;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 26.06.2015.
 */
public class IOStreamUtilsMain {

    public static final String DIRECTORY_NAME = "C:\\Users\\Admin\\workspace_idea\\DirectoryMess\\";

    public static void main (String[] args) {

//        IOStreamsUtils.generateRandomFilledFile("gen.txt");

//        IOStreamsUtils.sortRandom("gen.txt");

//        IOStreamsUtils.printRatedStudents("Students.txt", 90);

//        IOStreamsUtils.fileCopy("gen.txt", "copyOfGen.txt");

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "line 00");
        map.put(500, "line 01");
        map.put(1000, "line 02");
        map.put(1500, "line 03");
        map.put(2000, "line 04");
        map.put(2500, "line 05");
        map.put(3000, "line 06");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            MySchedule msch = new MySchedule(entry.getKey(), entry.getValue());
            msch.run();
        }
//        String name = "testPrint";
//        new File(String.format("%s%s", DIRECTORY_NAME, name)).mkdir();
//
//        try {
//            String path = String.format("%s%s\\\\", DIRECTORY_NAME, name);
//            File fileTest = new File(String.format("%s%s.txt", path, name));
//            fileTest.createNewFile();

//                if (file.createNewFile()){
//                    System.out.println("File is created!");
//                }else{
//                    System.out.println("File already exists.");
//                }

//            DirectoryMess.printInFile(fileTest);

//            DirectoryMess.readFromFile(fileTest);

//            DirectoryMess thread = new DirectoryMess(fileTest);
//            thread.start();
//
//            List<DirectoryMess> list = new ArrayList<>();
//            for (int i = 0; i < 10; ++i) {
//                list.add(new DirectoryMess(new File(String.format("%s%d\\%d.txt", DIRECTORY_NAME, i, i))));
//            }
//            list.forEach(ua.org.oracle.academy.malahk.DirectoryMess::start);

//            new Thread(new LinkedBlockingQueue().new addToQueue()).start();
//            new Thread(new LinkedBlockingQueue().new deleteFromQueue()).start();



//        File file = new File(String.format("%s%d\\%d.txt", DIRECTORY_NAME, 0, 0));
//        try (BufferedReader myReader = new BufferedReader(new FileReader(file))) {
//
//            for (int i = 0; i < 100; ++i) {
//                String line = myReader.readLine();
//
////                for (int j = 0; j < line.length(); ++j) {
////                    queue.push(line.charAt(j));
////                }
//                myReader.close();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ua.org.oracle.academy.malahk.Solution2.Writer myWriter = new ua.org.oracle.academy.malahk.Solution2.Writer();
        myWriter.start();



//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//


    }
}
