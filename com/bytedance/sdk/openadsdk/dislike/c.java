package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;
import java.util.ArrayList;
import java.util.List;

public class c extends TTDislikeDialogAbstract {
  private TTDislikeListView a;
  
  private TTDislikeListView b;
  
  private RelativeLayout c;
  
  private View d;
  
  private b e;
  
  private b f;
  
  private k g;
  
  private a h;
  
  public c(Context paramContext, k paramk) {
    super(paramContext, ab.g(paramContext, "tt_dislikeDialog"));
    this.g = paramk;
  }
  
  private void a() {
    Window window = getWindow();
    if (window != null) {
      window.setGravity(80);
      WindowManager.LayoutParams layoutParams = window.getAttributes();
      layoutParams.y = 50;
      window.setAttributes(layoutParams);
    } 
  }
  
  private void a(Context paramContext) {
    this.c = (RelativeLayout)findViewById(ab.e(getContext(), "tt_dislike_title_content"));
    this.d = findViewById(ab.e(getContext(), "tt_dislike_line1"));
    findViewById(ab.e(getContext(), "tt_dislike_header_back")).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            c.b(this.a);
            if (c.a(this.a) != null)
              c.a(this.a).c(); 
          }
        });
    this.a = (TTDislikeListView)findViewById(ab.e(getContext(), "tt_filer_words_lv"));
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            try {
              FilterWord filterWord = (FilterWord)param1AdapterView.getAdapter().getItem(param1Int);
              if (filterWord.hasSecondOptions()) {
                c.a(this.a, filterWord);
                if (c.a(this.a) != null)
                  c.a(this.a).a(param1Int, filterWord); 
                return;
              } 
            } finally {}
            if (c.a(this.a) != null)
              try {
                c.a(this.a).a(param1Int, c.c(this.a).R().get(param1Int));
              } finally {} 
            this.a.dismiss();
          }
        });
    this.b = (TTDislikeListView)findViewById(ab.e(getContext(), "tt_filer_words_lv_second"));
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (c.a(this.a) != null)
              try {
                FilterWord filterWord = (FilterWord)param1AdapterView.getAdapter().getItem(param1Int);
                c.a(this.a).a(param1Int, filterWord);
              } finally {} 
            this.a.dismiss();
          }
        });
  }
  
  private void a(FilterWord paramFilterWord) {
    if (paramFilterWord == null)
      return; 
    b b1 = this.f;
    if (b1 != null)
      b1.a(paramFilterWord.getOptions()); 
    RelativeLayout relativeLayout = this.c;
    if (relativeLayout != null)
      relativeLayout.setVisibility(0); 
    View view = this.d;
    if (view != null)
      view.setVisibility(0); 
    TTDislikeListView tTDislikeListView = this.a;
    if (tTDislikeListView != null)
      tTDislikeListView.setVisibility(8); 
    tTDislikeListView = this.b;
    if (tTDislikeListView != null)
      tTDislikeListView.setVisibility(0); 
  }
  
  private void b() {
    setOnShowListener(new DialogInterface.OnShowListener(this) {
          public void onShow(DialogInterface param1DialogInterface) {
            if (c.a(this.a) != null)
              c.a(this.a).a(); 
          }
        });
    setOnDismissListener(new DialogInterface.OnDismissListener(this) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            if (c.a(this.a) != null)
              c.a(this.a).b(); 
          }
        });
    this.e = new b(getLayoutInflater(), this.g.R());
    this.a.setAdapter((ListAdapter)this.e);
    this.f = new b(getLayoutInflater(), new ArrayList<FilterWord>());
    this.f.a(false);
    this.b.setAdapter((ListAdapter)this.f);
  }
  
  private void c() {
    RelativeLayout relativeLayout = this.c;
    if (relativeLayout != null)
      relativeLayout.setVisibility(8); 
    View view = this.d;
    if (view != null)
      view.setVisibility(8); 
    TTDislikeListView tTDislikeListView2 = this.a;
    if (tTDislikeListView2 != null)
      tTDislikeListView2.setVisibility(0); 
    b b1 = this.f;
    if (b1 != null)
      b1.a(); 
    TTDislikeListView tTDislikeListView1 = this.b;
    if (tTDislikeListView1 != null)
      tTDislikeListView1.setVisibility(8); 
  }
  
  public void a(k paramk) {
    b b1 = this.e;
    if (b1 != null) {
      if (paramk == null)
        return; 
      this.g = paramk;
      b1.a(this.g.R());
      setMaterialMeta(this.g);
    } 
  }
  
  public void a(a parama) {
    this.h = parama;
  }
  
  public int getLayoutId() {
    return ab.f(getContext(), "tt_dislike_dialog_layout");
  }
  
  public ViewGroup.LayoutParams getLayoutParams() {
    return new ViewGroup.LayoutParams(ai.c(getContext()) - 120, -2);
  }
  
  public int[] getTTDislikeListViewIds() {
    return new int[] { ab.e(getContext(), "tt_filer_words_lv"), ab.e(getContext(), "tt_filer_words_lv_second") };
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setCanceledOnTouchOutside(true);
    setCancelable(true);
    a();
    a(getContext());
    b();
    setMaterialMeta(this.g);
  }
  
  public void show() {
    super.show();
    c();
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int, FilterWord param1FilterWord);
    
    void b();
    
    void c();
  }
  
  public static class b extends BaseAdapter {
    private boolean a = true;
    
    private final List<FilterWord> b;
    
    private final LayoutInflater c;
    
    public b(LayoutInflater param1LayoutInflater, List<FilterWord> param1List) {
      this.b = param1List;
      this.c = param1LayoutInflater;
    }
    
    public void a() {
      this.b.clear();
      notifyDataSetChanged();
    }
    
    public void a(List<FilterWord> param1List) {
      if (param1List != null) {
        if (param1List.isEmpty())
          return; 
        this.b.clear();
        this.b.addAll(param1List);
        notifyDataSetChanged();
      } 
    }
    
    public void a(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public int getCount() {
      List<FilterWord> list = this.b;
      return (list == null) ? 0 : list.size();
    }
    
    public Object getItem(int param1Int) {
      return this.b.get(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      a a2;
      if (param1View == null) {
        a1 = new a();
        LayoutInflater layoutInflater = this.c;
        View view = layoutInflater.inflate(ab.f(layoutInflater.getContext(), "tt_dialog_listview_item"), param1ViewGroup, false);
        a1.a = (TextView)view.findViewById(ab.e(this.c.getContext(), "tt_item_tv"));
        a1.b = (ImageView)view.findViewById(ab.e(this.c.getContext(), "tt_item_arrow"));
        view.setTag(a1);
      } else {
        a a = (a)a1.getTag();
        a2 = a1;
        a1 = a;
      } 
      FilterWord filterWord = this.b.get(param1Int);
      a1.a.setText(filterWord.getName());
      if (param1Int != this.b.size() - 1) {
        a1.a.setBackgroundResource(ab.d(this.c.getContext(), "tt_dislike_middle_seletor"));
      } else {
        a1.a.setBackgroundResource(ab.d(this.c.getContext(), "tt_dislike_bottom_seletor"));
      } 
      if (this.a && param1Int == 0)
        a1.a.setBackgroundResource(ab.d(this.c.getContext(), "tt_dislike_top_seletor")); 
      if (filterWord.hasSecondOptions()) {
        a1.b.setVisibility(0);
        return (View)a2;
      } 
      a1.b.setVisibility(8);
      return (View)a2;
    }
    
    static class a {
      TextView a;
      
      ImageView b;
      
      private a() {}
    }
  }
  
  static class a {
    TextView a;
    
    ImageView b;
    
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\dislike\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */