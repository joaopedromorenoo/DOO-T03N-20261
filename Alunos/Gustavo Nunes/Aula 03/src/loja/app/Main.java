package loja.app;

import loja.model.Venda;
import loja.service.VendaService;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // onde serão armazenadas as vendas
    private static ArrayList<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {
        mostraMenu();
    }

    // Mostra menu ao usuário
    private static void mostraMenu() {

        System.out.printf("========================================" +
                "\n\n[1] - Calcular apenas Preço\n" +
                "[2] - Calcular apenas Troco\n" +
                "[3] - Calcular apenas desconto\n" +
                "[4] - Cadastrar compra\n" +
                "[5] - Listar compras\n" +
                "[6] - Sair\n" +
                "========================================" +
                "Entre com a opção : ");

        direcionaUzuario();
    }

    // direciona usuário para opção escolhida
    private static void direcionaUzuario() {

        int op = scanner.nextInt();

        switch (op){

            case 1:
                calculaPreco();
                mostraMenu();
                break;

            case 2:
                calculaTroco();
                mostraMenu();
                break;

            case 3:
                calculaDesconto();
                mostraMenu();
                break;

            case 4:
                cadastraVenda();
                mostraMenu();
                break;

            case 5:
                listaCompras();
                mostraMenu();
                break;

            case 6:
                System.out.println("\nENCERRANDO...");
                break;

            default:
                mostraMenu();
                break;

        }
    }

    // Calculo do Preço
    private static void calculaPreco() {

        System.out.println("\nQuntidade: ");
        int quant = scanner.nextInt();
        System.out.println("\nValor unitário: ");
        double valUni = scanner.nextDouble();

        double preco = VendaService.calculaPreco(quant,valUni);

        System.out.printf("\nPreço = R$%.2f",preco);

    }

    // Calculo do troco
    private static void calculaTroco() {

        System.out.println("\nValor pago: ");
        double valPag = scanner.nextDouble();
        System.out.println("\nValor devido: ");
        double valDev = scanner.nextDouble();

        double troco = VendaService.calculaTroco(valPag,valDev);

        System.out.printf("\nTroco = R$%.2f",troco);

    }

    // calcula desconto
    private static void calculaDesconto(){

        System.out.println("\nQuntidade: ");
        int quant = scanner.nextInt();
        System.out.println("\nValor Total: ");
        double valTot = scanner.nextDouble();

        double desconto = VendaService.calculaDesconto(quant, valTot);

        System.out.printf("\nDesconto = R$%.2f",desconto);
    }

    // Cadastra nova compra
    private static void cadastraVenda() {
        System.out.println("\nQuntidade: ");
        int quant = scanner.nextInt();
        System.out.println("\nValor unitário: ");
        double valUni = scanner.nextDouble();

        double desconto = VendaService.calculaDesconto(quant,valUni);
        double valVenda = VendaService.calculaPreco(quant,valUni);
        vendas.add(VendaService.cadastraVenda(quant,valVenda,desconto));

        System.out.println("venda cadastrada com sucesso cadastrada com sucesso!");
    }

    // Lista compras realizadas
    private static void listaCompras() {

        if (vendas.isEmpty()) {
            System.out.println("\nNenhuma compra cadastrada.");
            return;
        }

        for (Venda m : vendas){
            System.out.println(m);
        }
    }

}