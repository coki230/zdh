import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class TestHttp {
    public static void main(String[] args) {

        TestHttp a = new TestHttp();
        String url = a.getUrl();
        Map<String, String> headers = a.getHead("lianjia_uuid=df584a96-f0a1-46ea-a2a5-25bc0078d3fd; UM_distinctid=17101cd50ad2e-0ea8e4c07d9d4b-396f7f02-fa000-17101cd50ae451; _smt_uid=5e773ecd.16008ea5; _ga=GA1.2.360959453.1584873167; _jzqc=1; _jzqy=1.1584873165.1585361921.2.jzqsr=baidu.jzqsr=baidu|jzqct=%E9%93%BE%E5%AE%B6; _gid=GA1.2.1948162185.1585361923; Hm_lvt_9152f8221cb6243a53c83b956842be8a=1584873179,1585361958; Hm_lpvt_9152f8221cb6243a53c83b956842be8a=1585361958; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2217101cd52d632c-05c234abefcf6d-396f7f02-1024000-17101cd52d7340%22%2C%22%24device_id%22%3A%2217101cd52d632c-05c234abefcf6d-396f7f02-1024000-17101cd52d7340%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_utm_source%22%3A%22baidu%22%2C%22%24latest_utm_medium%22%3A%22pinzhuan%22%2C%22%24latest_utm_campaign%22%3A%22Main%22%2C%22%24latest_utm_content%22%3A%22Title%22%7D%7D; select_city=320500; _jzqckmp=1; lianjia_ssid=48b196ba-195d-465c-8bc9-c49efe92dcb0; _jzqa=1.3991065939536365000.1584873165.1585455347.1585472096.7; _jzqb=1.1.10.1585472096.1");
        HttpResponse response = HttpRequest.get(url)
                .addHeaders(headers)
                .execute();

        String body = response.body();
        a.parse(body);

    }

    private String getUrl() {
        StringBuilder url = new StringBuilder("https://ajax.lianjia.com/map/search/ershoufang/?callback=jQuery");
        url.append("jQuery11110010104336630113675_1585472095115");
        url.append("&city_id=320500&group_type=district");
        url.append("&max_lat=31.448343&min_lat=31.158561&max_lng=120.732979&min_lng=120.451845");
        url.append("&sug_id=&sug_type=&filters=%7B%7D&request_ts=1585472095990&source=ljpc");
        url.append("&authorization=dffbf45f66a2c95fbe2d8dd86d782a9d&_=1585472095116");
        return url.toString();
    }

    private Map<String, String> getHead(String cookie) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Connection", "keep-alive");
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
        headers.put("Sec-Fetch-Dest", "script");
        headers.put("Accept", "*/*");
        headers.put("Sec-Fetch-Site", "same-site");
        headers.put("Sec-Fetch-Mode", "no-cors");
        headers.put("Referer", "https://su.lianjia.com/ditu/");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("Cookie", cookie);

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
