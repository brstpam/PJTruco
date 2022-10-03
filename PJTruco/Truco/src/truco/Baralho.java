package truco;
public class Baralho extends Carta{
    protected Carta[] monte = new Carta[41];
    
    private static Baralho g_instance;
    
    public static Baralho getInstance(){
        if (g_instance == null){
            g_instance = new Baralho();
        }
        return g_instance;
    }
    private Baralho(){
        monte[0]=new Carta();monte[0].Nome = "A ♠";monte[0].valor = 12;
        monte[1]=new Carta();monte[1].Nome = "2 ♠";monte[1].valor = 9;
        monte[2]=new Carta();monte[2].Nome = "3 ♠";monte[2].valor = 10;
        monte[3]=new Carta();monte[3].Nome = "4 ♠";monte[3].valor = 1;
        monte[4]=new Carta();monte[4].Nome = "5 ♠";monte[4].valor = 2;
        monte[5]=new Carta();monte[5].Nome = "6 ♠";monte[5].valor = 3;
        monte[6]=new Carta();monte[6].Nome = "7 ♠";monte[6].valor = 4;
        monte[7]=new Carta();monte[7].Nome = "Q ♠";monte[7].valor = 5;
        monte[8]=new Carta();monte[8].Nome = "J ♠";monte[8].valor = 6;
        monte[9]=new Carta();monte[9].Nome = "K ♠";monte[9].valor = 7;
        monte[10]=new Carta();monte[10].Nome = "A ♦";monte[10].valor = 8;
        monte[11]=new Carta();monte[11].Nome = "2 ♦";monte[11].valor = 9;
        monte[12]=new Carta();monte[12].Nome = "3 ♦";monte[12].valor = 10;
        monte[13]=new Carta();monte[13].Nome = "4 ♦";monte[13].valor = 1;
        monte[14]=new Carta();monte[14].Nome = "5 ♦";monte[14].valor = 2;
        monte[15]=new Carta();monte[15].Nome = "6 ♦";monte[15].valor = 3;
        monte[16]=new Carta();monte[16].Nome = "7 ♦";monte[16].valor = 11;
        monte[17]=new Carta();monte[17].Nome = "Q ♦";monte[17].valor = 5;
        monte[18]=new Carta();monte[18].Nome = "J ♦";monte[18].valor = 6;
        monte[19]=new Carta();monte[19].Nome = "K ♦";monte[19].valor = 7;
        monte[20]=new Carta();monte[20].Nome = "A ♥";monte[20].valor = 8;
        monte[21]=new Carta();monte[21].Nome = "2 ♥";monte[21].valor = 9;
        monte[22]=new Carta();monte[22].Nome = "3 ♥";monte[22].valor = 10;
        monte[23]=new Carta();monte[23].Nome = "4 ♥";monte[23].valor = 1;
        monte[24]=new Carta();monte[24].Nome = "5 ♥";monte[24].valor = 2;
        monte[25]=new Carta();monte[25].Nome = "6 ♥";monte[25].valor = 3;
        monte[26]=new Carta();monte[26].Nome = "7 ♥";monte[26].valor = 13;
        monte[27]=new Carta();monte[27].Nome = "Q ♥";monte[27].valor = 5;
        monte[28]=new Carta();monte[28].Nome = "J ♥";monte[28].valor = 6;
        monte[29]=new Carta();monte[29].Nome = "K ♥";monte[29].valor = 7;
        monte[30]=new Carta();monte[30].Nome = "A ♣";monte[30].valor = 8;
        monte[31]=new Carta();monte[31].Nome = "2 ♣";monte[31].valor = 9;
        monte[32]=new Carta();monte[32].Nome = "3 ♣";monte[32].valor = 10;
        monte[33]=new Carta();monte[33].Nome = "4 ♣";monte[33].valor = 14;
        monte[34]=new Carta();monte[34].Nome = "5 ♣";monte[34].valor = 2;
        monte[35]=new Carta();monte[35].Nome = "6 ♣";monte[35].valor = 3;
        monte[36]=new Carta();monte[36].Nome = "7 ♣";monte[36].valor = 4;
        monte[37]=new Carta();monte[37].Nome = "Q ♣";monte[37].valor = 5;
        monte[38]=new Carta();monte[38].Nome = "J ♣";monte[38].valor = 6;
        monte[39]=new Carta();monte[39].Nome = "K ♣";monte[39].valor = 7;
        monte[40]=new Carta();monte[40].Nome = "Correr";monte[40].valor = 0;
    }
    public void zeraBaralho(){
        for(int b=0;b<40;b++){
            monte[b].saiu = false;
        }
    } 
}
