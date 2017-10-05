package injectest;

import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

//@Component
public class Application {

    final private String qual = "Thomas";

    public Person getThomas() {
        return thomas;
    }

    @Inject
    public void setThomas(Person thomas) {
        this.thomas = thomas;
    }

    private Person thomas;

    @Inject
    private Service1 service1;

    @Inject
    private List<Person> personList;

    @Inject
    private List<Auto> autoList;

    private void test1() {
        System.out.println("--------- test autowired --------");
        String msg = String.format("thomas=%s", thomas);
        System.out.println(msg);
        msg = String.format("service1=%s", service1);
        System.out.println(msg);
        msg = String.format("personList = %s", personList);
        System.out.println(msg);
        msg = String.format("autoList = %s", autoList);
        System.out.println(msg);
        System.out.println("---------------------------------");
    }


    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");

        // test autowired
        Application app = context.getBean(Application.class);
        app.test1();

        // thomas
        Person thomas = context.getBean("thomas", Person.class);
        System.out.println("thomas=" + thomas);

        // person
        Person stefanie = context.getBean("stefanie", Person.class);
        System.out.println("stefanie=" + stefanie);

        // alle personen
        Map<String, Person> personMap = context.getBeansOfType(Person.class);
        for (String key : personMap.keySet()) {
            Person person = personMap.get(key);
            String message = String.format("name='%s', person='%s'", key, person);
            System.out.println(message);
        }
        if (personMap.isEmpty()) {
            System.out.println("no beans found...");
            System.out.println();
        }

        // single auto by qualifier
//        String qualifier = "stefanie";
//        Auto autoQualifier = BeanFactoryAnnotationUtils. qualifiedBeanOfType(context.getAutowireCapableBeanFactory(), Auto.class, qualifier);
//        System.out.printf("Auto[%s] = %s", qualifier, autoQualifier);
//        System.out.println();
//        System.out.println("-----------------------------");

        // list auto by qualifiers
        Map<String, Auto> autoMap = context.getBeansOfType(Auto.class);
        for (Map.Entry<String, Auto> autoEntry : autoMap.entrySet()) {
            String name = autoEntry.getKey();
            Auto auto = autoEntry.getValue();

            // check qualifier
            String[] qualifierArray = new String[]{"thomas", "stefanie"};
            for (String newqualifier : qualifierArray) {
                if (BeanFactoryAnnotationUtils.isQualifierMatch(newqualifier::equals, name, context.getAutowireCapableBeanFactory())) {
                    System.out.printf("Auto[%s] = %s", newqualifier, auto);
                    System.out.println();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Application{" +
                "thomas=" + thomas +
                '}';
    }

}
