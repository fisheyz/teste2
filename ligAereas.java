//Codigo feito por Andre Gouveia, Ruben Ferreira, Tiago Mateus

import java.io.*;
import java.util.*;

class ligAereas{
    static int n;

    //calcular as transitividades
    static void floydwarshall(int[][] ligacoes){
	for(int k=0; k<n; k++)
	    for(int i=0; i<n; i++)
	  	for(int j=0; j<n; j++)
		    if(ligacoes[i][k]==1 && ligacoes[k][j]==1)
			ligacoes[i][j]=1;
    }

    public static void main(String args[]){
	Scanner stdin = new Scanner(System.in);

	n = stdin.nextInt();
	int[][] ligacoes = new int[n][n];
	String linha=stdin.nextLine();

	//preencher a matriz a 1 quando i==j
	for(int i=0; i<n; i++)
	    for(int j=0; j<n; j++)
		if(i==j)
		    ligacoes[i][j]=1;

	//leitura da linha
	for(int i=0; i<n ;i++){

	    linha=stdin.nextLine();
	    String [] results = linha.split(" ");


	    char origem = results[0].charAt(0);
	    int n_ligacoes = Integer.parseInt(results[1]);

	    //leitura do resto da string
	    for(int j=2; j<results.length ;j++){
		char destino = results[j].charAt(0);
		//System.out.println(destino);
		ligacoes[(int)origem-65][(int)destino-65]=1;
	    }
	}

	floydwarshall(ligacoes);

	//print da matriz
	System.out.print("  ");
	for(int i=0; i<n; i++){
	    if(i==n-1)
		System.out.print((char)(i+65));
	    else
		System.out.print((char)(i+65)+" ");
	}
	 System.out.println();

	for(int i=0; i<n; i++){
	    System.out.print((char)(i+65)+" ");
	    for(int j=0; j<n; j++)
		if(j==n-1)
		    System.out.print(ligacoes[i][j]);
		else
		    System.out.print(ligacoes[i][j]+" ");
	    System.out.println();
	    }
    }
}
