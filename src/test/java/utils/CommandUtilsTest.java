package utils;

import org.example.utils.CommandUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandUtilsTest {

    @Test
    public void testToRegisterAliasGlob() {
        CommandUtils commandUtils = new CommandUtils();
        commandUtils.processCommand("glob is I");
        String result = commandUtils.processCommand("how many Credits is glob?");
        assertEquals("should be equal", "glob is 1 Credit(s)", result);
    }

    @Test
    public void testToRegisterAliasProk() {
        CommandUtils commandUtils = new CommandUtils();
        commandUtils.processCommand("prok is V");
        String result = commandUtils.processCommand("how many Credits is prok?");
        assertEquals("should be equal", "prok is 5 Credit(s)", result);
    }

    @Test
    public void testHowManyCommandWithUnregisteredAlias() {
        CommandUtils commandUtils = new CommandUtils();
        String result = commandUtils.processCommand("how many Credits is prok?");
        assertEquals("I have no idea what you are talking about", result);
    }

    @Test
    public void testHowManyCommandWithOneAlias() {
        CommandUtils commandUtils = new CommandUtils();
        commandUtils.processCommand("prok is V");
        String result = commandUtils.processCommand("how many Credits is prok?");
        assertEquals("should be equal", "prok is 5 Credit(s)", result);
    }

    @Test
    public void testHowManyCommandWithSomeAlias() {
        CommandUtils commandUtils = new CommandUtils();
        commandUtils.processCommand("prok is V");
        String result = commandUtils.processCommand("how many Credits is prok prok?");
        assertEquals("should be equal", "prok prok is 10 Credit(s)", result);
    }

    @Test
    public void testHowMuchCommandWithOneAlias() {
        CommandUtils commandUtils = new CommandUtils();
        commandUtils.processCommand("glob is I");
        commandUtils.processCommand("prok is V");
        commandUtils.processCommand("pish is X");
        commandUtils.processCommand("tegj is L");
        String result = commandUtils.processCommand("how much is pish tegj glob glob?");
        assertEquals("should be equal", "pish tegj glob glob is 62", result);
    }
}
