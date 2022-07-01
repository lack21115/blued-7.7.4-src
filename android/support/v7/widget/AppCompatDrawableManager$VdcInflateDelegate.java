package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

final class AppCompatDrawableManager$VdcInflateDelegate implements AppCompatDrawableManager$InflateDelegate {
  public final Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    try {
      return (Drawable)VectorDrawableCompat.createFromXmlInner(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
    } catch (Exception exception) {
      Log.e("VdcInflateDelegate", "Exception while inflating <vector>", exception);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatDrawableManager$VdcInflateDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */