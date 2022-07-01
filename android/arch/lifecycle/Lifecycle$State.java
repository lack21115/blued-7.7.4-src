package android.arch.lifecycle;

public enum Lifecycle$State {
  CREATED, DESTROYED, INITIALIZED, RESUMED, STARTED;
  
  static {
    CREATED = new Lifecycle$State("CREATED", 2);
    STARTED = new Lifecycle$State("STARTED", 3);
    RESUMED = new Lifecycle$State("RESUMED", 4);
    $VALUES = new Lifecycle$State[] { DESTROYED, INITIALIZED, CREATED, STARTED, RESUMED };
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\Lifecycle$State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */