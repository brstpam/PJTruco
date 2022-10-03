package truco;
import java.util.Scanner;
public class Truco {
    public static void main(String[] args){
        int first;
        Scanner input = new Scanner(System.in);
        Jogo j = new Jogo();
        Carta[] ds = new Carta[4]; for(int t=0;t<4;t++){ ds[t] = new Carta();} //Vetor monte de descarte
        
        System.out.println("Informe os nomes\n");
        for(int n=0;n<4;n++){
            System.out.println("jogador "+n);
            String nome = input.nextLine();
            j.jogador[n].setNome(nome);
        }
        
        for(int m=0;;m++){
            first = m;
            j.zeraTento();
            j.Embaralha();
            j.Distribui();
            for1: for(int r=0;r<3;r++){
                for(int d=0;d<4;d++){
                    ds[d] = j.Jogar(j.jogador,(first+d)%4);
                    if(ds[d].valor == 0){
                        j.jogador[(first+d)%4].correram();
                        if(j.d1.getpoint()>=2) j.d1.recebetento(j.getTento());
                        else if(j.d2.getpoint()>=2) j.d2.recebetento(j.getTento());
                        break for1; 
                    }
                    System.out.println(ds[d].Nome);
                }
                first = j.TestaMao(ds,j.jogador,first);
            }
                if(j.d1.getpoint()>=2) j.d1.recebetento(j.getTento());
                else if(j.d2.getpoint()>=2) j.d2.recebetento(j.getTento());
                if(j.testeVitoria(j.d1)){
                    System.out.println("A DUPLA 1 VENCEU!!");
                    System.out.print("     PLACAR\n"+"Dupla 1 = "+(j.d1.getPlacar())+" pontos!");
                    System.out.println(" X Dupla 2 = "+(j.d2.getPlacar())+" pontos!");
                    break;
                }
                if(j.testeVitoria(j.d2)){
                    System.out.println("A DUPLA 2 VENCEU!!");
                    System.out.print("     PLACAR\n"+"Dupla 1 = "+(j.d1.getPlacar())+" pontos!");
                    System.out.println(" X Dupla 2 = "+(j.d2.getPlacar())+" pontos!");
                    break;
                }
                
                System.out.println("              PROXIMA MÃO");
                System.out.print("     PLACAR\n"+"Dupla 1 = "+(j.d1.getPlacar())+" pontos!");
                System.out.println(" X Dupla 2 = "+(j.d2.getPlacar())+" pontos!");
        }
    }
}
