import java.util.Random;

public class Generala {
    public static void  main(String []args){
        int dados[] = new int[5];
        Random random = new Random();

        for (int i=0; i<5; i++){
            dados[i]= random.nextInt(6)+1;
        }

        for (int i=0; i<5; i++){
            System.out.printf(dados[i]+" - ");
        }

        if (generala(dados)){
            System.out.printf("\nLa jugada es GENERALA");
        } else if (poker(dados)) {
            System.out.printf("\nLa jugada es POKER");
        }else if (full(dados)){
            System.out.printf("\nLa jugada es FULL");
        } else if (escalera(dados)) {
            System.out.printf("\nLa jugada es ESCALERA");
        }else {
            System.out.printf("\nNo existe ninguna combinacion");
        }

    }

    public static boolean generala(int[] dados){
        for (int i=0; i< dados.length-1; i++){
            if (dados[0] != dados[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean poker(int[] dados){
       for (int i=0; i< dados.length;i++){
           int contador =0;
           for (int j=0; j<dados.length; j++){
               if(dados[i]==dados[j]){
                   contador++;
               }
           }
           if (contador == 4){
               return true;
           }
       }
       return false;

    }

    public static boolean full(int [] dados) {
        int contadorPrimerValor = 1,contadorSegundoValor = 0,segundoValor=0;

        for (int i = 1; i < dados.length; i++) {
            if (dados[0] == dados[i]) {
                contadorPrimerValor++;
            }
        }
        if (contadorPrimerValor == 3 || contadorPrimerValor == 2) {
            for (int i = 1; i < dados.length; i++) {
                if (dados[0] != dados[i]) {
                    segundoValor = dados[i];
                    break;
                }
            }
        }
        for (int i=1; i< dados.length; i++){
            if (segundoValor == dados[i]) {
                contadorSegundoValor++;
            }
        }

        if (contadorPrimerValor + contadorSegundoValor != 5) {
            return false;
        }
        return true;
    }

    public static boolean escalera(int[] dados){
        int contador=1;
        for (int i=0; i< dados.length-1; i++) {
            if (dados[i] < dados[i + 1]) {
                contador++;
            }
        }
        if (dados[3] == 6 && dados[4] == 1){
            contador++;
        }
        if (contador != 5){
            return false;
        }
        return true;
    }
}





