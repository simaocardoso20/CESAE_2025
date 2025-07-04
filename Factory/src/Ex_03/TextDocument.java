package Ex_03;

public class TextDocument extends Document {

    public TextDocument(String autor, String nome, String extensao) {
        super("autor", "nome", ".docx");
    }

    @Override
    public void open(){

        System.out.println("A abrir o documento de Texto "+getNome()+getExtensao());
    }

    @Override
    public void save(){

        System.out.println("Alterações do "+getAutor()+" gravadas.");
    }

    @Override
    public void close(){

        System.out.println("A fechar o documento de Texto");
    }

}
