package org.chromium.content.browser;

import android.util.Pair;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.webcontents.WebContentsUserData;
import org.chromium.content_public.browser.JavascriptInjector;
import org.chromium.content_public.browser.WebContents;

public class JavascriptInjectorImpl implements JavascriptInjector {
  private final Map mInjectedObjects = new HashMap<Object, Object>();
  
  private long mNativePtr;
  
  private final Set mRetainedObjects = new HashSet();
  
  public JavascriptInjectorImpl(WebContents paramWebContents) {
    this.mNativePtr = nativeInit(paramWebContents, this.mRetainedObjects);
  }
  
  public static JavascriptInjector fromWebContents(WebContents paramWebContents) {
    return (JavascriptInjector)WebContentsUserData.fromWebContents(paramWebContents, JavascriptInjectorImpl.class, JavascriptInjectorImpl$UserDataFactoryLazyHolder.access$000());
  }
  
  private native void nativeAddInterface(long paramLong, Object paramObject, String paramString, Class paramClass);
  
  private native long nativeInit(WebContents paramWebContents, Object paramObject);
  
  private native void nativeRemoveInterface(long paramLong, String paramString);
  
  private native void nativeSetAllowInspection(long paramLong, boolean paramBoolean);
  
  @CalledByNative
  private void onDestroy() {
    this.mNativePtr = 0L;
  }
  
  public final void addPossiblyUnsafeInterface(Object paramObject, String paramString, Class paramClass) {
    if (this.mNativePtr != 0L && paramObject != null) {
      this.mInjectedObjects.put(paramString, new Pair(paramObject, paramClass));
      nativeAddInterface(this.mNativePtr, paramObject, paramString, paramClass);
    } 
  }
  
  public final Map getInterfaces() {
    return this.mInjectedObjects;
  }
  
  public final void removeInterface(String paramString) {
    this.mInjectedObjects.remove(paramString);
    if (this.mNativePtr != 0L)
      nativeRemoveInterface(this.mNativePtr, paramString); 
  }
  
  public final void setAllowInspection(boolean paramBoolean) {
    if (this.mNativePtr != 0L)
      nativeSetAllowInspection(this.mNativePtr, paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\JavascriptInjectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */