package android.support.v4.app;

import java.util.ArrayList;

final class FragmentManagerImpl$PopBackStackState implements FragmentManagerImpl$OpGenerator {
  private int mFlags;
  
  private int mId;
  
  private String mName;
  
  FragmentManagerImpl$PopBackStackState(String paramString, int paramInt1, int paramInt2) {
    this.mName = paramString;
    this.mId = paramInt1;
    this.mFlags = paramInt2;
  }
  
  public final boolean generateOps(ArrayList paramArrayList1, ArrayList paramArrayList2) {
    if (FragmentManagerImpl.this.mPrimaryNav != null && this.mId < 0 && this.mName == null) {
      FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this.mPrimaryNav.mChildFragmentManager;
      if (fragmentManagerImpl != null && fragmentManagerImpl.popBackStackImmediate())
        return false; 
    } 
    return FragmentManagerImpl.this.popBackStackState(paramArrayList1, paramArrayList2, this.mName, this.mId, this.mFlags);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$PopBackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */