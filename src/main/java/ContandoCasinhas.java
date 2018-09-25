import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContandoCasinhas {

    BigInteger totalAntes = new BigInteger("1");
    BigInteger contadorTotalAntes = new BigInteger ("2");

    BigInteger numCasa = new BigInteger("2");

    BigInteger totalDepois = new BigInteger ("3");
    BigInteger contadorTotalDepois = new BigInteger ("4");

    List<BigInteger[]> chavesEncontradas = new ArrayList<BigInteger[]>();

    BigInteger valor1 = new BigInteger ("1");
    BigInteger valor2 = new BigInteger ("2");
    BigInteger resultadoArray = new BigInteger ("0");

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss,SSS");
    int contadorNumeros = 1;

    public void executarAlgoritmoContandoCasinhas() {


        System.out.println("Horário inicial execução ["+ contadorNumeros +"]: " + sdf.format(new Date()) + "\n\n");

        while(chavesEncontradas.size() < 5) {

            if (totalAntes.compareTo(totalDepois) == 0) {

                resultadoArray = contadorTotalDepois.subtract(valor1);
                chavesEncontradas.add(new BigInteger[]{numCasa, resultadoArray});

                System.out.println("Horário final execução ["+ contadorNumeros +"]: " + sdf.format(new Date()) + "\n");
                contadorNumeros++;

            }


            totalAntes = totalAntes.add(contadorTotalAntes);
            contadorTotalAntes = contadorTotalAntes.add(valor1);
            numCasa = numCasa.add(valor1);

            contadorTotalDepois = numCasa;
            contadorTotalDepois = contadorTotalDepois.add(valor2);

            totalDepois = numCasa;
            totalDepois = totalDepois.add(valor1);


            while (totalAntes.compareTo(totalDepois) == 1) {

                totalDepois = totalDepois.add(contadorTotalDepois);
                contadorTotalDepois = contadorTotalDepois.add(valor1);

            }

        }

        print();

    }

    public void print() {

        for (int i = 0; i < chavesEncontradas.size(); i++) {
            System.out.println("[" + chavesEncontradas.get(i)[0].toString() + "," + chavesEncontradas.get(i)[1].toString() + "]");
        }
    }

    public static void main(String args[]) {

        ContandoCasinhas c = new ContandoCasinhas();

        c.executarAlgoritmoContandoCasinhas();

    }

}
