package com.sc.science.filescan.utils;

import org.apache.commons.io.FileUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface FileScan {
    public void doScanJar(File file) throws Exception;
}

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ScannerJava {
    private static final String scanJarPath = "F:\\temp";
    private static final String outUnJarPath = "F:\\tempcode";
    private static final String jarEntryStartWith[] = {"com/fg/user/service", "com/cjia/user/service"};
    private static final Pattern patternClass = Pattern.compile("interface (.*)\\{");
    private static final Pattern patternMethod = Pattern.compile("public (.*);");

    public static void main(String[] args) throws Exception {

        scanFile(scanJarPath, new FileScan() {
            @Override
            public void doScanJar(File file) throws Exception {
                if (file.getName().endsWith(".jar")) {
                    JarFile jarFile = new JarFile(file.getAbsolutePath());
                    Enumeration<JarEntry> entryEnumeration = jarFile.entries();
                    while (entryEnumeration.hasMoreElements()) {
                        JarEntry jarEntry = entryEnumeration.nextElement();
                        if (jarEntryStartWith(jarEntry) && jarEntry.getName().endsWith(".java")) {
                            String outFileName = outUnJarPath +"\\"+ jarEntry.getName();
                            File f = new File(outFileName);
                            if (jarEntry.isDirectory()) {
                                if (!f.exists()) {
                                    f.mkdirs();
                                }
                            } else {
                                File pf = f.getParentFile();
                                if (!pf.exists()) {
                                    pf.mkdirs();
                                }
                                InputStream in = jarFile.getInputStream(jarEntry);
                                OutputStream out = new BufferedOutputStream(
                                        new FileOutputStream(f));
                                byte[] buffer = new byte[2048];
                                int nBytes = 0;
                                while ((nBytes = in.read(buffer)) > 0) {
                                    out.write(buffer, 0, nBytes);
                                }
                                out.flush();
                                out.close();
                                in.close();
                            }

                        }


                    }
                }
            }
        });

        scanFile(outUnJarPath, new FileScan() {
            @Override
            public void doScanJar(File file) throws Exception {
                if (file.getName().endsWith(".java")) {
                    String string = FileUtils.readFileToString(file, "utf-8");
                    Scanner scanner = new Scanner(string);
                    scanner.useDelimiter("\n");
                    while (scanner.hasNext()) {
                        String nextstr = scanner.next();
                        Matcher calssm = patternClass.matcher(nextstr);
                        while (calssm.find()) {
                            String filePath = file.getPath();
                            filePath = filePath.substring(filePath.lastIndexOf("com"), filePath.lastIndexOf("\\")).replace("\\", ".") + ".";
                            System.out.println();
                            System.out.println(filePath + calssm.group(1));

                        }
                        Matcher methodm = patternMethod.matcher(nextstr);
                        while (methodm.find()) {
                            System.out.println("public " + methodm.group(1));
                        }
                    }


                }
            }
        });


    }

    public static boolean jarEntryStartWith(JarEntry jarEntry) {
        for (String str : jarEntryStartWith) {
            if (jarEntry.getName().startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public static void scanFile(String path, FileScan fileScan) throws Exception {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        scanFile(file2.getAbsolutePath(), fileScan);
                    } else {
                        //System.out.println("文件:" + file2.getAbsolutePath());
                        fileScan.doScanJar(file2);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

}

