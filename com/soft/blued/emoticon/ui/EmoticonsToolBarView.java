package com.soft.blued.emoticon.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.message.MessageProtos;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import skin.support.widget.SkinCompatBackgroundHelper;

public class EmoticonsToolBarView extends LinearLayout implements BluedSkinSupportable {
  private LayoutInflater a;
  
  private Context b;
  
  private ImageView c;
  
  private HorizontalScrollView d;
  
  private LinearLayout e;
  
  private List<EmoticonPackageModel> f;
  
  private int g;
  
  private ArrayList<View> h = new ArrayList<View>();
  
  private RelativeLayout i;
  
  private boolean j;
  
  private String k;
  
  private SkinCompatBackgroundHelper l;
  
  private List<OnToolBarItemClickListener> m;
  
  public EmoticonsToolBarView(Context paramContext) {
    super(paramContext);
  }
  
  public EmoticonsToolBarView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    this.l = new SkinCompatBackgroundHelper((View)this);
    this.a = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.a.inflate(2131493048, (ViewGroup)this);
    this.i = (RelativeLayout)findViewById(2131299909);
    this.c = (ImageView)findViewById(2131297804);
    this.d = (HorizontalScrollView)findViewById(2131297388);
    this.e = (LinearLayout)findViewById(2131299190);
    this.g = (int)TypedValue.applyDimension(1, 60.0F, getResources().getDisplayMetrics());
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackMessage.a(MessageProtos.Event.MSG_EMOJI_CLICK, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, EmoticonsToolBarView.a(this.a));
            BluedURIRouterAdapter.openEmotionShop(EmoticonsToolBarView.b(this.a), 0);
          }
        });
  }
  
  private void a(int paramInt) {
    if (paramInt < this.e.getChildCount())
      this.d.post(new Runnable(this, paramInt) {
            public void run() {
              int i = EmoticonsToolBarView.d(this.b).getScrollX();
              if (Build.VERSION.SDK_INT > 11) {
                int k = (int)EmoticonsToolBarView.e(this.b).getChildAt(this.a).getX();
                if (k < i) {
                  EmoticonsToolBarView.d(this.b).scrollTo(k, 0);
                  return;
                } 
                int m = EmoticonsToolBarView.e(this.b).getChildAt(this.a).getWidth();
                int j = EmoticonsToolBarView.d(this.b).getWidth();
                k += m;
                i += j;
                if (k > i)
                  EmoticonsToolBarView.d(this.b).scrollTo(k - i, 0); 
              } 
            }
          }); 
  }
  
  public void a(IRequestHost paramIRequestHost, List<EmoticonPackageModel> paramList) {
    this.f = paramList;
    this.e.removeAllViews();
    this.h.clear();
    int j = 0;
    for (int i = 0; j < this.f.size(); i++) {
      EmoticonPackageModel emoticonPackageModel = this.f.get(i);
      View view = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131494157, null);
      ImageView imageView = (ImageView)view.findViewById(2131297804);
      view.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(this.g, -1));
      this.e.addView(view);
      if (emoticonPackageModel.emoticonType == 0) {
        imageView.setImageResource(this.b.getResources().getIdentifier(emoticonPackageModel.icon, "drawable", this.b.getPackageName()));
      } else if (emoticonPackageModel.icon.startsWith("assets://")) {
        ImageLoader.c(paramIRequestHost, emoticonPackageModel.icon.substring(9)).a(imageView);
      } else if (emoticonPackageModel.icon.startsWith("file://")) {
        ImageLoader.d(paramIRequestHost, emoticonPackageModel.icon.substring(7)).a(imageView);
      } else {
        ImageLoader.a(paramIRequestHost, emoticonPackageModel.icon).a(imageView);
      } 
      view.setBackgroundResource(2131232927);
      this.h.add(view);
      imageView.setOnClickListener(new View.OnClickListener(this, j) {
            public void onClick(View param1View) {
              if (EmoticonsToolBarView.c(this.b) != null && !EmoticonsToolBarView.c(this.b).isEmpty()) {
                Iterator<EmoticonsToolBarView.OnToolBarItemClickListener> iterator = EmoticonsToolBarView.c(this.b).iterator();
                while (iterator.hasNext())
                  ((EmoticonsToolBarView.OnToolBarItemClickListener)iterator.next()).a(this.a); 
              } 
            }
          });
      j++;
    } 
    if (this.j) {
      this.i.setVisibility(8);
    } else {
      View view = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131494158, null);
      view.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(this.g, -1));
      this.e.addView(view);
      view.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              BluedURIRouterAdapter.openEmotionShop(EmoticonsToolBarView.b(this.a), 1);
            }
          });
    } 
    setToolBtnSelect(0);
  }
  
  public void a(OnToolBarItemClickListener paramOnToolBarItemClickListener) {
    if (this.m == null)
      this.m = new ArrayList<OnToolBarItemClickListener>(); 
    this.m.add(paramOnToolBarItemClickListener);
  }
  
  public void g() {
    Log.e("Skin", "EmoticonsToolBarView apply skin");
  }
  
  public void setModel(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void setOnToolBarItemClickListener(OnToolBarItemClickListener paramOnToolBarItemClickListener) {
    a(paramOnToolBarItemClickListener);
  }
  
  public void setTargetUid(String paramString) {
    this.k = paramString;
  }
  
  public void setToolBtnSelect(int paramInt) {
    a(paramInt);
    for (int i = 0; i < this.h.size(); i++) {
      if (paramInt == i) {
        ((View)this.h.get(i)).setBackgroundColor(getResources().getColor(2131100891));
      } else {
        ((View)this.h.get(i)).setBackgroundResource(2131234237);
      } 
    } 
  }
  
  public static interface OnToolBarItemClickListener {
    void a(int param1Int);
  }
  
  public class ToolBarAdapter extends BaseAdapter {
    public int getCount() {
      return EmoticonsToolBarView.f(this.a).size();
    }
    
    public Object getItem(int param1Int) {
      return EmoticonsToolBarView.f(this.a).get(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      EmoticonsToolBarView.ViewHolder viewHolder1;
      EmoticonsToolBarView.ViewHolder viewHolder2;
      if (param1View == null) {
        viewHolder1 = new EmoticonsToolBarView.ViewHolder(this.a);
        View view = EmoticonsToolBarView.g(this.a).inflate(2131494157, null);
        viewHolder1.a = (ImageView)view.findViewById(2131297804);
        viewHolder1.b = (FrameLayout)view.findViewById(2131296838);
        view.setTag(viewHolder1);
      } else {
        EmoticonsToolBarView.ViewHolder viewHolder = (EmoticonsToolBarView.ViewHolder)viewHolder1.getTag();
        viewHolder2 = viewHolder1;
        viewHolder1 = viewHolder;
      } 
      EmoticonPackageModel emoticonPackageModel = EmoticonsToolBarView.f(this.a).get(param1Int);
      int i = EmoticonsToolBarView.b(this.a).getResources().getIdentifier(emoticonPackageModel.icon, "drawable", EmoticonsToolBarView.b(this.a).getPackageName());
      viewHolder1.a.setImageResource(i);
      viewHolder1.a.setOnClickListener(new View.OnClickListener(this, param1Int) {
            public void onClick(View param2View) {
              if (EmoticonsToolBarView.c(this.b.a) != null && !EmoticonsToolBarView.c(this.b.a).isEmpty()) {
                Iterator<EmoticonsToolBarView.OnToolBarItemClickListener> iterator = EmoticonsToolBarView.c(this.b.a).iterator();
                while (iterator.hasNext())
                  ((EmoticonsToolBarView.OnToolBarItemClickListener)iterator.next()).a(this.a); 
              } 
            }
          });
      return (View)viewHolder2;
    }
  }
  
  class null implements View.OnClickListener {
    null(EmoticonsToolBarView this$0, int param1Int) {}
    
    public void onClick(View param1View) {
      if (EmoticonsToolBarView.c(this.b.a) != null && !EmoticonsToolBarView.c(this.b.a).isEmpty()) {
        Iterator<EmoticonsToolBarView.OnToolBarItemClickListener> iterator = EmoticonsToolBarView.c(this.b.a).iterator();
        while (iterator.hasNext())
          ((EmoticonsToolBarView.OnToolBarItemClickListener)iterator.next()).a(this.a); 
      } 
    }
  }
  
  class ViewHolder {
    public ImageView a;
    
    public FrameLayout b;
    
    ViewHolder(EmoticonsToolBarView this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\emotico\\ui\EmoticonsToolBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */