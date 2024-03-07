import java.util.Scanner;
public class Main {

    static double docalculation(String equation, int nri){

        int[] operands = new int[10];
        char[] operators = new char[10];

        for(int nr : operands){
            for(int i = 0; i<equation.length(); i++){
                char c = equation.charAt(i);
                if(Character.isDigit(c)){
                    operands[i] = Integer.parseInt(Character.toString(c));
                }else if(c == 'x' || c == 'y'){
                    operands[i] = nri;
                }
            }
        }

        double rezultati = operands[0];

        for(char operator : operators){
            for(int i = 0; i<equation.length(); i++){
                char c = equation.charAt(i);
                if(!Character.isDigit(c) && c != 'x' && c != 'y'){
                    operators[i] = c;
                }
            }
        }

        for(int i = 0; i<equation.length()-1; i++){
            char c = equation.charAt(i);
            char c2 = equation.charAt(i+1);
            if(!Character.isDigit(c) && c != 'x' && c != 'y') {
                switch (c) {
                    case '+':
                        rezultati +=  Integer.parseInt(Character.toString(c2));
                        break;
                    case '-':
                        rezultati -= Integer.parseInt(Character.toString(c2));
                        break;
                    case '*':
                        rezultati *= Integer.parseInt(Character.toString(c2));
                        break;
                    case '/':
                        rezultati /= Integer.parseInt(Character.toString(c2));
                        break;
                }
            }
        }
        return rezultati;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = 5;

        System.out.println("Shkruaje ekuacionin per f(x). (Shembull: x-2),");
        System.out.print("f(x) = ");
        String eqin = scanner.next();
        System.out.print("Shkruaje vleren fillestare te x: ");
        int nrin = scanner.nextInt();

        for(int i = nrin; i<nrin+iterations; i++){
            System.out.println("(x=" + i + "), (y=" + docalculation(eqin, i) + ")");
        }
    }
}