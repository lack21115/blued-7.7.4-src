package com.facebook.stetho.inspector.elements;

public interface DocumentProviderListener {
  void onAttributeModified(Object paramObject, String paramString1, String paramString2);
  
  void onAttributeRemoved(Object paramObject, String paramString);
  
  void onInspectRequested(Object paramObject);
  
  void onPossiblyChanged();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\DocumentProviderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */