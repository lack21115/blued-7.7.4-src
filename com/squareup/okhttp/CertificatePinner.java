package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class CertificatePinner {
  public static final CertificatePinner DEFAULT = (new Builder()).build();
  
  private final Map<String, Set<ByteString>> hostnameToPins;
  
  private CertificatePinner(Builder paramBuilder) {
    this.hostnameToPins = Util.immutableMap(paramBuilder.hostnameToPins);
  }
  
  public static String pin(Certificate paramCertificate) {
    if (paramCertificate instanceof X509Certificate) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sha1/");
      stringBuilder.append(sha1((X509Certificate)paramCertificate).base64());
      return stringBuilder.toString();
    } 
    throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
  }
  
  private static ByteString sha1(X509Certificate paramX509Certificate) {
    return Util.sha1(ByteString.of(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public void check(String paramString, List<Certificate> paramList) throws SSLPeerUnverifiedException {
    Set<ByteString> set = findMatchingPins(paramString);
    if (set == null)
      return; 
    int j = paramList.size();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      if (set.contains(sha1((X509Certificate)paramList.get(i))))
        return; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Certificate pinning failure!");
    stringBuilder.append("\n  Peer certificate chain:");
    j = paramList.size();
    for (i = bool; i < j; i++) {
      X509Certificate x509Certificate = (X509Certificate)paramList.get(i);
      stringBuilder.append("\n    ");
      stringBuilder.append(pin(x509Certificate));
      stringBuilder.append(": ");
      stringBuilder.append(x509Certificate.getSubjectDN().getName());
    } 
    stringBuilder.append("\n  Pinned certificates for ");
    stringBuilder.append(paramString);
    stringBuilder.append(":");
    for (ByteString byteString : set) {
      stringBuilder.append("\n    sha1/");
      stringBuilder.append(byteString.base64());
    } 
    throw new SSLPeerUnverifiedException(stringBuilder.toString());
  }
  
  public void check(String paramString, Certificate... paramVarArgs) throws SSLPeerUnverifiedException {
    check(paramString, Arrays.asList(paramVarArgs));
  }
  
  Set<ByteString> findMatchingPins(String paramString) {
    Set<ByteString> set = this.hostnameToPins.get(paramString);
    int i = paramString.indexOf('.');
    if (i != paramString.lastIndexOf('.')) {
      Map<String, Set<ByteString>> map = this.hostnameToPins;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("*.");
      stringBuilder.append(paramString.substring(i + 1));
      Set set1 = map.get(stringBuilder.toString());
    } else {
      paramString = null;
    } 
    if (set == null && paramString == null)
      return null; 
    if (set != null && paramString != null) {
      LinkedHashSet<ByteString> linkedHashSet = new LinkedHashSet();
      linkedHashSet.addAll(set);
      linkedHashSet.addAll((Collection)paramString);
      return linkedHashSet;
    } 
    return (Set<ByteString>)((set != null) ? set : paramString);
  }
  
  public static final class Builder {
    private final Map<String, Set<ByteString>> hostnameToPins = new LinkedHashMap<String, Set<ByteString>>();
    
    public Builder add(String param1String, String... param1VarArgs) {
      if (param1String != null) {
        LinkedHashSet<? extends ByteString> linkedHashSet = new LinkedHashSet();
        Set<? extends ByteString> set = this.hostnameToPins.put(param1String, Collections.unmodifiableSet(linkedHashSet));
        if (set != null)
          linkedHashSet.addAll(set); 
        int j = param1VarArgs.length;
        int i = 0;
        while (i < j) {
          String str = param1VarArgs[i];
          if (str.startsWith("sha1/")) {
            ByteString byteString = ByteString.decodeBase64(str.substring(5));
            if (byteString != null) {
              linkedHashSet.add(byteString);
              i++;
              continue;
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("pins must be base64: ");
            stringBuilder1.append(str);
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("pins must start with 'sha1/': ");
          stringBuilder.append(str);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        return this;
      } 
      throw new IllegalArgumentException("hostname == null");
    }
    
    public CertificatePinner build() {
      return new CertificatePinner(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\CertificatePinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */