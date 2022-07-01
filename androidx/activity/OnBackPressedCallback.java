package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {
  private boolean a;
  
  private CopyOnWriteArrayList<Cancellable> b = new CopyOnWriteArrayList<Cancellable>();
  
  public OnBackPressedCallback(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  void a(Cancellable paramCancellable) {
    this.b.add(paramCancellable);
  }
  
  void b(Cancellable paramCancellable) {
    this.b.remove(paramCancellable);
  }
  
  public abstract void handleOnBackPressed();
  
  public final boolean isEnabled() {
    return this.a;
  }
  
  public final void remove() {
    Iterator<Cancellable> iterator = this.b.iterator();
    while (iterator.hasNext())
      ((Cancellable)iterator.next()).cancel(); 
  }
  
  public final void setEnabled(boolean paramBoolean) {
    this.a = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\activity\OnBackPressedCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */