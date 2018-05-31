package com.vijfhart.casus.test;
import com.vijfhart.casus.tree.*;
import java.util.*;
import java.util.function.*;

public class WerknemerApp{
  public static void main (String args[]){

	  String[][] werknemers = {
		  {"3381","SMITS","KLERK","7902","2400","","20"},
		  {"3462","ALKEMA","VERKOPER","4621","2600","300","30"},
		  {"3518","WALSTRA","VERKOPER","4621","2250","500","30"},
		  {"3930","PIETERS","MANAGER","6221","3975","","20"},
		  {"4510","VERGEER","VERKOPER","4621","2250","1400","30"},
		  {"4621","KLAASEN","MANAGER","6221","3850","","30"},
		  {"5810","HEUVEL","MANAGER","6221","3450","","10"},
		  {"5931","SANDERS","ANALIST","3930","4000","","20"},
		  {"6221","KRAAY","DIRECTEUR","","6000","","10"},
		  {"6500","DROST","VERKOPER","4621","2500","0","30"},
		  {"6681","ADELAAR","KLERK","5931","2100","","20"},
		  {"7900","APPEL","KLERK","4621","1950","","30"},
		  {"7902","VERMEULEN","ANALIST","3930","3900","","20"},
		  {"8222","MANDERS","KLERK","5810","2300","","10"}};

    Arrays.sort(werknemers, new Comparator<String[]>(){
       public int compare(String[] first, String[] other){
         return first[3].compareTo(other[3]);
    }});
    final Tree<WerknemerNode> list = new NodeTree<>();
    List<WerknemerNode> wlist = new ArrayList<>();
    for(int i=0;i<werknemers.length;i++){
       wlist.add(new WerknemerNode(new Werknemer(werknemers[i][1],Integer.parseInt(werknemers[i][4]))));
    }
    for(int i=0;i<werknemers.length;i++){
      for(int j=0;j<werknemers.length;j++){
        if(werknemers[i][0].equals(werknemers[j][3])){
          wlist.get(j).setParent(wlist.get(i));
        }
      }
    }
    for(WerknemerNode node:wlist){
      list.add(node);
    }

    TreeIterator<WerknemerNode> iterator = list.iterator();

    ToLongFunction<WerknemerNode> salaris = x->x.getWerknemer().getSalaris();
    
    Comparator<WerknemerNode> comparator = (x,y)->
            y.getWerknemer().getNaam().compareTo(x.getWerknemer().getNaam());
    iterator.orderSiblingsBy(comparator);
    for(WerknemerNode node:wlist){
      if(node.getWerknemer().getNaam().equals("KRAAY"))
        iterator.startWith(node);
    }

    while(iterator.hasNext()){
      WerknemerNode node=iterator.next();
     // if(node==e)iterator.remove();
      System.out.println( String.format("%d %3d %5d %5d %5d %6d %5.2f",
                         iterator.level(),
                         list.descendantCount(node), 
                         node.getWerknemer().getSalaris(), 
                         list.descendantMin(node,salaris),
                         list.descendantMax(node,salaris),
                         list.descendantSum(node,salaris),
                         list.descendantAverage(node,x->x.getWerknemer().getSalaris()))+ " " +
                         iterator.path("/",x->x.getWerknemer().getNaam().toLowerCase()));
    }
  }
}

