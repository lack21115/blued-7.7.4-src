package android.arch.lifecycle;

public enum Lifecycle$Event {
  ON_ANY, ON_CREATE, ON_DESTROY, ON_PAUSE, ON_RESUME, ON_START, ON_STOP;
  
  static {
    ON_RESUME = new Lifecycle$Event("ON_RESUME", 2);
    ON_PAUSE = new Lifecycle$Event("ON_PAUSE", 3);
    ON_STOP = new Lifecycle$Event("ON_STOP", 4);
    ON_DESTROY = new Lifecycle$Event("ON_DESTROY", 5);
    ON_ANY = new Lifecycle$Event("ON_ANY", 6);
    $VALUES = new Lifecycle$Event[] { ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY };
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\Lifecycle$Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */