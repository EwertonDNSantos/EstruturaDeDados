package Ex;

import java.util.*;

/**
 *
 * @author EwertonDNSantos
 */

public class Exercicio1 {
    
    public static void main(String[] args){
        
        String[] sa, qa;
        String dif = "";
        int s, q, aux = 0;
        int[] a, b, sq;
        boolean p;
         
        Scanner SQ = new Scanner(System.in);
        Scanner SQS = new Scanner(System.in);
        
        s = SQ.nextInt();
        sa = new String[s];
        
        String inputS = SQS.nextLine();
        String number[] = inputS.split(" ");
        
        System.arraycopy(number, 0, sa, 0, number.length);
      
        q = SQ.nextInt();
        qa = new String[q];
       
        String inputQ = SQS.nextLine();
        number = inputQ.split(" ");
        
        System.arraycopy(number, 0, qa, 0, number.length);
      
        a = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            a[i] = Integer.parseInt(sa[i]);  
        }

        b = new int[qa.length];
        for (int i = 0; i < qa.length; i++) {
            b[i] = Integer.parseInt(qa[i]);
        }
     
        sq = new int[s];
        
        for(int i = 0; i < a.length; i++){
            p = false;
            
            for(int j = 0; j < b.length; j++){
                if(a[i] == b[j]){
                    p = true;
                }
            }
            
            if(p != true){
                sq[aux] = a[i];
                aux++;
            }
        }
        
        Arrays.sort(sq, 0, (aux-1));
           
        for(int i = 0; i < aux; i++){
            if(i == 0){
                dif += String.valueOf(sq[i]);
            }else{
                dif += " " + String.valueOf(sq[i]);
            }
        }
        
        System.out.println(dif);
    }

}
    



    
    
    
    
    
    
    
    
    
    
    
    
    
    