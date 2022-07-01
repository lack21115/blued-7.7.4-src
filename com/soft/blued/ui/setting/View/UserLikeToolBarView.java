package com.soft.blued.ui.setting.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;

public class UserLikeToolBarView extends FrameLayout implements View.OnClickListener {
  private Context a;
  
  private LayoutInflater b;
  
  private LinearLayout c;
  
  private FrameLayout d;
  
  private TextView e;
  
  private View f;
  
  private ImageView g;
  
  private FrameLayout h;
  
  private TextView i;
  
  private View j;
  
  private ImageView k;
  
  private OnToolBarItemClickListener l;
  
  public UserLikeToolBarView(Context paramContext) {
    this(paramContext, null);
  }
  
  public UserLikeToolBarView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UserLikeToolBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
    this.b.inflate(2131494217, (ViewGroup)this);
    this.c = (LinearLayout)findViewById(2131299753);
    this.d = (FrameLayout)findViewById(2131298027);
    this.e = (TextView)findViewById(2131300205);
    this.f = findViewById(2131301611);
    this.g = (ImageView)findViewById(2131299492);
    this.h = (FrameLayout)findViewById(2131298028);
    this.i = (TextView)findViewById(2131300206);
    this.j = findViewById(2131301612);
    this.k = (ImageView)findViewById(2131299493);
    setToolBtnSelect(0);
    this.d.setOnClickListener(this);
    this.h.setOnClickListener(this);
    a();
  }
  
  private int a(int paramInt) {
    return BluedSkinUtils.a(this.a, paramInt);
  }
  
  public void a() {
    String[] arrayOfString = this.a.getResources().getStringArray(2130903113);
    for (int i = 0; i < arrayOfString.length; i++) {
      if (i != 0) {
        if (i == 1)
          this.i.setText(arrayOfString[1]); 
      } else {
        this.e.setText(arrayOfString[0]);
      } 
    } 
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131298027:
      case 2131298028:
        break;
    } 
    if (this.l != null) {
      int i = paramView.getId();
      boolean bool = false;
      if (i != 2131298027 && paramView.getId() == 2131298028)
        bool = true; 
      this.l.a(bool);
    } 
  }
  
  public void setOnToolBarItemClickListener(OnToolBarItemClickListener paramOnToolBarItemClickListener) {
    this.l = paramOnToolBarItemClickListener;
  }
  
  public void setToolBtnSelect(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setToolBtnSelect:");
    stringBuilder.append(paramInt);
    Log.v("drb", stringBuilder.toString());
    if (paramInt == 0) {
      this.e.setTextColor(a(2131100838));
      this.f.setVisibility(0);
      this.i.setTextColor(a(2131100844));
      this.j.setVisibility(8);
      return;
    } 
    if (paramInt == 1) {
      this.e.setTextColor(a(2131100844));
      this.f.setVisibility(8);
      this.i.setTextColor(a(2131100838));
      this.j.setVisibility(0);
      return;
    } 
    if (paramInt == 2) {
      this.e.setTextColor(a(2131100844));
      this.f.setVisibility(8);
      this.i.setTextColor(a(2131100844));
      this.j.setVisibility(8);
      return;
    } 
    if (paramInt == 3) {
      this.e.setTextColor(a(2131100844));
      this.f.setVisibility(8);
      this.i.setTextColor(a(2131100844));
      this.j.setVisibility(8);
    } 
  }
  
  public static interface OnToolBarItemClickListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\View\UserLikeToolBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */