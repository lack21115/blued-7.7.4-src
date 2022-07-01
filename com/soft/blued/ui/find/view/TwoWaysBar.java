package com.soft.blued.ui.find.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.customview.rangebar.RangeBar;
import com.soft.blued.utils.Logger;

public class TwoWaysBar extends RangeBar {
  public Context a;
  
  public int b = 100;
  
  public TwoWaysBarListner c;
  
  public int d = 1;
  
  private boolean e = true;
  
  private int f;
  
  private int g;
  
  private boolean h;
  
  public TwoWaysBar(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public TwoWaysBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public TwoWaysBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
    String str1;
    String str2 = "+";
    String str3 = "";
    if (paramInt3 == 2) {
      StringBuilder stringBuilder1 = new StringBuilder();
      str1 = paramContext.getResources().getString(2131757905);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramInt1);
      stringBuilder2.append("-");
      stringBuilder2.append(paramInt2);
      stringBuilder1.append(String.format(str1, new Object[] { stringBuilder2.toString() }));
      if (paramInt2 < 30)
        str2 = ""; 
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    if (paramInt3 == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("-");
      stringBuilder.append(paramInt2);
      stringBuilder.append(str1.getResources().getString(2131756203));
      if (paramInt2 < 100)
        str2 = ""; 
      stringBuilder.append(str2);
      return stringBuilder.toString();
    } 
    if (paramInt3 == 4) {
      if (paramInt1 == 0 && paramInt2 == 0)
        return str1.getResources().getString(2131758043); 
      if (paramInt1 == 0 && paramInt2 == 100)
        return str1.getResources().getString(2131758025); 
      if (paramInt1 == paramInt2) {
        paramInt2 = paramInt1;
        if (paramInt1 == 100)
          paramInt2 = 99; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt2);
        stringBuilder1.append("-");
        paramInt1 = paramInt2 + 1;
        stringBuilder1.append(paramInt1);
        stringBuilder1.append(str1.getResources().getString(2131756203));
        if (paramInt1 < 100)
          str2 = ""; 
        stringBuilder1.append(str2);
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("-");
      stringBuilder.append(paramInt2);
      stringBuilder.append(str1.getResources().getString(2131756203));
      if (paramInt2 < 100)
        str2 = ""; 
      stringBuilder.append(str2);
      str3 = stringBuilder.toString();
    } 
    return str3;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt) {
    boolean bool = paramString.contains("-");
    int i = 0;
    if (bool) {
      String[] arrayOfString = paramString.split("-");
      if (arrayOfString.length == 2) {
        int j;
        try {
          j = Integer.valueOf(arrayOfString[0]).intValue();
          i = j;
        } catch (Exception exception1) {}
        if (paramInt == 2) {
          j = 30;
        } else {
          j = 100;
        } 
        if (paramInt == 2) {
          try {
            if (arrayOfString[1].equals("max")) {
              j = 30;
            } else {
              int k = Integer.valueOf(arrayOfString[1]).intValue();
              j = k;
            } 
          } catch (Exception exception) {}
        } else if (exception[1].equals("max")) {
          j = 100;
        } else {
          int k = Integer.valueOf((String)exception[1]).intValue();
          j = k;
        } 
        return a(paramContext, i, j, paramInt);
      } 
    } 
    if (paramInt == 2)
      return String.format(paramContext.getResources().getString(2131757905), new Object[] { "0-30+" }); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("0-100+");
    stringBuilder.append(paramContext.getResources().getString(2131756203));
    return stringBuilder.toString();
  }
  
  private void a() {
    this.g = ViewConfiguration.get(this.a).getScaledTouchSlop();
    setBarColor(BluedSkinUtils.a(this.a, 2131100533));
    setBarWeight(DensityUtils.a(this.a, 3.0F));
    if (this.e || getContext() instanceof com.soft.blued.ui.home.HomeActivity) {
      setConnectingLineColor(this.a.getResources().getColor(2131100527));
    } else {
      setConnectingLineColor(this.a.getResources().getColor(2131100533));
    } 
    setConnectingLineWeight(DensityUtils.a(this.a, 1.0F));
    setTickCount(this.b);
    setTickHeight(0.0F);
    setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener(this) {
          public void a(RangeBar param1RangeBar, int param1Int1, int param1Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("left:");
            stringBuilder.append(param1Int1);
            stringBuilder.append(",right:");
            stringBuilder.append(param1Int2);
            Logger.a("rangebar", stringBuilder.toString());
            if (this.a.c != null) {
              if (this.a.d == 3 || this.a.d == 4) {
                this.a.c.a(param1Int1, param1Int2);
                return;
              } 
              int i = param1Int1;
              if (param1Int1 < 0)
                i = 0; 
              param1Int1 = param1Int2;
              if (param1Int2 + 1 > this.a.b)
                param1Int1 = this.a.b - 1; 
              this.a.c.a(i, param1Int1 + 1);
              return;
            } 
          }
        });
  }
  
  public void a(String paramString, int paramInt) {
    this.b = paramInt;
    a();
    int n = paramInt - 1;
    boolean bool = paramString.contains("-");
    int m = 0;
    int i = 0;
    int k = n;
    if (bool) {
      int i1 = m;
      try {
        String[] arrayOfString = paramString.split("-");
        i1 = m;
        m = Integer.valueOf(arrayOfString[0]).intValue();
        k = n;
        i = m;
        i1 = m;
        if (!"max".equals(arrayOfString[1])) {
          i1 = m;
          k = Integer.valueOf(arrayOfString[1]).intValue();
          i = m;
        } 
      } catch (Exception exception) {
        k = n;
        i = i1;
      } 
    } 
    int j = this.d;
    if (j == 3 || j == 4 || j == 2) {
      if (i >= 0 && k < paramInt)
        a(i, k); 
      return;
    } 
    if (i >= 0 && k < paramInt) {
      a(i, k - 1);
      return;
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0) {
      if (i != 1) {
        if (i == 2 && !this.h && Math.abs(this.f - paramMotionEvent.getX()) > this.g) {
          TwoWaysBarListner twoWaysBarListner = this.c;
          if (twoWaysBarListner != null) {
            this.h = true;
            twoWaysBarListner.c(this.e);
          } 
        } 
      } else {
        this.h = false;
        TwoWaysBarListner twoWaysBarListner = this.c;
        if (twoWaysBarListner != null)
          twoWaysBarListner.b(this.e); 
      } 
    } else {
      this.f = (int)paramMotionEvent.getX();
      TwoWaysBarListner twoWaysBarListner = this.c;
      if (twoWaysBarListner != null)
        twoWaysBarListner.a(this.e); 
    } 
    return this.e ? super.onTouchEvent(paramMotionEvent) : true;
  }
  
  public void setEnabled(boolean paramBoolean) {
    this.e = paramBoolean;
    if (this.e || getContext() instanceof com.soft.blued.ui.home.HomeActivity) {
      setThumbImageNormal(2131232764);
      setThumbImagePressed(2131232764);
      setConnectingLineColor(this.a.getResources().getColor(2131100716));
      return;
    } 
    setThumbImageNormal(2131232765);
    setThumbImagePressed(2131232765);
    setConnectingLineColor(this.a.getResources().getColor(2131100733));
  }
  
  public void setTwoWaysBarListner(TwoWaysBarListner paramTwoWaysBarListner) {
    this.c = paramTwoWaysBarListner;
  }
  
  public static interface RANGE_TYPE {}
  
  public static class TowWaysBarListenerAdapter implements TwoWaysBarListner {
    public void a(int param1Int1, int param1Int2) {}
    
    public void a(boolean param1Boolean) {}
    
    public void b(boolean param1Boolean) {}
    
    public void c(boolean param1Boolean) {}
  }
  
  public static interface TwoWaysBarListner {
    void a(int param1Int1, int param1Int2);
    
    void a(boolean param1Boolean);
    
    void b(boolean param1Boolean);
    
    void c(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\TwoWaysBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */