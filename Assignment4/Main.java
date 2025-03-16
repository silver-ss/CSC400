//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String inputString1 = "41 2 * 3 +";
        String inputString2 = "42*3+";
        String inputString3 = "42*+";
        String inputString4 = "9999 1800 * 7 %";
        String inputString5 = "A3+4/";
        String inputString6 = "85+4/";
        String inputString7 = "52-";
        String inputString8 = "25-";

        PostfixCalc calculator = new PostfixCalc();

        //test 1:  multi-digit with spaces
        try { System.out.println("Results for " + inputString1 + " = " + calculator.calculate(inputString1));
            } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
        //test 2: single digit no spaces
        try{ System.out.println("Results for " + inputString2 + " = " + calculator.calculate(inputString2));
            } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
        //test 3: invalid equation, too many operators
        try{ System.out.println("Results for " + inputString3 + " = " + calculator.calculate(inputString3));
            } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
        //test 4: large numbers and mod operator
        try{ System.out.println("Results for " + inputString4 + " = " + calculator.calculate(inputString4));
            } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
        //test 5: unexpected letter instead of number
        try{ System.out.println("Results for " + inputString5 + " = " + calculator.calculate(inputString5));
            } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
        //test 6: integer or double division
        try{ System.out.println("Results for " + inputString6 + " = " + calculator.calculate(inputString6));
            } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
        //test 7 using subtraction to validate order is working correctly
        try{ System.out.println("Results for " + inputString7 + " = " + calculator.calculate(inputString7));
        } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
        //test 8: ensure order is working correctly by reversing intended order to confirm produces negative
        try{ System.out.println("Results for " + inputString8 + " = " + calculator.calculate(inputString8));
        } catch (IllegalArgumentException e) { System.out.println("ERROR: " + e.getMessage()); }
    }
}