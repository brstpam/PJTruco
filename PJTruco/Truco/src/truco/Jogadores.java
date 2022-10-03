package truco;
public class Jogadores extends Dupla{
   
   protected Carta [] mao = new Carta[3];
   private int point1;
   private String nome;
   
   public void setNome(String p_nome){
       this.nome = p_nome;
   }
   public String getNome(){
       return nome;
   }
   public Jogadores (){
       for (int i=0;i<3;i++){
           mao[i] = new Carta();
       }
   }
   @Override
   public int getpoint(){
       return point1;
   }
   public void setpoint(){
       point1++;
   }
   public void zerapoint(){
       point1 = 0;
   }
   public void correram(){
       point1+=2;
   }
}
