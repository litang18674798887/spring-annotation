package com.lt.ext;


import com.lt.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理
 * BeanPostProcessor:bean后置处理器，bean创建对象初始化前后进行拦截器工作的
 * BeanFactoryPostProcessor：beanFactory的后置处理器
 * 在BeanFactory标准初始化之后调用，所有的bean定义已经保存加载到beanFactory中，但是bean的实例还没有创建
 *
 *  1.ioc容器创建对象
 *  2.invokeBeanFactoryPostProcessors(beanFactory); 执行BeanFactoryPostProcessors
 *          如何找到所有的BeanFactoryPostProcessor并执行他们的方法
 *              1.直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor 的组件并执行他们的方法
 *              2.在初始化创建其他组件前面执行
 *  3.BeanDefinitionRegistryPostProcessor
 *      postProcessBeanDefinitionRegistry();
 *      在所有bean定义信息将要被加载，bean实例还未创建的
 *
 *      优先于BeanFactoryPostProcessor执行
 *      利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件
 *
 *      原理：
 *      ioc创建对象
 *      2.refresh();  --》 invokeBeanFactoryPostProcessors(beanFactory)
 *      3.先从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件
 *          1.触发postProcessBeanDefinitionRegistry(registry)
 *          2.触发postProcessBeanFactory(beanFactory);
 *      4.再来从容器中找到BeanFactoryPostProcessor，然后依次触发postProcessBeanFactory()方法
 *
 *  4.ApplicationListener :监听容器中发布的事件，事件驱动模型开发
 *      public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *          监听ApplicationEvent及其子事件
 *
 *      步骤
 *          1.写一个监听器（ApplicationListener的实现类）来监听某一个事件（ApplicationEvent及其子类）
 *              @EventListener
 *              原理：使用EventListenerMethodProcessor处理器来解析方法上的 @EventListener
 *
 *
 *          2.把监听器加入到容器中
 *          3.只要容器中有相关事件的发布，我们就能监听到这个事件
 *              ContextRefreshedEvent：容器刷新完成（所有bean都完成创建）会发布这个事件
 *              ContextClosedEvent：关闭容器会发布这个事件
 *          4.发布一个事件：
 *              applicationContext.publishEvent()
 *
 *      原理：
 *          com.lt.test.Ext_Test$1[source=我发布的事件]
 *      1.ContextRefreshEvent事件：
 *          1.容器创建对象：refresh();
 *          2.finishRefresh(); 容器刷新完成 容器刷新完成会发布ContextRefreshedEvent事件
 *          3.publishEvent(new ContextRefreshedEvent(this));
 *      2.自己发布的事件
 *      3.容器关闭发布的事件
 *
 *
 *      【事件发布流程】：
 *          1.获取事件的多播器（派发器） getApplicationEventMulticaster()
 *          2.multicastEvent() 派发事件
 *          3.获取到所有的ApplicationListener:
 *           for (final ApplicationListener<?> listener : getApplicationListeners(event, type))
 *               2.否则同步的方式直接执行 invokeListener(listener, event);
 *                 拿到Listener回调onApplicationEvent()方法
 *
 *       【事件多播器（派发器）】
 *          1.容器创建对象：refresh();
 *          2.initApplicationEventMulticaster(); 初始化 ApplicationEventMulticaster();
 *              1.先去容器中找applicationEventMulticaster 的组件
 *              2.如果没有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *                  并且加入到容器中，我们可以在其他组件派发事件，自动注册applicationEventMulticaster
 *
 *
 *       【容器中有哪些监听器】
 *          1.容器创建对象 refresh();
 *          2.registerListeners();
 *              从容器中拿到所有的监听器，把他们注册到applicationEventMulticaster 中
 *              String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *              //将listener注册到applicationEventMulticaster 中
 *              getApplicationEventMulticaster().multicastEvent(earlyEvent);
 *
 *        【SmartInitializingSingleton】 原理 --> afterSingletonsInstantiated
 *          1.ioc容器创建对象, 并finishRefresh();
 *          2.finishBeanFactoryInitialization(beanFactory); 初始化剩下的单实例bean
 *              1.先创建所有的单实例bean getBean(beanName);
 *              2.获取所有创建好的单实例bean，判断SmartInitializingSingleton 类型
 *                  如果是smartSingleton.afterSingletonsInstantiated();
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
@ComponentScan("com.lt.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Car car() {
        return new Car();
    }
}
