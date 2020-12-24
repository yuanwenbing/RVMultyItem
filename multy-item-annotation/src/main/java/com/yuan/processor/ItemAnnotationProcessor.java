package com.yuan.processor;

import com.google.auto.service.AutoService;
import com.yuan.annotation.Item;
import com.yuan.annotation.Path;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;


/**
 * Created by yuan 2020/11/3.
 */
@AutoService(Processor.class)
public class ItemAnnotationProcessor extends AbstractProcessor {

    // 文件相关辅助类
    private Filer mFiler;

    private Elements mElementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        mFiler = processingEnv.getFiler();
        mElementUtils = env.getElementUtils();

    }

    @Override
    public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment roundEnv) {

        Set<? extends Element> pathElements = roundEnv.getElementsAnnotatedWith(Path.class);

        String generatePath = "";
        String generateName = "";

        for (Element pathElement : pathElements) {
            generatePath = pathElement.getAnnotation(Path.class).path();
            generateName = pathElement.getAnnotation(Path.class).name();

            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Item.class);
            List<ItemElement> itemElementList = new ArrayList<>();
            for (Element element : elements) {
                // 因为BindView只作用于Class，判断注解是否是属性，不是的话直接结束
                if (element.getKind() != ElementKind.CLASS) {
                    return false;
                }
                PackageElement packageElement = mElementUtils.getPackageOf(element);
                String packageName = packageElement.getQualifiedName().toString();
                // 获取注解元数据
                int[] types = element.getAnnotation(Item.class).type();
                String support = element.getAnnotation(Item.class).support();
                // 获取属性的类
                for (int type : types) {
                    String simpleName = element.getSimpleName().toString();
                    ItemElement itemElement = new ItemElement();
                    itemElement.setSimpleName(simpleName);
                    itemElement.setClassName(support);
                    itemElement.setPackageName(packageName);
                    itemElement.setValue(type);
                    itemElementList.add(itemElement);
                }
            }

            if(elements.size()>0) {
                new ItemGenerator().generate(mFiler, generatePath,generateName, itemElementList);
            }
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(Item.class.getCanonicalName());
        annotations.add(Path.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        System.out.println(SourceVersion.latestSupported());
        return SourceVersion.latestSupported();
    }
}