package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;

public class HelloOpenDialogFragment_ViewBinding implements Unbinder {
  private HelloOpenDialogFragment b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  private View f;
  
  public HelloOpenDialogFragment_ViewBinding(HelloOpenDialogFragment paramHelloOpenDialogFragment, View paramView) {
    this.b = paramHelloOpenDialogFragment;
    paramHelloOpenDialogFragment.ivCallLeft = (ImageView)Utils.a(paramView, 2131297715, "field 'ivCallLeft'", ImageView.class);
    paramHelloOpenDialogFragment.tvCallTitleLeft = (TextView)Utils.a(paramView, 2131300609, "field 'tvCallTitleLeft'", TextView.class);
    paramHelloOpenDialogFragment.tvCallLeft = (TextView)Utils.a(paramView, 2131300605, "field 'tvCallLeft'", TextView.class);
    View view = Utils.a(paramView, 2131299973, "field 'sllCallLeft' and method 'onViewClicked'");
    paramHelloOpenDialogFragment.sllCallLeft = (ShapeLinearLayout)Utils.b(view, 2131299973, "field 'sllCallLeft'", ShapeLinearLayout.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramHelloOpenDialogFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramHelloOpenDialogFragment.ivCallRight = (ImageView)Utils.a(paramView, 2131297716, "field 'ivCallRight'", ImageView.class);
    paramHelloOpenDialogFragment.tvCallTitleRight = (TextView)Utils.a(paramView, 2131300610, "field 'tvCallTitleRight'", TextView.class);
    paramHelloOpenDialogFragment.tvCallRight = (TextView)Utils.a(paramView, 2131300607, "field 'tvCallRight'", TextView.class);
    view = Utils.a(paramView, 2131299974, "field 'sllCallRight' and method 'onViewClicked'");
    paramHelloOpenDialogFragment.sllCallRight = (ShapeLinearLayout)Utils.b(view, 2131299974, "field 'sllCallRight'", ShapeLinearLayout.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramHelloOpenDialogFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    view = Utils.a(paramView, 2131296621, "field 'callOpen' and method 'onViewClicked'");
    paramHelloOpenDialogFragment.callOpen = (ShapeTextView)Utils.b(view, 2131296621, "field 'callOpen'", ShapeTextView.class);
    this.e = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramHelloOpenDialogFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramHelloOpenDialogFragment.cardView = (CardView)Utils.a(paramView, 2131296659, "field 'cardView'", CardView.class);
    view = Utils.a(paramView, 2131297729, "field 'ivClose' and method 'onViewClicked'");
    paramHelloOpenDialogFragment.ivClose = (ImageView)Utils.b(view, 2131297729, "field 'ivClose'", ImageView.class);
    this.f = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramHelloOpenDialogFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramHelloOpenDialogFragment.ivBuySuccess = (ImageView)Utils.a(paramView, 2131297710, "field 'ivBuySuccess'", ImageView.class);
    paramHelloOpenDialogFragment.tvTitle = (TextView)Utils.a(paramView, 2131301409, "field 'tvTitle'", TextView.class);
    paramHelloOpenDialogFragment.tvCount = (TextView)Utils.a(paramView, 2131300670, "field 'tvCount'", TextView.class);
    paramHelloOpenDialogFragment.tvContent = (TextView)Utils.a(paramView, 2131300663, "field 'tvContent'", TextView.class);
  }
  
  public void unbind() {
    HelloOpenDialogFragment helloOpenDialogFragment = this.b;
    if (helloOpenDialogFragment != null) {
      this.b = null;
      helloOpenDialogFragment.ivCallLeft = null;
      helloOpenDialogFragment.tvCallTitleLeft = null;
      helloOpenDialogFragment.tvCallLeft = null;
      helloOpenDialogFragment.sllCallLeft = null;
      helloOpenDialogFragment.ivCallRight = null;
      helloOpenDialogFragment.tvCallTitleRight = null;
      helloOpenDialogFragment.tvCallRight = null;
      helloOpenDialogFragment.sllCallRight = null;
      helloOpenDialogFragment.callOpen = null;
      helloOpenDialogFragment.cardView = null;
      helloOpenDialogFragment.ivClose = null;
      helloOpenDialogFragment.ivBuySuccess = null;
      helloOpenDialogFragment.tvTitle = null;
      helloOpenDialogFragment.tvCount = null;
      helloOpenDialogFragment.tvContent = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\HelloOpenDialogFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */