package com.yuan.processor;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.annotation.processing.Filer;
import javax.tools.JavaFileObject;

/**
 * Created by yuan 2020/11/3.
 */

class ItemGenerator {
    public void generate(Filer filer, String generatePath, List<ItemElement> itemElementList) {
        try {
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append("package ").append(generatePath).append(";\n");
            stringBuffer.append("import android.content.Context;\n");
            stringBuffer.append("import com.yuan.multy_item.IItemVew;\n");
            stringBuffer.append("import com.yuan.multy_item.ItemViewDefault;\n");
            for (ItemElement itemElement : itemElementList) {
                stringBuffer.append("import ").append(itemElement.getPackageName()).append(".").append(itemElement.getSimpleName()).append(";\n");
            }
            stringBuffer.append("import java.lang.reflect.InvocationHandler;\n");
            stringBuffer.append("import java.lang.reflect.Method;\n");
            stringBuffer.append("import java.lang.reflect.Proxy;\n");
            stringBuffer.append("public class ItemViewFactory {\n");
            stringBuffer
                    .append("    @SuppressWarnings(\"unchecked\")\n" + "    public static <T extends IItemVew> T getViewProxy(Context context, int viewType) {\n" + "\n" + "        try {\n" + "            Class clazz = getViewClass(viewType);\n" + "            final Object o = clazz.getConstructor(Context.class).newInstance(context);\n" + "            return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {\n" + "                @Override\n" + "                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {\n" + "                    return method.invoke(o, args);\n" + "                }\n" + "            });\n" + "        } catch (Exception e) {\n" + "            return (T) new ItemViewDefault(context);\n" + "        }\n" + "    }\n");
            stringBuffer.append("    private static Class<? extends IItemVew> getViewClass(int viewType) {\n");
            for (ItemElement itemElement : itemElementList) {
                stringBuffer.append("        if(viewType ==").append(itemElement.getValue()).append("){\n").append("            return ")
                        .append(itemElement.getSimpleName()).append(".class;\n").append("        }\n");
            }
            stringBuffer.append("        return ItemViewDefault.class;\n");
            stringBuffer.append("    }\n");
            stringBuffer.append("}");


            JavaFileObject javaFileObject = filer.createSourceFile("ItemViewFactory");
            Writer writer = javaFileObject.openWriter();
            writer.write(stringBuffer.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPackageName(String className) {
        if (className == null || className.equals("")) {
            return "";
        }

        return className.substring(0, className.lastIndexOf("."));
    }
}
