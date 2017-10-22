import java.util.HashMap;

public class Encode_and_Decode_TinyURL_535 {

    // Encodes a URL to a shortened URL.
    HashMap<String, String> tinyUrlMap = new HashMap<>();
    HashMap<String, String> longUrlMap = new HashMap<>();
    String tinyPrefix = "https://tinyurl.com/";

    public String encode(String longUrl) {
        if (longUrlMap.containsKey(longUrl)) return longUrlMap.get(longUrl);
        String tinyUrl = tinyPrefix + (longUrl.hashCode() + System.nanoTime());
        tinyUrlMap.put(tinyUrl, longUrl);
        longUrlMap.put(longUrl, tinyUrl);
        return tinyUrl;
    }

    public String decode(String shortUrl) {
        return tinyUrlMap.get(shortUrl);
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
    public static void main(String[] args) {
        Encode_and_Decode_TinyURL_535 T = new Encode_and_Decode_TinyURL_535();
        String str = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(T.encode(str));
        System.out.println(T.decode(T.encode(str)));
    }
}
