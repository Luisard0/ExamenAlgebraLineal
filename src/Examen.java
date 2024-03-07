public class Examen {
    //Crea una matriz sin las fila a ni la columna b
    static void matrizInterna(double matriz[][], double temp[][], int a, int b, int n) {
        //matriz[][] --->> Es la matriz actual.
        //temp[][] ----->> Es la matriz auxiliar, sin la fila a ni columna b
        int i = 0, j = 0;
        //
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {

                if (fila != a && columna != b) {
                    temp[i][j++] = matriz[fila][columna];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    //Calcula la matriz inversa de una matriz cuadrada dada
    static double[][] matrizInversa(double matriz[][]) {
        // matriz -->> Matriz a calcular su inversa
        int n = matriz.length;
        //Calcula el determinante de la matriz
        double determinante = determinanteMatriz(matriz, n);
        //Si el determinante es 0 la matriz no tiene inversa
        if (determinante == 0) {
            System.out.println("La matriz no tiene inversa.");
            return null;
        }

        double[][] inversa = new double[n][n];
        double[][] temp = new double[n - 1][n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizInterna(matriz, temp, i, j, n);
                //Calcula el cofactor utilizando el determinante de la sumatriz y su posición en la matriz
                double cofactor = Math.pow(-1, i + j) * determinanteMatriz(temp, n - 1);
                inversa[j][i] = cofactor / determinante;
            }
        }
        return inversa;
    }

    //Método que calcula el determinante de la matriz, retorna un número double
    static double determinanteMatriz(double matriz[][], int n) {
        //matriz -->> Matriz a la cual se le va a calcular el determinante
        //n --->> dimención de la matriz
        double determinante = 0;
        //si solo tiene una dimención se retorna el primer y unico valor
        //Caso base
        if (n == 1) {
            return matriz[0][0];
        }
        double[][] temp = new double[n - 1][n - 1];
        //Determina si es positivo o negativo
        double multiplicador = 1;
        //Recursividad
        for (int f = 0; f < n; f++) {
            matrizInterna(matriz, temp, 0, f, n);
            //Se acumula la suma de cada submatriz
            determinante += multiplicador * matriz[0][f] * determinanteMatriz(temp, n - 1);
            multiplicador = -1 * multiplicador;
        }
        return determinante;
    }
    //Metodo que imprime la matríz
    static void imprimirMatriz(double[][] matriz) {
        //Recorre cada espacio de la matríz y lo imprime
        for (double[] fila : matriz) {
            for (double elemento : fila) {
                System.out.print("["+elemento + "] ");
            }
            System.out.println();
        }
    }
}