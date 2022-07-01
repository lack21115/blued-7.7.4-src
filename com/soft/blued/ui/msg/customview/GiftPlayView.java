package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.pop.BirthCardPop;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;
import java.util.concurrent.LinkedBlockingQueue;

public class GiftPlayView extends AppCompatImageView {
  public static final String a = GiftPlayView.class.getSimpleName();
  
  private final int b = 0;
  
  private final int c = 1;
  
  private final int d = 2;
  
  private int e = 0;
  
  private MsgExtraGift f;
  
  private LinkedBlockingQueue<MsgExtraGift> g = new LinkedBlockingQueue<MsgExtraGift>();
  
  public GiftPlayView(Context paramContext) {
    super(paramContext);
  }
  
  public GiftPlayView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public GiftPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a() {
    this.f = this.g.poll();
    MsgExtraGift msgExtraGift = this.f;
    if (msgExtraGift != null && msgExtraGift.gift_like != null) {
      a(this.f.gift_like.gift_url);
      return;
    } 
    this.e = 0;
  }
  
  private void a(GiftGivingOptionForJsonParse.CardGift paramCardGift, String paramString) {
    GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = new GiftGivingOptionForJsonParse();
    giftGivingOptionForJsonParse.gift_id = paramString;
    giftGivingOptionForJsonParse.extra_info = paramCardGift;
    (new XPopup.Builder(getContext())).a((XPopupCallback)new SimpleCallback(this) {
          public void d(BasePopupView param1BasePopupView) {
            super.d(param1BasePopupView);
            GiftPlayView.c(this.a);
          }
        }).a((BasePopupView)new BirthCardPop(getContext(), giftGivingOptionForJsonParse, false, false)).h();
  }
  
  private void a(String paramString) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ChattingModel======");
    stringBuilder.append(paramString);
    Logger.e(str, new Object[] { stringBuilder.toString() });
    ImageLoader.a(null, paramString).f().a(new ImageLoader.OnAnimationStateListener(this, paramString) {
          public void a() {
            String str = GiftPlayView.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onAnimationStart======");
            stringBuilder.append(this.a);
            Logger.e(str, new Object[] { stringBuilder.toString() });
            GiftPlayView.a(this.b, 1);
            this.b.setVisibility(0);
            str = GiftPlayView.a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("onAnimationStart======");
            stringBuilder.append(this.a);
            Logger.e(str, new Object[] { stringBuilder.toString() });
          }
          
          public void b() {
            String str = GiftPlayView.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onAnimationEnd======");
            stringBuilder.append(this.a);
            Logger.e(str, new Object[] { stringBuilder.toString() });
            if (GiftPlayView.a(this.b) != null && (GiftPlayView.a(this.b)).gift_like != null && (GiftPlayView.a(this.b)).gift_like.giftTye == 3 && (GiftPlayView.a(this.b)).gift_like.cardGift != null && !TextUtils.isEmpty((GiftPlayView.a(this.b)).gift_like.cardGift.text)) {
              GiftPlayView giftPlayView = this.b;
              GiftPlayView.a(giftPlayView, (GiftPlayView.a(giftPlayView)).gift_like.cardGift, (GiftPlayView.a(this.b)).gift_like.giftId);
              GiftPlayView.a(this.b, 2);
              this.b.setImageDrawable(null);
              this.b.setVisibility(8);
              return;
            } 
            GiftPlayView.a(this.b, 0);
            this.b.setVisibility(8);
            if (!GiftPlayView.b(this.b).isEmpty()) {
              GiftPlayView.c(this.b);
              return;
            } 
            this.b.setImageDrawable(null);
            this.b.setVisibility(8);
          }
        }).a((ImageView)this);
  }
  
  public void a(MsgExtraGift paramMsgExtraGift) {
    if (paramMsgExtraGift != null) {
      if (paramMsgExtraGift.gift_like == null)
        return; 
      if (this.e == 0) {
        this.e = 1;
        this.f = paramMsgExtraGift;
        a(paramMsgExtraGift.gift_like.gift_url);
        return;
      } 
      this.g.add(paramMsgExtraGift);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\GiftPlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */