package a.d.b;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class e extends View {
  public e(Context paramContext) {
    super(paramContext);
    super.setVisibility(8);
    throw new VerifyError("bad dex opcode");
  }
  
  public void draw(Canvas paramCanvas) {
    throw new VerifyError("bad dex opcode");
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(0, 0);
    throw new VerifyError("bad dex opcode");
  }
  
  public void setGuidelineBegin(int paramInt) {
    ConstraintLayout.a a = (ConstraintLayout.a)getLayoutParams();
    a.a = paramInt;
    setLayoutParams((ViewGroup.LayoutParams)a);
    throw new VerifyError("bad dex opcode");
  }
  
  public void setGuidelineEnd(int paramInt) {
    ConstraintLayout.a a = (ConstraintLayout.a)getLayoutParams();
    a.b = paramInt;
    setLayoutParams((ViewGroup.LayoutParams)a);
    throw new VerifyError("bad dex opcode");
  }
  
  public void setGuidelinePercent(float paramFloat) {
    ConstraintLayout.a a = (ConstraintLayout.a)getLayoutParams();
    a.c = paramFloat;
    setLayoutParams((ViewGroup.LayoutParams)a);
    throw new VerifyError("bad dex opcode");
  }
  
  public void setVisibility(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\d\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */