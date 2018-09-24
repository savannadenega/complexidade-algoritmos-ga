import java.util.ArrayList;
import java.util.List;

public class ContandoCasinhas {

    int totalAntes = 1;
    int contadorTotalAntes = 2;

    int numCasa = 2;

    int totalDepois = numCasa + 1;
    int contadorTotalDepois = totalDepois + 1;

    List<int[]> chavesEncontradas = new ArrayList<int[]>();

    public void execucao(){

        //chavesEncontradas.add(new int[]{6,8});

        while(chavesEncontradas.size() < 2){

                totalAntes = totalAntes + contadorTotalAntes;
                contadorTotalAntes++;
                numCasa++;
                contadorTotalDepois = numCasa + 2;
                totalDepois = numCasa + 1 + contadorTotalDepois;

                //contadorTotalDepois = totalDepois + 1;
                while(totalAntes > totalDepois) {

                    totalDepois = totalDepois + contadorTotalDepois;
                    contadorTotalDepois = contadorTotalDepois + 1;

                }

                if (totalAntes == totalDepois) {

                    chavesEncontradas.add(new int[]{numCasa, contadorTotalDepois});
                }

        }

        print();

    }

    public void print(){

        for(int i = 0; i < chavesEncontradas.size(); i++) {
            System.out.println("[" + chavesEncontradas.get(i)[0] + "," + chavesEncontradas.get(i)[1] + "]");
        }
    }

    public static void main(String args[]){

        ContandoCasinhas c = new ContandoCasinhas();

        c.execucao();

    }

}
