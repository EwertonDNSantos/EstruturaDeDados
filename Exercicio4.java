package Ex4;

import java.util.*;

/*
Agora estamos definindo a class No, que vai nos auxiliar na pilha
*/
class No<o> {
    //Variáveis
    private o object;
    private No prox;
    
    //Construtor
    public No(o object){
        this.object = object;
        prox = null;
    }
    
    //Getter and Setter
    public o getObject(){
        return object;
    }
    public void setObject(o object){
        this.object = object;
    }
    
    public No getProx(){
        return prox;
    }
    public void setProx(No prox){
        this.prox = prox;
    }
}

//Definindo a class Exercicio4
public class Exercicio4<o>{
    
    //Variáveis
    private No topo;
    private int nElementos;
    
    //Construtor
    public Exercicio4(){
        topo = null;
        nElementos = 0; 
    }
    
    //Verifica se a Exercicio4 está vazia
    public boolean vazia(){
        if(nElementos == 0){
            return true;
        }
            return false;
    }
    
    //Obtem o tamanho da Exercicio4
    public int tamanho(){
        return nElementos;
    }
    
    //Verifica quem é o topo da lista, caso ela esteja vazia, retorna null
    public o top(){
        if(vazia()){
            return null;
        }
            return (o) topo.getObject();
    }
    
    //Esse método vai inseri um elemento no topo da Exercicio4
    public void push(o valor){
        No novoNo = new No(valor);
        
        //Faz o novoNo apontar para o topo 
        novoNo.setProx(topo);
        
        //Faz o topo virar o novoNo 
        topo = novoNo;
        
        nElementos ++;
    }
    
    public o pop(){
        No aux;
        No rem;
        
        //Confere se a pilha está vazia
        if(vazia()){
            return null;
        }
        
        /*
        Fazemos a aux virar o próximo valor após o topo e fazemos a variavel
        rem virar topo para guardar o valor do topo para mostrar o valor do topo
        que foi retirado
        */
        aux = topo.getProx();
        rem = topo;
        
        
        //Agora transformamos o topo no proximo e fazemos o antigo topo ser null
        topo = null;
        topo = aux;
        
        nElementos --;
        //Agora estamos "convertendo" abstrato e pegando o conteudo
        return (o) rem.getObject();
    }

    public static void main(String[] args){
        
	Scanner sc = new Scanner(System.in);
	String	expressaoN = new String();
	int i;
        
        //Aqui nós usamos o Scanner para definir quantas expressões teremos
	i = sc.nextInt();
        
	//O While vai rodar de acordo com o número de expressões digitadas
	while(i>0){
            //Entrada das expressões
            expressaoN = sc.next();
        
            //Criação da pilha
            Exercicio4 pilha = new Exercicio4();
            
            /*
              Local onde ficara as expressões que passaram pelo 
              processo de Notaçao Polonesa Inversa(NPI)
            */
            String notacaoPI = new String();
            int tamanhoEx = expressaoN.length();
            char c;	
        
            for(int j = 0;j < tamanhoEx; j++){
        
                /*   
                charAt => Esse método retorna um caractere em um determinado 
                          local em uma string
                */
                c = expressaoN.charAt(j);
                switch(c){
                        case '(': 
                                break;

                        case '+':
                                pilha.push(c);
                                break;
	
                        case '-':
                                pilha.push(c);		
                                break;
		
                        case '*':
                                pilha.push(c);		
                                break;
 
                        case '/':
                                pilha.push(c);		
                                break;
 	
                        case '^': 
                                pilha.push(c);
                                break;

                        case ')': 
                                notacaoPI += pilha.pop();
                                break;

                        default : 
                                notacaoPI += c;	
                                break;
		}	
        }
		System.out.println(notacaoPI);
		i--;
	}
    }
}