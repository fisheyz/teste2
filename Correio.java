import java.util.*;
import java.io.*;

class Correio{

	public static void main(String args[]){
		Scanner stdin = new Scanner(System.in);


		int n = stdin.nextInt();
		int c = stdin.nextInt();
		int vec[] = new int[n];
		boolean sum[] = new boolean[c+1];
		sum[0] = true;
		for(int i=1; i<=c; i++)
			sum[i] = false;

		for(int i=0; i<n; i++)
			vec[i]=stdin.nextInt();

		for(int i=0; i<n;i++)
			for(int j=c; j>=vec[i]; j--)
				if(sum[j-vec[i]] == true)
					sum[j] = true;

		int h;

		for(h=c; h>=0; h--)
			if(sum[h] == true)
				break;

		System.out.println(h);

	}
}
