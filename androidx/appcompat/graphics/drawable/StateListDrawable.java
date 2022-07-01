package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class StateListDrawable extends DrawableContainer {
  private StateListState a;
  
  private boolean b;
  
  StateListDrawable() {
    this((StateListState)null, (Resources)null);
  }
  
  StateListDrawable(StateListState paramStateListState) {
    if (paramStateListState != null)
      a(paramStateListState); 
  }
  
  StateListDrawable(StateListState paramStateListState, Resources paramResources) {
    a(new StateListState(paramStateListState, this, paramResources));
    onStateChange(getState());
  }
  
  private void a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    StateListState stateListState = this.a;
    int i = paramXmlPullParser.getDepth() + 1;
    while (true) {
      Drawable drawable;
      int[] arrayOfInt;
      int j = paramXmlPullParser.next();
      if (j != 1) {
        int k = paramXmlPullParser.getDepth();
        if (k >= i || j != 3) {
          if (j != 2 || k > i || !paramXmlPullParser.getName().equals("item"))
            continue; 
          TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawableItem);
          Drawable drawable1 = null;
          j = typedArray.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
          if (j > 0)
            drawable1 = ResourceManagerInternal.get().getDrawable(paramContext, j); 
          typedArray.recycle();
          arrayOfInt = a(paramAttributeSet);
          drawable = drawable1;
          if (drawable1 == null)
            while (true) {
              j = paramXmlPullParser.next();
              if (j == 4)
                continue; 
              if (j == 2) {
                if (Build.VERSION.SDK_INT >= 21) {
                  drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
                  break;
                } 
                drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(paramXmlPullParser.getPositionDescription());
                stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(stringBuilder.toString());
              } 
              stateListState.a(arrayOfInt, drawable);
            }  
        } else {
          break;
        } 
      } else {
        break;
      } 
      stateListState.a(arrayOfInt, drawable);
    } 
  }
  
  private void a(TypedArray paramTypedArray) {
    StateListState stateListState = this.a;
    if (Build.VERSION.SDK_INT >= 21)
      stateListState.f |= paramTypedArray.getChangingConfigurations(); 
    stateListState.k = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, stateListState.k);
    stateListState.n = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, stateListState.n);
    stateListState.C = paramTypedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, stateListState.C);
    stateListState.D = paramTypedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, stateListState.D);
    stateListState.z = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_dither, stateListState.z);
  }
  
  void a(DrawableContainer.DrawableContainerState paramDrawableContainerState) {
    super.a(paramDrawableContainerState);
    if (paramDrawableContainerState instanceof StateListState)
      this.a = (StateListState)paramDrawableContainerState; 
  }
  
  int[] a(AttributeSet paramAttributeSet) {
    int k = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[k];
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      int n = paramAttributeSet.getAttributeNameResource(i);
      int m = j;
      if (n != 0) {
        m = j;
        if (n != 16842960) {
          m = j;
          if (n != 16843161) {
            if (paramAttributeSet.getAttributeBooleanValue(i, false)) {
              m = n;
            } else {
              m = -n;
            } 
            arrayOfInt[j] = m;
            m = j + 1;
          } 
        } 
      } 
      i++;
    } 
    return StateSet.trimStateSet(arrayOfInt, j);
  }
  
  public void addState(int[] paramArrayOfint, Drawable paramDrawable) {
    if (paramDrawable != null) {
      this.a.a(paramArrayOfint, paramDrawable);
      onStateChange(getState());
    } 
  }
  
  public void applyTheme(Resources.Theme paramTheme) {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  StateListState b() {
    return new StateListState(this.a, this, null);
  }
  
  public void inflate(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawable);
    setVisible(typedArray.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
    a(typedArray);
    a(paramResources);
    typedArray.recycle();
    a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    onStateChange(getState());
  }
  
  public boolean isStateful() {
    return true;
  }
  
  public Drawable mutate() {
    if (!this.b && super.mutate() == this) {
      this.a.a();
      this.b = true;
    } 
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    boolean bool = super.onStateChange(paramArrayOfint);
    int j = this.a.b(paramArrayOfint);
    int i = j;
    if (j < 0)
      i = this.a.b(StateSet.WILD_CARD); 
    return (a(i) || bool);
  }
  
  static class StateListState extends DrawableContainer.DrawableContainerState {
    int[][] L;
    
    StateListState(StateListState param1StateListState, StateListDrawable param1StateListDrawable, Resources param1Resources) {
      super(param1StateListState, param1StateListDrawable, param1Resources);
      if (param1StateListState != null) {
        this.L = param1StateListState.L;
        return;
      } 
      this.L = new int[c()][];
    }
    
    int a(int[] param1ArrayOfint, Drawable param1Drawable) {
      int i = addChild(param1Drawable);
      this.L[i] = param1ArrayOfint;
      return i;
    }
    
    void a() {
      int[][] arrayOfInt1 = this.L;
      int[][] arrayOfInt2 = new int[arrayOfInt1.length][];
      for (int i = arrayOfInt1.length - 1; i >= 0; i--) {
        arrayOfInt1 = this.L;
        if (arrayOfInt1[i] != null) {
          int[] arrayOfInt = (int[])arrayOfInt1[i].clone();
        } else {
          arrayOfInt1 = null;
        } 
        arrayOfInt2[i] = (int[])arrayOfInt1;
      } 
      this.L = arrayOfInt2;
    }
    
    int b(int[] param1ArrayOfint) {
      int[][] arrayOfInt = this.L;
      int j = getChildCount();
      for (int i = 0; i < j; i++) {
        if (StateSet.stateSetMatches(arrayOfInt[i], param1ArrayOfint))
          return i; 
      } 
      return -1;
    }
    
    public void growArray(int param1Int1, int param1Int2) {
      super.growArray(param1Int1, param1Int2);
      int[][] arrayOfInt = new int[param1Int2][];
      System.arraycopy(this.L, 0, arrayOfInt, 0, param1Int1);
      this.L = arrayOfInt;
    }
    
    public Drawable newDrawable() {
      return new StateListDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      return new StateListDrawable(this, param1Resources);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\graphics\drawable\StateListDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */