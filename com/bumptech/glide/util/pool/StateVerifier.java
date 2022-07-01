package com.bumptech.glide.util.pool;

public abstract class StateVerifier {
  private StateVerifier() {}
  
  public static StateVerifier a() {
    return new DefaultStateVerifier();
  }
  
  abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  static class DebugStateVerifier extends StateVerifier {
    private volatile RuntimeException a;
    
    void a(boolean param1Boolean) {
      if (param1Boolean) {
        this.a = new RuntimeException("Released");
        return;
      } 
      this.a = null;
    }
    
    public void b() {
      if (this.a == null)
        return; 
      throw new IllegalStateException("Already released", this.a);
    }
  }
  
  static class DefaultStateVerifier extends StateVerifier {
    private volatile boolean a;
    
    public void a(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public void b() {
      if (!this.a)
        return; 
      throw new IllegalStateException("Already released");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\pool\StateVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */