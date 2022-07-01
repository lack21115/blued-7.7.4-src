package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;

final class AndroidDocumentRoot extends AbstractChainedDescriptor<AndroidDocumentRoot> {
  private final Application mApplication;
  
  public AndroidDocumentRoot(Application paramApplication) {
    this.mApplication = (Application)Util.throwIfNull(paramApplication);
  }
  
  protected void onGetChildren(AndroidDocumentRoot paramAndroidDocumentRoot, Accumulator<Object> paramAccumulator) {
    paramAccumulator.store(this.mApplication);
  }
  
  protected String onGetNodeName(AndroidDocumentRoot paramAndroidDocumentRoot) {
    return "root";
  }
  
  protected NodeType onGetNodeType(AndroidDocumentRoot paramAndroidDocumentRoot) {
    return NodeType.DOCUMENT_NODE;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\AndroidDocumentRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */