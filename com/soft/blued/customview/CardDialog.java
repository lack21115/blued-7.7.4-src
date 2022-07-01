package com.soft.blued.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CardDialog extends Dialog {
  public CardDialog(Context paramContext) {
    super(paramContext);
  }
  
  public static class Builder {
    public Context a;
    
    private CardDialog b = null;
    
    private CirclePageIndicator c;
    
    private View d;
    
    private ViewPager e;
    
    private int f;
    
    private int g;
    
    private int h;
    
    private DialogInterface.OnClickListener i;
    
    private DialogInterface.OnClickListener j;
    
    private Timer k = new Timer();
    
    public Builder(Context param1Context) {
      this.a = param1Context;
    }
    
    public Builder a() {
      this.d = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131492982, null);
      this.c = (CirclePageIndicator)this.d.findViewById(2131296853);
      this.e = (ViewPager)this.d.findViewById(2131301724);
      return this;
    }
    
    public Builder a(int param1Int1, int param1Int2) {
      this.g = param1Int1;
      this.h = param1Int2;
      return this;
    }
    
    public Builder a(DialogInterface.OnClickListener param1OnClickListener) {
      this.i = param1OnClickListener;
      return this;
    }
    
    public void a(int param1Int) {
      this.h = param1Int;
    }
    
    public Dialog b() {
      return this.b;
    }
    
    public Builder b(DialogInterface.OnClickListener param1OnClickListener) {
      this.j = param1OnClickListener;
      return this;
    }
    
    public int c() {
      return this.g;
    }
    
    public int d() {
      return this.h;
    }
    
    public Builder e() {
      ArrayList<View> arrayList = new ArrayList();
      View view1 = LayoutInflater.from(this.a).inflate(2131493025, null);
      View view2 = LayoutInflater.from(this.a).inflate(2131493024, null);
      this.e.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
            public void onPageScrollStateChanged(int param2Int) {}
            
            public void onPageScrolled(int param2Int1, float param2Float, int param2Int2) {}
            
            public void onPageSelected(int param2Int) {
              CardDialog.Builder.a(this.a, param2Int);
              if (this.a.c() == 2) {
                if (param2Int == 0) {
                  this.a.a(0);
                  return;
                } 
                if (param2Int == 1)
                  this.a.a(1); 
              } 
            }
          });
      if (this.g == 2) {
        arrayList.add(view1);
        arrayList.add(view2);
      } else {
        int i = this.h;
        if (i == 0) {
          arrayList.add(view1);
        } else if (i == 1) {
          arrayList.add(view2);
        } 
      } 
      PagerAdapter pagerAdapter = new PagerAdapter(this, arrayList) {
          public void destroyItem(ViewGroup param2ViewGroup, int param2Int, Object param2Object) {
            param2ViewGroup.removeView(this.a.get(param2Int));
          }
          
          public int getCount() {
            return this.a.size();
          }
          
          public int getItemPosition(Object param2Object) {
            return super.getItemPosition(param2Object);
          }
          
          public Object instantiateItem(ViewGroup param2ViewGroup, int param2Int) {
            param2ViewGroup.addView(this.a.get(param2Int));
            return this.a.get(param2Int);
          }
          
          public boolean isViewFromObject(View param2View, Object param2Object) {
            return (param2View == param2Object);
          }
        };
      this.e.setAdapter(pagerAdapter);
      this.k.schedule(new TimerTask(this, arrayList) {
            public void run() {
              if (CardDialog.Builder.a(this.b) == this.a.size() - 1)
                CardDialog.Builder.a(this.b, -1); 
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      CardDialog.Builder.b(this.a.b).setCurrentItem(CardDialog.Builder.a(this.a.b) + 1);
                    }
                  });
            }
          }5000L, 5000L);
      if (arrayList.size() == 1) {
        this.c.setVisibility(8);
        return this;
      } 
      this.c.setVisibility(0);
      this.c.setRadius(5.0F);
      this.c.setViewPager(this.e);
      this.c.setInterval(18);
      this.c.setFillColor(2131100608);
      this.c.setPageColor(2131100604);
      this.c.setStrokeColor(2131100604);
      this.c.setStrokeWidth(1.0F);
      return this;
    }
    
    public CardDialog f() {
      this.b = new CardDialog(this.a);
      this.b.requestWindowFeature(1);
      this.b.setContentView(this.d);
      Window window = this.b.getWindow();
      WindowManager.LayoutParams layoutParams = window.getAttributes();
      window.setBackgroundDrawableResource(2131100897);
      layoutParams.width = DensityUtils.a(this.a, 240.0F);
      layoutParams.height = DensityUtils.a(this.a, 300.0F);
      window.setAttributes(layoutParams);
      if (this.i != null)
        ((TextView)this.d.findViewById(2131300596)).setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param2View) {
                CardDialog.Builder.d(this.a).onClick((DialogInterface)CardDialog.Builder.c(this.a), -1);
              }
            }); 
      if (this.j != null)
        ((TextView)this.d.findViewById(2131300595)).setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param2View) {
                CardDialog.Builder.e(this.a).onClick((DialogInterface)CardDialog.Builder.c(this.a), -2);
              }
            }); 
      return this.b;
    }
  }
  
  class null implements ViewPager.OnPageChangeListener {
    null(CardDialog this$0) {}
    
    public void onPageScrollStateChanged(int param1Int) {}
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
    
    public void onPageSelected(int param1Int) {
      CardDialog.Builder.a(this.a, param1Int);
      if (this.a.c() == 2) {
        if (param1Int == 0) {
          this.a.a(0);
          return;
        } 
        if (param1Int == 1)
          this.a.a(1); 
      } 
    }
  }
  
  class null extends PagerAdapter {
    null(CardDialog this$0, List param1List) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView(this.a.get(param1Int));
    }
    
    public int getCount() {
      return this.a.size();
    }
    
    public int getItemPosition(Object param1Object) {
      return super.getItemPosition(param1Object);
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      param1ViewGroup.addView(this.a.get(param1Int));
      return this.a.get(param1Int);
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class null extends TimerTask {
    null(CardDialog this$0, List param1List) {}
    
    public void run() {
      if (CardDialog.Builder.a(this.b) == this.a.size() - 1)
        CardDialog.Builder.a(this.b, -1); 
      AppInfo.n().post(new Runnable(this) {
            public void run() {
              CardDialog.Builder.b(this.a.b).setCurrentItem(CardDialog.Builder.a(this.a.b) + 1);
            }
          });
    }
  }
  
  class null implements Runnable {
    public void run() {
      CardDialog.Builder.b(this.a.b).setCurrentItem(CardDialog.Builder.a(this.a.b) + 1);
    }
  }
  
  class null implements View.OnClickListener {
    null(CardDialog this$0) {}
    
    public void onClick(View param1View) {
      CardDialog.Builder.d(this.a).onClick((DialogInterface)CardDialog.Builder.c(this.a), -1);
    }
  }
  
  class null implements View.OnClickListener {
    null(CardDialog this$0) {}
    
    public void onClick(View param1View) {
      CardDialog.Builder.e(this.a).onClick((DialogInterface)CardDialog.Builder.c(this.a), -2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CardDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */