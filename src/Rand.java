import java.lang.Math;

//import java.util.Random;

public final class Rand {

  public static final int getRandomNumberInRange(int min, int max) {
    if (min >= max) {
      throw new IllegalArgumentException("max must be greater than min");
    }

    return (int) (Math.random() * ((max - min) + 1)) + min;
  }
}
