package com.blued.android.module.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.module.live.base.R;

public class GiftHitLoadingView extends LinearLayout {
  protected ImageView a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private ImageView d;
  
  private int e = 0;
  
  public GiftHitLoadingView(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    b();
  }
  
  public GiftHitLoadingView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    b();
  }
  
  private void b() {
    this.c = LayoutInflater.from(this.b);
    View view = this.c.inflate(R.layout.gift_hit_loading_layout, (ViewGroup)this, true);
    this.d = (ImageView)view.findViewById(R.id.gift_loading_floor);
    this.a = (ImageView)view.findViewById(R.id.gift_loading_progress);
  }
  
  public void a() {
    this.a.setVisibility(8);
    setLoadFloorVisibility(0);
    this.e = 0;
  }
  
  public void a(int paramInt) {
    this.a.setVisibility(0);
    this.e = paramInt;
    setLoadFloorVisibility(8);
    setResources(this.e);
  }
  
  public void setLoadFloorVisibility(int paramInt) {
    this.d.setVisibility(paramInt);
  }
  
  protected void setResources(int paramInt) {
    switch (paramInt) {
      default:
        this.a.setImageResource(0);
        this.a.setVisibility(8);
        setLoadFloorVisibility(0);
        return;
      case 9:
        this.a.setImageResource(R.drawable.gift_hit_anim1);
        return;
      case 8:
        this.a.setImageResource(R.drawable.gift_hit_anim2);
        return;
      case 7:
        this.a.setImageResource(R.drawable.gift_hit_anim3);
        return;
      case 6:
        this.a.setImageResource(R.drawable.gift_hit_anim4);
        return;
      case 5:
        this.a.setImageResource(R.drawable.gift_hit_anim5);
        return;
      case 4:
        this.a.setImageResource(R.drawable.gift_hit_anim6);
        return;
      case 3:
        this.a.setImageResource(R.drawable.gift_hit_anim7);
        return;
      case 2:
        break;
    } 
    this.a.setImageResource(R.drawable.gift_hit_anim8);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\GiftHitLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */