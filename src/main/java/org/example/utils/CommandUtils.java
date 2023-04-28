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

        if (command.contains("is") && command.contains("Credits")) {
            return runRegisterUnitCreditFormat(command);
        }
        return runRegisterUnit(command);
    }

    private String runRegisterUnit(String command) {
        final int ROMAN_NUMERAL_INDEX = 2;
        final int ALIAS_INDEX = 0;

        String[] array = command.split("\\s+");
        String romanNumeral = array[ROMAN_NUMERAL_INDEX].trim();
        int result = romanUtils.toNumber(romanNumeral);
        String alias = array[ALIAS_INDEX].trim();
        aliasMap.put(alias, result);
        return alias + " registered successfully";
    }

    private String runRegisterUnitCreditFormat(String command) {
        final int ALIAS_INDEX = 0;
        final int TOTAL_VALUE_INDEX = 1;

        String instruction = command
                .replace("Credits", "");

        String[] array = instruction.split(" is ");
        String alias = array[ALIAS_INDEX].trim();
        String aliasToAdd = null;
        int value = Integer.parseInt(array[TOTAL_VALUE_INDEX].trim());
        for (String aliasItem : alias.split("\\s+")) {
            if (!aliasMap.containsKey(aliasItem)) {
                aliasToAdd = aliasItem;
            } else {
                value -= aliasMap.get(aliasItem);
            }
        }
        if (aliasToAdd != null) {
            aliasMap.put(aliasToAdd, value);
        }
        return aliasToAdd + " registered successfully";
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
