package Ex_03;

public class PresentationDocument extends Document{

    public PresentationDocument(String autor, String nome, String extensao) {
        super("autor", "nome", ".pptx");
    }

    @Override
    public void open(){

        System.out.println("A abrir o documento de Apresentação "+getNome()+getExtensao());
    }

    @Override
    public void save(){

        System.out.println("Alterações do "+getAutor()+" gravadas.");
    }

    @Override
    public void close(){

        System.out.println("A fechar o documento de Apresentação");
    }

}
