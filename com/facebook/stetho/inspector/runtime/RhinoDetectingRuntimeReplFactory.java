package com.facebook.stetho.inspector.runtime;

import android.content.Context;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import java.lang.reflect.InvocationTargetException;

public class RhinoDetectingRuntimeReplFactory implements RuntimeReplFactory {
  private final Context mContext;
  
  private RuntimeException mRhinoJsUnexpectedError;
  
  private RuntimeReplFactory mRhinoReplFactory;
  
  private boolean mSearchedForRhinoJs;
  
  public RhinoDetectingRuntimeReplFactory(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private static RuntimeReplFactory findRhinoReplFactory(Context paramContext) throws RuntimeException {
    try {
      return (RuntimeReplFactory)Class.forName("com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder").getDeclaredMethod("defaultFactory", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
    } catch (ClassNotFoundException classNotFoundException) {
      LogUtil.i("Error finding stetho-js-rhino, cannot enable console evaluation!");
      return null;
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimeException(noSuchMethodException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException(invocationTargetException);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } 
  }
  
  public RuntimeRepl newInstance() {
    if (!this.mSearchedForRhinoJs) {
      this.mSearchedForRhinoJs = true;
      try {
        this.mRhinoReplFactory = findRhinoReplFactory(this.mContext);
      } catch (RuntimeException runtimeException) {
        this.mRhinoJsUnexpectedError = runtimeException;
      } 
    } 
    RuntimeReplFactory runtimeReplFactory = this.mRhinoReplFactory;
    return (runtimeReplFactory != null) ? runtimeReplFactory.newInstance() : new RuntimeRepl() {
        public Object evaluate(String param1String) throws Exception {
          if (RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("stetho-js-rhino threw: ");
            stringBuilder.append(RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError.toString());
            return stringBuilder.toString();
          } 
          return "Not supported without stetho-js-rhino dependency";
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\runtime\RhinoDetectingRuntimeReplFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */