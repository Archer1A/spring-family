package com.vic.reactorDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
@Slf4j
public class ReactorDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactorDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // just(): 指定序列中包含的全部元素。创建出来的Flux序列在发布这些元素后会自动结束
        Flux.just("hello","world").subscribe(System.out::println);
        // formArray(),formIterable(),fromStream(): 可以从一个数组，iterable对象或stream对象中创建flux对象
        Flux.fromArray(new Integer[]{1, 2, 3, 4, 5, 6}).subscribe(System.out::println);
        //empty(): 创建一个不包含任何元素，只发布结束消息的序列
        Flux.empty().subscribe(System.out::println);
        //创建包含start 起始的 count个数量的integer对象的序列
        Flux.range(1, 3).subscribe(System.out::println);

        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::print);
        Flux.generate(sink -> {
            sink.next("hello");
            sink.next("hhhh");
            sink.complete();
        }).subscribe(System.out::print);
       /* Flux.range(1, 6)
                .doOnRequest(n -> log.info("request {} number"))
                .doOnComplete(()->log.info("Publisher complete 1"));*/
    }
}
