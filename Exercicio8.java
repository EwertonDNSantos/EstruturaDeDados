package Ex;

import java.util.Scanner;

public class Exercicio8{
    
    static class No{
        private int object;
        private No left;
        private No right;

        public No(){
                left = null;
                right = null;
        }

        public int getObject() {
                return object;
        }
        public void setObject(int object) {
                this.object = object;
        }

        public No getLeft() {
                return left;
        }
        public void setLeft(No left) {
                this.left = left;
        }

        public No getRight() {
                return right;
        }

        public void setRight(No right) {
                this.right = right;
        }
    }
    
    static class ArvB{
        private No raiz;
        private int count;

        public ArvB(){
                count = 0;
                raiz = null;
        }

        public int getCount(){
            return count;
        }

        /** Verifica se a árvore está vazia */
        public boolean vazia (){
                return (raiz == null);
        }

        /**Buscar recursivamente a partir da raiz.
            Retorna o endereço se o elemento for
            encontrado, caso contrário retorna NULL*/
        private No busca(No T, int valor) {
                if (T == null)
                        return null;  // Arvore Vazia

                if(T.getObject() == valor)
                        return T; 	// Elem. encontrado na raiz

                if (valor < T.getObject())
                        return busca(T.getLeft(), valor);
            else
                        return busca(T.getRight(), valor);
        }

        /**Buscar um elemento na ABP
                Retorna o endereço se o elemento for
                encontrado, caso contrário retorna NULL*/
        public No busca(int valor) {          
                if (raiz != null) 
                        return busca(raiz, valor);

                return null;
        }


        /**Exibe o conteúdo de uma árvore no formato in-ordem
            (preserva a ordenação)*/
        private void exibe (No T){
                if (T != null) {
                        exibe(T.getLeft());
                        System.out.print(" " + T.getObject());
                        exibe(T.getRight());
                }
        }

        public void exibe() {
                if (raiz == null)
                        System.out.println("Arvore vazia");
                else
                        exibe(raiz);
        }

        /**Insere um nó em uma árvore ABP
            Retorna 1 se a inserção for com sucesso.
            Caso contrário retorna 0*/
        public boolean insere(int valor){

                No novoNo = new No();
                novoNo.setObject(valor);
                novoNo.setLeft(null);
                novoNo.setRight(null);

                if (raiz == null){ // Arvore vazia
                        raiz = novoNo;
                        return true;
                }

            // Procura a posicao correta pra inserir o novo no
            No aux = raiz;
            No p = null;
            
            while (aux != null) {
                        p = aux;
                        if (valor < aux.getObject()){
                                count++;
                                aux = aux.getLeft();
                        }else{
                                count++;
                                aux = aux.getRight();
                        }
                }

                // Encontrou um nó folha para inserir
                if (valor < p.getObject()){
                        p.setLeft(novoNo);
                }else{
                        p.setRight(novoNo);
                }
                return true;
        } 
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size, input;
        ArvB tree = new ArvB();
        
        size = Integer.parseInt(sc.nextLine());
        
        if(size > 3000000){
            return;
        }
        
        for(int i = 0; i < size; i++){
            input = Integer.parseInt(sc.nextLine());
            tree.insere(input);
            System.out.println(tree.getCount());
        }    
    }    
}

