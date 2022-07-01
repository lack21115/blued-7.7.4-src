package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ViewModelStores {
  @Deprecated
  public static ViewModelStore of(Fragment paramFragment) {
    return paramFragment.getViewModelStore();
  }
  
  @Deprecated
  public static ViewModelStore of(FragmentActivity paramFragmentActivity) {
    return paramFragmentActivity.getViewModelStore();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\ViewModelStores.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */