package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod {
  private Locale a;
  
  public AllCapsTransformationMethod(Context paramContext) {
    this.a = (paramContext.getResources().getConfiguration()).locale;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView) {
    return (paramCharSequence != null) ? paramCharSequence.toString().toUpperCase(this.a) : null;
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\text\AllCapsTransformationMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */