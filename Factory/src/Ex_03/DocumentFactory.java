package Ex_03;

public class DocumentFactory {

    public static Document createDocument(String tipo, String nome, String autor){

        switch (tipo) {

            case "TEXTO":
                return new TextDocument(tipo, nome, autor);

            case "CALCULO":
                return new SheetsDocument(tipo, nome, autor);

            case "PRESENTATION":
                return new PresentationDocument(tipo, nome, autor);

            default:
                throw new IllegalArgumentException("Tipo de documento inválido: " + tipo);

        }
    }
}
