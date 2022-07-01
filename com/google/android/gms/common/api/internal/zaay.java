package com.google.android.gms.common.api.internal;

abstract class zaay {
  private final zaaw zaa;
  
  protected zaay(zaaw paramzaaw) {
    this.zaa = paramzaaw;
  }
  
  protected abstract void zaa();
  
  public final void zaa(zaaz paramzaaz) {
    zaaz.zaa(paramzaaz).lock();
    try {
      zaaw zaaw1 = zaaz.zab(paramzaaz);
      zaaw zaaw2 = this.zaa;
      if (zaaw1 != zaaw2)
        return; 
      zaa();
      return;
    } finally {
      zaaz.zaa(paramzaaz).unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */