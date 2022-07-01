package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

final class AppCompatDrawableManager$AvdcInflateDelegate implements AppCompatDrawableManager$InflateDelegate {
  public final Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    try {
      return (Drawable)AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
    } catch (Exception exception) {
      Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", exception);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatDrawableManager$AvdcInflateDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */