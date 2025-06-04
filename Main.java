import infaestructure.util.ValidacoesScanner;
import ui.MenuPrincipal;

public class Main{
    public static void main(String[] args) {
        ValidacoesScanner validacoesScanner = new ValidacoesScanner();
        MenuPrincipal menuPrincipal = new MenuPrincipal(validacoesScanner);
        menuPrincipal.selecionarOpcaoNoMenu();
    }
}