package Ex3;

import java.util.*;

public class Exercicio3 {
    static class LDE <o> {
        class No<o>{
            //Variáveis No
            private o object;
            private o proxObject;
            private o antObject;

            private No prox;
            private No ant;

            private No novoProx;
            private No novoAnt;

            //Construtor No
            public No(o object) {
                this.object = object;
                prox = null;
            }

            //Getter and Setter
            public void setObject(o object) {
                this.object = object;
            }

            public o getObject() {
                return object;
            }

            public void setProxObject(o proxObject) {
                this.proxObject = proxObject;
            }

            public o getProxObject() {
                return proxObject;
            }

            public void setAntObject(o antObject) {
                this.antObject = antObject;
            }

            public o getAntObject() {
                return antObject;
            }

            public void setProx(No prox) {
                this.prox = prox;
            }

            public No getProx() {
                return prox;
            }

            public void setAnt(No ant) {
                this.ant = ant;
            }

            public No getAnt() {
                return ant;
            }

            public void setNovoProx(No novoProx) {
                this.novoProx = novoProx;
            }

            public No getNovoProx() {
                return novoProx;
            }

            public void setNovoAnt(No novoAnt) {
                this.novoAnt = novoAnt;
            }

            public No getNovoAnt() {
                return novoAnt;
            }
        }
    
        //Variáveis LDE
        private No head;
        private No tail;
        private int tamanho;

        //Construtor LDE
        public LDE() {
            head = null;
            tail = null;
            tamanho = 0;

        }

        //Método que confere se a lista está vazia
        public boolean vazia(){
            if(tamanho == 0){
                return true;
            }
                return false;
        }

        //Método que adiciona um elemento a lista
        public void adiciona(o object, o antObject, o proxObject) {
            No novoNo = new No(object);
            novoNo.setAntObject(antObject);
            novoNo.setProxObject(proxObject);

            if (vazia()) {
                novoNo.setProx(null);
                novoNo.setAnt(null);
                head = novoNo;
                tail = novoNo;
            } else {
                novoNo.setProx(null);
                tail.setProx(novoNo);
                novoNo.setAnt(tail);
                tail = novoNo;
            }

            tamanho++;
        }

        //Método que confere se a lista é Sana
        public boolean Sana() {
            No aux1 = head;
            No aux2 = head.getProx();
            int i = 0;

            try {

                for (i = 0; aux1 != aux2 && i < tamanho; i++) {
                    if (aux1 != aux1.getNovoProx().getNovoAnt()) {
                        return false;
                    }
                    aux1 = aux1.getNovoProx();
                }

                if(i >= tamanho){
                    return false;
                }

                return true;

            } catch (Exception e) {
                return false;
            }
        }

        /*
            Método que adiciona um novo elemento a lista de 
            acordo com as "coordenadas" colocadas
        */
        public void procuraAdd() {
            No aux1 = head;
            No aux2 = tail;

            for (int i = 0; i <= tamanho / 2; i++) {
                aux1.setNovoAnt(procuraObject((o) aux1.getAntObject()));
                aux1.setNovoProx(procuraObject((o) aux1.getProxObject()));

                aux2.setNovoAnt(procuraObject((o) aux2.getAntObject()));
                aux2.setNovoProx(procuraObject((o) aux2.getProxObject()));

                aux1 = aux1.getProx();
                aux2 = aux2.getAnt();
            }

            if (tamanho % 2 != 0) {
                aux1.setNovoAnt(procuraObject((o) aux1.getAntObject()));
                aux1.setNovoProx(procuraObject((o) aux1.getProxObject()));
            }
        }

        //Procura o objeto passado nas "coordenadas"
        public No procuraObject(o object) {
            No aux1 = head;
            No aux2 = tail;

            if (vazia()) {
                return null;
            }

            for (int i = 1; i <= tamanho / 2; i++) {
                if (aux1.getObject() == object) {
                    return aux1;
                }
                if (aux2.getObject() == object) {
                    return aux2;
                }

                aux1 = aux1.getProx();
                aux2 = aux2.getAnt();
            }

            if (tamanho % 2 != 0 && aux1.getObject() == object) {
                return aux1;
            }
            return null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int elem, antElem, proxElem;

        LDE lista = new LDE();
        String st;

         while (sc.hasNext()) {
            st = sc.nextLine();
            String[] aux = st.split(" ");
            elem = Integer.parseInt(aux[0], 5);
            antElem = Integer.parseInt(aux[1], 5);
            proxElem = Integer.parseInt(aux[2], 5);
            lista.adiciona(elem, antElem, proxElem);
        }
         
        lista.procuraAdd();
        
        if (lista.Sana()) {
            System.out.println("Sana");
        } else {
            System.out.println("Insana");
        }
    }
}
