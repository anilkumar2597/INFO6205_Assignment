package edu.neu.coe.info6205;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import java.util.Random;
import java.util.Arrays;
import java.util.function.Supplier;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;


public class BenchMarkInsertSort {


    private static Config config;
    public static Integer[] Array_Random(int N){


        Random rand = new Random();
        Integer[] array_random = new Integer[N];
        
        for(int i = 0; i<N;i++){
            array_random[i] = rand.nextInt(N);
        }
        
        
        return array_random;
        
    }
    
    
    public static Integer[] Array_Sorted(int N){

        Integer[] array_sort = new Integer[N];
        
        for(int i = 1; i<=N;i++){
            array_sort[i-1] = i;
        }
        
        
        return array_sort;
    }

    
   
    public static Integer[] Array_Partial_Sorted(int N){


        Random rand = new Random();
        
        Integer[] array_partial = new Integer[N];
        
        for (int i = 0; i<N/2; i++){
            array_partial[i] = i;
        }

        for (int i = N/2; i<N; i++){

            array_partial[i] =  rand.nextInt(N) + N/2;
        }

        
        
        return array_partial;
    }
    public static Integer[] Array_Reverse(int N){

        
    	Integer[] array_reverse = new Integer[N];
        
    	for(int i = 0; i<N;i++){
            
    		array_reverse[i] = N-i;
        }
        
        
        return array_reverse;
    }
    
    
    public static void BenchMark(int N, String description, Supplier<Integer[]> supplier){

        Helper<Integer> help = new BaseHelper<>(description, N, config);
        final GenericSort<Integer> sorted = new InsertionSort<>(help);
        final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                description ,
                (xs) -> Arrays.copyOf(xs, xs.length),
                sorted::sort,
                null

        );
        System.out.println(benchmark.runFromSupplier(supplier, 5)+  " ms");
    }


    
    
    public static void main(String[] args) {


           for(int i = 1000; i<= 32000; i=i*2) {
           
           
           int Number = i;

            String Result = "Insertion sort for random array of size: " + Number;
            
            Supplier<Integer[]> supplier_array = () -> Array_Random(Number);
            
            BenchMark(Number, Result , supplier_array);

            
            Result = "Insertion sort for sorted array of size: " + Number;
            
            supplier_array = () -> Array_Sorted(Number);
            
            BenchMark(Number, Result , supplier_array);

            
            
            Result = "Insertion sort for partial sorted array of size: " + Number;
            
            supplier_array = () -> Array_Partial_Sorted(Number);
            
            BenchMark(Number, Result, supplier_array);

            Result = "Insertion sort for reverse sorted array of size: " + Number;
            
            supplier_array = () -> Array_Reverse(Number);
            
            BenchMark(Number, Result, supplier_array);

           }


    }



}