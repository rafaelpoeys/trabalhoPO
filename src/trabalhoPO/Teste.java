
			
		/*
		 
		/**------------------------------------BLOCO DE TESTE-------------------------------------------
		
		Multa[] p = new Multa[5];
		p[0]= new Multa("1abc","","","10/06/2010","10:15");
		p[1]= new Multa("ALY6951","llll","llll","11/04/2014","16:33");
		p[2]= new Multa("ghi","","","23/04/2016","23:11");
		p[3]= new Multa("ghi","","","23/04/2017","05:50");
		p[4]= new Multa("ALY6951","kkkk","kkkk","17/05/2010","17:00");
		
		
		int j =0;
		while(j<5) {
			System.out.print("| ");
			System.out.print(p[j].getPlaca()+" - "+p[j].getData()+" - "+p[j].getHora());
			
			j++;
		}
		System.out.println("");
		System.out.println("--------------------depois de ordenado-----------------");
		
		quickSort(p,5);
		
		int k =0;
		while(k<5) {
			System.out.print("| ");
			System.out.print(p[k].getPlaca()+" - "+p[k].getData()+" - "+p[k].getHora());
			
			k++;
		}
		
		
		//--------------------BLOCO PARA ESCREVER GRAVAR(ESCREVER) UM NOVO ARQUIVO--------------------------
		try {
			OutputStream os = new FileOutputStream("C:\\Users\\oaaraujo\\Desktop\\trabalhoPO\\teste.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
	  
			//--------------adptar ao código que for ordenado e usar para gravar o novo arquivo depois que terminar 
	        //--------------de ordenar.
			int c=0;
			while(c<5) {
			bw.write(c+" "+p[c].getPlaca()+";"+p[c].getNome()+";"+p[c].getEndereco()+";"
					+p[c].getData()+";"+p[c].getHora()+";");
			bw.newLine();
			c++;
		 }
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//------------------------------FIM BLOCO ESCREVER(GRAVAR) NOVO ARQUIVO-----------------------------------
		
		
		
		System.out.println("");
		
		System.out.println((System.currentTimeMillis()-t1)+" milissegundos"); // resultado do tempo gasto
		System.out.println("----------------------pesqbinaria-----------------");
		
		if (pesqBinaria ("def",p, 5)<0) {
		System.out.println("valor não encontrado");
		} else {
			System.out.println("valor está no indice "+pesqBinaria ("def",p, 5));
		}
		 
		
     //-----------------------------FIM BLOCO TESTE----------------------------------------------------------	
		 
		
	*/
		//------------------------------FIM BLOCO ESCREVER(GRAVAR) NOVO ARQUIVO-----------------------------------
		
		
		/*
		System.out.println("");
		
		System.out.println((System.currentTimeMillis()-t1)+" milissegundos"); // resultado do tempo gasto
		System.out.println("----------------------pesqbinaria-----------------");
		
		if (pesqBinaria ("def",p, 5)<0) {
		System.out.println("valor não encontrado");
		} else {
			System.out.println("valor está no indice "+pesqBinaria ("def",p, 5));
		}
		
		*
		*
		*/
		

	