import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter currencyConverter = new CurrencyConverter("SUA_API_KEY");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    ***********************************************
                    Seja bem-vindo(a) ao Conversor de Moedas!
                    
                    Digite a opção que você deseja:
                    
                    1) Real Brasileiro --> Dólar Americano
                    2) Real Brasileiro --> Euro
                    3) Real Brasileiro --> Iene
                    4) Dólar Americano --> Real Brasileiro
                    5) Euro --> Real Brasileiro
                    6) Iene --> Real Brasileiro
                    7) Sair da aplicação
                    
                    ***********************************************
                    """);

            int option = scanner.nextInt();

            if (option == 7) {
                System.out.println("Obrigado por utilizar nossa aplicação. Volte sempre!");
                break;
            }

            System.out.println("Digite o valor a ser convertido: ");
            double valueToConvert = scanner.nextDouble();

            if (option == 1) {
                currencyConverter.printMessage("BRL", "USD", valueToConvert);
            } else if (option == 2) {
                currencyConverter.printMessage("BRL", "EUR", valueToConvert);
            } else if (option == 3) {
                currencyConverter.printMessage("BRL", "JPY", valueToConvert);
            } else if (option == 4) {
                currencyConverter.printMessage("USD", "BRL", valueToConvert);
            } else if (option == 5) {
                currencyConverter.printMessage("EUR", "BRL", valueToConvert);
            } else if (option == 6) {
                currencyConverter.printMessage("JPY", "BRL", valueToConvert);
            }
        }
    }
}