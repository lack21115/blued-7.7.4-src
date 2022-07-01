package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimationUtilsCompat {
  private static Interpolator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser) throws XmlPullParserException, IOException {
    PathInterpolatorCompat pathInterpolatorCompat;
    int i = paramXmlPullParser.getDepth();
    paramResources = null;
    while (true) {
      int j = paramXmlPullParser.next();
      if ((j != 3 || paramXmlPullParser.getDepth() > i) && j != 1) {
        LinearInterpolator linearInterpolator;
        AccelerateInterpolator accelerateInterpolator;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator;
        CycleInterpolator cycleInterpolator;
        AnticipateInterpolator anticipateInterpolator;
        OvershootInterpolator overshootInterpolator;
        BounceInterpolator bounceInterpolator;
        if (j != 2)
          continue; 
        AttributeSet attributeSet = Xml.asAttributeSet(paramXmlPullParser);
        String str = paramXmlPullParser.getName();
        if (str.equals("linearInterpolator")) {
          linearInterpolator = new LinearInterpolator();
          continue;
        } 
        if (str.equals("accelerateInterpolator")) {
          accelerateInterpolator = new AccelerateInterpolator(paramContext, (AttributeSet)linearInterpolator);
          continue;
        } 
        if (str.equals("decelerateInterpolator")) {
          DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(paramContext, (AttributeSet)accelerateInterpolator);
          continue;
        } 
        if (str.equals("accelerateDecelerateInterpolator")) {
          accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
          continue;
        } 
        if (str.equals("cycleInterpolator")) {
          cycleInterpolator = new CycleInterpolator(paramContext, (AttributeSet)accelerateDecelerateInterpolator);
          continue;
        } 
        if (str.equals("anticipateInterpolator")) {
          anticipateInterpolator = new AnticipateInterpolator(paramContext, (AttributeSet)cycleInterpolator);
          continue;
        } 
        if (str.equals("overshootInterpolator")) {
          overshootInterpolator = new OvershootInterpolator(paramContext, (AttributeSet)anticipateInterpolator);
          continue;
        } 
        if (str.equals("anticipateOvershootInterpolator")) {
          AnticipateOvershootInterpolator anticipateOvershootInterpolator = new AnticipateOvershootInterpolator(paramContext, (AttributeSet)overshootInterpolator);
          continue;
        } 
        if (str.equals("bounceInterpolator")) {
          bounceInterpolator = new BounceInterpolator();
          continue;
        } 
        if (str.equals("pathInterpolator")) {
          pathInterpolatorCompat = new PathInterpolatorCompat(paramContext, (AttributeSet)bounceInterpolator, paramXmlPullParser);
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown interpolator name: ");
        stringBuilder.append(paramXmlPullParser.getName());
        throw new RuntimeException(stringBuilder.toString());
      } 
      break;
    } 
    return pathInterpolatorCompat;
  }
  
  public static Interpolator loadInterpolator(Context paramContext, int paramInt) throws Resources.NotFoundException {
    if (Build.VERSION.SDK_INT >= 21)
      return AnimationUtils.loadInterpolator(paramContext, paramInt); 
    StringBuilder stringBuilder = null;
    Resources.NotFoundException notFoundException2 = null;
    Resources.NotFoundException notFoundException1 = null;
    if (paramInt == 17563663) {
      Resources.NotFoundException notFoundException;
      try {
        return (Interpolator)new FastOutLinearInInterpolator();
      } catch (XmlPullParserException xmlPullParserException) {
        notFoundException1 = notFoundException2;
        stringBuilder = new StringBuilder();
        notFoundException1 = notFoundException2;
        stringBuilder.append("Can't load animation resource ID #0x");
        notFoundException1 = notFoundException2;
        stringBuilder.append(Integer.toHexString(paramInt));
        notFoundException1 = notFoundException2;
        notFoundException = new Resources.NotFoundException(stringBuilder.toString());
        notFoundException1 = notFoundException2;
        notFoundException.initCause((Throwable)xmlPullParserException);
        notFoundException1 = notFoundException2;
        throw notFoundException;
      } catch (IOException iOException) {
        notFoundException1 = notFoundException;
        StringBuilder stringBuilder1 = new StringBuilder();
        notFoundException1 = notFoundException;
        stringBuilder1.append("Can't load animation resource ID #0x");
        notFoundException1 = notFoundException;
        stringBuilder1.append(Integer.toHexString(paramInt));
        notFoundException1 = notFoundException;
        Resources.NotFoundException notFoundException3 = new Resources.NotFoundException(stringBuilder1.toString());
        notFoundException1 = notFoundException;
        notFoundException3.initCause(iOException);
        notFoundException1 = notFoundException;
        throw notFoundException3;
      } finally {
        if (notFoundException1 != null)
          notFoundException1.close(); 
      } 
    } 
    if (paramInt == 17563661)
      return (Interpolator)new FastOutSlowInInterpolator(); 
    if (paramInt == 17563662)
      return (Interpolator)new LinearOutSlowInInterpolator(); 
    XmlResourceParser xmlResourceParser4 = paramContext.getResources().getAnimation(paramInt);
    XmlResourceParser xmlResourceParser1 = xmlResourceParser4;
    XmlResourceParser xmlResourceParser2 = xmlResourceParser4;
    XmlResourceParser xmlResourceParser3 = xmlResourceParser4;
    Interpolator interpolator = a(paramContext, paramContext.getResources(), paramContext.getTheme(), (XmlPullParser)xmlResourceParser4);
    if (xmlResourceParser4 != null)
      xmlResourceParser4.close(); 
    return interpolator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\vectordrawable\graphics\drawable\AnimationUtilsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */