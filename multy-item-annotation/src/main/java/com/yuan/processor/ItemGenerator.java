package com.yuan.processor;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.Adler32;

import javax.annotation.processing.Filer;
import javax.tools.JavaFileObject;

/**
 * Created by yuan 2020/11/3.
 */

class ItemGenerator {
    public void generate(Filer filer, String generatePath, String generateName, List<ItemElement> itemElementList) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("package ").append(generatePath).append(";\n");
            stringBuilder.append("import android.content.Context;\n");
            stringBuilder.append("import com.yuan.multy_item.IItemVew;\n");
            stringBuilder.append("import com.yuan.multy_item.ItemViewDefault;\n");
            for (ItemElement itemElement : itemElementList) {
                stringBuilder.append("import ").append(itemElement.getPackageName()).append(".").append(itemElement.getSimpleName()).append(";\n");
            }
            stringBuilder.append("import java.lang.reflect.InvocationHandler;\n");
            stringBuilder.append("import java.lang.reflect.Method;\n");
            stringBuilder.append("import java.lang.reflect.Proxy;\n");
            stringBuilder.append("public class ").append(generateName).append("{\n");
            stringBuilder
                    .append("    @SuppressWarnings(\"unchecked\")\n" + "    public static <T extends IItemVew> T getViewProxy(Context context, int viewType) {\n" + "\n" + "        try {\n" + "            Class clazz = getViewClass(viewType);\n" + "            final Object o = clazz.getConstructor(Context.class).newInstance(context);\n" + "            return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {\n" + "                @Override\n" + "                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {\n" + "                    return method.invoke(o, args);\n" + "                }\n" + "            });\n" + "        } catch (Exception e) {\n" + "            return (T) new ItemViewDefault(context);\n" + "        }\n" + "    }\n");
            stringBuilder.append("    private static Class<? extends IItemVew> getViewClass(int viewType) {\n");
            for (ItemElement itemElement : itemElementList) {
                if(generateName.equals(itemElement.getClassName())) {
                    stringBuilder.append("        if(viewType ==").append(itemElement.getValue()).append("){\n").append("            return ")
                            .append(itemElement.getSimpleName()).append(".class;\n").append("        }\n");
                }
            }
            stringBuilder.append("        return ItemViewDefault.class;\n");
            stringBuilder.append("    }\n");
            stringBuilder.append("}");

            JavaFileObject javaFileObject = filer.createSourceFile(generateName);
            Writer writer = javaFileObject.openWriter();
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
