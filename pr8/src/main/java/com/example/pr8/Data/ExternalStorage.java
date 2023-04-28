package com.example.pr8.Data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class ExternalStorage {
    public void writeFile(String name, String text){
        File newFile = new File(name);
        try {
            FileOutputStream inn = new FileOutputStream(newFile);
            inn.write(text.getBytes(StandardCharsets.UTF_8));
            inn.close();
        } catch (Exception e){
            System.out.println("File not found");
        }
    }

    public String readFile(String name){
        File newFile = new File(name);
        try {
            FileInputStream inn = new FileInputStream(newFile);
            BufferedInputStream bufinn = new BufferedInputStream(inn, 15);
            int i;
            String answer = "";
            while((i = bufinn.read())!= -1){
                answer += (char)i;
            }
            return answer;
        } catch (Exception e){
            System.out.println("File not found");
            return "File not found";
        }
    }
}
