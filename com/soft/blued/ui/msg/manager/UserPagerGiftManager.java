package com.soft.blued.ui.msg.manager;

import android.content.Context;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.util.Stack;

public class UserPagerGiftManager {
  private static UserPagerGiftManager b;
  
  public GiftGivingOptionForJsonParse a;
  
  private Stack<GiftPlayer> c = new Stack<GiftPlayer>();
  
  public static UserPagerGiftManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/msg/manager/UserPagerGiftManager.b : Lcom/soft/blued/ui/msg/manager/UserPagerGiftManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/msg/manager/UserPagerGiftManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/msg/manager/UserPagerGiftManager.b : Lcom/soft/blued/ui/msg/manager/UserPagerGiftManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/msg/manager/UserPagerGiftManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/msg/manager/UserPagerGiftManager.b : Lcom/soft/blued/ui/msg/manager/UserPagerGiftManager;
    //   25: ldc com/soft/blued/ui/msg/manager/UserPagerGiftManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/msg/manager/UserPagerGiftManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/msg/manager/UserPagerGiftManager.b : Lcom/soft/blued/ui/msg/manager/UserPagerGiftManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static String a(boolean paramBoolean, MsgExtraGift paramMsgExtraGift, Context paramContext, String paramString) {
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" ");
      stringBuilder.append(paramContext.getResources().getString(2131757999));
      stringBuilder.append(paramMsgExtraGift.getGiftName());
      return stringBuilder.toString();
    } 
    return paramContext.getResources().getString(2131758091, new Object[] { paramMsgExtraGift.gift_like.toNickName, paramMsgExtraGift.getGiftName() });
  }
  
  public static byte[] a(int paramInt) {
    byte[] arrayOfByte = new byte[4];
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = (byte)(paramInt >> i * 8 & 0xFF); 
    return arrayOfByte;
  }
  
  public void a(GiftPlayer paramGiftPlayer) {
    if (!this.c.contains(paramGiftPlayer)) {
      this.c.add(paramGiftPlayer);
      GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = this.a;
      if (giftGivingOptionForJsonParse != null) {
        paramGiftPlayer.a(giftGivingOptionForJsonParse);
        this.a = null;
      } 
    } 
  }
  
  public GiftPlayer b() {
    return this.c.peek();
  }
  
  public void b(GiftPlayer paramGiftPlayer) {
    if (paramGiftPlayer == null)
      return; 
    this.c.remove(paramGiftPlayer);
  }
  
  public long c() {
    if (!this.c.isEmpty()) {
      GiftPlayer giftPlayer = this.c.peek();
      if (giftPlayer != null)
        return giftPlayer.a(); 
    } 
    return 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\UserPagerGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */