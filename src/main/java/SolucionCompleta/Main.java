/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SolucionCompleta;

/**
 *
 * @author NEIDER
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Lectura de datos de entrada
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los elementos de la matriz, separados por espacios:");
        String[] numsStr = sc.nextLine().split(" ");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        sc.close();

        // Solución del problema
        int[] sortedNums = sortByFrequency(nums);

        // Imprimir resultado
        System.out.println("Matriz ordenada:");
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] sortByFrequency(int[] nums) {
        // Contar la frecuencia de cada número

         Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // define una función de comparación personalizada
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (!freq.get(num1).equals(freq.get(num2))) {
                    return freq.get(num1) - freq.get(num2);
                } else {
                    return num2 - num1;
                }
            }
        };
        
        // ordena los valores de la matriz utilizando la función de comparación personalizada
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }
        Arrays.sort(numsObj, comp);
        
        // convierte los valores ordenados a una matriz primitiva
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }
        
        return nums;
    } 
}

