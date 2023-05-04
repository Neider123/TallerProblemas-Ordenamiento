/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaordenamiento;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author NEIDER
 */
public class Solution {
    
     public int[] frequencySort(int[] nums) {
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
