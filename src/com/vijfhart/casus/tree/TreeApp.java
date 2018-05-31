package com.vijfhart.casus.tree;

import java.util.*;
import java.util.function.*;

public class TreeApp{
  
  public static void main (String args[]){


    NameNode a = new NameNode("a",null);
    NameNode b = new NameNode("b",a);
    NameNode c = new NameNode("c",b);
    NameNode d = new NameNode("d",a);
    NameNode e = new NameNode("e",b);
    NameNode f = new NameNode("f",e);
  
    final NodeTree<NameNode> list = new NodeTree<>();
    
    list.add(b);
    list.add(a);
    list.add(e);
    list.add(c);
    list.add(f);
    list.add(d); 
    
    TreeIterator<NameNode> iterator = list.iterator();
    Function<NameNode,String> nodeName = node -> node.getName();
    ToLongFunction<NameNode> nameLength = node -> node.getName().length();
    Comparator<NameNode> comparator = (first,second) -> second.getName().compareTo(first.getName());
    
    
    iterator.orderSiblingsBy(comparator);
    iterator.startWith(a);
    while(iterator.hasNext()){
      NameNode node=iterator.next();
      System.out.println(node + " " + iterator.level() + " " + 
                         list.descendantCount(node)+ " "+ 
                         iterator.path("/", n->n.getName().toUpperCase())+ " " +
                         iterator.isLeaf());
    }
    
  }
 
}

