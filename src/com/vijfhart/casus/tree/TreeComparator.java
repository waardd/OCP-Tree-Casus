package com.vijfhart.casus.tree;
import java.util.*;
/**
 * A comparator to specify the order of nodes in a tree.
 * The comparator uses a local comparator to specify the order of siblings.
 *
 * @author Marko Draisma
 * @version 1.0
 * @param <T> the node type
 */
public class TreeComparator<T extends Node<T>> implements Comparator<T> {
  
  private Comparator<T> siblingComparator;
 
   /**
   * Constructor that specifies what comparator to use when sorting siblings in a tree.
   * @param siblingComparator: the comparator to use for sorting siblings.
   */
 
  public TreeComparator(Comparator<T> siblingComparator){
    this.siblingComparator = siblingComparator;
  }

  public TreeComparator(){}

   /**
   * Specifies what comparator to use when sorting siblings in a tree.
   * @param siblingComparator: the comparator to use for sorting siblings.
   */
  public void setSiblingComparator(Comparator<T> siblingComparator){
    this.siblingComparator=siblingComparator;
  }
  
   /**
   * Specifies the ordering of nodes in a Tree.
   * This is a recursive method: the ordering of nodes is known when:
   * - one of the nodes has no parent (this should be the first node)
   * - one node is the parent of the other (the parent should be placed first)
   * - two nodes share the same parent (ordering is specified by the siblingComparator)
   * If two nodes seem unrelated, the ordering is specified by ordering the parents.
   * @param first: the first node to compare
   * @param second: the second node to compare
   * @return -1 if the first node has a lowel level then the second node,
   *         +1 positive value if the first node has a higher level then the second node,
   *          0 if the first node has the same level as the second node.
   */

  public int compare(T first, T second){
    if(first.getParent()==null) return -1;
    if(second.getParent()==null) return 1;
    if (first.compareLevelTo(second)>0){
      if(first.getParent().equals(second)) return 1;
      return compare(first.getParent(),second);
    }
    if (first.compareLevelTo(second)<0){
      if(first.equals(second.getParent())) return -1;
      return compare(first,second.getParent());
    }
    if (first.getParent().equals(second.getParent())&&siblingComparator!=null){
       return siblingComparator.compare(first,second);
    }
    return compare(first.getParent(),second.getParent());
  }

}
