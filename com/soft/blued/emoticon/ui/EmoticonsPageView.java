package com.soft.blued.emoticon.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmoticonsPageView extends ViewPager implements IViewStateListener {
  public int d = -1;
  
  private Context e;
  
  private IRequestHost f;
  
  private int g = 0;
  
  private int h = 0;
  
  private List<EmoticonPackageModel> i;
  
  private EmoticonsViewPagerAdapter j;
  
  private List<View> k = new ArrayList<View>();
  
  private List<IViewStateListener> l;
  
  private OnEmoticonsPageViewListener m;
  
  public EmoticonsPageView(Context paramContext) {
    super(paramContext);
    this.e = paramContext;
  }
  
  public EmoticonsPageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
  }
  
  public int a(EmoticonPackageModel paramEmoticonPackageModel) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(IRequestHost paramIRequestHost, List<EmoticonPackageModel> paramList) {
    this.f = paramIRequestHost;
    this.i = paramList;
  }
  
  public void a(EmoticonModel paramEmoticonModel) {
    List<IViewStateListener> list = this.l;
    if (list != null && !list.isEmpty()) {
      Iterator<IViewStateListener> iterator = this.l.iterator();
      while (iterator.hasNext())
        ((IViewStateListener)iterator.next()).a(paramEmoticonModel); 
    } 
  }
  
  public void a(IViewStateListener paramIViewStateListener) {
    if (this.l == null)
      this.l = new ArrayList<IViewStateListener>(); 
    this.l.add(paramIViewStateListener);
  }
  
  public void c(int paramInt) {}
  
  public void f() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = paramInt2;
    post(new Runnable(this) {
          public void run() {
            this.a.f();
          }
        });
  }
  
  public void setIViewListener(IViewStateListener paramIViewStateListener) {
    a(paramIViewStateListener);
  }
  
  public void setOnIndicatorListener(OnEmoticonsPageViewListener paramOnEmoticonsPageViewListener) {
    this.m = paramOnEmoticonsPageViewListener;
  }
  
  public void setPageSelect(int paramInt) {
    if (getAdapter() != null && paramInt >= 0 && paramInt < this.i.size()) {
      int i = 0;
      int j = 0;
      while (i < paramInt) {
        j += a(this.i.get(i));
        i++;
      } 
      setCurrentItem(j);
    } 
  }
  
  class EmoticonsViewPagerAdapter extends PagerAdapter {
    private EmoticonsViewPagerAdapter(EmoticonsPageView this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      ((ViewPager)param1ViewGroup).removeView((View)param1Object);
    }
    
    public int getCount() {
      return EmoticonsPageView.d(this.a).size();
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      ((ViewPager)param1ViewGroup).addView(EmoticonsPageView.d(this.a).get(param1Int));
      return EmoticonsPageView.d(this.a).get(param1Int);
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  public static interface OnEmoticonsPageViewListener {
    void a(int param1Int);
    
    void a(int param1Int1, int param1Int2);
    
    void b(int param1Int);
    
    void c(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\emotico\\ui\EmoticonsPageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */