package injectest;

import org.springframework.stereotype.Service;

@Service
public class Service1 {

    public void go() {
        System.out.println("Service1.go()");
    }
}
