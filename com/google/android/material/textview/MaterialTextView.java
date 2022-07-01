package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialTextView extends AppCompatTextView {
  public MaterialTextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public MaterialTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public MaterialTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public MaterialTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt1, paramInt2), paramAttributeSet, paramInt1);
    paramContext = getContext();
    if (a(paramContext)) {
      Resources.Theme theme = paramContext.getTheme();
      if (!a(paramContext, theme, paramAttributeSet, paramInt1, paramInt2)) {
        paramInt1 = a(theme, paramAttributeSet, paramInt1, paramInt2);
        if (paramInt1 != -1)
          a(theme, paramInt1); 
      } 
    } 
  }
  
  private static int a(Context paramContext, TypedArray paramTypedArray, int... paramVarArgs) {
    int i = 0;
    int j = -1;
    while (i < paramVarArgs.length && j < 0) {
      j = MaterialResources.a(paramContext, paramTypedArray, paramVarArgs[i], -1);
      i++;
    } 
    return j;
  }
  
  private static int a(Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = paramTheme.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialTextView, paramInt1, paramInt2);
    paramInt1 = typedArray.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
    typedArray.recycle();
    return paramInt1;
  }
  
  private void a(Resources.Theme paramTheme, int paramInt) {
    TypedArray typedArray = paramTheme.obtainStyledAttributes(paramInt, R.styleable.MaterialTextAppearance);
    paramInt = a(getContext(), typedArray, new int[] { R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight });
    typedArray.recycle();
    if (paramInt >= 0)
      setLineHeight(paramInt); 
  }
  
  private static boolean a(Context paramContext) {
    return MaterialAttributes.a(paramContext, R.attr.textAppearanceLineHeightEnabled, true);
  }
  
  private static boolean a(Context paramContext, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = paramTheme.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialTextView, paramInt1, paramInt2);
    paramInt1 = R.styleable.MaterialTextView_android_lineHeight;
    boolean bool = false;
    paramInt1 = a(paramContext, typedArray, new int[] { paramInt1, R.styleable.MaterialTextView_lineHeight });
    typedArray.recycle();
    if (paramInt1 != -1)
      bool = true; 
    return bool;
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    if (a(paramContext))
      a(paramContext.getTheme(), paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textview\MaterialTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */