package infrastructure.util;

public class ValidarStrings {

    public static final String VALOR_NAO_INFORMADO = "NÂO INFORMADO";

    public static boolean verificarCaracteresEspeciais(String texto){
        if (texto == null){
            return false;
        }
        return !texto.matches("^[\\p{L}\\s]+$");
    }

    public static String formatarValorNaoInformado(Object object, String valor){
        if (object == null) {
            return valor;
        }
        return object.toString();
    }
}
