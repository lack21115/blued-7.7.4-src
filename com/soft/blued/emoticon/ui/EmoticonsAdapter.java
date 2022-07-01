package com.soft.blued.emoticon.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.customview.emoji.view.EmojiTextView;
import com.soft.blued.emoticon.model.EmoticonModel;
import java.util.List;

public class EmoticonsAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private PopupWindow c;
  
  private IRequestHost d;
  
  private List<EmoticonModel> e;
  
  private int f = 0;
  
  private int g = 0;
  
  private IViewStateListener h;
  
  public EmoticonsAdapter(Context paramContext, List<EmoticonModel> paramList, IRequestHost paramIRequestHost) {
    this.b = paramContext;
    this.d = paramIRequestHost;
    this.a = LayoutInflater.from(paramContext);
    this.e = paramList;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.f = paramInt1;
    this.g = this.f - paramInt2;
    notifyDataSetChanged();
  }
  
  public void a(IViewStateListener paramIViewStateListener) {
    this.h = paramIViewStateListener;
  }
  
  public int getCount() {
    return this.e.size();
  }
  
  public Object getItem(int paramInt) {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    ViewHolder viewHolder3;
    if (paramView == null) {
      viewHolder1 = new ViewHolder(this);
      View view = this.a.inflate(2131493497, paramViewGroup, false);
      view.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.f));
      viewHolder1.a = (ImageView)view.findViewById(2131297625);
      viewHolder1.c = (RelativeLayout)view.findViewById(2131299697);
      viewHolder1.b = (RelativeLayout)view.findViewById(2131299722);
      viewHolder1.d = (TextView)view.findViewById(2131297654);
      viewHolder1.e = (EmojiTextView)view.findViewById(2131296982);
      view.setTag(viewHolder1);
      viewHolder2 = viewHolder1;
    } else {
      viewHolder2 = (ViewHolder)viewHolder1.getTag();
      viewHolder3 = viewHolder1;
    } 
    EmoticonModel emoticonModel = this.e.get(paramInt);
    if (emoticonModel != null) {
      if (emoticonModel.emoticonType == 0) {
        if (emoticonModel.emoji != null) {
          viewHolder2.d.setVisibility(8);
          viewHolder2.e.setVisibility(0);
          viewHolder2.e.setText(emoticonModel.emoji.a());
        } else {
          viewHolder2.e.setVisibility(8);
          viewHolder2.a.setBackgroundResource(0);
          viewHolder2.b.setBackgroundResource(2131232927);
          RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
          layoutParams.addRule(13);
          viewHolder2.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          paramInt = this.b.getResources().getIdentifier(emoticonModel.original, "drawable", this.b.getPackageName());
          viewHolder2.a.setImageResource(paramInt);
          viewHolder2.d.setVisibility(8);
        } 
      } else {
        ImageWrapper imageWrapper;
        viewHolder2.b.setBackgroundResource(0);
        paramInt = this.g;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
        layoutParams.addRule(14);
        viewHolder2.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        if (emoticonModel.url.startsWith("assets://")) {
          imageWrapper = ImageLoader.c(this.d, emoticonModel.url.substring(9));
        } else if (emoticonModel.url.startsWith("file://")) {
          imageWrapper = ImageLoader.d(this.d, emoticonModel.url.substring(7));
        } else {
          imageWrapper = ImageLoader.a(this.d, emoticonModel.url);
        } 
        imageWrapper.a(2131232927).a(viewHolder2.a);
        viewHolder2.d.setVisibility(0);
        if (BlueAppLocal.d()) {
          if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
            viewHolder2.d.setText(emoticonModel.name_zh);
          } else {
            viewHolder2.d.setText(emoticonModel.name_zh_tw);
          } 
        } else {
          viewHolder2.d.setText(emoticonModel.name);
        } 
        viewHolder2.b.setOnTouchListener(new View.OnTouchListener(this) {
              public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
                if ((param1MotionEvent.getAction() == 3 || param1MotionEvent.getAction() == 1) && EmoticonsAdapter.a(this.a) != null && EmoticonsAdapter.a(this.a).isShowing()) {
                  EmoticonsAdapter.a(this.a).dismiss();
                  EmoticonsAdapter.a(this.a, (PopupWindow)null);
                } 
                return false;
              }
            });
        viewHolder2.b.setOnLongClickListener(new View.OnLongClickListener(this, emoticonModel, viewHolder2) {
              public boolean onLongClick(View param1View) {
                int i;
                param1View = EmoticonsAdapter.b(this.c).inflate(2131494038, null);
                ImageView imageView = (ImageView)param1View.findViewById(2131297417);
                if (this.a.url_original.startsWith("assets://")) {
                  ImageLoader.c(EmoticonsAdapter.c(this.c), this.a.url_original.substring(9)).a(imageView);
                } else if (this.a.url_original.startsWith("file://")) {
                  ImageLoader.d(EmoticonsAdapter.c(this.c), this.a.url_original.substring(7)).a(imageView);
                } else {
                  ImageLoader.a(EmoticonsAdapter.c(this.c), this.a.url_original).a(imageView);
                } 
                int k = AppInfo.l / 3;
                EmoticonsAdapter.a(this.c, new PopupWindow(param1View, k, k, false));
                EmoticonsAdapter.a(this.c).setBackgroundDrawable((Drawable)new BitmapDrawable());
                EmoticonsAdapter.a(this.c).setOutsideTouchable(true);
                EmoticonsAdapter.a(this.c).setFocusable(true);
                EmoticonsAdapter.a(this.c).update();
                int[] arrayOfInt = new int[2];
                this.b.b.getLocationOnScreen(arrayOfInt);
                if (arrayOfInt[0] < 100) {
                  i = arrayOfInt[0] + EmoticonsAdapter.d(this.c) / 4;
                } else {
                  i = arrayOfInt[0] + EmoticonsAdapter.e(this.c) / 2 - k / 2;
                } 
                int j = i;
                if (arrayOfInt[0] > AppInfo.l - k)
                  j = i - EmoticonsAdapter.d(this.c) / 2; 
                EmoticonsAdapter.a(this.c).showAtLocation((View)this.b.c, 0, j, arrayOfInt[1] - EmoticonsAdapter.a(this.c).getHeight() - DensityUtils.b(EmoticonsAdapter.f(this.c), 88.0F));
                return false;
              }
            });
      } 
      viewHolder3.setOnClickListener(new View.OnClickListener(this, emoticonModel) {
            public void onClick(View param1View) {
              if (EmoticonsAdapter.g(this.b) != null)
                EmoticonsAdapter.g(this.b).a(this.a); 
            }
          });
    } 
    return (View)viewHolder3;
  }
  
  class ViewHolder {
    public ImageView a;
    
    public RelativeLayout b;
    
    public RelativeLayout c;
    
    public TextView d;
    
    public EmojiTextView e;
    
    ViewHolder(EmoticonsAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\emotico\\ui\EmoticonsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */