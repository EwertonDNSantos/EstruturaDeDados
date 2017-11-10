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
            Método que realizar a criação de uma árvore com uso da recursividade
        */ 
        public No gearArvB(int[] pre, int[] in, int inStart, int inEnd){
           
                //Condição de parada
                if (inStart > inEnd){
                    return null;
                }
                
                No no = new No();
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
 
