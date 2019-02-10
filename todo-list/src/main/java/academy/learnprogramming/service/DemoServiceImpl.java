package academy.learnprogramming.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    public String getWelcomeMessage() {
        return "Welcome to this demo application";
    }
}
