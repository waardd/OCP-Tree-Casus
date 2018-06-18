package com.vijfhart.casus.tree.file;

import com.sun.javafx.sg.prism.NodePath;
import com.vijfhart.casus.tree.Node;
import com.vijfhart.casus.tree.NodeTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FileTree<T extends Node<T>> implements Node<T>{

    NodeTree<T> tree = new NodeTree<>();

    public void fileTree(String startDirectory){
        String startDir=startDirectory;
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
//        Files.walk(p1)
//
//                List<String> list = paths
//
//                .filter(Files::isDirectory)
//                .map(path -> Files.isDirectory(path) ? path.toString() + '/' : path.toString())
//                .collect(Collectors.toList());
//
//                //.collect(Collectors.toMap(TreeMap.put(a,b)));

        try (Stream<Path> paths = Files.walk(Paths.get(p1))) {
            List<String> pathList = paths.map(p -> {
                if (Files.isDirectory(p)) {
                    return "\\" + p.toString();
                }
                return p.toString();
            })
                    .peek(System.out::println) // write all results in console for debug
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
