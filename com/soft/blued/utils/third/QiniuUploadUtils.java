package com.soft.blued.utils.third;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.soft.blued.model.BluedAlbum;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QiniuUploadUtils {
  public static List<Pair<String, String>> a(String paramString1, String paramString2) {
    ArrayList<Pair> arrayList = new ArrayList();
    arrayList.add(new Pair(paramString1, paramString2));
    return (List)arrayList;
  }
  
  public static void a(String paramString, BluedAlbum paramBluedAlbum, QiniuUploadTools.QiNiuListener paramQiNiuListener) {
    if (!TextUtils.isEmpty(paramString))
      QiniuUploadTools.a(null, new File(paramString), paramBluedAlbum.key, paramBluedAlbum.token, paramQiNiuListener); 
  }
  
  public static void a(byte[] paramArrayOfbyte, BluedAlbum paramBluedAlbum, QiniuUploadTools.QiNiuListener paramQiNiuListener) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0)
      QiniuUploadTools.a(null, paramArrayOfbyte, paramBluedAlbum.key, paramBluedAlbum.token, paramQiNiuListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\third\QiniuUploadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */