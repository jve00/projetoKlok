package Excercoes;

public class SegundosInvalidosExceptions extends Exception{

    public SegundosInvalidosExceptions(String msg){
        super(msg);

    }
    public SegundosInvalidosExceptions(){
        super("Erro ao contar os segundos");
    }
}
