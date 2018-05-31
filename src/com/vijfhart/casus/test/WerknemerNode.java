package com.vijfhart.casus.test;
import com.vijfhart.casus.tree.*;

class WerknemerNode extends AbstractNode<WerknemerNode>{
  private Werknemer werknemer;
  private WerknemerNode parent;

  WerknemerNode(Werknemer werknemer, WerknemerNode parent){
   this.werknemer=werknemer;
   setParent(parent);
  }

  WerknemerNode(Werknemer werknemer){
   this.werknemer=werknemer;
  }

  public Werknemer getWerknemer(){
    return werknemer;
  }

  public String toString(){
    return werknemer.toString();
  }

  public boolean equals(WerknemerNode other){
    return getWerknemer().equals(other.getWerknemer());
  }

}
