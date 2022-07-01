package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

final class Fragment$2 extends FragmentContainer {
  public final Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle) {
    return Fragment.this.mHost.instantiate(paramContext, paramString, paramBundle);
  }
  
  public final View onFindViewById(int paramInt) {
    if (Fragment.this.mView != null)
      return Fragment.this.mView.findViewById(paramInt); 
    throw new IllegalStateException("Fragment does not have a view");
  }
  
  public final boolean onHasView() {
    return (Fragment.this.mView != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\Fragment$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */