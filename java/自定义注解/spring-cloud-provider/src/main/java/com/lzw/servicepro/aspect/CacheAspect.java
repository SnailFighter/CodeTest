package com.lzw.servicepro.aspect;

import com.lzw.servicepro.annotations.DoService;
import com.lzw.servicepro.service.CacheBiz;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

//切面处理注解
@Component
@Aspect
public class CacheAspect {

    @Autowired
    private CacheBiz cacheBiz;

    @Around("@annotation(com.lzw.servicepro.annotations.DoService)")//这里会拦截对应注解
    public Object getCache(ProceedingJoinPoint pjt){
        //拿到注解的方法
        Method method = getMethod(pjt);
        //找到这个方法是否有注解
        Annotation[] annotations = method.getDeclaredAnnotations();
        if(annotations==null||annotations.length==0) {
            try {
                return pjt.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else {
            //如果有注解
            for(int j=0;j<annotations.length;j++){
                if(annotations[j] instanceof  com.lzw.servicepro.annotations.DoService){
                    String key = (String)DoServiceHandler(annotations[j],method,pjt);
                    cacheBiz.getInfo(Long.getLong(key));
                    return "id:"+key+"name: cache 王xx";
                }
            }

        }

        return null;
    }

    //获取方法签名，方法
    private Method getMethod(ProceedingJoinPoint pjt){

        //获取参数，类型为Object
        Object[] args = pjt.getArgs();
        //获取每个参数的类型
        Class[] argsType = new Class[args.length];
        for(int i=0;i<args.length;i++)
            argsType[i] = args[i].getClass();

        try {
            //获取到具体方法
            return pjt.getTarget().getClass().getMethod(pjt.getSignature().getName(),argsType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    //对DoService注解处理，货物spel值
    private Object DoServiceHandler(Annotation annotation,Method method,ProceedingJoinPoint pjt){
        DoService doService = (DoService)annotation;
        //开始解析SPEL表达式
        //获取拦截方法参数名列表
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramsArray = discoverer.getParameterNames(method);

        //解析器
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        for(int i=0;i<paramsArray.length;i++){
            context.setVariable(paramsArray[i],pjt.getArgs()[i]);
        }
        return parser.parseExpression(doService.cache()).getValue(context,String.class);//这里必须指明使用了spel的注解中的方法
    }

}
