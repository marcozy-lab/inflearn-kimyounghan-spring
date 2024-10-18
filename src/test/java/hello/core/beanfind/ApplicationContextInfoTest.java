package hello.core.beanfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationContextInfoTest {

    private static final Logger log = LoggerFactory.getLogger(ApplicationContextInfoTest.class);
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);

                System.out.println("name = " + beanDefinitionName + "bean = " + bean);
            }
        }
    }
}
