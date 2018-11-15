package com.lt.config;


import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFIlter implements TypeFilter {


    /**
     *
     * @param metadataReader            读取到当前正在扫描类的信息
     * @param metadataReaderFactory     获取到其他任何类信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前正在扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("------>>>>>>>"+className);

        if (className.contains("er")) {
            System.out.println("-------匹配成功");
            return true;
        }
        return false;
    }
}
