package com.google.android.gms.common.api.internal;

final class zabc implements BackgroundDetector.BackgroundStateChangeListener {
  zabc(GoogleApiManager paramGoogleApiManager) {}
  
  public final void onBackgroundStateChanged(boolean paramBoolean) {
    GoogleApiManager.zaa(this.zaa).sendMessage(GoogleApiManager.zaa(this.zaa).obtainMessage(1, Boolean.valueOf(paramBoolean)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zabc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */