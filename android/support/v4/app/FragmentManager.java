package android.support.v4.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager {
  public abstract FragmentTransaction beginTransaction();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract Fragment findFragmentByTag(String paramString);
  
  public abstract List getFragments();
  
  public abstract boolean isStateSaved();
  
  public abstract void popBackStack(int paramInt1, int paramInt2);
  
  public abstract boolean popBackStackImmediate();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */