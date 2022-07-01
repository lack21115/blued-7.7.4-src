package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import java.util.ArrayList;
import java.util.List;

public class PopActionSheet implements View.OnClickListener {
  private MyPopupWindow a;
  
  private View b;
  
  private Context c;
  
  private LayoutInflater d;
  
  private View e;
  
  private LinearLayout f;
  
  private View g;
  
  private PopSheetClickListner h;
  
  private int i;
  
  private List<ActionItem> j = new ArrayList<ActionItem>();
  
  private boolean k;
  
  public PopActionSheet(Context paramContext, String[] paramArrayOfString, int[] paramArrayOfint, boolean paramBoolean, PopSheetClickListner paramPopSheetClickListner) {
    this.c = paramContext;
    this.k = paramBoolean;
    int i;
    for (i = 0; i < paramArrayOfString.length; i++) {
      ActionItem actionItem = new ActionItem(this);
      actionItem.a = paramArrayOfString[i];
      if (i < paramArrayOfint.length) {
        actionItem.b = paramArrayOfint[i];
      } else {
        actionItem.b = 0;
      } 
      this.j.add(actionItem);
    } 
    this.h = paramPopSheetClickListner;
    f();
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString, int[] paramArrayOfint, int paramInt, PopSheetClickListner paramPopSheetClickListner) {
    PopActionSheet popActionSheet = new PopActionSheet(paramContext, paramArrayOfString, paramArrayOfint, true, paramPopSheetClickListner);
    popActionSheet.a(paramInt);
    popActionSheet.a();
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString, int[] paramArrayOfint, int paramInt, boolean paramBoolean, PopSheetClickListner paramPopSheetClickListner) {
    PopActionSheet popActionSheet = new PopActionSheet(paramContext, paramArrayOfString, paramArrayOfint, paramBoolean, paramPopSheetClickListner);
    popActionSheet.a(paramInt);
    popActionSheet.a();
  }
  
  private void f() {
    this.d = LayoutInflater.from(this.c);
    this.e = this.d.inflate(R.layout.sheet_pop_center, null);
    this.f = (LinearLayout)this.e.findViewById(R.id.ll_main);
    this.g = this.e.findViewById(R.id.btn_cancel);
    this.g.setOnClickListener(this);
    this.b = this.e.findViewById(R.id.tv_bg);
    this.b.setOnClickListener(this);
    g();
    this.a = new MyPopupWindow(this, this.e, -1, -1, true);
    this.a.setBackgroundDrawable(this.c.getResources().getDrawable(17170445));
    this.a.setTouchable(true);
    this.a.setOutsideTouchable(true);
    this.a.setFocusable(true);
    this.a.update();
  }
  
  private void g() {
    List<ActionItem> list = this.j;
    if (list != null && list.size() > 0)
      for (int i = this.j.size() - 1; i >= 0; i--) {
        View view = this.d.inflate(R.layout.item_sheet_pop_center, null);
        TextView textView = (TextView)view.findViewById(R.id.tv_text);
        textView.setText(((ActionItem)this.j.get(i)).a);
        if (((ActionItem)this.j.get(i)).b != 0)
          textView.setTextColor(this.c.getResources().getColor(((ActionItem)this.j.get(i)).b)); 
        view.setId(i);
        if (i == 0 && !this.k) {
          textView.setBackground(null);
          view.setOnClickListener(null);
        } else {
          view.setOnClickListener(this);
        } 
        this.f.addView(view, 0);
      }  
  }
  
  public void a() {
    this.b.clearAnimation();
    this.e.clearAnimation();
    if (this.a.isShowing())
      this.a.a(); 
    if (this.i > 0) {
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.f.getLayoutParams();
      layoutParams.width = this.i;
      this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    this.a.showAtLocation(this.e, 17, 0, 0);
    this.e.setVisibility(0);
    d();
  }
  
  public void a(int paramInt) {
    this.i = paramInt;
  }
  
  public void b() {
    c();
    this.f.setVisibility(8);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopActionSheet.a(this.a).a();
          }
        },  320L);
  }
  
  public void c() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.f.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
  }
  
  public void d() {
    this.f.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
  }
  
  public MyPopupWindow e() {
    return this.a;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.btn_cancel || paramView.getId() == R.id.tv_bg) {
      b();
      return;
    } 
    for (int i = 0; i < this.j.size(); i++) {
      if (paramView.getId() == i) {
        this.h.onClick(i, ((ActionItem)this.j.get(i)).a);
        b();
        return;
      } 
    } 
  }
  
  public class ActionItem {
    public String a;
    
    public int b;
    
    public ActionItem(PopActionSheet this$0) {}
  }
  
  public class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopActionSheet this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.b();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
  
  public static interface PopSheetClickListner {
    void onClick(int param1Int, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */