<<<<<<< HEAD
package proxy;

import java.util.Objects;
import java.util.function.Function;

public class TypeProxy {
    public static Function<?,String> string = String::valueOf;
    public static Function<String,Integer> integer = Integer::parseInt;
    public static Function<String,Double> doubleof = Double::parseDouble;
    public static Function<String,Float> floatof = Float::parseFloat;
    public static Function<String,Long> longof = Long::parseLong;

}
=======
package proxy;

import java.util.Objects;
import java.util.function.Function;

public class TypeProxy {
    public static Function<?,String> string = String::valueOf;
    public static Function<String,Integer> integer = Integer::parseInt;
    public static Function<String,Double> doubleof = Double::parseDouble;
    public static Function<String,Float> floatof = Float::parseFloat;
    public static Function<String,Long> longof = Long::parseLong;

}
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9
