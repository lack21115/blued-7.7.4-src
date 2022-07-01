package com.soft.blued.emoticon.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.framework.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class EmoticonsIndicatorView extends LinearLayout {
  private Context a;
  
  private ArrayList<ImageView> b;
  
  private Bitmap c;
  
  private Bitmap d;
  
  private int e = 12;
  
  private int f;
  
  public EmoticonsIndicatorView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setOrientation(0);
    this.f = DensityUtils.a(this.a, this.e);
    this.c = BitmapFactory.decodeResource(getResources(), 2131232875);
    this.d = BitmapFactory.decodeResource(getResources(), 2131232874);
  }
  
  public void a(int paramInt) {
    if (this.b != null)
      return; 
    this.b = new ArrayList<ImageView>();
    for (int i = 0; i < paramInt; i++) {
      RelativeLayout relativeLayout = new RelativeLayout(this.a);
      int j = this.f;
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(j, j);
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams1.addRule(13);
      ImageView imageView = new ImageView(this.a);
      if (i == 0) {
        imageView.setImageBitmap(this.c);
        relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
      } else {
        imageView.setImageBitmap(this.d);
        relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
      } 
      addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
      this.b.add(imageView);
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: iflt -> 18
    //   4: iload_2
    //   5: iflt -> 18
    //   8: iload_1
    //   9: istore_3
    //   10: iload_2
    //   11: istore #4
    //   13: iload_2
    //   14: iload_1
    //   15: if_icmpne -> 23
    //   18: iconst_0
    //   19: istore_3
    //   20: iconst_0
    //   21: istore #4
    //   23: iload_3
    //   24: istore_1
    //   25: iload_3
    //   26: ifge -> 34
    //   29: iconst_0
    //   30: istore_1
    //   31: iconst_0
    //   32: istore #4
    //   34: aload_0
    //   35: getfield b : Ljava/util/ArrayList;
    //   38: iload_1
    //   39: invokevirtual get : (I)Ljava/lang/Object;
    //   42: checkcast android/widget/ImageView
    //   45: aload_0
    //   46: getfield d : Landroid/graphics/Bitmap;
    //   49: invokevirtual setImageBitmap : (Landroid/graphics/Bitmap;)V
    //   52: aload_0
    //   53: getfield b : Ljava/util/ArrayList;
    //   56: iload #4
    //   58: invokevirtual get : (I)Ljava/lang/Object;
    //   61: checkcast android/widget/ImageView
    //   64: aload_0
    //   65: getfield c : Landroid/graphics/Bitmap;
    //   68: invokevirtual setImageBitmap : (Landroid/graphics/Bitmap;)V
    //   71: return
  }
  
  public void b(int paramInt) {
    Iterator<ImageView> iterator = this.b.iterator();
    while (iterator.hasNext())
      ((ImageView)iterator.next()).setImageBitmap(this.d); 
    ((ImageView)this.b.get(paramInt)).setImageBitmap(this.c);
  }
  
  public void setIndicatorCount(int paramInt) {
    ArrayList<ImageView> arrayList = this.b;
    if (arrayList != null) {
      if (paramInt > arrayList.size())
        return; 
      for (int i = 0; i < this.b.size(); i++) {
        if (i >= paramInt) {
          ((ImageView)this.b.get(i)).setVisibility(8);
          ((View)((ImageView)this.b.get(i)).getParent()).setVisibility(8);
        } else {
          ((ImageView)this.b.get(i)).setVisibility(0);
          ((View)((ImageView)this.b.get(i)).getParent()).setVisibility(0);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\emotico\\ui\EmoticonsIndicatorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */