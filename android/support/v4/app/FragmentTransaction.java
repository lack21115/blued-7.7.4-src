package android.support.v4.app;

public abstract class FragmentTransaction {
  public abstract FragmentTransaction add(Fragment paramFragment, String paramString);
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public abstract FragmentTransaction remove(Fragment paramFragment);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */