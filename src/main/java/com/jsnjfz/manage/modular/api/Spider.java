package com.jsnjfz.manage.modular.api;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Spider {

    public static void main(String[] args) throws Exception{
        new Spider().parseJD().forEach(System.out::println);
    }

    public List<Content> parseJD() throws Exception{

        String url = "https://bde4.cc";
        System.out.println(url);
        // 解析网页 (Jsoup返回Document就是浏览器的Document对象)

        Document document = Jsoup.parse((new URL(url)), 30000);

        Elements elements = document.getElementsByClass("card");

        List<Content> list = new ArrayList<Content>();

        for (Element el : elements){

            String src = el.getElementsByTag("img").eq(0).attr("data-src");

            String href = el.getElementsByClass("image").eq(0).attr("href");

            String name = el.getElementsByClass("image").eq(0).attr("title");

//            list.add(new Content(name, src, href));
            System.out.println("name: " + name + "  img:  " + src + "  href:  " + href);

        }


        return list;
    }
}
