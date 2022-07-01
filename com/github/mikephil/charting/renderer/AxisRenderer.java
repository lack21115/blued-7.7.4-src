package com.github.mikephil.charting.renderer;

import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class AxisRenderer extends Renderer {
  protected AxisBase a;
  
  protected Transformer b;
  
  protected Paint c;
  
  protected Paint d;
  
  protected Paint e;
  
  protected Paint f;
  
  public AxisRenderer(ViewPortHandler paramViewPortHandler, Transformer paramTransformer, AxisBase paramAxisBase) {
    super(paramViewPortHandler);
    this.b = paramTransformer;
    this.a = paramAxisBase;
    if (this.o != null) {
      this.d = new Paint(1);
      this.c = new Paint();
      this.c.setColor(-7829368);
      this.c.setStrokeWidth(1.0F);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setAlpha(90);
      this.e = new Paint();
      this.e.setColor(-16777216);
      this.e.setStrokeWidth(1.0F);
      this.e.setStyle(Paint.Style.STROKE);
      this.f = new Paint(1);
      this.f.setStyle(Paint.Style.STROKE);
    } 
  }
  
  public Paint a() {
    return this.d;
  }
  
  protected void a(float paramFloat1, float paramFloat2) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (this.o != null) {
      f2 = paramFloat1;
      f1 = paramFloat2;
      if (this.o.i() > 10.0F) {
        f2 = paramFloat1;
        f1 = paramFloat2;
        if (!this.o.t()) {
          double d;
          MPPointD mPPointD1 = this.b.a(this.o.f(), this.o.e());
          MPPointD mPPointD2 = this.b.a(this.o.f(), this.o.h());
          if (!paramBoolean) {
            paramFloat1 = (float)mPPointD2.b;
            d = mPPointD1.b;
          } else {
            paramFloat1 = (float)mPPointD1.b;
            d = mPPointD2.b;
          } 
          f1 = (float)d;
          MPPointD.a(mPPointD1);
          MPPointD.a(mPPointD2);
          f2 = paramFloat1;
        } 
      } 
    } 
    a(f2, f1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\AxisRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */