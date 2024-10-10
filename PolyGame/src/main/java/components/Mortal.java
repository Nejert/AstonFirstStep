package components;

/**
 * {@code Mortal} interface is implemented by classes that has the property of being killed.
 *
 * @see Entity
 */
public interface Mortal {
  /**
   * Method that lets you know whether the calling object is alive.
   *
   * @return {@code true} if this object is alive
   */
  boolean isAlive();
}
