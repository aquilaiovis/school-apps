package ch.bbw.PasswordGenerator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class PasswordGeneratorTest
{
    @Test
    public void testPasswordGenerator()
    {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        InputStream inputStream = new ByteArrayInputStream("   This   is   password   number   4221.   ".getBytes());
        passwordGenerator.setScanner(new Scanner(inputStream));

        passwordGenerator.checkPasswordStrength(passwordGenerator.suggestPassword());
    }
}