package truco;
public class Carta {
    protected int valor;
    protected String Nome;
    protected boolean saiu;
    
    public Carta(int p_valor,String p_Nome){
        this.Nome = p_Nome;
        this.valor = p_valor;
    }
    public Carta(){   
    }
}
