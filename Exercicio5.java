package Ex5;

import java.util.Scanner;

public class Exercicio5<o>{
    
    //Iniciando a classe No
    class No<o> {
        //Declaração das váriaveis que vão ser usadas No No
        o object;
        No next;
        No prev;

        //Construtor da classe No
        public No(o object){
            this.object = object;
            next = null;
            prev = null;
        }

        //Getter and Setter
        public o getObject(){
            return object;
        }
        public void setObjeto(o object){
            this.object = object;
        }

        public No getNext(){
            return next;
        }
        public void setNext(No next){
            this.next = next;
        }

        public No getPrev(){
            return prev;
        }
        public void setPrev(No prev){
            this.prev = prev;
        }
    }
    
    //Declaração das variáveis para a Exercicio5
    private No head;
    private No tail;
    private int size;
    
    //Construtor da Exercicio5
    public Exercicio5(){
           head = null;
           tail = null;
           size = 0;
    }
    
    //Métodos
    
    /*
      Método que verifica se a fila está vazia
    */
    public boolean Vazia(){
        if(size == 0){
            return true;
        }
            return false;
    }
    
    /*
      Método que returna o size da fila
    */
    public int size(){
        return size;
    }
    
    /*
      Método que adiciona no inicio da fila
    */
    public void addHead(o object){
        No newNo = new No(object);
        if(Vazia()){
            head = newNo;
            tail = newNo;
            newNo.setNext(head);
            newNo.setPrev(tail);
            size++;
        }
        else
        {
            newNo.setPrev(head);
            head.setNext(newNo);
            head = newNo;
            size++;
        }
    }
    
    /*
      Método que adiciona no fim da fila
    */
    public void addTail(o object){
        No newNo = new No(object);
        if(Vazia()){
            head = newNo;
            tail = newNo;
            newNo.setNext(head);
            newNo.setPrev(tail);
            size++;
        }
        else
        {
            newNo.setNext(tail);
            tail.setPrev(newNo);
            tail = newNo;
            size++;
        }
    }
    
    /*
      Método que remove no inicio da fila
    */
    public o remHead(){
        if(Vazia()){
            return null;
        }
        else
        {
            No aux = head;
            head = aux.getPrev();
            size--;
            return (o) aux.getObject();
        }
    }
    
    /*
       Método que remove no fim da fila
    */
    public o remTail(){
        if(Vazia()){
            return null;
        }
        else
        {
            No aux = tail;
            tail = aux.getNext();
            size--;
            return (o) aux.getObject();
        }     
    }
       
    public static void main(String[] args){
        Exercicio5 filaEnc = new Exercicio5();
        int number;
        String str;
        int k = 0;
        boolean reverse = false;
        boolean continua = true;
        
        Scanner sc = new Scanner(System.in);
        
        //Number é o número de operações que será possível realizar
        number = sc.nextInt();
        
        while(continua){
            str = sc.nextLine();
            //Lê o comando que será usado na fila
            String[] comand = str.split(" ");
            
            switch(comand[0]){
                
                case "toFront": //toFront N - Adiciona o elemento N na Head
                    if(reverse){
                        filaEnc.addTail(comand[1]);
                        break;
                    }
                        filaEnc.addHead(comand[1]);
                        break;
                    
                case "push_back": //push_back N - Adiciona o elemento N na Tail
                    if(reverse){
                        filaEnc.addHead(comand[1]);
                        break;
                    }
                        filaEnc.addTail(comand[1]);
                        break;
                    
                case "back": //back - Imprimi o número da Tail e apaga o mesmo
                    if(filaEnc.Vazia()){
                        System.out.println("No job for Ada?");
                        break;
                    }
                    if(reverse){
                        System.out.println(filaEnc.remHead());
                        break;
                    }
                    else
                    {
                        System.out.println(filaEnc.remTail());
                        break;
                    }
                    
                case "front": //front - Imprimi o número da Head e apaga o mesmo
                    if(filaEnc.Vazia()){
                        System.out.println("No job for Ada?");
                        break;
                    }
                    if(reverse){
                        System.out.println(filaEnc.remTail());
                        break;
                    }
                    else
                    {
                        System.out.println(filaEnc.remHead());
                        break;
                    }
                    
                case "reverse": //reverse - ativa o Reverte na fila
                    reverse = !reverse;
                    break;
            }
            k++;
            if(k == number + 1){
                continua = false;
            }   
        }  
    }
}
