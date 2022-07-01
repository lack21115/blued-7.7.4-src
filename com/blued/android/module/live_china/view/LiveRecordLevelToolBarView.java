package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

public class LiveRecordLevelToolBarView extends FrameLayout implements View.OnClickListener {
  private Context a;
  
  private LayoutInflater b;
  
  private LinearLayout c;
  
  private FrameLayout d;
  
  private TextView e;
  
  private View f;
  
  private FrameLayout g;
  
  private TextView h;
  
  private View i;
  
  private OnToolBarItemClickListener j;
  
  public LiveRecordLevelToolBarView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveRecordLevelToolBarView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveRecordLevelToolBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
    this.b.inflate(R.layout.live_record_level_tool_bar_view, (ViewGroup)this);
    this.c = (LinearLayout)findViewById(R.id.root_view);
    this.d = (FrameLayout)findViewById(R.id.layout1);
    this.e = (TextView)findViewById(R.id.text1);
    this.f = findViewById(R.id.view1);
    this.g = (FrameLayout)findViewById(R.id.layout2);
    this.h = (TextView)findViewById(R.id.text2);
    this.i = findViewById(R.id.view2);
    setToolBtnSelect(0);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  public void a(String[] paramArrayOfString) {
    for (int i = 0; i < paramArrayOfString.length; i++) {
      if (i != 0) {
        if (i == 1)
          this.h.setText(paramArrayOfString[1]); 
      } else {
        this.e.setText(paramArrayOfString[0]);
      } 
    } 
  }
  
  public void onClick(View paramView) {
    if ((paramView.getId() == R.id.layout1 || paramView.getId() == R.id.layout2) && this.j != null) {
      int i = paramView.getId();
      int j = R.id.layout1;
      boolean bool = false;
      if (i != j && paramView.getId() == R.id.layout2)
        bool = true; 
      this.j.a(bool);
    } 
  }
  
  public void setOnToolBarItemClickListener(OnToolBarItemClickListener paramOnToolBarItemClickListener) {
    this.j = paramOnToolBarItemClickListener;
  }
  
  public void setToolBtnSelect(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setToolBtnSelect:");
    stringBuilder.append(paramInt);
    Log.v("pk", stringBuilder.toString());
    if (paramInt == 0) {
      this.e.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.f.setVisibility(0);
      this.h.setTextColor(this.a.getResources().getColor(R.color.syc_k));
      this.i.setVisibility(8);
      return;
    } 
    if (paramInt == 1) {
      this.e.setTextColor(this.a.getResources().getColor(R.color.syc_k));
      this.f.setVisibility(8);
      this.h.setTextColor(this.a.getResources().getColor(R.color.syc_h));
      this.i.setVisibility(0);
    } 
  }
  
  public static interface OnToolBarItemClickListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveRecordLevelToolBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */