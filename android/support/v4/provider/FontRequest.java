package android.support.v4.provider;

import android.support.v4.util.Preconditions;
import android.util.Base64;
import java.util.List;

public final class FontRequest {
  final List mCertificates;
  
  final int mCertificatesArray;
  
  final String mIdentifier;
  
  final String mProviderAuthority;
  
  final String mProviderPackage;
  
  final String mQuery;
  
  public FontRequest(String paramString1, String paramString2, String paramString3, List paramList) {
    this.mProviderAuthority = (String)Preconditions.checkNotNull(paramString1);
    this.mProviderPackage = (String)Preconditions.checkNotNull(paramString2);
    this.mQuery = (String)Preconditions.checkNotNull(paramString3);
    this.mCertificates = (List)Preconditions.checkNotNull(paramList);
    this.mCertificatesArray = 0;
    StringBuilder stringBuilder = new StringBuilder(this.mProviderAuthority);
    stringBuilder.append("-");
    stringBuilder.append(this.mProviderPackage);
    stringBuilder.append("-");
    stringBuilder.append(this.mQuery);
    this.mIdentifier = stringBuilder.toString();
  }
  
  public final String toString() {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder("FontRequest {mProviderAuthority: ");
    stringBuilder2.append(this.mProviderAuthority);
    stringBuilder2.append(", mProviderPackage: ");
    stringBuilder2.append(this.mProviderPackage);
    stringBuilder2.append(", mQuery: ");
    stringBuilder2.append(this.mQuery);
    stringBuilder2.append(", mCertificates:");
    stringBuilder1.append(stringBuilder2.toString());
    for (int i = 0; i < this.mCertificates.size(); i++) {
      stringBuilder1.append(" [");
      List<byte[]> list = this.mCertificates.get(i);
      for (int j = 0; j < list.size(); j++) {
        stringBuilder1.append(" \"");
        stringBuilder1.append(Base64.encodeToString(list.get(j), 0));
        stringBuilder1.append("\"");
      } 
      stringBuilder1.append(" ]");
    } 
    stringBuilder1.append("}");
    stringBuilder2 = new StringBuilder("mCertificatesArray: ");
    stringBuilder2.append(this.mCertificatesArray);
    stringBuilder1.append(stringBuilder2.toString());
    return stringBuilder1.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\provider\FontRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */