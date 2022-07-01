package android.support.v7.widget;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TextView;
import java.lang.ref.WeakReference;

final class AppCompatTextHelper$1 extends ResourcesCompat.FontCallback {
  public final void onFontRetrieved(Typeface paramTypeface) {
    AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
    WeakReference<TextView> weakReference = textViewWeak;
    if (appCompatTextHelper.mAsyncFontPending) {
      appCompatTextHelper.mFontTypeface = paramTypeface;
      TextView textView = weakReference.get();
      if (textView != null)
        textView.setTypeface(paramTypeface, appCompatTextHelper.mStyle); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatTextHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */