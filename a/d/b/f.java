package a.d.b;

import a.d.a.i.d;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public class f extends View {
  public int b;
  
  public View c;
  
  public int d;
  
  public void a() {
    if (this.c == null)
      throw new VerifyError("bad dex opcode"); 
    ConstraintLayout.a a1 = (ConstraintLayout.a)getLayoutParams();
    ConstraintLayout.a a2 = (ConstraintLayout.a)this.c.getLayoutParams();
    d d = a2.k0;
    d.Y = 0;
    a1.k0.f(d.h());
    a1.k0.e(a2.k0.c());
    a2.k0.Y = 8;
    throw new VerifyError("bad dex opcode");
  }
  
  public void a(ConstraintLayout paramConstraintLayout) {
    if (this.b == -1 && !isInEditMode())
      setVisibility(this.d); 
    this.c = paramConstraintLayout.findViewById(this.b);
    View view = this.c;
    if (view != null) {
      ((ConstraintLayout.a)view.getLayoutParams()).Z = true;
      this.c.setVisibility(0);
      setVisibility(0);
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public View getContent() {
    return this.c;
  }
  
  public int getEmptyVisibility() {
    return this.d;
  }
  
  public void onDraw(Canvas paramCanvas) {
    if (isInEditMode()) {
      paramCanvas.drawRGB(223, 223, 223);
      Paint paint = new Paint();
      paint.setARGB(255, 210, 210, 210);
      paint.setTextAlign(Paint.Align.CENTER);
      paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect rect = new Rect();
      paramCanvas.getClipBounds(rect);
      paint.setTextSize(rect.height());
      int i = rect.height();
      int j = rect.width();
      paint.setTextAlign(Paint.Align.LEFT);
      paint.getTextBounds("?", 0, 1, rect);
      float f1 = j / 2.0F;
      float f2 = rect.width() / 2.0F;
      float f3 = rect.left;
      float f4 = i / 2.0F;
      paramCanvas.drawText("?", f1 - f2 - f3, rect.height() / 2.0F + f4 - rect.bottom, paint);
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public void setContentId(int paramInt) {
    if (this.b == paramInt)
      throw new VerifyError("bad dex opcode"); 
    View view = this.c;
    if (view != null) {
      view.setVisibility(0);
      ((ConstraintLayout.a)this.c.getLayoutParams()).Z = false;
      this.c = null;
    } 
    this.b = paramInt;
    if (paramInt != -1) {
      view = ((View)getParent()).findViewById(paramInt);
      if (view != null)
        view.setVisibility(8); 
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public void setEmptyVisibility(int paramInt) {
    this.d = paramInt;
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\d\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */