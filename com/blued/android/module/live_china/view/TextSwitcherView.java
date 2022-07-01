package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import java.util.ArrayList;

public class TextSwitcherView extends TextSwitcher implements ViewSwitcher.ViewFactory {
  private ArrayList<String> a = new ArrayList<String>();
  
  private int b = 0;
  
  private Context c;
  
  private boolean d = false;
  
  public TextSwitcherView(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
    b();
  }
  
  public TextSwitcherView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    b();
  }
  
  private void b() {
    setFactory(this);
    this.a.add("给主播打赏弯豆，帮他提升热度值");
    this.a.add("叫上朋友看直播，帮他提升热度值");
    TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
    translateAnimation.setDuration(1000L);
    setInAnimation((Animation)translateAnimation);
    translateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, -1.0F);
    translateAnimation.setDuration(1000L);
    setOutAnimation((Animation)translateAnimation);
    c();
    a();
  }
  
  private void c() {
    ArrayList<String> arrayList = this.a;
    if (arrayList != null && arrayList.size() > 0) {
      setText(this.a.get(this.b));
      this.b++;
      if (this.b >= this.a.size())
        this.b = 0; 
    } 
  }
  
  public void a() {
    if (this.d)
      return; 
    postDelayed(new Runnable(this) {
          public void run() {
            TextSwitcherView.a(this.a);
            this.a.a();
          }
        },  3000L);
  }
  
  public View makeView() {
    TextView textView = new TextView(getContext());
    textView.setTextColor(-30914);
    textView.setTextSize(2, 13.0F);
    return (View)textView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\TextSwitcherView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */