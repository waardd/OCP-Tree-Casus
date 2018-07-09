package com.vijfhart.casus.tree.file;

import com.sun.javafx.sg.prism.NodePath;
import com.vijfhart.casus.tree.Node;
import com.vijfhart.casus.tree.NodeTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FileTree<T extends Node<T>> implements Node<T>{

    NodeTree<T> tree = new NodeTree<>();
    static String startDir;
    public void fileTree(String startDirectory){
        startDir=startDirectory;
    }

    public void fillTree(String startDir) throws IOException {
        Map TreeMap = new Map() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            @Override
            public Object remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set keySet() {
                return null;
            }

            @Override
            public Collection values() {
                return null;
            }

            @Override
            public Set<Entry> entrySet() {
                return null;
            }
        };
        String a = null;
        NodePath b = null;
        Path p1 = Paths.get(startDir);

        // Vul de pathNodes met alle Path's en PathNodes
        Map<Path,PathNode> pathNodes = new HashMap<>();
        try (Stream<Path> paths = Files.walk(Paths.get(startDir))) {
            paths.map((Path p) -> {
                if (Files.isRegularFile(p)) {
                    Path filePath = p.getFileName();
                    PathNode pathNode = new PathNode(p); //zet er wat properties op;
                    pathNodes.put(filePath, pathNode);
                }
                return null;
            })
                    .peek(System.out::println); // write all results in console for debug
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Walk trough the map and find parents
        pathNodes.entrySet().stream().//weten we niet meer....
    }
}
