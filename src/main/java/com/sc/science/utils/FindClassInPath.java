package com.sc.science.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * 指定路径查找类文件
 */
public class FindClassInPath {
    private static String CLASS_FILE_TO_FIND =
            "com.google.common.collect.ImmutableSet";//形式  com/google/common/collect/ImmutableSet.class or com.google.common.collect.ImmutableSet
    private static String FILE_TO_PATH = "C:\\Users\\Administrator\\Desktop\\prelog\\lib";
    private static List<String> foundIn = new LinkedList<String>();
    private static List<String> foundNotIn = new LinkedList<String>();

    public static void main(String[] args) {
        if (!CLASS_FILE_TO_FIND.endsWith(".class")) {
            CLASS_FILE_TO_FIND = CLASS_FILE_TO_FIND.replace('.', '/') + ".class";
        }
        if (args.length > 1) {
            CLASS_FILE_TO_FIND = args[1];
            FILE_TO_PATH = args[0];
        }
        File start = new File(FILE_TO_PATH);

        search(start);
        System.out.println("---total count:"+foundNotIn.size()+"---");

        System.out.println("******RESULTS******");
        for (String s : foundIn) {
            System.out.println(s);
        }
        System.out.println("---total found count:" + foundIn.size() + "---");
    }

    private static void search(File start) {
        try {
            final FileFilter filter = new FileFilter() {

                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".jar") || pathname.isDirectory();
                }
            };
            for (File f : start.listFiles(filter)) {
                if (f.isDirectory()) {
                    search(f);
                } else {
                    searchJar(f);
                }
            }
        } catch (Exception e) {
            System.err.println("Error at: " + start.getPath() + " " + e.getMessage());
        }
    }

    private static void searchJar(File f) {
        try {
            System.out.println("Searching: " + f.getPath());
            foundNotIn.add(f.getPath());
            JarFile jar = new JarFile(f);
            ZipEntry e = jar.getEntry(CLASS_FILE_TO_FIND);
            if (e == null) {
                e = jar.getJarEntry(CLASS_FILE_TO_FIND);
                if (e != null) {
                    foundIn.add(f.getPath());
                }
            } else {
                foundIn.add(f.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}