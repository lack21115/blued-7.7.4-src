package android.support.v4.content;

import android.support.v4.util.DebugUtils;

public final class Loader {
  public boolean mAbandoned;
  
  public boolean mContentChanged;
  
  public int mId;
  
  public Loader$OnLoadCompleteListener mListener;
  
  public Loader$OnLoadCanceledListener mOnLoadCanceledListener;
  
  public boolean mProcessingChange;
  
  public boolean mReset;
  
  public boolean mStarted;
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(this, stringBuilder);
    stringBuilder.append(" id=");
    stringBuilder.append(this.mId);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public final void unregisterListener(Loader$OnLoadCompleteListener paramLoader$OnLoadCompleteListener) {
    if (this.mListener != null) {
      if (this.mListener == paramLoader$OnLoadCompleteListener) {
        this.mListener = null;
        return;
      } 
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    } 
    throw new IllegalStateException("No listener register");
  }
  
  public final void unregisterOnLoadCanceledListener(Loader$OnLoadCanceledListener paramLoader$OnLoadCanceledListener) {
    if (this.mOnLoadCanceledListener != null) {
      if (this.mOnLoadCanceledListener == paramLoader$OnLoadCanceledListener) {
        this.mOnLoadCanceledListener = null;
        return;
      } 
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    } 
    throw new IllegalStateException("No listener register");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\content\Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */