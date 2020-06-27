import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestHttp {
    public static void main(String[] args) {

        TestHttp a = new TestHttp();
        String url = a.getUrl("063520b924f5809f39920d5198f70f8e", "1586603750840");

        System.out.println(url);
        Map<String, String> headers = a.getHead();
        HttpResponse response = HttpRequest.get(url)
                .addHeaders(headers)
                .execute();

        String body = response.body();
        System.out.println(body);
        a.parse(body);

    }

    private String getUrl(String authorization, String requestSign) {
         StringBuilder url = new StringBuilder("https://ajax.lianjia.com/map/search/ershoufang/?callback=");
        long timeMillis = System.currentTimeMillis();
        long x = Long.valueOf(requestSign) - 904;
        long y = Long.valueOf(requestSign) - 905;
        url.append("jQuery1111"+ timeMillis +"_"+ y);
        url.append("&city_id=320500&group_type=district");
        url.append("&max_lat=31.448343&min_lat=31.158561&max_lng=120.732979&min_lng=120.451845");
        url.append("&sug_id=&sug_type=&filters=%7B%7D&request_ts="+ requestSign +"&source=ljpc");
        url.append("&authorization="+ authorization +"&_=" + x);
        return url.toString();
    }

    private Map<String, String> getHead() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Connection", "keep-alive");
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
        headers.put("Sec-Fetch-Dest", "script");
        headers.put("Accept", "*/*");
        headers.put("Sec-Fetch-Site", "same-site");
        headers.put("Sec-Fetch-Mode", "no-cors");
        headers.put("Referer", "https://su.lianjia.com/ditu/");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
//        String cookie
//        headers.put("Cookie", cookie);

        return headers;
    }

    private void parse(String body) {
        int index = body.indexOf("(");
        String substring = body.substring(index + 1, body.length() - 1);

        ResponseData parse = JSON.parseObject(substring, ResponseData.class);

        Map<Long, Node> list = parse.getData().getList();
        list.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value.getName());
            System.out.println(value.getUnit_price());
        });

    }
}
