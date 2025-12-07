import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validador {
    
    // Verifica se a data existe no calendário (ex: impede 30/02)
    public static boolean isDataValida(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // ISSO É O SEGREDO: Não aceita datas "imaginárias"
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    // Verifica se o usuário selecionou o item inválido da combo
    public static boolean isComboValida(String valorSelecionado) {
        return valorSelecionado != null && !valorSelecionado.equals("Selecione...");
    }
}
