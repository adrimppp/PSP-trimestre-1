import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder= new ProcessBuilder("cmd", "/c", "dir", "/z");
        Process process=processBuilder.start();
        int numSalida=process.waitFor();
        if(numSalida!=0){
            System.out.println("Salida: "+numSalida);
            //guardar error en error.log()
            anadirError(process);
        }
    }
    private static void anadirError(Process process) throws IOException {
        //pasa la cadena del error
        BufferedReader br=new BufferedReader(new InputStreamReader(process.getErrorStream(), "CP850"));
        //escribir la cadena
        File file=new File("error.txt");
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        String line;
        while((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            System.out.println(line);
        }
        bw.close();
        fw.close();

    }
}