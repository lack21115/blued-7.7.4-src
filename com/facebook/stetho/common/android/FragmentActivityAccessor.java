package com.facebook.stetho.common.android;

import javax.annotation.Nullable;

public interface FragmentActivityAccessor<FRAGMENT_ACTIVITY extends android.app.Activity, FRAGMENT_MANAGER> {
  @Nullable
  FRAGMENT_MANAGER getFragmentManager(FRAGMENT_ACTIVITY paramFRAGMENT_ACTIVITY);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\FragmentActivityAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */