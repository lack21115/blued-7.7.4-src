package com.facebook.stetho.common.android;

import android.content.res.Resources;
import android.view.View;
import javax.annotation.Nullable;

public interface FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER> {
  public static final int NO_ID = 0;
  
  @Nullable
  FRAGMENT_MANAGER getChildFragmentManager(FRAGMENT paramFRAGMENT);
  
  @Nullable
  FRAGMENT_MANAGER getFragmentManager(FRAGMENT paramFRAGMENT);
  
  int getId(FRAGMENT paramFRAGMENT);
  
  Resources getResources(FRAGMENT paramFRAGMENT);
  
  @Nullable
  String getTag(FRAGMENT paramFRAGMENT);
  
  @Nullable
  View getView(FRAGMENT paramFRAGMENT);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\FragmentAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */