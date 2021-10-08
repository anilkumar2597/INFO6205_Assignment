package edu.neu.coe.info6205.union_find;

import java.util.Arrays;
import java.util.Random;

public class HWQUPC_Solution {
	
	public static int count(int N) {
		
		UF find = new UF_HWQUPC(N);
		int count =0;
		
		Random random = new Random();
		while(find.components()>1) {
			int m = random.nextInt(N);
			int n = random.nextInt(N);
			
			find.connect(m, n);
			count++;
			
			System.out.println(m+"  "+n);
					
		}
		return count;
		
	}
	
	
	
	public static void main(String[ ] args) {
		int N = Integer.parseInt(args[0]);
		
		if(args.length>0) {
			int no_of_connections = count(N);
			System.out.println("No of Objects " +args[0] +"\nNo of Connections" +no_of_connections);
		}
	}
}
