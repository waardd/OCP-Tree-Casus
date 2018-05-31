package com.vijfhart.casus.tree;
import java.util.Iterator;
/**
 * Sub-interface of Iterable, to indicate that a class implementing this interface can loop through a Tree.
 * 
 * @author Marko Draisma
 * @version 1.0
 * @param T - the node type of elements in the tree
 */
public interface TreeIterable<T extends Node<T>> extends Iterable<T> {
   /**
    * Returns a TreeIterator to loop through the node elements in a Tree.
    * @return a TreeIterator 
    */
   TreeIterator<T> iterator();
}
