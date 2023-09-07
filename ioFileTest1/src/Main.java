import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./test");
        printAllFiles(file);
        boolean res = file.listFiles() == null;
        System.out.println(res);
        System.out.println(file.listFiles());
    }

    static void printAllFiles(File file) throws FileNotFoundException {
        final int fatherFileLevel = 0;
        printAllFilesIn(file, fatherFileLevel);
    }

    static void printAllFilesIn(File file, int fileLevel) throws FileNotFoundException {
        if(!file.exists()){
            throw new FileNotFoundException("File not found");
        }

        String preString = "";

        for(int j = 0; j < fileLevel; j++){
            preString += "\t";
        }

        fileLevel++;

        if(file.isDirectory()){
            System.out.println(preString + file.getName() + File.separator);
            File[] files = file.listFiles();
            for(File f : files){
                printAllFilesIn(f, fileLevel);
            }
        }else{
            System.out.println(preString + file.getName());
        }


    }
}

//import java.io.File;
//import java.io.IOException;

//public class Main {
//    public static void main(String[] args) throws IOException {
//        File file = new File("./");
//        printFiles(file);
//    }
//
//    static void printFiles(File file){
//        int i=0;
//        printFileEnd(file,i);
//    }
//
//    static void printFileEnd(File file,int i){
//        String prefix="";
//        for (int j = 0; j < i; j++) {
//            prefix += "\t";
//        }
//        i++;
//        if(file.exists()){
//            System.out.println(prefix+file.getName()+File.separator);
//            File[] files = file.listFiles();
//            if(files!=null){
//                for (File file1 : files) {
//                    if(file1.isDirectory())
//                        printFileEnd(file1,i);
//                    else
//                        System.out.println(prefix+file1.getName());
//                }
//            }
//        }
//    }
//}