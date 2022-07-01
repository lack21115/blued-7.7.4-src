package com.soft.blued.ui.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.soft.blued.ui.video.uitls.ViewUtils;

public class AlbumTabsView extends FrameLayout implements View.OnClickListener {
  private View a;
  
  private View b;
  
  private RelativeLayout c;
  
  private RelativeLayout d;
  
  private RelativeLayout e;
  
  private TextView f;
  
  private TextView g;
  
  private ITabsClickListener h;
  
  public AlbumTabsView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public AlbumTabsView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AlbumTabsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    View view = LayoutInflater.from(getContext()).inflate(2131492920, null);
    this.c = (RelativeLayout)view.findViewById(2131296435);
    this.c.setOnClickListener(this);
    this.d = (RelativeLayout)view.findViewById(2131299952);
    this.d.setOnClickListener(this);
    this.e = (RelativeLayout)view.findViewById(2131296630);
    this.f = (TextView)view.findViewById(2131296430);
    this.g = (TextView)view.findViewById(2131299950);
    this.a = view.findViewById(2131296431);
    this.b = view.findViewById(2131299951);
    addView(view);
  }
  
  private void b() {
    this.f.setSelected(true);
    this.a.setVisibility(0);
    this.g.setSelected(false);
    this.b.setVisibility(4);
  }
  
  private void c() {
    this.g.setSelected(true);
    this.b.setVisibility(0);
    this.f.setSelected(false);
    this.a.setVisibility(4);
  }
  
  public void a(ITabsClickListener paramITabsClickListener, boolean paramBoolean, int paramInt) {
    this.h = paramITabsClickListener;
    if (paramInt != 1) {
      if (paramInt == 2)
        b(); 
    } else {
      c();
    } 
    if (paramBoolean) {
      this.e.setVisibility(0);
      this.e.setOnClickListener(this);
      return;
    } 
    this.e.setVisibility(8);
  }
  
  public void onClick(View paramView) {
    ViewUtils.a(paramView);
    if (this.h == null)
      return; 
    int i = paramView.getId();
    if (i != 2131296435) {
      if (i != 2131296630) {
        if (i != 2131299952)
          return; 
        this.h.E();
        return;
      } 
      this.h.F();
      return;
    } 
    this.h.D();
  }
  
  public static interface ITabsClickListener {
    void D();
    
    void E();
    
    void F();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\view\AlbumTabsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */