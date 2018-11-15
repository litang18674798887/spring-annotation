package com.lt.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 自定义逻辑，返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {


    /**
     * 返回值就是导入到容器组件的全类型
     * AnnotationMetadata   当前标注@Import注解类的所有注解信息
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.lt.bean.Blue","com.lt.bean.Yellow"};
    }
}
