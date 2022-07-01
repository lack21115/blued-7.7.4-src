package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.adapter.FuGiftAdapter;
import com.soft.blued.ui.msg.event.OpenGiftPackageEvent;
import com.soft.blued.ui.msg.model.FuGiftModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

public class FuGiftPop extends CenterPopupView {
  private RecyclerView c;
  
  private List<FuGiftModel> d;
  
  private TextView e;
  
  private TextView f;
  
  private ImageView g;
  
  private ActivityFragmentActive h;
  
  private String i;
  
  public FuGiftPop(Context paramContext, List<FuGiftModel> paramList, String paramString, ActivityFragmentActive paramActivityFragmentActive) {
    super(paramContext);
    this.d = paramList;
    this.i = paramString;
    this.h = paramActivityFragmentActive;
  }
  
  public void b() {
    super.b();
    this.c = (RecyclerView)findViewById(2131299601);
    this.c.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(getContext(), 3));
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 5.0F));
    spacesItemDecoration.a(true, false, false, false);
    spacesItemDecoration.a(5);
    FuGiftAdapter fuGiftAdapter = new FuGiftAdapter(this.d, (IRequestHost)this.h);
    this.c.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    this.c.setAdapter((RecyclerView.Adapter)fuGiftAdapter);
    this.e = (TextView)findViewById(2131300890);
    String str = getContext().getString(2131757982);
    TextView textView = this.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("- ");
    stringBuilder.append(String.format(str, new Object[] { Integer.valueOf(this.d.size()) }));
    stringBuilder.append(" -");
    textView.setText(stringBuilder.toString());
    this.f = (TextView)findViewById(2131300491);
    this.g = (ImageView)findViewById(2131297804);
    if (!TextUtils.isEmpty(this.i))
      ImageLoader.a((IRequestHost)this.h, this.i).a(this.g); 
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            BluedPreferences.V(false);
            this.a.p();
            OpenGiftPackageEvent openGiftPackageEvent = new OpenGiftPackageEvent();
            openGiftPackageEvent.a = FuGiftPop.a(this.a);
            LiveEventBus.get("open_gift_package").post(openGiftPackageEvent);
          }
        });
  }
  
  public int getImplLayoutId() {
    return 2131494039;
  }
  
  public int getMaxWidth() {
    return AppInfo.l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\FuGiftPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */