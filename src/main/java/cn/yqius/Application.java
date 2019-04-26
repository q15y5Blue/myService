package cn.yqius;

import cn.yqius.customService.DiscardServer;
import cn.yqius.util.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final DiscardServer discardServer;

    @Autowired
    public Application(DiscardServer discardServer) {
        this.discardServer = discardServer;
    }

    @Override
    public void run(String... args) throws Exception {
        discardServer.run(8088);
    }
////////////////////////////////////////////////


    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
//
    }
}
