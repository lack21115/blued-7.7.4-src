package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

final class AppCompatTextViewAutoSizeHelper {
  private static final RectF TEMP_RECTF = new RectF();
  
  private static Hashtable sTextViewMethodByNameCache = new Hashtable<Object, Object>();
  
  float mAutoSizeMaxTextSizeInPx = -1.0F;
  
  float mAutoSizeMinTextSizeInPx = -1.0F;
  
  float mAutoSizeStepGranularityInPx = -1.0F;
  
  int[] mAutoSizeTextSizesInPx = new int[0];
  
  int mAutoSizeTextType = 0;
  
  final Context mContext;
  
  boolean mHasPresetAutoSizeValues = false;
  
  boolean mNeedsAutoSizeText = false;
  
  private TextPaint mTempTextPaint;
  
  private final TextView mTextView;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  AppCompatTextViewAutoSizeHelper(TextView paramTextView) {
    this.mTextView = paramTextView;
    this.mContext = this.mTextView.getContext();
  }
  
  static int[] cleanupAutoSizePresetSizes(int[] paramArrayOfint) {
    int j = paramArrayOfint.length;
    if (j == 0)
      return paramArrayOfint; 
    Arrays.sort(paramArrayOfint);
    ArrayList<? extends Comparable<? super Integer>> arrayList = new ArrayList();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      int k = paramArrayOfint[i];
      if (k > 0 && Collections.binarySearch(arrayList, Integer.valueOf(k)) < 0)
        arrayList.add(Integer.valueOf(k)); 
    } 
    if (j == arrayList.size())
      return paramArrayOfint; 
    j = arrayList.size();
    paramArrayOfint = new int[j];
    for (i = bool; i < j; i++)
      paramArrayOfint[i] = ((Integer)arrayList.get(i)).intValue(); 
    return paramArrayOfint;
  }
  
  private static Method getTextViewMethod(String paramString) {
    try {
      Method method2 = (Method)sTextViewMethodByNameCache.get(paramString);
      Method method1 = method2;
      if (method2 == null) {
        method2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        method1 = method2;
        if (method2 != null) {
          method2.setAccessible(true);
          sTextViewMethodByNameCache.put(paramString, method2);
          method1 = method2;
        } 
      } 
      return method1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Failed to retrieve TextView#");
      stringBuilder.append(paramString);
      stringBuilder.append("() method");
      Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), exception);
      return null;
    } 
  }
  
  private static Object invokeAndReturnWithDefault(Object paramObject1, String paramString, Object paramObject2) {
    try {
      return getTextViewMethod(paramString).invoke(paramObject1, new Object[0]);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Failed to invoke TextView#");
      stringBuilder.append(paramString);
      stringBuilder.append("() method");
      Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), exception);
      return paramObject2;
    } finally {}
    throw paramObject1;
  }
  
  final void autoSizeText() {
    if (!isAutoSizeEnabled())
      return; 
    if (this.mNeedsAutoSizeText) {
      if (this.mTextView.getMeasuredHeight() > 0) {
        int i;
        if (this.mTextView.getMeasuredWidth() <= 0)
          return; 
        if (((Boolean)invokeAndReturnWithDefault(this.mTextView, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
          i = 1048576;
        } else {
          i = this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft() - this.mTextView.getTotalPaddingRight();
        } 
        int j = this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom() - this.mTextView.getCompoundPaddingTop();
        if (i > 0) {
          if (j <= 0)
            return; 
          synchronized (TEMP_RECTF) {
            TEMP_RECTF.setEmpty();
            TEMP_RECTF.right = i;
            TEMP_RECTF.bottom = j;
            RectF rectF = TEMP_RECTF;
            i = this.mAutoSizeTextSizesInPx.length;
            if (i != 0) {
              int k = i - 1;
              i = 1;
              j = 0;
              while (true) {
                int m;
                if (i <= k) {
                  StaticLayout staticLayout;
                  StaticLayout.Builder builder;
                  m = (i + k) / 2;
                  int n = this.mAutoSizeTextSizesInPx[m];
                  CharSequence charSequence2 = this.mTextView.getText();
                  TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
                  CharSequence charSequence1 = charSequence2;
                  if (transformationMethod != null) {
                    CharSequence charSequence = transformationMethod.getTransformation(charSequence2, (View)this.mTextView);
                    charSequence1 = charSequence2;
                    if (charSequence != null)
                      charSequence1 = charSequence; 
                  } 
                  if (Build.VERSION.SDK_INT >= 16) {
                    j = this.mTextView.getMaxLines();
                  } else {
                    j = -1;
                  } 
                  if (this.mTempTextPaint == null) {
                    this.mTempTextPaint = new TextPaint();
                  } else {
                    this.mTempTextPaint.reset();
                  } 
                  this.mTempTextPaint.set(this.mTextView.getPaint());
                  this.mTempTextPaint.setTextSize(n);
                  Layout.Alignment alignment = (Layout.Alignment)invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
                  if (Build.VERSION.SDK_INT >= 23) {
                    n = Math.round(rectF.right);
                    TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic)invokeAndReturnWithDefault(this.mTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
                    builder = StaticLayout.Builder.obtain(charSequence1, 0, charSequence1.length(), this.mTempTextPaint, n).setAlignment(alignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
                    if (j == -1) {
                      n = Integer.MAX_VALUE;
                    } else {
                      n = j;
                    } 
                    staticLayout = builder.setMaxLines(n).setTextDirection(textDirectionHeuristic).build();
                  } else {
                    float f1;
                    float f2;
                    boolean bool;
                    n = Math.round(rectF.right);
                    if (Build.VERSION.SDK_INT >= 16) {
                      f1 = this.mTextView.getLineSpacingMultiplier();
                      f2 = this.mTextView.getLineSpacingExtra();
                      bool = this.mTextView.getIncludeFontPadding();
                    } else {
                      f1 = ((Float)invokeAndReturnWithDefault(this.mTextView, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
                      f2 = ((Float)invokeAndReturnWithDefault(this.mTextView, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
                      bool = ((Boolean)invokeAndReturnWithDefault(this.mTextView, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
                    } 
                    staticLayout = new StaticLayout(charSequence1, this.mTempTextPaint, n, (Layout.Alignment)builder, f1, f2, bool);
                  } 
                  if ((j != -1 && (staticLayout.getLineCount() > j || staticLayout.getLineEnd(staticLayout.getLineCount() - 1) != charSequence1.length())) || staticLayout.getHeight() > rectF.bottom) {
                    j = 0;
                  } else {
                    j = 1;
                  } 
                } else {
                  float f = this.mAutoSizeTextSizesInPx[j];
                  if (f != this.mTextView.getTextSize())
                    setTextSizeInternal(0, f); 
                  this.mNeedsAutoSizeText = true;
                } 
                if (j != 0) {
                  j = i;
                  i = m + 1;
                  continue;
                } 
                j = m - 1;
                k = j;
              } 
            } 
            throw new IllegalStateException("No available text sizes to choose from.");
          } 
        } 
        return;
      } 
      return;
    } 
    this.mNeedsAutoSizeText = true;
  }
  
  final boolean isAutoSizeEnabled() {
    return (supportsAutoSizeText() && this.mAutoSizeTextType != 0);
  }
  
  final void setTextSizeInternal(int paramInt, float paramFloat) {
    Resources resources;
    if (this.mContext == null) {
      resources = Resources.getSystem();
    } else {
      resources = this.mContext.getResources();
    } 
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, resources.getDisplayMetrics());
    if (paramFloat != this.mTextView.getPaint().getTextSize()) {
      boolean bool;
      this.mTextView.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT >= 18) {
        bool = this.mTextView.isInLayout();
      } else {
        bool = false;
      } 
      if (this.mTextView.getLayout() != null) {
        this.mNeedsAutoSizeText = false;
        try {
          Method method = getTextViewMethod("nullLayouts");
          if (method != null)
            method.invoke(this.mTextView, new Object[0]); 
        } catch (Exception exception) {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", exception);
        } 
        if (!bool) {
          this.mTextView.requestLayout();
        } else {
          this.mTextView.forceLayout();
        } 
        this.mTextView.invalidate();
      } 
    } 
  }
  
  final boolean setupAutoSizeText() {
    boolean bool = supportsAutoSizeText();
    int i = 0;
    if (bool && this.mAutoSizeTextType == 1) {
      if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
        float f = Math.round(this.mAutoSizeMinTextSizeInPx);
        int j = 1;
        while (Math.round(this.mAutoSizeStepGranularityInPx + f) <= Math.round(this.mAutoSizeMaxTextSizeInPx)) {
          j++;
          f += this.mAutoSizeStepGranularityInPx;
        } 
        int[] arrayOfInt = new int[j];
        f = this.mAutoSizeMinTextSizeInPx;
        while (i < j) {
          arrayOfInt[i] = Math.round(f);
          f += this.mAutoSizeStepGranularityInPx;
          i++;
        } 
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      } 
      this.mNeedsAutoSizeText = true;
    } else {
      this.mNeedsAutoSizeText = false;
    } 
    return this.mNeedsAutoSizeText;
  }
  
  final boolean setupAutoSizeUniformPresetSizesConfiguration() {
    boolean bool;
    int i = this.mAutoSizeTextSizesInPx.length;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mHasPresetAutoSizeValues = bool;
    if (this.mHasPresetAutoSizeValues) {
      this.mAutoSizeTextType = 1;
      this.mAutoSizeMinTextSizeInPx = this.mAutoSizeTextSizesInPx[0];
      this.mAutoSizeMaxTextSizeInPx = this.mAutoSizeTextSizesInPx[i - 1];
      this.mAutoSizeStepGranularityInPx = -1.0F;
    } 
    return this.mHasPresetAutoSizeValues;
  }
  
  final boolean supportsAutoSizeText() {
    return !(this.mTextView instanceof AppCompatEditText);
  }
  
  final void validateAndSetAutoSizeTextTypeUniformConfiguration(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (paramFloat1 > 0.0F) {
      if (paramFloat2 > paramFloat1) {
        if (paramFloat3 > 0.0F) {
          this.mAutoSizeTextType = 1;
          this.mAutoSizeMinTextSizeInPx = paramFloat1;
          this.mAutoSizeMaxTextSizeInPx = paramFloat2;
          this.mAutoSizeStepGranularityInPx = paramFloat3;
          this.mHasPresetAutoSizeValues = false;
          return;
        } 
        StringBuilder stringBuilder2 = new StringBuilder("The auto-size step granularity (");
        stringBuilder2.append(paramFloat3);
        stringBuilder2.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder("Maximum auto-size text size (");
      stringBuilder1.append(paramFloat2);
      stringBuilder1.append("px) is less or equal to minimum auto-size text size (");
      stringBuilder1.append(paramFloat1);
      stringBuilder1.append("px)");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder("Minimum auto-size text size (");
    stringBuilder.append(paramFloat1);
    stringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatTextViewAutoSizeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */