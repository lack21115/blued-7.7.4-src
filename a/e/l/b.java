package a.e.l;

import android.os.Build;

public interface b {
  public static final boolean a;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 27) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\e\l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */