package com.springboot.mybatis.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mybatis.domain.URLModel;

@RestController
@RequestMapping("/api/url") // /api/url/generateTinnyURL
public class OtherAPIController {

	@RequestMapping(value = "/generateTinnyURL", method = RequestMethod.POST)
	public ResponseEntity<Object> generateTinnyURL(@RequestBody URLModel urlModel) throws Exception {
		URL url = null;
		String tinnyURL = "";
		/*if (urlModel.getAlias_name().equals("") || urlModel.getAlias_name() == null)
		{
			url = new URL("https://tinyurl.com/create.php?source=create&url=" + urlModel.getYour_url() + "");
		} 
		else
		{
			url = new URL("https://tinyurl.com/create.php?source=create&url=" + urlModel.getYour_url() + "&alias="+ urlModel.getAlias_name() + "");
		}*/
		
		url = new URL("https://tinyurl.com/create.php?source=create&url=" + urlModel.getYour_url() + "");

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String strTemp = "";
		while (null != (strTemp = br.readLine())) {
			Document doc = Jsoup.parse(strTemp);
			Elements link = doc.getElementsByTag("a");
			String path = "";
			for (Element element : link) {
				path = element.attr("href");

				if (path.indexOf("https://tinyurl.com/") != -1 && !path.endsWith(".php")) {
					tinnyURL = path;
				}
			}

		}
		if (tinnyURL == null || tinnyURL.equals(""))
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(tinnyURL, HttpStatus.OK);

	}

}
