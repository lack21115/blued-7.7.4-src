package androidx.core.text;

import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat implements Spannable {
  private static final Object a = new Object();
  
  private static Executor b = null;
  
  private final Spannable c;
  
  private final Params d;
  
  private final int[] e;
  
  private final PrecomputedText f;
  
  private PrecomputedTextCompat(PrecomputedText paramPrecomputedText, Params paramParams) {
    this.c = (Spannable)paramPrecomputedText;
    this.d = paramParams;
    this.e = null;
    if (Build.VERSION.SDK_INT < 29)
      paramPrecomputedText = null; 
    this.f = paramPrecomputedText;
  }
  
  private PrecomputedTextCompat(CharSequence paramCharSequence, Params paramParams, int[] paramArrayOfint) {
    this.c = (Spannable)new SpannableString(paramCharSequence);
    this.d = paramParams;
    this.e = paramArrayOfint;
    this.f = null;
  }
  
  public static PrecomputedTextCompat create(CharSequence paramCharSequence, Params paramParams) {
    Preconditions.checkNotNull(paramCharSequence);
    Preconditions.checkNotNull(paramParams);
    try {
      PrecomputedTextCompat precomputedTextCompat;
      TraceCompat.beginSection("PrecomputedText");
      if (Build.VERSION.SDK_INT >= 29 && paramParams.a != null) {
        precomputedTextCompat = new PrecomputedTextCompat(PrecomputedText.create(paramCharSequence, paramParams.a), paramParams);
        return precomputedTextCompat;
      } 
      ArrayList<Integer> arrayList = new ArrayList();
      int j = precomputedTextCompat.length();
      int i = 0;
      while (true) {
        if (i < j) {
          i = TextUtils.indexOf((CharSequence)precomputedTextCompat, '\n', i, j);
          if (i < 0) {
            i = j;
          } else {
            i++;
          } 
          arrayList.add(Integer.valueOf(i));
          continue;
        } 
        int[] arrayOfInt = new int[arrayList.size()];
        for (i = 0; i < arrayList.size(); i++)
          arrayOfInt[i] = ((Integer)arrayList.get(i)).intValue(); 
        if (Build.VERSION.SDK_INT >= 23) {
          StaticLayout.Builder.obtain((CharSequence)precomputedTextCompat, 0, precomputedTextCompat.length(), paramParams.getTextPaint(), 2147483647).setBreakStrategy(paramParams.getBreakStrategy()).setHyphenationFrequency(paramParams.getHyphenationFrequency()).setTextDirection(paramParams.getTextDirection()).build();
        } else if (Build.VERSION.SDK_INT >= 21) {
          new StaticLayout((CharSequence)precomputedTextCompat, paramParams.getTextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
        } 
        precomputedTextCompat = new PrecomputedTextCompat((CharSequence)precomputedTextCompat, paramParams, arrayOfInt);
        return precomputedTextCompat;
      } 
    } finally {
      TraceCompat.endSection();
    } 
  }
  
  public static Future<PrecomputedTextCompat> getTextFuture(CharSequence paramCharSequence, Params paramParams, Executor paramExecutor) {
    PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextFutureTask(paramParams, paramCharSequence);
    Executor executor = paramExecutor;
    if (paramExecutor == null)
      synchronized (a) {
        if (b == null)
          b = Executors.newFixedThreadPool(1); 
        executor = b;
      }  
    executor.execute(precomputedTextFutureTask);
    return precomputedTextFutureTask;
  }
  
  public char charAt(int paramInt) {
    return this.c.charAt(paramInt);
  }
  
  public int getParagraphCount() {
    return (Build.VERSION.SDK_INT >= 29) ? this.f.getParagraphCount() : this.e.length;
  }
  
  public int getParagraphEnd(int paramInt) {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    return (Build.VERSION.SDK_INT >= 29) ? this.f.getParagraphEnd(paramInt) : this.e[paramInt];
  }
  
  public int getParagraphStart(int paramInt) {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    return (Build.VERSION.SDK_INT >= 29) ? this.f.getParagraphStart(paramInt) : ((paramInt == 0) ? 0 : this.e[paramInt - 1]);
  }
  
  public Params getParams() {
    return this.d;
  }
  
  public PrecomputedText getPrecomputedText() {
    Spannable spannable = this.c;
    return (spannable instanceof PrecomputedText) ? (PrecomputedText)spannable : null;
  }
  
  public int getSpanEnd(Object paramObject) {
    return this.c.getSpanEnd(paramObject);
  }
  
  public int getSpanFlags(Object paramObject) {
    return this.c.getSpanFlags(paramObject);
  }
  
  public int getSpanStart(Object paramObject) {
    return this.c.getSpanStart(paramObject);
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass) {
    return (T[])((Build.VERSION.SDK_INT >= 29) ? this.f.getSpans(paramInt1, paramInt2, paramClass) : this.c.getSpans(paramInt1, paramInt2, paramClass));
  }
  
  public int length() {
    return this.c.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass) {
    return this.c.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public void removeSpan(Object paramObject) {
    if (!(paramObject instanceof android.text.style.MetricAffectingSpan)) {
      if (Build.VERSION.SDK_INT >= 29) {
        this.f.removeSpan(paramObject);
        return;
      } 
      this.c.removeSpan(paramObject);
      return;
    } 
    throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
    if (!(paramObject instanceof android.text.style.MetricAffectingSpan)) {
      if (Build.VERSION.SDK_INT >= 29) {
        this.f.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
        return;
      } 
      this.c.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    } 
    throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2) {
    return this.c.subSequence(paramInt1, paramInt2);
  }
  
  public String toString() {
    return this.c.toString();
  }
  
  public static final class Params {
    final PrecomputedText.Params a;
    
    private final TextPaint b;
    
    private final TextDirectionHeuristic c;
    
    private final int d;
    
    private final int e;
    
    public Params(PrecomputedText.Params param1Params) {
      this.b = param1Params.getTextPaint();
      this.c = param1Params.getTextDirection();
      this.d = param1Params.getBreakStrategy();
      this.e = param1Params.getHyphenationFrequency();
      if (Build.VERSION.SDK_INT < 29)
        param1Params = null; 
      this.a = param1Params;
    }
    
    Params(TextPaint param1TextPaint, TextDirectionHeuristic param1TextDirectionHeuristic, int param1Int1, int param1Int2) {
      if (Build.VERSION.SDK_INT >= 29) {
        this.a = (new PrecomputedText.Params.Builder(param1TextPaint)).setBreakStrategy(param1Int1).setHyphenationFrequency(param1Int2).setTextDirection(param1TextDirectionHeuristic).build();
      } else {
        this.a = null;
      } 
      this.b = param1TextPaint;
      this.c = param1TextDirectionHeuristic;
      this.d = param1Int1;
      this.e = param1Int2;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Params))
        return false; 
      param1Object = param1Object;
      return !equalsWithoutTextDirection((Params)param1Object) ? false : (!(Build.VERSION.SDK_INT >= 18 && this.c != param1Object.getTextDirection()));
    }
    
    public boolean equalsWithoutTextDirection(Params param1Params) {
      if (Build.VERSION.SDK_INT >= 23) {
        if (this.d != param1Params.getBreakStrategy())
          return false; 
        if (this.e != param1Params.getHyphenationFrequency())
          return false; 
      } 
      if (this.b.getTextSize() != param1Params.getTextPaint().getTextSize())
        return false; 
      if (this.b.getTextScaleX() != param1Params.getTextPaint().getTextScaleX())
        return false; 
      if (this.b.getTextSkewX() != param1Params.getTextPaint().getTextSkewX())
        return false; 
      if (Build.VERSION.SDK_INT >= 21) {
        if (this.b.getLetterSpacing() != param1Params.getTextPaint().getLetterSpacing())
          return false; 
        if (!TextUtils.equals(this.b.getFontFeatureSettings(), param1Params.getTextPaint().getFontFeatureSettings()))
          return false; 
      } 
      if (this.b.getFlags() != param1Params.getTextPaint().getFlags())
        return false; 
      if (Build.VERSION.SDK_INT >= 24) {
        if (!this.b.getTextLocales().equals(param1Params.getTextPaint().getTextLocales()))
          return false; 
      } else if (Build.VERSION.SDK_INT >= 17 && !this.b.getTextLocale().equals(param1Params.getTextPaint().getTextLocale())) {
        return false;
      } 
      if (this.b.getTypeface() == null) {
        if (param1Params.getTextPaint().getTypeface() != null)
          return false; 
      } else if (!this.b.getTypeface().equals(param1Params.getTextPaint().getTypeface())) {
        return false;
      } 
      return true;
    }
    
    public int getBreakStrategy() {
      return this.d;
    }
    
    public int getHyphenationFrequency() {
      return this.e;
    }
    
    public TextDirectionHeuristic getTextDirection() {
      return this.c;
    }
    
    public TextPaint getTextPaint() {
      return this.b;
    }
    
    public int hashCode() {
      return (Build.VERSION.SDK_INT >= 24) ? ObjectsCompat.hash(new Object[] { 
            Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocales(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), 
            Integer.valueOf(this.e) }) : ((Build.VERSION.SDK_INT >= 21) ? ObjectsCompat.hash(new Object[] { 
            Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), 
            Integer.valueOf(this.e) }) : ((Build.VERSION.SDK_INT >= 18) ? ObjectsCompat.hash(new Object[] { Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e) }) : ((Build.VERSION.SDK_INT >= 17) ? ObjectsCompat.hash(new Object[] { Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e) }) : ObjectsCompat.hash(new Object[] { Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e) }))));
    }
    
    public String toString() {
      StringBuilder stringBuilder1 = new StringBuilder("{");
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("textSize=");
      stringBuilder2.append(this.b.getTextSize());
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", textScaleX=");
      stringBuilder2.append(this.b.getTextScaleX());
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", textSkewX=");
      stringBuilder2.append(this.b.getTextSkewX());
      stringBuilder1.append(stringBuilder2.toString());
      if (Build.VERSION.SDK_INT >= 21) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", letterSpacing=");
        stringBuilder2.append(this.b.getLetterSpacing());
        stringBuilder1.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", elegantTextHeight=");
        stringBuilder2.append(this.b.isElegantTextHeight());
        stringBuilder1.append(stringBuilder2.toString());
      } 
      if (Build.VERSION.SDK_INT >= 24) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", textLocale=");
        stringBuilder2.append(this.b.getTextLocales());
        stringBuilder1.append(stringBuilder2.toString());
      } else if (Build.VERSION.SDK_INT >= 17) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", textLocale=");
        stringBuilder2.append(this.b.getTextLocale());
        stringBuilder1.append(stringBuilder2.toString());
      } 
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", typeface=");
      stringBuilder2.append(this.b.getTypeface());
      stringBuilder1.append(stringBuilder2.toString());
      if (Build.VERSION.SDK_INT >= 26) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", variationSettings=");
        stringBuilder2.append(this.b.getFontVariationSettings());
        stringBuilder1.append(stringBuilder2.toString());
      } 
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", textDir=");
      stringBuilder2.append(this.c);
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", breakStrategy=");
      stringBuilder2.append(this.d);
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", hyphenationFrequency=");
      stringBuilder2.append(this.e);
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append("}");
      return stringBuilder1.toString();
    }
    
    public static class Builder {
      private final TextPaint a;
      
      private TextDirectionHeuristic b;
      
      private int c;
      
      private int d;
      
      public Builder(TextPaint param2TextPaint) {
        this.a = param2TextPaint;
        if (Build.VERSION.SDK_INT >= 23) {
          this.c = 1;
          this.d = 1;
        } else {
          this.d = 0;
          this.c = 0;
        } 
        if (Build.VERSION.SDK_INT >= 18) {
          this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
        } 
        this.b = null;
      }
      
      public PrecomputedTextCompat.Params build() {
        return new PrecomputedTextCompat.Params(this.a, this.b, this.c, this.d);
      }
      
      public Builder setBreakStrategy(int param2Int) {
        this.c = param2Int;
        return this;
      }
      
      public Builder setHyphenationFrequency(int param2Int) {
        this.d = param2Int;
        return this;
      }
      
      public Builder setTextDirection(TextDirectionHeuristic param2TextDirectionHeuristic) {
        this.b = param2TextDirectionHeuristic;
        return this;
      }
    }
  }
  
  public static class Builder {
    private final TextPaint a;
    
    private TextDirectionHeuristic b;
    
    private int c;
    
    private int d;
    
    public Builder(TextPaint param1TextPaint) {
      this.a = param1TextPaint;
      if (Build.VERSION.SDK_INT >= 23) {
        this.c = 1;
        this.d = 1;
      } else {
        this.d = 0;
        this.c = 0;
      } 
      if (Build.VERSION.SDK_INT >= 18) {
        this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        return;
      } 
      this.b = null;
    }
    
    public PrecomputedTextCompat.Params build() {
      return new PrecomputedTextCompat.Params(this.a, this.b, this.c, this.d);
    }
    
    public Builder setBreakStrategy(int param1Int) {
      this.c = param1Int;
      return this;
    }
    
    public Builder setHyphenationFrequency(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public Builder setTextDirection(TextDirectionHeuristic param1TextDirectionHeuristic) {
      this.b = param1TextDirectionHeuristic;
      return this;
    }
  }
  
  static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {
    PrecomputedTextFutureTask(PrecomputedTextCompat.Params param1Params, CharSequence param1CharSequence) {
      super(new PrecomputedTextCallback(param1Params, param1CharSequence));
    }
    
    static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
      private PrecomputedTextCompat.Params a;
      
      private CharSequence b;
      
      PrecomputedTextCallback(PrecomputedTextCompat.Params param2Params, CharSequence param2CharSequence) {
        this.a = param2Params;
        this.b = param2CharSequence;
      }
      
      public PrecomputedTextCompat call() throws Exception {
        return PrecomputedTextCompat.create(this.b, this.a);
      }
    }
  }
  
  static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
    private PrecomputedTextCompat.Params a;
    
    private CharSequence b;
    
    PrecomputedTextCallback(PrecomputedTextCompat.Params param1Params, CharSequence param1CharSequence) {
      this.a = param1Params;
      this.b = param1CharSequence;
    }
    
    public PrecomputedTextCompat call() throws Exception {
      return PrecomputedTextCompat.create(this.b, this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\text\PrecomputedTextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */