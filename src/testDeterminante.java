public class testDeterminante {
    public static void main(String[] arg){

        // Matriz del examen
        double matrix[][] = {{1,3,4,2,1,5,7,4},
                            {2,4,3,5,7,1,8,2},
                            {-4,2,-1,8,2,-1,4,2},
                            {-2,-1,1,2,4,3,2,8},
                            {7,4,1,8,3,-2,1,4},
                            {1,4,-1,3,2,8,4,3},
                            {-1,5,4,3,-2,8,3,-1},
                            {1,-4,3,2,1,-1,3,4}};

        //Determinante de la matriz
        System.out.println("Determinante de la matriz:\t " + Examen.determinanteMatriz(matrix, 8));
        //Inversa de la matriz
        System.out.println("\nInversa de la matriz: \n");
        Examen.imprimirMatriz(Examen.matrizInversa(matrix));

    }
}
