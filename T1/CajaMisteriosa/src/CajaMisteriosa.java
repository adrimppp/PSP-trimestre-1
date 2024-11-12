public class CajaMisteriosa {
    private Regalo regalo;

    public CajaMisteriosa() {
    }

    public Regalo getRegalo() {
        return regalo;
    }

    public void setRegalo(Regalo regalo) {
        this.regalo = regalo;
    }

    public void dejarRegalo(Regalo regalo) {
        setRegalo(regalo);
        System.out.println("Se ha dejado el regalo "+ regalo.getNombre());
    }
    public Regalo cogerRegalo() {
        Regalo regaloAcoger=getRegalo();
        setRegalo(null);
        System.out.println("Se ha cogido el regalo "+ regaloAcoger.getNombre());
        return regaloAcoger;
    }

    public boolean estaVacia(){
        if (getRegalo() == null){
            return true;
        }
        return false;
    }

}
