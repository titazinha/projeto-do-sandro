import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mercosul {
    public static void main(String[] args) {
        double total = 0.0;
        double prodUni = 0;
        double frete = 0;
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Sabonete", 2.0, 0));
        produtos.add(new Produto("Shampoo", 10.0, 1));
        produtos.add(new Produto("Limpol", 3.5, 2));
        produtos.add(new Produto("Oleo", 17.0, 3));
        produtos.add(new Produto("Pão", 6.3, 4));
        
        traço();
        System.out.printf("%-60s%n", "Bem vindos ao Mercosul");
        traço();
        
        System.out.printf("%-60s%n", "Gostaria de iniciar o seu pedido? [S/N]: ");
        Scanner scanner = new Scanner(System.in);
        String P = scanner.nextLine().toUpperCase();
        traço();
        
        if (P.equals("S")) {
            System.out.printf("%-60s%n", "Lista de produtos");
            traço();
            System.out.println();
            System.out.printf("%-20s%-34s%-3s%n", "Produtos", "Preço", "Cod");
            
            for (Produto produto : produtos) {
                System.out.println("-".repeat(60));
                System.out.printf("%-20sR$%-30.2f%-4d%n", produto.getNome(), produto.getPreco(), produto.getCod());
            }
            
            traço();
            
            System.out.println("Digite o código do produto escolhido e sua quantidade para adicionar ao carrinho\n");
            
            while (true) {
                System.out.print("Código do item: ");
                int item = scanner.nextInt();
                System.out.print("Quantidade do item: ");
                int quant = scanner.nextInt();
                
                for (Produto produto : produtos) {
                    if (produto.getCod() == item) {
                        prodUni = produto.getPreco() * quant;
                        total += prodUni;
                        break;
                    }
                }
                
                System.out.print("Gostaria de adicionar mais algum item? [S/N]:\n");
                String continuar = scanner.next().toUpperCase();
                
                if (continuar.equals("N")) {
                    break;
                }
            }
            
            System.out.println();
            System.out.printf("Total dos itens: R$%.2f%n", total);
            System.out.println();
            
            if (total >= 200) {
                System.out.println("Você tem o frete gratuito\n");
                frete = 0;
            } else {
                System.out.println("O frete custará um acréscimo de R$10 ao valor final\n");
                frete = 10;
            }
            
            System.out.println("Qual será a forma de pagamento escolhida? Digite o código\n");
            System.out.println("Pix - 10% de desconto (Cod 1)\n");
            System.out.println("Boleto - 5% de desconto (Cod 2)\n");
            System.out.println("Cartão - até 3x sem juros, acima haverá um acréscimo de 2.5% por parcela (Cod 3)\n");
            
            while (true) {
                int pagamento = scanner.nextInt();
                
                if (pagamento == 1) {
                    total *= 0.9; // Aplica desconto de 10%
                    break;
                } else if (pagamento == 2) {
                    total *= 0.95; // Aplica desconto de 5%
                    break;
                } else if (pagamento == 3) {
                    System.out.print("Digite a quantidade de parcelas desejadas: ");
                    int parcelas = scanner.nextInt();
                    
                    if (parcelas <= 3) {
                        // Parcelamento em até 3x sem juros
                        double valor_parcela = total / parcelas;
                        System.out.printf("O valor de cada parcela será de R$%.2f%n", valor_parcela);
                        break;
                    } else {
                        double acrescimo = 2.5; // Acréscimo de 2.5% por parcela
                        total *= (1 + acrescimo / 100); // Aplica o acréscimo
                        double valor_parcela = total / parcelas;
                        System.out.printf("O valor de cada parcela será de R$%.2f%n", valor_parcela);
                        break;
                    }
                } else {
                    System.out.println("Opção de pagamento inválida");
                }
            }
            
            System.out.printf("O valor final de sua compra é de R$%.2f%n", total + frete);
            System.out.println("Obrigado e volte sempre!");
        }
        
        if (P.equals("N")) {
            System.out.println("Obrigado e volte sempre!");
        }
        
        scanner.close();
    }
    
    public static void traço() {
        System.out.println("-=".repeat(30));
    }
}
