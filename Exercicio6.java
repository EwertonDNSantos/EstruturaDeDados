package Ex;
        
import java.util.Scanner;


public class Exercicio6 {
    
    public static class Arv{
        
        //Variável que vai nos ajudar na contagem
        public static int count = 0;
        
        //Criando a classe No
        public class No{
            //Variáveis
            private int object;
            private No esq;
            private No dir;
            
            //construtor da classe No
            public No(){
                esq = null;
                dir = null;
            }

            //Getter and Setter
            public int getObject() {
                return object;
            }
            public void setObject(int object) {
                this.object = object;
            }

            public No getEsq() {
                return esq;
            }
            public void setEsq(No esq) {
                this.esq = esq;
            }

            public No getDir() {
                return dir;
            }

            public void setDir(No dir) {
                this.dir = dir;
            }    
        }
        
        //Declarando a Raiz da Classe Arv
        private No raiz;

        //Construtor da Classe Arv
        public Arv(){
            raiz = null;
        }
        
        //Métodos
        
         /* 
            Método que verifica se a árvore está vazia
        */
        public boolean vazia(){
            if(raiz == null){
                return true;
            }
                return false;
        }

        /** Funcao de busca recursiva.
                Retorna o endereço do elemento se ele for encontrado.
                Caso contrario, retorna null*/
        private No busca(No T, int valor){          
            No aux = new No();
            
            try{
                // Condicao de parada
                if(T == null){ 
                    return null;  // Arvore Vazia
                }

                // Condicao de parada
                if(T.getObject() == valor){
                    return T; //Elem. encontrado na raiz
                }

                // Caso recursivo
                aux = busca(T.getEsq(), valor);
                if(aux == null){ 
                    aux = busca(T.getDir(), valor);
                }

            }catch(Exception e){}
            
            return aux;      
        }

        /** Busca um elemento na árvore
                Retorna o endereço se o elemento for encontrado, 
                Caso contrário retorna null*/
        public No busca(int valor){
            try{
                if(vazia()){
                    return null;
                }  
            }catch(Exception e){}
            //No res = busca(raiz, valor);
            //return res;
            return busca(raiz, valor);
        }


        /** Insere um nó raiz em uma árvore vazia 
                Retorna true se a inserção for feita com sucesso.
                Caso contrário, retorna false*/   
        public boolean insereRaiz(int valor){   
            try{ 
                if(raiz != null){ 
                    return false;  //Erro: Arvore não está vazia
                }
                
                No novoNo = new No();
                novoNo.setObject(valor);
                novoNo.setDir(null);
                novoNo.setEsq(null);

                raiz = novoNo;
            }catch(Exception e){}
            
            return true;
        }   

        /** Insere um filho à direita de um dado nó.
                Retorna true se a inserção for com sucesso,
                Caso contrário false*/
        public boolean insereDir(int vPai, int vFilho ){
            try{
                // Verifica se o elemento já existe
                No filho = busca(vFilho);
                if(filho != null){
                    return false;  // Err: dado já existe
                }
                
                // Busca o pai e verifica se possui filho direito
                No pai = busca(vPai);
                if(pai == null){
                    return false;  // Err: pai não encontrado
                }
                
                if(pai.getDir() != null){
                    return false;  // Err: filho dir já existe
                }
                
                No novoNo = new No();
                novoNo.setObject(vFilho);
                novoNo.setEsq(null);
                novoNo.setDir(null);

                pai.setDir(novoNo);
                
            }catch(Exception e){}
            
            return true;
        }

        /** Insere um filho à esquerda de um dado nó.
                Retorna true se a inserção for com sucesso,
                Caso contrário false*/
        public boolean insereEsq(int vPai, int vFilho ){
            try{
                // Verifica se o elemento já existe 
                No filho = busca(vFilho);
                if(filho != null){
                    return false;  // Err: dado já existe
                }
                // Busca o pai e verifica se possui filho da esq
                No pai = busca(vPai);
                if(pai == null){
                    return false; // Err: pai não encontrado
                }
                
                if(pai.getEsq() != null){
                    return false; // Err: filho esq já existe
                }
                
                No novoNo = new No();
                novoNo.setObject(vFilho);
                novoNo.setEsq(null);
                novoNo.setDir(null);

                pai.setEsq(novoNo);
                
            }catch(Exception e){}
            
            return true;
        }

        /** Exibe o conteúdo de uma árvore em pré-ordem*/
        private void exibePreOrdem(No T){
            try{
                if(T == null){
                    return;
                }
                
                System.out.print(" " + T.getObject());
                
                if(T.getEsq() != null){
                    exibePreOrdem(T.getEsq());
                }
            
                if(T.getDir() != null){
                    exibePreOrdem(T.getDir());
                }   
            }catch(Exception e){}
        }

        /** Exibe o conteúdo de uma árvore em pré-ordem*/
        public void exibePreOrdem(){
            try{
                if(raiz == null){
                    System.out.println("Arvore vazia");
                }
                else
                {
                    exibePreOrdem(raiz);
                } 
            }catch(Exception e){}
        }	


        /** Exibe o conteúdo de uma árvore em In-ordem*/
        private void exibeInOrdem(No T){
            try{
                if(T == null){
                    return ;
                }
            
                if(T.getEsq() != null){
                    exibeInOrdem(T.getEsq());
                }
                
                System.out.print(" " + T.getObject());

                if(T.getDir() != null){
                    exibeInOrdem(T.getDir());
                }
            }catch(Exception e){}
        }


        /** Exibe o conteúdo de uma árvore em In-ordem*/
        public void exibeInOrdem(){
            try{
                if(raiz == null){
                    System.out.println("Arvore vazia");
                }
                else
                {
                    exibeInOrdem(raiz);
                }
            }catch(Exception e){}
        }	

        /** Exibe o conteúdo de uma árvore em Pos-ordem*/
        private void exibePosOrdem(No T){
            try{
                if(T == null){
                    return ;
                }
                
                if(T.getEsq() != null){
                    exibePosOrdem(T.getEsq());
                }

                if(T.getDir() != null){
                    exibePosOrdem(T.getDir());
                }
                
                System.out.print(" " + T.getObject());     
            }catch(Exception e){}
        }

        /** Exibe o conteúdo de uma árvore em Pos-ordem*/
        public void exibePosOrdem(){
            try{
                if(raiz == null){
                    System.out.println("Arvore vazia");
                }
                else
                {
                    exibePosOrdem(raiz);
                }
            }catch(Exception e){}
        }
        
        /*
            Método que realizar a criação de uma árvore com uso da recursividade
        */ 
        public No gearArvB(int[] pre, int[] in, int inStart, int inEnd){
            No no = new No();
            try{
                //Condição de parada
                if (inStart > inEnd){
                    return null;
                }

                no.setObject(pre[count++]);
                
                //Condição de parada
                if (inStart == inEnd){
                    return no;
                }

                int value = inEnd;

                for (int i = inStart; i <= inEnd; i++){
                    if(in[i] == no.getObject()){
                        value = i;
                        break;
                    }
                }

                // Caso recursivo:
                no.setEsq(gearArvB(pre, in, inStart, value - 1));
                no.setDir(gearArvB(pre, in, value + 1, inEnd));
            }catch(Exception e){}
            return no;
        }
        
        /*
            Método utilizado para "criar" a pos-ordem de uma árvore a partir
            de um No
        */
        private String createPosOrder(No T) {
            String aux = "";
            try{
                //Condição de parada
                if(T == null){
                    return null;
                }
                //Se a Esquerda da raiz não for null
                if (T.getEsq() != null){
                    //aux recebe o valor anterior da aux mais o novo valor da Pos-Order
                    //A partir do lado esquerdo da raiz atual
                    aux = aux + createPosOrder(T.getEsq());  
                }

                //Se a Direita da raiz não for null
                if (T.getDir() != null){
                    //aux recebe o valor anterior de aux mais o novo valor da Pos-Order
                    //A partir do lado direito da raiz atual
                    aux = aux + createPosOrder(T.getDir());
                }
            }catch(Exception e){}
            //Esse return acaba gerando o Pos-Order com um espaço na frente, 
            //depois iremos corrigir isso!
            return String.valueOf(aux + " " + T.getObject());
        }
        
        /*
            Método utilizador para a "criar" a pos ordem de uma árvore a partir
            da raiz
        */
        public String createPosOrder() {
            return createPosOrder(raiz);
        }
        
        //É uma operação perigosa, mas para esse caso é bem funcional
        public void setRaiz(No novaRaiz){
            this.raiz = novaRaiz;
        }
    }
    
    public static void main(String[] args){
        while(true){
        try{
            Arv arvB = new Arv();//Iniciando a Árvore
            Scanner sc = new Scanner(System.in);
            String originalInputPosOrder;//String que vai reseber o Input da Pos-Order, para compararmos no final
            String[] pre, pos, in;//Strings que vão receber a Input
            int sizeInputLine; //Número de elementos que ficaram na linha da Input
            int[] InputPre, InputIn;//Array para a conversão da Input

            //Recebe o Número de Elementos de uma linha
            sizeInputLine = Integer.parseInt(sc.nextLine());
            //Iniciando o Array de Inteiros para o Input
            InputPre = new int[sizeInputLine];
            InputIn = new int[sizeInputLine];

            //Aqui nós pegamos a Input sem espaços
            pre = sc.nextLine().split(" ");
            originalInputPosOrder = sc.nextLine();//Preservamos a entrada da Pos-Order com espaços
            pos = originalInputPosOrder.split(" ");//Aqui pegamos a Pos-Order sem espaços e passamos para o Array
            in = sc.nextLine().split(" ");

            //Convertendo Input para Inteiros
            for(int i = 0; i < sizeInputLine; i++){
                InputPre[i] = Integer.parseInt(pre[i]);
                InputIn[i]  = Integer.parseInt(in[i]);
            }

            /* 
                Primeiro vamos criar uma árvore temporária, usando o Input Pre-Order
                e o Input In-Order. 
                Depois disso só precisamos trocar a raiz da árvore, para a raiz da
                nossa árvore temporária.
            */
            arvB.setRaiz(arvB.gearArvB(InputPre, InputIn, 0, sizeInputLine - 1));

            //Agora vamos apenas pegar o Pos-Order que foi gerado
            String arvBPos = arvB.createPosOrder();
            //System.out.println(pos_order_arvore);

            /*
                Aqui conferimos se o Pos-Order que pegamos com a arvBPos é igual 
                ao Input do usuário. Aqui nós corrigimos o espaço do inicio do return
                que foi gerado no método createPosOrder().
            */
            if(arvBPos.equals(" " + originalInputPosOrder)){
                System.out.println("yes");
            }
            else
            {
                System.out.println("no");
            }
        
        }catch(Exception e){}
        }
        }
    }  
