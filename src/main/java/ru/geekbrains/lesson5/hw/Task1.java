package ru.geekbrains.lesson5.hw;

import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Task1 {
    public static void createBackup(String directoryPath) {
        // Создание папки backup, если она не существует
        String backupPath = directoryPath + "/backup";
        File backupDirectory = new File(backupPath);
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        // Список всех файлов в директории
        File[] files = new File(directoryPath).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Копирование файлов
                    try {
                        Path sourceFilePath = file.toPath();
                        Path targetFilePath = new File(backupPath + "/" + file.getName()).toPath();
                        Files.copy(sourceFilePath, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.out.println("Ошибка при копировании файла " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
            System.out.println("Резервная копия успешно создана в папке backup");
        } else {
            System.out.println("Директория " + directoryPath + " пустая");
        }
    }

    public static void main(String[] args) {
        String directoryPath = "./";
        createBackup(directoryPath);
    }
}

