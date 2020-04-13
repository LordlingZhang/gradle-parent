package com.zhangyu.proxy.jdk.custom;

import java.io.*;

/**
 * 自定义类加载
 * 代码生成、编译、重新动态load到JVM
 */
public class ZYClassLoader extends ClassLoader {

    private File baseDir;

    /**
     * Creates a new class loader using the <tt>ClassLoader</tt> returned by
     * the method {@link #getSystemClassLoader()
     * <tt>getSystemClassLoader()</tt>} as the parent class loader.
     *
     * <p> If there is a security manager, its {@link
     * SecurityManager#checkCreateClassLoader()
     * <tt>checkCreateClassLoader</tt>} method is invoked.  This may result in
     * a security exception.  </p>
     *
     * @throws SecurityException If a security manager exists and its
     *                           <tt>checkCreateClassLoader</tt> method doesn't allow creation
     *                           of a new class loader.
     */
    public ZYClassLoader() {
        String basePath = ZYClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    /**
     * Finds the class with the specified <a href="#name">binary name</a>.
     * This method should be overridden by class loader implementations that
     * follow the delegation model for loading classes, and will be invoked by
     * the {@link #loadClass <tt>loadClass</tt>} method after checking the
     * parent class loader for the requested class.  The default implementation
     * throws a <tt>ClassNotFoundException</tt>.
     *
     * @param name The <a href="#name">binary name</a> of the class
     * @return The resulting <tt>Class</tt> object
     * @throws ClassNotFoundException If the class could not be found
     * @since 1.2
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = ZYClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null){
            File classFile = new File(baseDir, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1){
                        out.write(buff, 0, len);
                    }
                    // 往JVM中写一个流
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (in != null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    classFile.delete();
                }
            }
        }


        return super.findClass(name);
    }
}
