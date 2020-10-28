package it.esedra.corso;
public class EsempioSideEffects {
    int addendoA, addendoB, somma;

    public void somma(){
        somma = addendoA + addendoB;
    }

    public int getAddendoA() { return addendoA; }

    public void setAddendoA(int addendoA) { this.addendoA = addendoA; }

    public int getAddendoB() { return addendoB; }

    public void setAddendoB(int addendoB) { this.addendoB = addendoB; }

    public int getSomma() { return somma; }

    public void setSomma(int somma) { this.somma = somma; }
//	  public int somma(int addendoA, int addendoB){
//		  return addendoA + addendoB;
//	  }
}
/*
SOLUZIONE

int somma(int addendoA, int addendoB){
return addendoA + addendoB;
}



Soluzione 2

Consumer<String> c = s -> System.out.println(s);

SOLUZIONE 3
Consumer<String> c = System.out::println;

SOLUZIONE 4
//espressione lambda
IntFunction<String> intToString = i -> Integer.toString(i);
//method refrence
IntFunction<String> intToString = Integer::toString;

*/