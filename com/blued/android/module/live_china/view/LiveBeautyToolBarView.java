package com.blued.android.module.live_china.view;

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
import com.blued.android.module.live_china.R;

public class LiveBeautyToolBarView extends FrameLayout implements View.OnClickListener {
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
  
  public LiveBeautyToolBarView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveBeautyToolBarView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveBeautyToolBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
    this.b.inflate(R.layout.live_beauty_tool_bar_view, (ViewGroup)this);
    this.c = (LinearLayout)findViewById(R.id.root_view);
    this.d = (FrameLayout)findViewById(R.id.layout1);
    this.e = (TextView)findViewById(R.id.text1);
    this.f = findViewById(R.id.view1);
    this.g = (ImageView)findViewById(R.id.point1);
    this.h = (FrameLayout)findViewById(R.id.layout2);
    this.i = (TextView)findViewById(R.id.text2);
    this.j = findViewById(R.id.view2);
    this.k = (ImageView)findViewById(R.id.point2);
    this.l = (FrameLayout)findViewById(R.id.layout3);
    this.m = (TextView)findViewById(R.id.text3);
    this.n = findViewById(R.id.view3);
    this.o = (ImageView)findViewById(R.id.point3);
    this.p = (FrameLayout)findViewById(R.id.layout4);
    this.q = (TextView)findViewById(R.id.text4);
    this.r = findViewById(R.id.view4);
    this.s = (ImageView)findViewById(R.id.point4);
    setToolBtnSelect(0);
    this.d.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.p.setOnClickListener(this);
    a();
  }
  
  public void a() {
    String[] arrayOfString = this.a.getResources().getStringArray(R.array.live_beauty_title);
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
    if ((paramView.getId() == R.id.layout1 || paramView.getId() == R.id.layout2 || paramView.getId() == R.id.layout3 || paramView.getId() == R.id.layout4) && this.t != null) {
      int i = paramView.getId();
      int j = R.id.layout1;
      byte b = 0;
      if (i != j)
        if (paramView.getId() == R.id.layout2) {
          b = 1;
        } else if (paramView.getId() == R.id.layout3) {
          b = 2;
        } else if (paramView.getId() == R.id.layout4) {
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
    Log.v("pk", stringBuilder.toString());
    if (paramInt == 0) {
      this.e.setTextColor(this.a.getResources().getColor(R.color.syc_a));
      this.f.setVisibility(0);
      this.i.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.j.setVisibility(8);
      this.m.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.n.setVisibility(8);
      this.q.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.r.setVisibility(8);
      return;
    } 
    if (paramInt == 1) {
      this.e.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.f.setVisibility(8);
      this.i.setTextColor(this.a.getResources().getColor(R.color.syc_a));
      this.j.setVisibility(0);
      this.m.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.n.setVisibility(8);
      this.q.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.r.setVisibility(8);
      return;
    } 
    if (paramInt == 2) {
      this.e.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.f.setVisibility(8);
      this.i.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.j.setVisibility(8);
      this.m.setTextColor(this.a.getResources().getColor(R.color.syc_a));
      this.n.setVisibility(0);
      this.q.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.r.setVisibility(8);
      return;
    } 
    if (paramInt == 3) {
      this.e.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.f.setVisibility(8);
      this.i.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.j.setVisibility(8);
      this.m.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.n.setVisibility(8);
      this.q.setTextColor(this.a.getResources().getColor(R.color.syc_a));
      this.r.setVisibility(0);
    } 
  }
  
  public static interface OnToolBarItemClickListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveBeautyToolBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */