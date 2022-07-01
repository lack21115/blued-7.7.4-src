package com.soft.blued.ui.msg.pop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.msg.customview.BirthCardRelativeLayout;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;
import com.soft.blued.view.tip.CommonAlertDialog;

public class BirthCardPop extends CenterPopupView implements Observer<GiftGivingOptionForJsonParse.CardGift> {
  public IRequestHost c;
  
  private BirthCardRelativeLayout d;
  
  private GiftGivingOptionForJsonParse e;
  
  private boolean f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private boolean j;
  
  public BirthCardPop(Context paramContext, GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramContext);
    this.e = paramGiftGivingOptionForJsonParse;
    this.f = paramBoolean1;
    this.j = paramBoolean2;
  }
  
  public void a(GiftGivingOptionForJsonParse.CardGift paramCardGift) {
    GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = this.e;
    if (giftGivingOptionForJsonParse != null && giftGivingOptionForJsonParse.extra_info != null) {
      this.e.extra_info.from = paramCardGift.from;
      this.e.extra_info.to = paramCardGift.to;
      this.e.extra_info.text = paramCardGift.text;
      TextView textView = this.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("To: ");
      stringBuilder.append(paramCardGift.to);
      textView.setText(stringBuilder.toString());
      textView = this.h;
      stringBuilder = new StringBuilder();
      stringBuilder.append("From:");
      stringBuilder.append(paramCardGift.from);
      textView.setText(stringBuilder.toString());
      this.i.setText(paramCardGift.text);
    } 
  }
  
  public void b() {
    super.b();
    this.d = (BirthCardRelativeLayout)findViewById(2131299697);
    GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = this.e;
    if (giftGivingOptionForJsonParse != null && giftGivingOptionForJsonParse.extra_info != null) {
      int i;
      if (!TextUtils.isEmpty(this.e.extra_info.text_background_color)) {
        try {
          this.d.setShadeColor(Color.parseColor(this.e.extra_info.text_background_color));
        } finally {}
      } else {
        this.d.setShadeColor(0);
      } 
      this.g = (TextView)findViewById(2131301414);
      this.h = (TextView)findViewById(2131300785);
      TextView textView2 = this.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("To: ");
      stringBuilder.append(this.e.extra_info.to);
      textView2.setText(stringBuilder.toString());
      textView2 = this.h;
      stringBuilder = new StringBuilder();
      stringBuilder.append("From: ");
      stringBuilder.append(this.e.extra_info.from);
      textView2.setText(stringBuilder.toString());
      this.i = (TextView)findViewById(2131300663);
      this.i.setTextColor(Color.parseColor(this.e.extra_info.text_color));
      this.i.addTextChangedListener(new TextWatcher(this) {
            public void afterTextChanged(Editable param1Editable) {
              BirthCardPop.b(this.a).postDelayed(new Runnable(this) {
                    public void run() {
                      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)BirthCardPop.a(this.a.a).getLayoutParams();
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("lineCnt===");
                      stringBuilder.append(BirthCardPop.b(this.a.a).getLineCount());
                      Logger.c("BirthCardPop", new Object[] { stringBuilder.toString() });
                      if (BirthCardPop.b(this.a.a).getLineCount() < 3) {
                        layoutParams.topMargin = DensityUtil.a(30.0F);
                      } else {
                        layoutParams.topMargin = DensityUtil.a(10.0F);
                      } 
                      BirthCardPop.a(this.a.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                    }
                  }50L);
            }
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          });
      String str = this.e.extra_info.text;
      if (TextUtils.isEmpty(this.e.extra_info.text))
        if (BlueAppLocal.d()) {
          if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
            str = this.e.extra_info.text_zh_cn;
          } else {
            str = this.e.extra_info.text_zh_tw;
          } 
        } else {
          str = this.e.extra_info.text_en_us;
        }  
      this.i.setText(str);
      this.e.extra_info.text = str;
      ImageView imageView = (ImageView)findViewById(2131297706);
      ImageLoader.a(this.c, this.e.extra_info.background_image).a(imageView);
      imageView = (ImageView)findViewById(2131297899);
      ImageLoader.a(this.c, this.e.extra_info.after_effects).f().e(-1).a(imageView);
      TextView textView1 = (TextView)findViewById(2131301329);
      if (!this.f) {
        textView1.setVisibility(8);
      } else {
        textView1.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                String str;
                EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_SEND_CLICK, (BirthCardPop.c(this.a)).gift_id, new boolean[] { BirthCardPop.d(this.a) });
                this.a.p();
                if (BirthCardPop.d(this.a)) {
                  str = "go_on_send_gift_package";
                } else {
                  str = "go_on_send_gift";
                } 
                LiveEventBus.get(str).post(null);
              }
            });
      } 
      textView1 = (TextView)findViewById(2131300642);
      Resources resources = getResources();
      if (this.f) {
        i = 2131755726;
      } else {
        i = 2131756021;
      } 
      textView1.setText(resources.getString(i));
      textView1.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (BirthCardPop.e(this.a))
                EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_CANCEL_CLICK, (BirthCardPop.c(this.a)).gift_id, new boolean[0]); 
              this.a.c();
            }
          });
      TextView textView3 = (TextView)findViewById(2131300728);
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
      if (displayMetrics.density == 2.75F) {
        ConstraintLayout.LayoutParams layoutParams1 = (ConstraintLayout.LayoutParams)textView3.getLayoutParams();
        layoutParams1.bottomMargin = DensityUtil.a(265.0F);
        textView3.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)textView1.getLayoutParams();
        layoutParams.bottomMargin = DensityUtil.a(30.0F);
        textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      if (!this.f) {
        textView3.setVisibility(8);
        return;
      } 
      textView3.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              (new XPopup.Builder(this.a.getContext())).d(Boolean.valueOf(true)).a((BasePopupView)new GiftCardEditPop(this.a.getContext(), (BirthCardPop.c(this.a)).extra_info)).h();
            }
          });
    } 
  }
  
  public void c() {
    if (!this.f) {
      p();
      return;
    } 
    CommonAlertDialog.a(getContext(), "", getResources().getString(2131757950), null, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (BirthCardPop.c(this.a) != null && (BirthCardPop.c(this.a)).extra_info != null)
              (BirthCardPop.c(this.a)).extra_info.text = null; 
            EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK, (BirthCardPop.c(this.a)).gift_id, new boolean[0]);
            this.a.p();
          }
        }null, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            param1DialogInterface.dismiss();
            EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK, (BirthCardPop.c(this.a)).gift_id, new boolean[0]);
          }
        }null);
  }
  
  public int getImplLayoutId() {
    return 2131494028;
  }
  
  public void t() {
    super.t();
    LiveEventBus.get("card_edit", GiftGivingOptionForJsonParse.CardGift.class).removeObserver(this);
  }
  
  public void v() {
    super.v();
    this.d.a();
    LiveEventBus.get("card_edit", GiftGivingOptionForJsonParse.CardGift.class).observeForever(this);
    if (!this.f)
      EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_SHOW, this.e.gift_id, new boolean[0]); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\BirthCardPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */