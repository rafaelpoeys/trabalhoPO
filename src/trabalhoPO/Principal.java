package trabalhoPO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Principal {

	public static void main(String[] args) {
		
		InputStreamReader isr = null;
		
		//double t1 = System.currentTimeMillis(); //inicia a contagem do tempo
		 
		
		       //-------------------------------BLOCO DE LEITURA DE ARQUIVO---------------------------------------
		
			try {
				                                      //carrega o arquivo de 500 multas aleatórias
				InputStream is = new FileInputStream("base_prof/multa500alea.txt");
				
				isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				Multa[] vetM = new Multa[500]; //Cria um vetor do tipo multa, para armazenar as multas.
				
				
				String b; // = br.readLine();      //Lê a Primeira Linha do arquivo				
				String[] s; // = b.split(";");     //Separa os dados divididos pelo ";"
				
				
				for(int i=0; i<500;i++) {    //armazena os dados de cada multa em um vetor
					b = br.readLine();
					s = b.split(";");
					vetM[i] = new Multa(s[0],s[1],s[2],s[3],s[4]);
				}
				
				br.close();
				isr.close();
				
				//-----------------------FIM BLOCO DE LEITURA DE ARQUIVO-------------------------------------------
				
				
				
				//heapSort(vetM,500); //ordena o vetor vetM com o método heapSort
				//quicksort(vetM,500);
				quickInsercao(vetM,500);
				
				
				
				//--------------------BLOCO PARA ESCREVER GRAVAR(ESCREVER) UM NOVO ARQUIVO--------------------------
				
				OutputStream os = new FileOutputStream("base_aluno/ordenado500.txt");
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
		  
				//--------------adptar ao código que for ordenado e usar para gravar o novo arquivo depois que 
				//--------------terminar de ordenar.
				
				int c = 0;
				while(c<500) {
							         //escreve em uma linha corrida.
					bw.write((c+1)+" "+vetM[c].getPlaca()+";"+vetM[c].getNome()+";"+vetM[c].getEndereco()+";"+vetM[c].getData()+";"+vetM[c].getHora());
					
					bw.newLine();   //cria uma nova linha para escrever um novo registro.
					c++;
				}
				
				bw.close(); 	
				
				
				//------------------------------FIM BLOCO ESCREVER(GRAVAR) NOVO ARQUIVO-----------------------------------
				
					
				/**------------------------LÊ AS PLACAS-------------------------------------------*/					
				is = new FileInputStream("base_prof/placas.txt");
				isr = new InputStreamReader(is);
			    br = new BufferedReader(isr);
				
				String[] placas = new String[400];   //cria um vetor para armazenar as placas
				
				
				for(int i=0; i<400; i++) {
				
					placas[i]=br.readLine();         //armazena as placas no vetor placas
			
					//System.out.println(placas[i]);
				}
				
				isr.close();

				
				//CRIAR UM LOOP AQUI PARA LER CADA PLACA QUE FOI ARMAZENADA NO VETOR PLACAS. LOGO DEPOIS OU SIMULTANEO,
				//CADA INDICE DO VETOR SER ENTRADA NO MÉTODO PESQUISA BINARIA
				os = new FileOutputStream("base_aluno/placasMultadas500.txt");
				osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				
				for (int i=0; i<400; i++) {
					bw.write(pesqBinaria(placas[i],vetM,500));
					bw.newLine();
				}
				
				bw.close();
								
				//depois da pesquisa binaria precisa dar split no resultado e exibir
				// placa x tem y multas  endereço        hora
				//                       avenida tal	   10:50		
				
				
				//E AQUI GRAVAR(ESCREVER) UM NOVO ARQUIVO TEXTO COM O RESULTADO
				
				//System.out.println(t1);
			
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
	}
	
/**---------------------------METODO HEAPSORT---------------------------*/
	public static void heapSort (Multa vetor[], int nElem) {
		int dir = nElem-1;
	    int esq = (dir-1)/2;
	    Multa temp;
		while (esq >= 0){
			refazHeap (esq, nElem-1,vetor);
		    esq--;
		}
		while (dir > 0){	
			temp = vetor[0];
			vetor [0] = vetor [dir];
		    vetor [dir] = temp;
		    dir--;
		    refazHeap(0, dir,vetor);
		}
	} 
	private static void refazHeap (int esq, int dir, Multa vetor[]){
		int i = esq;
		int mF = 2*i+1; // maior filho
		Multa raiz = vetor[i];
		boolean heap = false;
		String s[],t[]; //,u[];
		String a, b; //, c;
		
		while ((mF <= dir) && (!heap)) {
			 if ( mF < dir) {
				 if ( vetor[mF].getPlaca().compareTo(vetor[mF+1].getPlaca()) < 0 ) {
					 mF ++;
				 } else {
					 if ( vetor[mF].getPlaca().compareTo(vetor[mF+1].getPlaca()) == 0 ) {
					  	//split menor filho
						s = vetor[mF].getData().split("/");
						a = s[2]+s[1]+s[0];
						
						//split maior filho
						t = vetor[mF+1].getData().split("/");
						b = t[2]+t[1]+t[0];
					
						if (a.compareTo(b) < 0 ) {
							mF ++;
						} else {
							if (a.compareTo(b) == 0 ) {
								if (vetor[mF].getHora().compareTo(vetor[mF+1].getHora()) < 0 ) {
									mF ++;
								}
							}
						}
					 }
				 }
			 }
			 if (raiz.getPlaca().compareTo(vetor[mF].getPlaca()) < 0) {
				 vetor[i] = vetor[mF];
				 i = mF;
				 mF = 2*i+1;
			 } else {
				 if ( raiz.getPlaca().compareTo(vetor[mF].getPlaca()) == 0 ) {
				   	//split menor filho
					s = vetor[mF].getData().split("/");
					a = s[2]+s[1]+s[0];
					
					//split maior filho
					t = vetor[mF+1].getData().split("/");
					b = t[2]+t[1]+t[0];
				
					if (a.compareTo(b) < 0 ) {
						vetor[i] = vetor[mF];
						i = mF;
						mF = 2*i+1;
					} else {
						if (a.compareTo(b) == 0 ) {
							if (raiz.getHora().compareTo(vetor[mF].getHora()) < 0 ) {
								vetor[i] = vetor[mF];
								i = mF;
								mF = 2*i+1;
							}
						}
					}
				 } else { heap = true; }
			 }
			 vetor[i] = raiz;
		}
}
/**---------------------------FIM HEAPSORT---------------------------*/
/**---------------------------METODO PESQUISA BINARIA---------------------------*/
//se tiver a chave que voce procura ele retorna um numero positivo, se não vai retornar um numero negativo
	public static String pesqBinaria (String chave,Multa vetor[], int nElem) {
		int i,meio, esq, dir, contMulta=0;
		esq = 0;
		dir = nElem-1;
		String achei="";
		
		while (esq <= dir) {
			meio = (esq + dir)/2;
			
			if (chave.compareTo(vetor[meio].getPlaca()) == 0) {
				i=1;
				
				contMulta++;
				achei = vetor[meio].getPlaca()+" "+contMulta+";"+vetor[meio].getEndereco()+";"+vetor[meio].getHora();
				
				if(meio-i >= 0) {
					while(chave.compareTo(vetor[meio-i].getPlaca()) == 0) {
						contMulta++;
						achei=achei+" "+contMulta+";"+vetor[meio-i].getEndereco()+";"+vetor[meio-i].getHora()+";";
						i++;
					}
				}
				
				i=1;
				
				if(meio+i < vetor.length) {
					while(chave.compareTo(vetor[meio+i].getPlaca())==0) {
						contMulta++;
						achei=achei+contMulta+";"+vetor[meio+i].getEndereco()+";"+vetor[meio+i].getHora()+";";
						i++;
					}
				}
				return "PLACA "+achei+" "+"Total de Multas = "+contMulta;
			} else {
				if ( (chave.compareTo( vetor[meio].getPlaca())) < 0 ) {
					dir = meio - 1;
				} else {
					esq = meio + 1;
				}		
			}
		}
		return  "PLACA "+chave+" NAO POSSUI MULTA";
	}
/**---------------------------FIM PESQUISA BINARIA---------------------------*/
/**---------------------------METODO QUICKSORT---------------------------*/
	public static void quicksort (Multa Vetor[],int nElem) {
		ordena (0,nElem -1, Vetor);
	}
	private static void ordena (int esq, int dir,Multa vetor[]) {
		//String pivo;
		int i = esq, j = dir;
		Multa temp, pivo;
		pivo = vetor[(i+j)/2]; //.getPlaca();
		String s[],t[]; //,u[];
		String a, b; //, c;
		
		do {
			while (vetor[i].getPlaca().compareTo(pivo.getPlaca()) < 0) { i++; }
			
			if (vetor[i].getPlaca().compareTo(pivo.getPlaca()) == 0) {
				
				s = vetor[i].getData().split("/");
				a = s[2]+s[1]+s[0];
				
				//split maior filho
				t = pivo.getData().split("/");
				b = t[2]+t[1]+t[0];
			
				if (a.compareTo(b) < 0 ) {
					i++;
				} else {
					if (a.compareTo(b) == 0 ) {
						if (vetor[i].getHora().compareTo(pivo.getHora()) < 0 ) {
							i++;
						}
					}
				}
			}
			
			while (vetor[j].getPlaca().compareTo(pivo.getPlaca()) > 0) { j--; }
			
			if (vetor[j].getPlaca().compareTo(pivo.getPlaca()) == 0) {
				
				s = vetor[j].getData().split("/");
				a = s[2]+s[1]+s[0];
				
				//split maior filho
				t = pivo.getData().split("/");
				b = t[2]+t[1]+t[0];
			
				if (a.compareTo(b) > 0 ) {
					j--;
				} else {
					if (a.compareTo(b) == 0 ) {
						if (vetor[j].getHora().compareTo(pivo.getHora()) > 0 ) {
							j--;
						}
					}
				}
			}		
			if (i <= j) {
				temp = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j) { ordena (esq, j,vetor); }
		if (dir > i) { ordena (i, dir,vetor); }
	}
/**---------------------------FIM METODO QUICKSORT---------------------------*/
	
	public static void quickInsercao (Multa vetor[], int nElem) {
		quickInsercaoOrdena(0,nElem-1, vetor);
	}
	
	public static void quickInsercaoOrdena (int esq, int dir,Multa vetor[]) {
		int i = esq, j = dir;
		Multa temp, pivo;
		pivo = vetor[(i+j)/2]; //.getPlaca();
		String s[],t[]; //,u[];
		String a, b; //, c;
		
		int size = (dir+1) - esq;
		if (size <= 10) {
			//System.out.println("Rafael");
			insercaoDireta(vetor, size);
		} else { 	
			do {
				while (vetor[i].getPlaca().compareTo(pivo.getPlaca()) < 0) { i++; }
				
				if (vetor[i].getPlaca().compareTo(pivo.getPlaca()) == 0) {
					
					s = vetor[i].getData().split("/");
					a = s[2]+s[1]+s[0];
					
					//split maior filho
					t = pivo.getData().split("/");
					b = t[2]+t[1]+t[0];
				
					if (a.compareTo(b) < 0 ) {
						i++;
					} else {
						if (a.compareTo(b) == 0 ) {
							if (vetor[i].getHora().compareTo(pivo.getHora()) < 0 ) {
								i++;
							}
						}
					}
				}
				
				while (vetor[j].getPlaca().compareTo(pivo.getPlaca()) > 0) { j--; }
				
				if (vetor[j].getPlaca().compareTo(pivo.getPlaca()) == 0) {
					
					s = vetor[j].getData().split("/");
					a = s[2]+s[1]+s[0];
					
					//split maior filho
					t = pivo.getData().split("/");
					b = t[2]+t[1]+t[0];
				
					if (a.compareTo(b) > 0 ) {
						j--;
					} else {
						if (a.compareTo(b) == 0 ) {
							if (vetor[j].getHora().compareTo(pivo.getHora()) > 0 ) {
								j--;
							}
						}
					}
				}		
				if (i <= j) {
					temp = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			if (esq < j) { quickInsercaoOrdena (esq, j,vetor); }
			if (dir > i) { quickInsercaoOrdena (i, dir,vetor); }
		 }
	}
/**---------------------------METODO INSERÇÃO DIRETA---------------------------*/
	public static void insercaoDireta(Multa vetor[], int nElem) {
		int i, j;
		Multa temp;
		//String s[],t[]; //,u[];
		//String a, b; //, c;
		//boolean fim=true;
		
		for (i=1; i < nElem; i++) {
			temp = vetor[i];
			j = i-1;
			while ( (j >= 0) && ( vetor[j].getPlaca().compareTo(temp.getPlaca()) > 0) ) {
				vetor [j+1] = vetor[j];
				j--;
			} /*
			while ((fim) && ( j >= 0 ) && (vetor[j].getPlaca().compareTo(temp.getPlaca()) == 0)) {
				// if (vetor[j].getData().compareTo(temp.getData))
				s = vetor[j].getData().split("/");
				a = s[2]+s[1]+s[0];

				//split maior filho
				t = temp.getData().split("/");
				b = t[2]+t[1]+t[0];
				
				if (a.compareTo(b) > 0 ) {
					vetor [j+1] = vetor[j];
					j--;
				} else {
					if (a.compareTo(b) == 0 ) {
						if (vetor[j].getHora().compareTo(temp.getHora()) > 0 ) {
							vetor [j+1] = vetor[j];
							j--;
						} else { fim=false; }
					} else { fim=false; }
				}
			} */
		 vetor [j+1] = temp;
		 }
	}
/**---------------------------FIM INSERÇÃO DIRETA---------------------------*/
}

