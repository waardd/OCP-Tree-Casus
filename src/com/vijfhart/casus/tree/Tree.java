package com.vijfhart.casus.tree;
import java.util.*;
import java.util.function.*;

/**
 * A Tree-structured collection containing Node elements.
 * The main characteristic of a Tree is that is an IterableTree: 
 * it can iterate through its elements using a TreeIterator.
 * Elements can be added to a Tree using the add method.
 * Furthermore, statistics can be calculated of characaristics of nodes
 * beneath a given node using lambda expressions.
 * 
 * @author Marko Draisma
 * @version 1.0
 * @param <T>: the node type in use
 */
public interface Tree<T extends Node<T>> extends TreeIterable<T> {
  long descendantSum(T t, ToLongFunction<T> f);
  double descendantSum(T t, ToDoubleFunction<T> f);
  double descendantAverage(T t, ToDoubleFunction<T> f);
  long descendantMin(T t, ToLongFunction<T> f);
  double descendantMin(T t, ToDoubleFunction<T> f);
  long descendantMax(T t, ToLongFunction<T> f);
  double descendantMax(T t, ToDoubleFunction<T> f);
  
  /**
   * The count of elements beneath the given node.
   * @param t: the node beneath which the count is calculated.
   * @return the count of nodes descending and excluding the given node.
   */
  long descendantCount(T t);
  
   /**
   * Adds a node element to the tree.
   * @param t: the node to add to the tree
   */
  void add(T t);
  
   /**
   * Generates a list of nodes descending a given node, including the given node itself.
   * @param node: a node
   * @return a list of nodes descending and including the given node.
   */

  List<T> descendantsOf(T node);
}
