package ru.geekbrains.lesson5;

import java.io.File;

public class Task2 {

    public static void main(String[] args) {
        printTree(new File("."), "", true);
    }

    static void printTree(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null)
                return;

            int subDirTotal = 0;
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() || files[i].isFile())
                    subDirTotal++;
            }

            int subDirCounter = 0;
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() || files[i].isFile()) {
                    subDirCounter++;
                    printTree(files[i], indent, subDirCounter == subDirTotal);
                }
            }
        }
    }
}
