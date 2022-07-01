package android.support.v4.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class ResourcesCompat$FontCallback {
  public final void callbackFailAsync(int paramInt, Handler paramHandler) {
    Handler handler = paramHandler;
    if (paramHandler == null)
      handler = new Handler(Looper.getMainLooper()); 
    handler.post(new ResourcesCompat$FontCallback$2());
  }
  
  public final void callbackSuccessAsync(Typeface paramTypeface, Handler paramHandler) {
    Handler handler = paramHandler;
    if (paramHandler == null)
      handler = new Handler(Looper.getMainLooper()); 
    handler.post(new ResourcesCompat$FontCallback$1(this, paramTypeface));
  }
  
  public abstract void onFontRetrieved(Typeface paramTypeface);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\content\res\ResourcesCompat$FontCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */