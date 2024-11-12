import java.util.ArrayList;

public class Fabrica {
    private static ArrayList<String> listaNombres=new ArrayList<>();
    private static ArrayList<Infante> listaInfantes=new ArrayList<>();
    private static Bombo bombo=new Bombo();
    private static Combinacion combinacion=new Combinacion();
    public Fabrica() {
        crearInfantes();
    }
    public static void crearInfantes(){
        llenarListaNombres();
        for(int i=0;i<listaNombres.size();i++){
            Infante infante=new Infante(listaNombres.get(i),bombo,combinacion);
            listaInfantes.add(infante);
        }
    }
    public static void llenarListaNombres(){
        listaNombres.add("Amanda");
        listaNombres.add("Beatriz");
        listaNombres.add("Carlos");
        listaNombres.add("Dani");
        listaNombres.add("Eduardo");
    }

    public static ArrayList<String> getListaNombres() {
        return listaNombres;
    }

    public static void setListaNombres(ArrayList<String> listaNombres) {
        Fabrica.listaNombres = listaNombres;
    }

    public static ArrayList<Infante> getListaInfantes() {
        return listaInfantes;
    }

    public static void setListaInfantes(ArrayList<Infante> listaInfantes) {
        Fabrica.listaInfantes = listaInfantes;
    }
}
