package truco;
public class Dupla {
    private int placar;
    
    private boolean Truco;
    private boolean Seis;
    private boolean Nove;
    private boolean Doze;
    
    protected Jogadores j1;
    protected Jogadores j2;
    
    public boolean getTruco(){
        return Truco;
    }
    public void setTruco(){
        Truco = true;
    }
    public void offTruco(){
        Truco = false;
    }
    public void offSeis(){
        Seis = false;
    }
    public void offNove(){
        Nove = false;
    }
    public void offDoze(){
        Doze = false;
    }
    public void setSeis(){
        Seis = true;
    }
    public void setNove(){
        Nove = true;
    }
    public void setDoze(){
        Doze = true;
    }
    public boolean getSeis(){
        return Seis;
    }
    public boolean getNove(){
        return Nove;
    }
    public boolean getDoze(){
        return Doze;
    }
    public Dupla(Jogadores j1, Jogadores j2){
        this.j1 = j1;
        this.j2 = j2;
    }
    public int getpoint(){
        return j1.getpoint()+j2.getpoint();
    }
    protected Dupla(){
    }
    public int getPlacar(){
        return placar;
    }
    public void recebetento(int tento){
        this.placar+=tento;
    }
    public boolean pTruco(){
       return Truco;
    }
    public void zeraTruco(){
       Truco = false;
       Seis = false;
       Nove = false;
       Doze = false;
   }
}
