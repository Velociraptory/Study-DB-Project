package hello;

import functional.Lamp;
import functional.Person;
import functional.Radio;
import functional.Switcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void fire(Object sender){
        System.out.println("STATIC FIRE");
    }
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        ///////FUNCTIONAL////////
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();
        //final String message = "FIRE"; //до java 8
        String message = "FIRE"; //после java 8
        //event subscribe
        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);

        //anonymous class
       /** sw.addElectricityListener(new ElectricityConsumer()
                {
                    @Override
                    public void electricityOn(Object sender){
                        System.out.println(message);
                        System.out.println("!!!");
                    }
                }
        ); **/

        //lambda expression
        /** sw.addElectricityListener(
                    sender -> {
                        System.out.println(message);
                        System.out.println("!!!");
                    }
        ); **/

        //lambda expression shorted
        //sw.addElectricityListener(s -> Application.fire(s));

        sw.addElectricityListener(Application::fire);

        sw.switchOn();

        ////////STREAMS//////////
        List<Person> list = new ArrayList<>();
        list.add(new Person("somebody", 38));
        list.add(new Person("once", 7));
        list.add(new Person("told", 6));
        list.add(new Person("me", 14));

       /** for(Person p : list){
            System.out.println(p);
        } **/

       //lambda exxpression + stream
       /** list.stream().forEach(
               (Person p ) -> {
                   System.out.println(p);
               }
               ); **/

       //lambda exxpression + stream shorted
       //list.stream().forEach(p -> System.out.println(p));

        //list.stream().forEach( System.out::println); //вызывать для каждого элемента list - println, параметром каждый раз передавать этот же элемент

        //stream + filter
       /** list.stream().
                filter(p -> {
                return p.getAge() > 7;
        }
        ).forEach( System.out::println); **/

        //stream + filter shorted
        /** list.stream().
                filter(p ->
                p.getAge() > 7
        ).forEach( System.out::println); **/

        //stream + filter shorted + sorted
        /** list.stream().
                filter(p ->
                p.getAge() > 7).
                sorted( (p1, p2) -> p1.getName().compareTo(p2.getName())).
        forEach( System.out::println); **/

        //stream + filter shorted + sorted + map
        list.stream().
                filter(p ->
                p.getAge() > 7).
                sorted( (p1, p2) -> p1.getName().compareTo(p2.getName())).
                map( p -> p.getName()).
        forEach( System.out::println);

        //forEach( (String name) -> System.out.println(name)); == forEach( System.out::println);

        /** int sum = 0;
        int moreThan7 = 0;
        for(Person p : list){
            if(p.getAge() > 7){
                sum += p.getAge();
                moreThan7++;
            }
        }
        double avg = (double)sum / moreThan7;
        System.out.println(avg); **/

        //stream + filter shorted + sorted + map + average
        double avg = list.stream().
                filter(p ->
                        p.getAge() > 7).
                mapToInt( p -> p.getAge()).
                average().getAsDouble();
        System.out.println(avg);
        ///////STREAMS///////////
        ///////FUNCTIONAL////////
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}