package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.soft.blued.ui.common_contract.ISelectPhotoBarCallback;

public class SelectPhotoBarView extends RelativeLayout implements View.OnClickListener {
  private CheckBox a;
  
  private TextView b;
  
  private TextView c;
  
  private TextView d;
  
  private View e;
  
  private ISelectPhotoBarCallback f;
  
  public SelectPhotoBarView(Context paramContext) {
    this(paramContext, null);
  }
  
  public SelectPhotoBarView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SelectPhotoBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    a(paramContext);
    this.a = (CheckBox)findViewById(2131299462);
    this.b = (TextView)findViewById(2131299461);
    this.c = (TextView)findViewById(2131299470);
    this.e = findViewById(2131299469);
    this.d = (TextView)findViewById(2131299465);
    this.e.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (SelectPhotoBarView.a(this.a) != null)
              SelectPhotoBarView.b(this.a).a(param1Boolean); 
          }
        });
  }
  
  private void setBurnBtnEnable(boolean paramBoolean) {
    CheckBox checkBox = this.a;
    if (checkBox != null)
      checkBox.setEnabled(paramBoolean); 
  }
  
  private void setNumTv(int paramInt) {
    TextView textView = this.d;
    if (textView != null)
      if (paramInt <= 0) {
        if (textView.getVisibility() == 0) {
          this.d.setVisibility(8);
          return;
        } 
      } else {
        textView.setText(String.valueOf(paramInt));
        if (this.d.getVisibility() == 8)
          this.d.setVisibility(0); 
      }  
  }
  
  private void setSendBtnEnable(boolean paramBoolean) {
    TextView textView = this.c;
    if (textView != null)
      textView.setEnabled(paramBoolean); 
    View view = this.e;
    if (view != null)
      view.setEnabled(paramBoolean); 
  }
  
  private void setSendBtnSelected(boolean paramBoolean) {
    TextView textView = this.c;
    if (textView != null)
      textView.setSelected(paramBoolean); 
    View view = this.e;
    if (view != null)
      view.setEnabled(paramBoolean); 
  }
  
  protected View a(Context paramContext) {
    return View.inflate(paramContext, 2131494252, (ViewGroup)this);
  }
  
  public void a(int paramInt) {
    setNumTv(paramInt);
    if (paramInt <= 0) {
      setBurnBtnEnable(false);
      setSendBtnEnable(false);
      return;
    } 
    setBurnBtnEnable(true);
    setSendBtnEnable(true);
    setSendBtnSelected(true);
  }
  
  public boolean a() {
    return this.a.isChecked();
  }
  
  public void b() {
    CheckBox checkBox = this.a;
    if (checkBox != null)
      checkBox.setVisibility(8); 
  }
  
  public void c() {
    CheckBox checkBox = this.a;
    if (checkBox != null)
      checkBox.setVisibility(0); 
  }
  
  public void onClick(View paramView) {
    if (this.f != null) {
      int i = paramView.getId();
      if (i != 2131299461) {
        if (i != 2131299469)
          return; 
        this.f.d();
        return;
      } 
      this.f.e();
    } 
  }
  
  public void setBurnBtnChecked(boolean paramBoolean) {
    CheckBox checkBox = this.a;
    if (checkBox != null)
      checkBox.setChecked(paramBoolean); 
  }
  
  public void setOperationCallback(ISelectPhotoBarCallback paramISelectPhotoBarCallback) {
    this.f = paramISelectPhotoBarCallback;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\SelectPhotoBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */