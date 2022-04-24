package io.kringen.producer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

  @PostConstruct 
	public void init(){ 
    KafkaTopicConfig topicConfig = new KafkaTopicConfig();
	} 
}
 