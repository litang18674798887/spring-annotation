package com.lt.config;


import com.lt.bean.Color;
import com.lt.bean.Person;
import com.lt.bean.Red;
import com.lt.condition.LinuxCondition;
import com.lt.condition.MyImportBeanDefinitionRegistrar;
import com.lt.condition.MyImportSelector;
import com.lt.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//满足当前条件，这个类中配置的所有的配置都会生效
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import 导入的导入组件，id默认是组件的全类型
public class MyConfig2 {


    /**
     *  给容器中注册组件的方式
     *  1.包扫描+组件标注注解 @Controller @Service @Component @Repository
     *  2.@Bean [导入的第三方包里面的组件]
     *  3.@Import[快速的给容器中导入一个组件]
     *      1.@Import(要导入到容器中的组件) 容器中就会自动注册这个组件，id默认是全类名
     *      2.ImportSelector ：返回需要导入的组件的全类名数组
     *      3.ImportBeanDefinitionRegistrar：手动注册bean的容器中
     *  4.使用spring提供的FactoryBean(工厂Bean)
     *      1.默认获取到的是工厂bean调用getObject创建对象
     *      2.要获取工厂Bean本身，我们需要给id前面加一个&
     *      &colorFactoryBean
     */


    /**
     *   Specifies the name of the scope to use for the annotated component/bean.
     * 	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * 	 * @see #value
     *
     *       prototype：多实例的 ioc启动的时候不会调用方法创建对象放在容器里面
     *       singleton：单实例的 ioc启动的时候会加载一次到容器中
     *
     *   懒加载
     *      单实例Bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动的时候不会创建对象，第一次使用（获取）Bean创建对象，并初始化（懒加载只针对单实例Bean）
     *
     * @return
     */
    @Scope      //("prototype") //调整作用域
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加person");
        return new Person("张三",25);
    }


    /**
     * @Conditional:按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows 给容器中注册（“bill”）
     * 如果系统是linux 给容器中注册（“linux”）
     */
    @Conditional({WindowsCondition.class})
    @Bean("Bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linux")
    public Person person03(){
        return new Person("linux",50);
    }




}
