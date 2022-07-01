package org.chromium.android_webview;

import android.view.ViewGroup;

final class AwContents$FullScreenTransitionsState {
  FullScreenView mFullScreenView;
  
  final AwViewMethods mInitialAwViewMethods;
  
  final ViewGroup mInitialContainerView;
  
  final AwContents$InternalAccessDelegate mInitialInternalAccessAdapter;
  
  boolean mWasInitialContainerViewFocused;
  
  private AwContents$FullScreenTransitionsState(ViewGroup paramViewGroup, AwContents$InternalAccessDelegate paramAwContents$InternalAccessDelegate, AwViewMethods paramAwViewMethods) {
    this.mInitialContainerView = paramViewGroup;
    this.mInitialInternalAccessAdapter = paramAwContents$InternalAccessDelegate;
    this.mInitialAwViewMethods = paramAwViewMethods;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$FullScreenTransitionsState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */