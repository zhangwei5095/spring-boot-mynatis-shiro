package cn.elvea.core.persistence.datasource;

import cn.elvea.core.persistence.datasource.annotation.MasterDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {
    private final static Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Pointcut("execution(* cn.elvea.service.*.*(..))")
    public void serviceExecution() {
    }

    @Before("serviceExecution()")
    public void setDynamicDataSource(JoinPoint point) {
        Object target = point.getTarget();
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        logger.debug("target - {}", target.getClass().getCanonicalName());
        logger.debug("method - {}", method.getName());

        boolean useMaster = false;
        if (method.isAnnotationPresent(MasterDataSource.class)) {
            useMaster = true;
        } else if (target.getClass().isAnnotationPresent(MasterDataSource.class)) {
            useMaster = true;
        }

        if (DynamicDataSourceHolder.isBindDataSource()) {
            logger.debug("allready bind datasource[{}].", DynamicDataSourceHolder.getDataSource());
        } else {
            if (useMaster) {
                logger.debug("switch to master.");
                DynamicDataSourceHolder.setMaster();
            } else {
                logger.debug("switch to slave.");
                DynamicDataSourceHolder.setSlave();
            }
        }
    }
}
