package ch.bbw.PasswordGenerator;

import java.util.Scanner;

public class PasswordGenerator
{
    private Scanner scanner;
    private String input, output;

    public PasswordGenerator()
    {
        scanner = new Scanner(System.in);
        output = "";
    }

    public String suggestPassword()
    {
        System.out.print("Please enter a sentence you can easily remember.\n> ");
        input = scanner.nextLine();

        String[] inputSegments = input.split(" ");
        for(String inputSegment: inputSegments)
        {
            if(inputSegment.length() > 0)
            {
                if (Character.isDigit(inputSegment.charAt(0)))
                {
                    char[] inputSegmentChars = inputSegment.toCharArray();
                    for (char inputSegmentChar : inputSegmentChars)
                    {
                        if (Character.isDigit(inputSegmentChar))
                        {
                            output += inputSegmentChar;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else
                {
                    output += inputSegment.charAt(0);
                }
            }
        }
        System.out.println("\nThank you. We suggest you to use the password:\n" + output);
        return output;
    }

    public void checkPasswordStrength(String password)
    {
        int strength = password.length();
        System.out.println("\nThis password has at least one:");

        if(password.matches(".*[0-9].*"))
        {
            System.out.println("- number");
            strength += 5;
        }
        if(password.matches(".*[a-z].*"))
        {
            System.out.println("- lowercase letter");
            strength += 5;
        }
        if(password.matches(".*[A-Z].*"))
        {
            System.out.println("- one uppercase letter");
            strength += 5;
        }
        if(password.matches(".*[^0-9A-Za-z].*"))
        {
            System.out.println("- one special character");
            strength += 5;
        }

        String strengthEvaluation = "The password is ";
        if(strength < 10)
        {
            strengthEvaluation += "very insecure.";
        }
        else if(strength < 20)
        {
            strengthEvaluation += "insecure.";
        }
        else if(strength < 30)
        {
            strengthEvaluation += "moderately secure.";
        }
        else if(strength < 40)
        {
            strengthEvaluation += "secure.";
        }
        else
        {
            strengthEvaluation += "very secure.";
        }
        System.out.println(strengthEvaluation);
    }

    // For testing
    public void setScanner(Scanner scanner)
    {
        this.scanner = scanner;
    }
}