package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final List<List<byte[]>> d;
  
  private final int e;
  
  private final String f;
  
  public FontRequest(String paramString1, String paramString2, String paramString3, int paramInt) {
    boolean bool;
    this.a = (String)Preconditions.checkNotNull(paramString1);
    this.b = (String)Preconditions.checkNotNull(paramString2);
    this.c = (String)Preconditions.checkNotNull(paramString3);
    this.d = null;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    this.e = paramInt;
    StringBuilder stringBuilder = new StringBuilder(this.a);
    stringBuilder.append("-");
    stringBuilder.append(this.b);
    stringBuilder.append("-");
    stringBuilder.append(this.c);
    this.f = stringBuilder.toString();
  }
  
  public FontRequest(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList) {
    this.a = (String)Preconditions.checkNotNull(paramString1);
    this.b = (String)Preconditions.checkNotNull(paramString2);
    this.c = (String)Preconditions.checkNotNull(paramString3);
    this.d = (List<List<byte[]>>)Preconditions.checkNotNull(paramList);
    this.e = 0;
    StringBuilder stringBuilder = new StringBuilder(this.a);
    stringBuilder.append("-");
    stringBuilder.append(this.b);
    stringBuilder.append("-");
    stringBuilder.append(this.c);
    this.f = stringBuilder.toString();
  }
  
  public List<List<byte[]>> getCertificates() {
    return this.d;
  }
  
  public int getCertificatesArrayResId() {
    return this.e;
  }
  
  public String getIdentifier() {
    return this.f;
  }
  
  public String getProviderAuthority() {
    return this.a;
  }
  
  public String getProviderPackage() {
    return this.b;
  }
  
  public String getQuery() {
    return this.c;
  }
  
  public String toString() {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("FontRequest {mProviderAuthority: ");
    stringBuilder2.append(this.a);
    stringBuilder2.append(", mProviderPackage: ");
    stringBuilder2.append(this.b);
    stringBuilder2.append(", mQuery: ");
    stringBuilder2.append(this.c);
    stringBuilder2.append(", mCertificates:");
    stringBuilder1.append(stringBuilder2.toString());
    for (int i = 0; i < this.d.size(); i++) {
      stringBuilder1.append(" [");
      List<byte[]> list = this.d.get(i);
      for (int j = 0; j < list.size(); j++) {
        stringBuilder1.append(" \"");
        stringBuilder1.append(Base64.encodeToString(list.get(j), 0));
        stringBuilder1.append("\"");
      } 
      stringBuilder1.append(" ]");
    } 
    stringBuilder1.append("}");
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("mCertificatesArray: ");
    stringBuilder2.append(this.e);
    stringBuilder1.append(stringBuilder2.toString());
    return stringBuilder1.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\provider\FontRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */