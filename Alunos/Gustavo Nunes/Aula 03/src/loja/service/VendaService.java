package loja.service;

import loja.model.Venda;

public class VendaService {

    // Retorna preço
    public static double calculaPreco(int quant,
                                      double valUni) {

        return quant * valUni;

    }

    // Retorna valor do desconto se aplicavel
    public static double calculaDesconto(int quantidade,
                                         double valTot) {
        if (quantidade > 10){
            return valTot * 0.05;
        }
        return 0;
    }

    // Retorna troco
    public static double calculaTroco(double valPag,
                                      double valDev) {

        return valPag - valDev;

    }

    // Retorna cadastro da venda
    public static Venda cadastraVenda(int quant, double valVen,
                                      double desconto){

        return new Venda(quant, valVen, desconto);
    }

}
