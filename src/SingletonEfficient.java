/**
 * This is an alternative implementation of singleton with
 * synchronized methods perform well in multi-thread applications.
 * Since the use of synchronized methods is a performance bottleneck,
 * the inner class approach exploits the fact that inner classes are not
 * loaded until they are referenced.
 * 
 * @author Daniel Valle
 */

public class SingletonEfficient {
  private SingletonEfficient() { }

  public static class SingletonHolder {
    public static SingletonEfficient singleton = new SingletonEfficient();
  }

  public static SingletonEfficient getInstance() {
    return SingletonHolder.singleton;
  }
}