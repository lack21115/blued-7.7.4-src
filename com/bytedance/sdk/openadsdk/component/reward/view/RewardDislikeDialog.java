package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;
import java.util.ArrayList;

public class RewardDislikeDialog extends FrameLayout {
  private View a;
  
  private TTDislikeListView b;
  
  private TTDislikeListView c;
  
  private RelativeLayout d;
  
  private View e;
  
  private c.b f;
  
  private c.b g;
  
  private k h;
  
  private a i;
  
  private boolean j = false;
  
  public RewardDislikeDialog(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public RewardDislikeDialog(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RewardDislikeDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public RewardDislikeDialog(Context paramContext, k paramk) {
    this(paramContext);
    this.h = paramk;
    c();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    setClickable(true);
    setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
          }
        });
    setBackgroundColor(Color.parseColor("#80000000"));
    int i = ab.f(paramContext, "tt_dislike_dialog_layout");
    this.a = LayoutInflater.from(paramContext).inflate(i, (ViewGroup)this, false);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
    layoutParams.gravity = 17;
    layoutParams.leftMargin = ai.c(getContext(), 20.0F);
    layoutParams.rightMargin = ai.c(getContext(), 20.0F);
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.a.setClickable(true);
    d();
    c();
  }
  
  private void a(FilterWord paramFilterWord) {
    if (paramFilterWord == null)
      return; 
    c.b b1 = this.g;
    if (b1 != null)
      b1.a(paramFilterWord.getOptions()); 
    RelativeLayout relativeLayout = this.d;
    if (relativeLayout != null)
      relativeLayout.setVisibility(0); 
    View view = this.e;
    if (view != null)
      view.setVisibility(0); 
    TTDislikeListView tTDislikeListView = this.b;
    if (tTDislikeListView != null)
      tTDislikeListView.setVisibility(8); 
    tTDislikeListView = this.c;
    if (tTDislikeListView != null)
      tTDislikeListView.setVisibility(0); 
  }
  
  private void c() {
    if (this.h == null)
      return; 
    LayoutInflater layoutInflater = LayoutInflater.from(getContext());
    this.f = new c.b(layoutInflater, this.h.R());
    this.b.setAdapter((ListAdapter)this.f);
    this.g = new c.b(layoutInflater, new ArrayList());
    this.g.a(false);
    this.c.setAdapter((ListAdapter)this.g);
    this.b.setMaterialMeta(this.h);
    this.c.setMaterialMeta(this.h);
  }
  
  private void d() {
    this.d = (RelativeLayout)this.a.findViewById(ab.e(getContext(), "tt_dislike_title_content"));
    this.e = this.a.findViewById(ab.e(getContext(), "tt_dislike_line1"));
    this.a.findViewById(ab.e(getContext(), "tt_dislike_header_back")).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            RewardDislikeDialog.a(this.a);
            if (RewardDislikeDialog.b(this.a) != null)
              RewardDislikeDialog.b(this.a).c(param1View); 
          }
        });
    this.b = (TTDislikeListView)this.a.findViewById(ab.e(getContext(), "tt_filer_words_lv"));
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            try {
              FilterWord filterWord = (FilterWord)param1AdapterView.getAdapter().getItem(param1Int);
              if (filterWord.hasSecondOptions()) {
                RewardDislikeDialog.a(this.a, filterWord);
                if (RewardDislikeDialog.b(this.a) != null)
                  RewardDislikeDialog.b(this.a).a(param1Int, filterWord); 
                return;
              } 
            } finally {}
            if (RewardDislikeDialog.b(this.a) != null)
              try {
                RewardDislikeDialog.b(this.a).a(param1Int, RewardDislikeDialog.c(this.a).R().get(param1Int));
              } finally {} 
            this.a.b();
          }
        });
    this.c = (TTDislikeListView)this.a.findViewById(ab.e(getContext(), "tt_filer_words_lv_second"));
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (RewardDislikeDialog.b(this.a) != null)
              try {
                FilterWord filterWord = (FilterWord)param1AdapterView.getAdapter().getItem(param1Int);
                RewardDislikeDialog.b(this.a).a(param1Int, filterWord);
              } finally {} 
            this.a.b();
          }
        });
  }
  
  private void e() {
    RelativeLayout relativeLayout = this.d;
    if (relativeLayout != null)
      relativeLayout.setVisibility(8); 
    View view = this.e;
    if (view != null)
      view.setVisibility(8); 
    TTDislikeListView tTDislikeListView2 = this.b;
    if (tTDislikeListView2 != null)
      tTDislikeListView2.setVisibility(0); 
    c.b b1 = this.g;
    if (b1 != null)
      b1.a(); 
    TTDislikeListView tTDislikeListView1 = this.c;
    if (tTDislikeListView1 != null)
      tTDislikeListView1.setVisibility(8); 
  }
  
  public void a() {
    if (this.a.getParent() == null)
      addView(this.a); 
    e();
    setVisibility(0);
    this.j = true;
    a a1 = this.i;
    if (a1 != null)
      a1.a((View)this); 
  }
  
  public void b() {
    setVisibility(8);
    this.j = false;
    a a1 = this.i;
    if (a1 != null)
      a1.b((View)this); 
  }
  
  public void setCallback(a parama) {
    this.i = parama;
  }
  
  public static interface a {
    void a(int param1Int, FilterWord param1FilterWord);
    
    void a(View param1View);
    
    void b(View param1View);
    
    void c(View param1View);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\view\RewardDislikeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */