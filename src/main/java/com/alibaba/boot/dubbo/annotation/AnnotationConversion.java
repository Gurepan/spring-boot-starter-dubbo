package com.alibaba.boot.dubbo.annotation;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.core.env.Environment;

import java.lang.annotation.Annotation;


/**
 * Created by Gure on 2017/6/27.
 */
public class AnnotationConversion {
    private Environment environment;

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Service Conversion(final Provide provide) {
        Service service = new Service() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return provide.annotationType();
            }

            @Override
            public Class<?> interfaceClass() {
                return provide.interfaceClass();
            }

            @Override
            public String interfaceName() {
                return Parse(provide.interfaceName());
            }

            @Override
            public String version() {
                return Parse(provide.version());
            }

            @Override
            public String group() {
                return Parse(provide.group());
            }

            @Override
            public String path() {
                return Parse(provide.path());
            }

            @Override
            public boolean export() {
                return provide.export();
            }

            @Override
            public String token() {
                return Parse(provide.token());
            }

            @Override
            public boolean deprecated() {
                return provide.deprecated();
            }

            @Override
            public boolean dynamic() {
                return provide.dynamic();
            }

            @Override
            public String accesslog() {
                return Parse(provide.accesslog());
            }

            @Override
            public int executes() {
                return provide.executes();
            }

            @Override
            public boolean register() {
                return provide.register();
            }

            @Override
            public int weight() {
                return provide.weight();
            }

            @Override
            public String document() {
                return Parse(provide.document());
            }

            @Override
            public int delay() {
                return provide.delay();
            }

            @Override
            public String local() {
                return Parse(provide.local());
            }

            @Override
            public String stub() {
                return Parse(provide.stub());
            }

            @Override
            public String cluster() {
                return Parse(provide.cluster());
            }

            @Override
            public String proxy() {
                return Parse(provide.proxy());
            }

            @Override
            public int connections() {
                return provide.connections();
            }

            @Override
            public int callbacks() {
                return provide.callbacks();
            }

            @Override
            public String onconnect() {
                return Parse(provide.onconnect());
            }

            @Override
            public String ondisconnect() {
                return Parse(provide.ondisconnect());
            }

            @Override
            public String owner() {
                return Parse(provide.owner());
            }

            @Override
            public String layer() {
                return Parse(provide.layer());
            }

            @Override
            public int retries() {
                return provide.retries();
            }

            @Override
            public String loadbalance() {
                return Parse(provide.loadbalance());
            }

            @Override
            public boolean async() {
                return provide.async();
            }

            @Override
            public int actives() {
                return provide.actives();
            }

            @Override
            public boolean sent() {
                return provide.sent();
            }

            @Override
            public String mock() {
                return Parse(provide.mock());
            }

            @Override
            public String validation() {
                return Parse(provide.validation());
            }

            @Override
            public int timeout() {
                return provide.timeout();
            }

            @Override
            public String cache() {
                return Parse(provide.cache());
            }

            @Override
            public String[] filter() {
                return provide.filter();
            }

            @Override
            public String[] listener() {
                return provide.listener();
            }

            @Override
            public String[] parameters() {
                return provide.parameters();
            }

            @Override
            public String application() {
                return Parse(provide.application());
            }

            @Override
            public String module() {
                return Parse(provide.module());
            }

            @Override
            public String provider() {
                return Parse(provide.provider());
            }

            @Override
            public String[] protocol() {
                return provide.protocol();
            }

            @Override
            public String monitor() {
                return Parse(provide.monitor());
            }

            @Override
            public String[] registry() {
                return provide.registry();
            }
        };
        return service;
    }

    public Require Conversion(final Require require) {
        return new Require() {
            @Override
            public boolean equals(Object obj) {
                return require.equals(obj);
            }

            @Override
            public int hashCode() {
                return require.hashCode();
            }

            @Override
            public String toString() {
                return require.toString();
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return require.annotationType();
            }

            @Override
            public String version() {
                return Parse(require.version());
            }

            @Override
            public int timeout() {
                return require.timeout();
            }

            @Override
            public String registry() {
                return Parse(require.registry());
            }

            @Override
            public String group() {
                return Parse(require.group());
            }

            @Override
            public String client() {
                return Parse(require.client());
            }

            @Override
            public String url() {
                return Parse(require.url());
            }

            @Override
            public String protocol() {
                return Parse(require.protocol());
            }

            @Override
            public boolean check() {
                return require.check();
            }

            @Override
            public boolean lazy() {
                return require.lazy();
            }

            @Override
            public int retries() {
                return require.retries();
            }

            @Override
            public int actives() {
                return require.actives();
            }

            @Override
            public String loadbalance() {
                return Parse(require.loadbalance());
            }

            @Override
            public boolean async() {
                return require.async();
            }

            @Override
            public boolean sent() {
                return require.sent();
            }
        };
    }

    private boolean needParse(String s) {
        int startIndex = s.indexOf("${");
        if (startIndex == -1) {
            return false;
        }
        int endIndex = s.indexOf("}", startIndex);
        if (endIndex == -1) {
            return false;
        }
        return true;
    }

    private String Parse(String s) {
        int startIndex = s.indexOf("${");
        if (startIndex == -1) {
            return s;
        }
        int endIndex = s.indexOf("}", startIndex);
        if (endIndex == -1) {
            return s;
        }
        String placeholder = s.substring(startIndex + 2, endIndex);
        if (placeholder == null || "".equals(placeholder)) {
            return s;
        }
        String s1 = environment.getProperty(placeholder);
        if (s1 == null || "".equals(s1)) {
            return s;
        }
        return s1;
    }
}
