package org.example.utils;

import java.util.HashMap;
import java.util.Map;

public class CommandUtils {

    private static final String HOW_MANY_INSTRUCTION_FORMAT = "how many Credits is ";
    private static final String HOW_MUCH_INSTRUCTION_FORMAT = "how much is ";

    private final Map<String, Integer> aliasMap = new HashMap<>();
    private final RomanUtils romanUtils = new RomanUtils();

    public String processCommand(String command) {
        if (command.contains(HOW_MANY_INSTRUCTION_FORMAT)) {
            return runHowManyInstruction(command);
        }
        if (command.contains(HOW_MUCH_INSTRUCTION_FORMAT)) {
            return runHowMuchInstruction(command);
        }

        String[] array = command.split("\\s+");
        String romanNumeral = array[2];
        int result = romanUtils.toNumber(romanNumeral);
        aliasMap.put(array[0], result);
        return array[0] + " registered successfully";
    }

    private String runHowManyInstruction(String command) {
        String alias = command
                .replace(HOW_MANY_INSTRUCTION_FORMAT, "")
                .replace("?", "");

        int count = 0;
        for (String aliasItem : alias.split("\\s+")) {
            if (!aliasMap.containsKey(aliasItem)) {
                return "I have no idea what you are talking about";
            }
            count += aliasMap.get(aliasItem);
        }

        return alias + " is " + count + " Credit(s)";
    }

    private String runHowMuchInstruction(String command) {
        String alias = command
                .replace(HOW_MUCH_INSTRUCTION_FORMAT, "")
                .replace("?", "");

        int count = 0;
        for (String aliasItem : alias.split("\\s+")) {
            if (!aliasMap.containsKey(aliasItem)) {
                return "I have no idea what you are talking about";
            }
            count += aliasMap.get(aliasItem);
        }

        return alias + " is " + count;
    }
}
