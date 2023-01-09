package com.example.demo.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Aqui estamos informando para o compilador que essa anotação esta disponivel em tempo de execução.
@Retention(RetentionPolicy.RUNTIME)
// Diz que podemos definir nossas proprias anotações personalizadas.
@Target(ElementType.METHOD)
// Habilitando o Kafka
@KafkaListener
public @interface StrConsumerCustomListener {

    // @AliasFor serve para definir atributos dentro de uma anotação.

    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "my-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";

}
