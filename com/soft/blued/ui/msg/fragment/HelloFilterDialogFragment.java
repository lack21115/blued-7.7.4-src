package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloFilterDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
  private Context a;
  
  private View b;
  
  private ShapeLinearLayout c;
  
  private ImageView d;
  
  private ShapeTextView e;
  
  private ShapeTextView f;
  
  private ShapeTextView g;
  
  private ShapeTextView h;
  
  private ShapeTextView i;
  
  private ShapeTextView j;
  
  private ShapeTextView k;
  
  private ShapeTextView l;
  
  private OnHelloFilterChange m;
  
  private void a(ShapeTextView paramShapeTextView) {
    a(paramShapeTextView, ((Boolean)paramShapeTextView.getTag()).booleanValue() ^ true);
  }
  
  private void a(ShapeTextView paramShapeTextView, boolean paramBoolean) {
    if (paramBoolean) {
      ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100728);
      ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
    } else {
      ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100838);
      ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100733);
    } 
    paramShapeTextView.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void g() {
    this.c = (ShapeLinearLayout)this.b.findViewById(2131298088);
    this.d = (ImageView)this.b.findViewById(2131297729);
    this.d.setOnClickListener(this);
    this.e = (ShapeTextView)this.b.findViewById(2131300112);
    this.e.setOnClickListener(this);
    this.f = (ShapeTextView)this.b.findViewById(2131300111);
    this.f.setOnClickListener(this);
    this.g = (ShapeTextView)this.b.findViewById(2131300110);
    this.g.setOnClickListener(this);
    this.h = (ShapeTextView)this.b.findViewById(2131300109);
    this.h.setOnClickListener(this);
    this.i = (ShapeTextView)this.b.findViewById(2131300108);
    this.i.setOnClickListener(this);
    this.j = (ShapeTextView)this.b.findViewById(2131300113);
    this.j.setOnClickListener(this);
    this.k = (ShapeTextView)this.b.findViewById(2131300107);
    this.k.setOnClickListener(this);
    this.l = (ShapeTextView)this.b.findViewById(2131300105);
    this.l.setOnClickListener(this);
  }
  
  public void a(OnHelloFilterChange paramOnHelloFilterChange) {
    this.m = paramOnHelloFilterChange;
  }
  
  public void a(String paramString) {
    a(this.e, false);
    a(this.f, false);
    a(this.g, false);
    a(this.h, false);
    a(this.i, false);
    a(this.j, false);
    if (TextUtils.isEmpty(paramString))
      return; 
    List<String> list = Arrays.asList(paramString.split(","));
    if (list.contains("1"))
      a(this.e, true); 
    if (list.contains("0.75"))
      a(this.f, true); 
    if (list.contains("0.5"))
      a(this.g, true); 
    if (list.contains("0.25"))
      a(this.h, true); 
    if (list.contains("0"))
      a(this.i, true); 
    if (list.contains("-1"))
      a(this.j, true); 
  }
  
  public String f() {
    ArrayList<String> arrayList = new ArrayList();
    if (this.e.getTag() != null && ((Boolean)this.e.getTag()).booleanValue())
      arrayList.add("1"); 
    if (this.f.getTag() != null && ((Boolean)this.f.getTag()).booleanValue())
      arrayList.add("0.75"); 
    if (this.g.getTag() != null && ((Boolean)this.g.getTag()).booleanValue())
      arrayList.add("0.5"); 
    if (this.h.getTag() != null && ((Boolean)this.h.getTag()).booleanValue())
      arrayList.add("0.25"); 
    if (this.i.getTag() != null && ((Boolean)this.i.getTag()).booleanValue())
      arrayList.add("0"); 
    if (this.j.getTag() != null && ((Boolean)this.j.getTag()).booleanValue())
      arrayList.add("-1"); 
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < arrayList.size(); i++) {
      stringBuilder.append(arrayList.get(i));
      stringBuilder.append(",");
    } 
    return TextUtils.isEmpty(stringBuilder.toString()) ? "" : stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131297729) {
      if (i != 2131300105) {
        switch (i) {
          default:
            return;
          case 2131300113:
            a(this.j);
            return;
          case 2131300112:
            a(this.e);
            return;
          case 2131300111:
            a(this.f);
            return;
          case 2131300110:
            a(this.g);
            return;
          case 2131300109:
            a(this.h);
            return;
          case 2131300108:
            a(this.i);
            return;
          case 2131300107:
            break;
        } 
        a((String)null);
        return;
      } 
      String str = f();
      BluedPreferences.aq(str);
      EventTrackGuy.c(GuyProtos.Event.VOCATIVE_SECOND_FILTER_CONFIRM_CLICK, str);
      OnHelloFilterChange onHelloFilterChange = this.m;
      if (onHelloFilterChange != null)
        onHelloFilterChange.a(str); 
      dismiss();
      return;
    } 
    dismiss();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(0, 2131820776);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = this.b;
    if (view == null) {
      this.b = paramLayoutInflater.inflate(2131492996, paramViewGroup, false);
      g();
      a(BluedPreferences.dQ());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.b.getParent()).removeView(this.b);
    } 
    return this.b;
  }
  
  public static interface OnHelloFilterChange {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\HelloFilterDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */