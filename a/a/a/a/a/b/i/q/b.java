package a.a.a.a.a.b.i.q;

public class b {
  public Thread a = Thread.currentThread();
  
  public void a() {
    if (this.a == null)
      this.a = Thread.currentThread(); 
    if (Thread.currentThread() == this.a)
      return; 
    throw new IllegalStateException("Wrong thread");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\q\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */