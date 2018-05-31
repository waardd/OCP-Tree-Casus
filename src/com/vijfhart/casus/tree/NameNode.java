package com.vijfhart.casus.tree;

public class NameNode extends AbstractNode<NameNode>{
  
  private String name;

  public NameNode(String name, NameNode parent){
     setParent(parent);
     this.name=name;
  }

  public NameNode(String name){
     this.name=name;
  }
  
  public String getName(){
     return name;
  }

  protected int compareToSibling(NameNode other){
     return name.compareTo(other.name);
  }

  public String toString(){
    return name;
  }
 
}
