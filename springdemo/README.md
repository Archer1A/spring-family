#Spring 启动流程

BeanConfig.class:

``@Configuration
  @Import({Color.class,MyImportBeanDefinitionRegistrar.class, LogAspect.class, MathCalculator.class,MyPostProcessor.class})
  public class BeanConfig {
  }
``

注册一个ioc容器：
`ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);`