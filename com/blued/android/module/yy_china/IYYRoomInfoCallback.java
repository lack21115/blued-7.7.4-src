package com.blued.android.module.yy_china;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.model.YYRoomModel;
import java.util.Map;

public interface IYYRoomInfoCallback {
  CharSequence a(CharSequence paramCharSequence, String paramString, ClickAtLinkListener paramClickAtLinkListener);
  
  String a();
  
  String a(int paramInt);
  
  void a(Context paramContext);
  
  void a(Context paramContext, EditText paramEditText, int paramInt1, int paramInt2, String paramString, Map<String, String> paramMap);
  
  void a(Context paramContext, FragmentManager paramFragmentManager, YYRoomModel paramYYRoomModel, Bitmap paramBitmap, String paramString);
  
  void a(Context paramContext, YYRoomModel paramYYRoomModel, Bitmap paramBitmap, String paramString);
  
  void a(Context paramContext, String paramString, int paramInt);
  
  void a(Context paramContext, String paramString1, String paramString2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, IRequestHost paramIRequestHost);
  
  void a(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  boolean a(Context paramContext, View.OnClickListener paramOnClickListener);
  
  String b();
  
  void b(Context paramContext);
  
  void b(Context paramContext, String paramString1, String paramString2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, IRequestHost paramIRequestHost);
  
  String c();
  
  void c(Context paramContext);
  
  boolean d();
  
  String e();
  
  String f();
  
  String g();
  
  String h();
  
  String i();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\IYYRoomInfoCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */