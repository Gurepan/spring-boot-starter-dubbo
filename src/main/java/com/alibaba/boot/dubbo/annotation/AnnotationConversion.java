package com.alibaba.boot.dubbo.annotation;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.BeanUtils;
import org.springframework.core.env.Environment;

/**
 * Created by Gure on 2017/6/27.
 */
public class AnnotationConversion {
    private Environment environment;

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void Conversion(Provide provide) {
        return;
    }

    public void Conversion(Require require) {
        return;
    }
}
