package truco;
import java.util.Scanner;
import java.util.Random;
public class Jogo {
    Scanner ler = new Scanner(System.in);

    private int tento = 2;
    private Baralho embaralhado;
    protected Jogadores [] jogador = new Jogadores[4];   
    protected Dupla d1;protected Dupla d2; 
    
    public Jogo(){ //Construtor
        embaralhado = Baralho.getInstance();
        for(int j=0;j<4;j++){
            jogador[j] = new Jogadores();
        }
        this.d1 = new Dupla(jogador[0],jogador[2]);
        this.d2 = new Dupla(jogador[1],jogador[3]);
    }
    public void Embaralha(){
        Carta aux;
        embaralhado.zeraBaralho();
        Random r = new Random();
        for(int i=0;i<40;i++){
            int j = r.nextInt(40);
            aux = embaralhado.monte[i];
            embaralhado.monte[i] = embaralhado.monte[j];
            embaralhado.monte[j] = aux;
        }
    }
    public void Distribui(){
        for(int i=0;i<12;i++){
            jogador[i%4].mao[i%3] = embaralhado.monte[i];
        }
    }
    public int Menu(Jogadores p_jogador){
        System.out.println(p_jogador.getNome()+" Escolha");
        if(!p_jogador.mao[0].saiu)
            System.out.println("1 - "+p_jogador.mao[0].Nome );
        if(!p_jogador.mao[1].saiu)
            System.out.println("2 - "+p_jogador.mao[1].Nome );
        if(!p_jogador.mao[2].saiu)
            System.out.println("3 - "+p_jogador.mao[2].Nome );
        if(!p_jogador.getTruco()){
            System.out.println("4 - TRUCO");
        }else if(!p_jogador.getSeis()){
            System.out.println("6 - SEIS");
        }else if(!p_jogador.getNove()){
            System.out.println("9 - NOVE");
        }else if(!p_jogador.getDoze()){
            System.out.println("12 - DOZE");
        }
       int op = ler.nextInt();
       while((op!=1)&&(op!=2)&&(op!=3)&&(op!=4)&&(op!=6)&&(op!=9)&&(op!=12)){
           return Menu(p_jogador);
        }
       if(op<4 && p_jogador.mao[op-1].saiu == true){
           System.out.println("Carta Invalida!");
           return Menu(p_jogador);
       }
       return op;
    }
    
    public Carta Jogar(Jogadores[] p_jogador,int pri){
       int op = Menu(p_jogador[pri]);
       switch(op){
            case 1: {p_jogador[pri].mao[0].saiu = true; return p_jogador[pri].mao[0];}
            case 2: {p_jogador[pri].mao[1].saiu = true; return p_jogador[pri].mao[1];}
            case 3: {p_jogador[pri].mao[2].saiu = true; return p_jogador[pri].mao[2];}
            case 4: {
                int Truco = Truco(p_jogador,pri);
                    if(Truco==1){
                       return Jogar(p_jogador,pri);
                    }else{
                        return embaralhado.monte[40];
                    }
            }
            case 6: {
                int Seis = Seis(p_jogador,pri);
                if(Seis==1){
                    return Jogar(p_jogador,pri);
                }else{
                    return embaralhado.monte[40];
                }  
            }
            case 9: {
                int Nove = Nove(p_jogador,pri);
                if(Nove==1){
                    return Jogar(p_jogador,pri);
                }else{
                    return embaralhado.monte[40];
                }
            }
            case 12: {
                int Doze = Doze(p_jogador,pri);
                if(Doze==1){
                    return Jogar(p_jogador,pri);
                }else{
                    return embaralhado.monte[40];
                }
            }
            default : return null;
       }
    }
    
    public int Truco(Jogadores[] p_jogador,int pri){
        System.out.println("TRUCO!!");
        System.out.println(p_jogador[(pri+1)%4].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
        int acc = ler.nextInt();
        while(acc!=1 && acc!=0){
            System.out.println(p_jogador[(pri+1)%4].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
            acc = ler.nextInt();
        }
        if(acc==1){
            this.tento = 4;
            for(int t=0;t<4;t++){
                p_jogador[(pri+t)%4].setTruco();
                if(t%2==0){
                    p_jogador[(pri+t)%4].setSeis();
                    p_jogador[(pri+t)%4].setNove();
                    p_jogador[(pri+t)%4].setDoze();
                }
            }
        }
        return acc;
    }
    public int Seis(Jogadores[] p_jogador,int pri){
        System.out.println("SEIS!!");
        System.out.println(p_jogador[(pri+1)%4].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
        int acc = ler.nextInt();
        while(acc!=1 && acc!=0){
            System.out.println(p_jogador[pri+1].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
            acc = ler.nextInt();
        }
        if(acc==1){
            this.tento = 8;
            for(int t=0;t<4;t++){
                if(t%2==0){
                    p_jogador[(pri+t)%4].setSeis();
                    p_jogador[(pri+t)%4].setNove();
                    p_jogador[(pri+t)%4].setDoze();
                }else{
                    p_jogador[(pri+t)%4].offNove();
                }
            }
        }
        return acc;
    }
    public int Nove(Jogadores[] p_jogador,int pri){
        System.out.println("NOVE!!");
        System.out.println(p_jogador[(pri+1)%4].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
        int acc = ler.nextInt();
        while(acc!=1 && acc!=0){
            System.out.println(p_jogador[pri+1].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
            acc = ler.nextInt();
        }
        if(acc==1){
            this.tento = 10;
            for(int t=0;t<4;t++){
                if(t%2==0){
                    p_jogador[(pri+t)%4].setNove();
                }else{
                    p_jogador[(pri+t)%4].offDoze();
                }
            }
                
        }
            
        return acc;
    }
    public int Doze(Jogadores[] p_jogador,int pri){
        System.out.println("DOZE!!");
        System.out.println(p_jogador[(pri+1)%4].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
        int acc = ler.nextInt();
        while(acc!=1 && acc!=0){
            System.out.println(p_jogador[pri+1].getNome()+ "Voce aceita?\n 1-SIM  0-CORRER");
            acc = ler.nextInt();
        }
        if(acc==1){
            this.tento = 12;
            for(int t=0;t<4;t+=2)
                p_jogador[(pri+t)%4].setDoze();
        } 
        return acc;
    }
    public int getTento(){
        return tento;
    }
    
    public int TestaMao(Carta[] ds, Jogadores[] jogador,int un) {
        int maior=0;int igual=0;
        for(int i=1;i<4;i++){
            if((ds[i].valor)==(ds[maior].valor)&&((i-maior)!=2))
                igual=i;
            if ((ds[i].valor)>(ds[maior].valor))
                maior=i;
        }
        if((ds[maior].valor > ds[igual].valor)||maior==igual){
            jogador[(maior+un)%4].setpoint();
            System.out.println(jogador[(maior+un)%4].getNome()+" fez");
        }else if((ds[maior].valor == ds[igual].valor)&& maior!=igual){
            jogador[(maior+un)%4].setpoint();
            jogador[(igual+un)%4].setpoint();
            System.out.println("AMARROU");
        }
        return (maior+un);
    }
    
    public boolean testeVitoria(Dupla p_dupla){
        return p_dupla.getPlacar() > 10;
    }
    
    public void zeraTento(){
        for (int z=0;z<4;z++){
            this.jogador[z].zerapoint();
            this.jogador[z].zeraTruco();
        }
        this.tento = 2;
        if((d1.getPlacar()==10)||(d2.getPlacar()==10)){
            this.tento = 4;
        }
    }
}
