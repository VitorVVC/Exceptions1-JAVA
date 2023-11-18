package Model.Exceptions;

// Pode ser extens RuntimeException || Exception.
// Diferença = RunTime não somos obrigados a propagar o erro se não precisarmos trata-lo com throws DomainException
// Enquanto em exception somos
public class DomainException extends RuntimeException{
    public DomainException(String msg){
        super(msg);
    }


}
