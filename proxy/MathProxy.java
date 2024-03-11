
package proxy;

import jdk.dynalink.beans.StaticClass;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;

public class MathProxy {
    public static Function<Integer,Integer> absInt = Math::abs;
    public static Function<Integer,Integer> roundInt = Math::round;
    public static BiFunction<Integer,Integer,Integer> minInt = Math::min;
    public static BiFunction<Integer,Integer,Integer> maxInt = Math::max;
    public static BiFunction<Integer,Integer,Integer> randomInt = (a,b) -> (int) (Math.random() *(b-a)+a);
    public static Function<Integer,Integer> floorInt = (a) -> (int) (Math.floor(a));
    public static BiFunction<Integer,Integer,Integer> parseInt = Math::min;


    public static Function<Double,Double> absDouble = Math::abs;
    public static Function<Double,Double> ceilDouble = Math::ceil;
    public static Function<Double,Double> sinDouble = Math::sin;
    public static BiFunction<Double,Double,Double> minDouble = Math::min;
    public static BiFunction<Double,Double,Double> maxDouble = Math::max;
    public static BiFunction<Double,Double,Double> randomDouble = (a,b) -> (Double) (Math.random() *(b-a)+a);
    public static Function<Double,Double> floorDouble = (a) -> (double) (Math.floor(a));


    public static Function<Float,Float> absFloat = Math::abs;
    public static BiFunction<Float,Float,Float> minFloat = Math::min;
    public static BiFunction<Float,Float,Float> maxFloat = Math::max;
    public static BiFunction<Float,Float,Float> randomFloat = (a,b) -> (float) (Math.random() *(b-a)+a);
    public static Function<Float,Float> floorFloat = (a) -> (float) (Math.floor(a));

}