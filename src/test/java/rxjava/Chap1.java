package rxjava;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by jiyeon on 2017. 6. 20..
 */
public class Chap1 {

    @Test
    public void test() {
        // SAM : single abstract method
        Observable<String> obs = Observable.create(s -> {
            s.onNext("hello");
        });

        obs.map(str -> str + " world")
            .subscribe(o -> { System.out.println(o); });
    }

    public static void main(String[] args) {
        // > world
        // hello world

        Scanner scanner = new Scanner(System.in);

        Observable<String> obs = Observable.create(s -> {
            scanner.forEachRemaining(input -> s.onNext(input));
        });

        obs.map(str -> "hello " + str )
                .subscribe(o -> { System.out.println(o); });
    }
}
