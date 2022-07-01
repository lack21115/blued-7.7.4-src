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

public class UserLabelToolBarView extends FrameLayout implements View.OnClickListener {
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
  
  private FrameLayout l;
  
  private TextView m;
  
  private View n;
  
  private ImageView o;
  
  private FrameLayout p;
  
  private TextView q;
  
  private View r;
  
  private ImageView s;
  
  private OnToolBarItemClickListener t;
  
  public UserLabelToolBarView(Context paramContext) {
    this(paramContext, null);
  }
  
  public UserLabelToolBarView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UserLabelToolBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
    this.b.inflate(2131494216, (ViewGroup)this);
    this.c = (LinearLayout)findViewById(2131299753);
    this.d = (FrameLayout)findViewById(2131298027);
    this.e = (TextView)findViewById(2131300205);
    this.f = findViewById(2131301611);
    this.g = (ImageView)findViewById(2131299492);
    this.h = (FrameLayout)findViewById(2131298028);
    this.i = (TextView)findViewById(2131300206);
    this.j = findViewById(2131301612);
    this.k = (ImageView)findViewById(2131299493);
    this.l = (FrameLayout)findViewById(2131298029);
    this.m = (TextView)findViewById(2131300207);
    this.n = findViewById(2131301613);
    this.o = (ImageView)findViewById(2131299494);
    this.p = (FrameLayout)findViewById(2131298030);
    this.q = (TextView)findViewById(2131300208);
    this.r = findViewById(2131301614);
    this.s = (ImageView)findViewById(2131299495);
    setToolBtnSelect(0);
    this.d.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.p.setOnClickListener(this);
    a();
  }
  
  private int a(int paramInt) {
    return BluedSkinUtils.a(this.a, paramInt);
  }
  
  public void a() {
    String[] arrayOfString = this.a.getResources().getStringArray(2130903112);
    for (int i = 0; i < arrayOfString.length; i++) {
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i == 3)
              this.q.setText(arrayOfString[3]); 
          } else {
            this.m.setText(arrayOfString[2]);
          } 
        } else {
          this.i.setText(arrayOfString[1]);
        } 
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
      case 2131298029:
      case 2131298030:
        break;
    } 
    if (this.t != null) {
      int i = paramView.getId();
      byte b = 0;
      if (i != 2131298027)
        if (paramView.getId() == 2131298028) {
          b = 1;
        } else if (paramView.getId() == 2131298029) {
          b = 2;
        } else if (paramView.getId() == 2131298030) {
          b = 3;
        }  
      this.t.a(b);
    } 
  }
  
  public void setOnToolBarItemClickListener(OnToolBarItemClickListener paramOnToolBarItemClickListener) {
    this.t = paramOnToolBarItemClickListener;
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
      this.m.setTextColor(a(2131100844));
      this.n.setVisibility(8);
      this.q.setTextColor(a(2131100844));
      this.r.setVisibility(8);
      return;
    } 
    if (paramInt == 1) {
      this.e.setTextColor(a(2131100844));
      this.f.setVisibility(8);
      this.i.setTextColor(a(2131100838));
      this.j.setVisibility(0);
      this.m.setTextColor(a(2131100844));
      this.n.setVisibility(8);
      this.q.setTextColor(a(2131100844));
      this.r.setVisibility(8);
      return;
    } 
    if (paramInt == 2) {
      this.e.setTextColor(a(2131100844));
      this.f.setVisibility(8);
      this.i.setTextColor(a(2131100844));
      this.j.setVisibility(8);
      this.m.setTextColor(a(2131100838));
      this.n.setVisibility(0);
      this.q.setTextColor(a(2131100844));
      this.r.setVisibility(8);
      return;
    } 
    if (paramInt == 3) {
      this.e.setTextColor(a(2131100844));
      this.f.setVisibility(8);
      this.i.setTextColor(a(2131100844));
      this.j.setVisibility(8);
      this.m.setTextColor(a(2131100844));
      this.n.setVisibility(8);
      this.q.setTextColor(a(2131100838));
      this.r.setVisibility(0);
    } 
  }
  
  public static interface OnToolBarItemClickListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\View\UserLabelToolBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */