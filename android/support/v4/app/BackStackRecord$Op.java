package android.support.v4.app;

final class BackStackRecord$Op {
  int cmd;
  
  int enterAnim;
  
  int exitAnim;
  
  Fragment fragment;
  
  int popEnterAnim;
  
  int popExitAnim;
  
  BackStackRecord$Op() {}
  
  BackStackRecord$Op(int paramInt, Fragment paramFragment) {
    this.cmd = paramInt;
    this.fragment = paramFragment;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\BackStackRecord$Op.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */