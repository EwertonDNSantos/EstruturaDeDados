
import java.util.Scanner;


public class Exercicio7 {
     public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);
            boolean[] contador;
            char[] input;
            int tam, aux, output;

            //Aqui nós recebemos o número de funções que o programa vai aceitar
            tam = Integer.parseInt (sc.nextLine());

            /*
              Enquanto Tam for maior que zero, o while continua a receber funções,
              a cada checagem ele decrementa o valor de Tam.
            */
            while (tam-- > 0){

                //Aqui nós recebemos as operações das árvores binárias
                String s = sc.nextLine();

                //Se o primeiro valor da árvore for "l", logo nós iremos retorna 0, caso não for, o programa continua
                if (s.equals("l")) {
                    System.out.println(0);
                    //Continua na próxima iteração
                    continue;
                }

                //Aqui nós criamos um array de booleans, para realizarmos a contagem com true e false
                contador = new boolean [s.length()];

                /*
                O primeiro valor do Input já recebe true, para iniciarmos a contagem,
                caso fosse false, daria break com NN
                */
                contador[0] = true;

                //Retorna os valores do contador e do Output a zero
                aux = 0;//Vai servir para descobrirmos a profundidade da árvore
                output = 0;//Começamos com zero e depois iremos aumentar ou não seu valor

                //Agora ele vai definir o tamanho do array de 
                input = new char[s.length()];

                //Agora ele vai passar todo o Input que está em uma String, para um array de Char
                for(int i = 0; i < s.length(); i++){
                    input[i] = s.charAt(i);
                }

                //Agora vamos procurar a profundidade da árvore que foi colocada no Input
                for (int i = 0; i < input.length; i++) {
                    //Se o Input for 'n' ele entra no if
                    if (input[i] == 'n'){
                        //Aumenta o número do contador e defini que a posição atual do contador é true
                        aux++;
                        contador[aux] = true;
                    } 
                    else
                    {   //Caso o Input não seja 'n', esse if testa se ele é um 'l'
                        if (input[i] == 'l'){
                            //Se a condição anterior do if for satisfeita, ele entra em um while
                            while(!contador[aux]){//Esse while só vai dar break, quando achar um valor true
                                /*
                                  Agora decrementamos o valor da aux e fazemos o Contador andar para a esquerda.
                                  Ele vai Decrementar até achar um valor true colocado anteriormente!
                                */
                                aux--;
                            }
                            //Agora definimos o valor atual do contador como false
                            contador[aux] = false;
                        }
                    }
                    /*
                      Se o Output anterior for maior do que o valor da aux que conseguimos 
                      agora, Output mantém o valor, se a aux for maior que o Output anterior
                      Output recebe o valor da aux.
                    */
                    output = Math.max(output, aux);
                }
                //Ao finalizar a execução do programa, nós printamos a pronfundidade
                System.out.println(output);
            }
        }
        catch(Exception e){}
    }
}
