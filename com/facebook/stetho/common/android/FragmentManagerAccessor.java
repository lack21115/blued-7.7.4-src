package com.facebook.stetho.common.android;

import java.util.List;
import javax.annotation.Nullable;

public interface FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> {
  @Nullable
  List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER paramFRAGMENT_MANAGER);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\FragmentManagerAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */