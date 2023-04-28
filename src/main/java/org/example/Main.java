package org.example;

import org.example.utils.CommandUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        CommandUtils commandUtils = new CommandUtils();

        System.out.println("Enter a command!");

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();
            String result = commandUtils.processCommand(command);
            if (result != null) {
                System.out.println(result);
            }
        }
    }
}