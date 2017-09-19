package Ex;

import java.util.*;

/**
 *
 * @author EwertonDNSantos
 */

public class Exercicio2 {
 
    static class LSE<O> {

	class No {

            private O object;
            private No prox;

            public No(){
                    setProx(null);
            }
            public O getObject() {
                    return object;
            }
            public void setObject(O object) {
                this.object = object;
            }
            public No getProx() {
                    return prox;
            }
            public void setProx(No prox) {
                    this.prox = prox;
            }

	}

	private No head;
	private int tamanho;

	public LSE(){
		head = null;
		tamanho = 0;
	}

	public boolean vazia(){
            if (tamanho == 0){
                return true;
            }else{
                return false;
            }
        }
        
	public int tamanho(){
	 return tamanho;
	}
        
	public O element(int pos){
            No aux = head;
            int cont = 1;

            if (vazia()){
                return null;
            }
            if ((pos < 1) || (pos > tamanho())){
                return null;
            }

	 while (cont < pos){
	 aux = aux.getProx();
	 cont++;
	 }
	 return aux.getObject();
	}

	public int posicao(O dado){

            int cont = 1;
            No aux;

            if (vazia()){
                 return -1;
            }

            aux = head;

            while (aux != null){

                if (aux.getObject().equals(dado)){
                    return cont;
                }
                aux = aux.getProx();
                cont++;
            }
            return -1;
	}

	private boolean addH(O valor){
            
            No novoNo = new No();
            novoNo.setObject(valor);
            novoNo.setProx(head);
            head = novoNo;
            tamanho++;

            return true;
	}

	private boolean addM(int pos, O dado){

            int cont = 1;
            No novoNo = new No();
            novoNo.setObject(dado);
            No aux = head;

            while ((cont < pos-1) && (aux != null)){
                aux = aux.getProx();
                cont++;
            }
            
            if (aux == null) {
	 	return false;
            }

            novoNo.setProx(aux.getProx());
            aux.setProx(novoNo);
            tamanho++;
            
            return true;
	}

	private boolean addT(O dado){

            No novoNo = new No();
            novoNo.setObject(dado);
            No aux = this.head;

            while(aux.getProx() != null){
                aux = aux.getProx();
            }

            novoNo.setProx(null);
            aux.setProx(novoNo);
            this.tamanho++;

            return true;
	}

	public boolean add(int pos, O dado) {

            if ((vazia()) && (pos != 1)){
                return false;
            }
            if (pos == 1){
                return addH(dado);
            }  
            else if (pos == tamanho+1){
                return addT(dado);
            }else{
                return addM(pos, dado);
            }
	}

	private O remH(){
            
            No p = head;
            O dado = p.getObject();
            head = p.getProx();
            tamanho--;
            p = null;

            return dado;
	}

	private O remM(int pos){

            No atual = null, antecessor = null;
            O dado = null;
            int cont = 1;
            atual = head;

            while((cont < pos) && (atual != null)){
                antecessor = atual;
                atual = atual.getProx();
                cont++;
            }

            if (atual == null) {
                return null;
            }
        
            dado = atual.getObject();
            antecessor.setProx(atual.getProx());
            tamanho--;
            atual = null;
            
            return dado;
	}
        
	public O remove(int pos) {
            
            if (vazia()){
                return null;
            } 
            if (pos == 1){
                return remH();
            }else{    
                return remM(pos);
            }
        }	
    }

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        String comE;
        String[] semE;

        LSE<String> tarefa = new LSE<String>();
        LSE<String> consulta = new LSE<String>();

        boolean repete;
        int[] repeticao;
        int n, q;

        comE = entrada.nextLine();
        semE = comE.split(" ");

        n = Integer.parseInt(semE[0]);
        q = Integer.parseInt(semE[1]);
        repeticao = new int[q];

        for(int posicao = 1; posicao <= n; posicao++){
            tarefa.add(posicao, entrada.nextLine());
        }

        for(int posicao = 1; posicao <= q; posicao++){
            consulta.add(posicao, entrada.nextLine());
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= q; j++){
                
                int tamanho_da_palavra_afazer = tarefa.element(i).length();
                int tamanho_da_palavra_consulta = consulta.element(j).length();
                String prefixo;

                if(tamanho_da_palavra_consulta <= tamanho_da_palavra_afazer){        
                    prefixo = tarefa.element(i).substring( 0, consulta.element(j).length());
                    repete = prefixo.contains(consulta.element(j));
                }else{
                    repete = false;
                }         
                if(repete){
                    repeticao[j-1] = repeticao[j-1] + 1;
                }
            }
        }
        for(int posicao = 0; posicao < repeticao.length; posicao++){
            System.out.println(repeticao[posicao]);
        }
    }
}