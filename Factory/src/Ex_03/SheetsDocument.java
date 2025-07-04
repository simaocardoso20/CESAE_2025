package Ex_03;

public class SheetsDocument extends Document{

    public SheetsDocument(String autor, String nome, String extensao) {
        super("autor", "nome", ".xlsx");
    }

    @Override
    public void open(){

        System.out.println("A abrir o documento de Cálculo "+getNome()+getExtensao());
    }

    @Override
    public void save(){

        System.out.println("Alterações do "+getAutor()+" gravadas.");
    }

    @Override
    public void close(){

        System.out.println("A fechar o documento de Cálculo");
    }

}
