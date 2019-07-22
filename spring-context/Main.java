import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Main
 *
 * @author Vic
 * @date 2019/7/19
 */
@Configuration
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
