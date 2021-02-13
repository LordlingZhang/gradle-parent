package com.zhangyu.proxy.jdk.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 自定义生成代理对象
 */
public class ZYProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(ZYClassLoader loader,
                                          Class<?>[] interfaces,
                                          ZYInvocationHandler h)
            throws IllegalArgumentException
    {
        try {
            // 1、生成源代码
            String proxyStr = generateSrc(interfaces[0]);
            // 2、把源代码输出，保存 XXX.java文件
            String path = ZYProxy.class.getResource("").getPath();
            File f = new File(path + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxyStr);
            fw.flush();
            fw.close();
            // 3、编译成生成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask compilationTask = compiler.getTask(null, manager, null, null, null, iterable);
            compilationTask.call();
            manager.close();

            // 4、将class内容动态加载到JVM中来
            Class proxyClass = loader.findClass("$Proxy0");
            f.delete();
            // 5、返回被代理的代理对象
            Constructor c = proxyClass.getConstructor(ZYInvocationHandler.class);
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 生成源代码
     * $开头的类基本代表 被代理类， 数字就是已经被生成了多少个代理类，序号
     * @param interfaces
     * @return
     */
    public static String generateSrc(Class<?> interfaces){
        StringBuilder sb = new StringBuilder();
        sb.append("package com.zhangyu.proxy.jdk.custom;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("import java.lang.Throwable;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        sb.append("ZYInvocationHandler h;" + ln);
        sb.append("public $Proxy0(ZYInvocationHandler h) {" + ln);
        sb.append("this.h = h;" +ln);
        sb.append("}" + ln);

        // 实现接口的所有方法
        for (Method m : interfaces.getMethods()){
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            sb.append("this.h.invoke(this,m,null);" + ln);
            sb.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            sb.append("}" + ln);
        }
        sb.append("}" + ln);

        return sb.toString();
    }
}
