package spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Liaoxuefeng {

	public static void main(String[] args) throws Exception {
		one();
	}
	
	public static void one() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta charset=\"GBK\"/>\r\n<title>");
		sb.append("Git教程").append("</title>\r\n");
		sb.append("\r\n<style>html,body{padding:0px;margin:0px;left:0px;right:0px;width:100%;height:100%;overflow-x:hidden;}\r\ndiv{padding:20px 50px 100px 50px;}</style>");
		sb.append("</head>\r\n<body>\r\n");
		for (int i = 1; i <= 31; i++) {
			File file = new File("D:\\liaoxuefeng_git\\" + i + ".html");
			Document doc = Jsoup.parse(file, "UTF-8");
			Elements titleEl = doc.select("div .x-content h4");
			String title = titleEl.html();
			title = title.replaceAll("\r", "");
			title = title.replaceAll("\n", "");
			title = title.replaceAll("\t", "");
			title = title.replaceAll("/", "");
			title = title.replaceAll("\\\\", "");
			title = title.replaceAll("\"", "");
			title = title.replaceAll(":", "");
			title = title.replaceAll("[<]", "");
			title = title.replaceAll("[>]", "");
			title = title.replaceAll("[|]", "");
			title = title.replaceAll("[*]", "");
			title = title.replaceAll("[?]", "");
			title = title.replaceAll("？", "");
			title = title.trim();
			Elements divEl = doc.select("div .x-wiki-content");
			sb.append("<div>\r\n<h2>").append(i).append("、 ").append(title).append("</h2>").append("\r\n<hr>");
			String content = divEl.html();
			content = content.replaceAll("/files/attachments/", "http://www.liaoxuefeng.com/files/attachments/");
			sb.append(content);
			sb.append("</div>\r\n");
			sb.append("\r\n\r\n\r\n");
		}
		sb.append("</body></html>");
		File newFile = new File("D:\\liaoxuefeng_git\\Git教程.html");
		FileWriter fw = new FileWriter(newFile);
		fw.write(sb.toString());
		fw.flush();
		fw.close();
	}

	public static void parse() throws Exception {
		for (int i = 1; i <= 111; i++) {
			File file = new File("D:\\liaoxuefeng_source\\" + i + ".html");
			Document doc = Jsoup.parse(file, "UTF-8");
			Elements titleEl = doc.select("div .x-content h4");
			String title = titleEl.html();
			title = title.replaceAll("\r", "");
			title = title.replaceAll("\n", "");
			title = title.replaceAll("\t", "");
			title = title.replaceAll("/", "");
			title = title.replaceAll("\\\\", "");
			title = title.replaceAll("\"", "");
			title = title.replaceAll(":", "");
			title = title.replaceAll("[<]", "");
			title = title.replaceAll("[>]", "");
			title = title.replaceAll("[|]", "");
			title = title.replaceAll("[*]", "");
			title = title.replaceAll("[?]", "");
			title = title.replaceAll("？", "");
			title = title.trim();
			Elements divEl = doc.select("div .x-wiki-content");
			StringBuilder sb = new StringBuilder();
			sb.append("<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta charset=\"GBK\"/>\r\n<title>");
			sb.append(title).append("</title>");
			sb.append("\r\n<style>html,body{padding:0px;margin:0px;left:0px;right:0px;width:100%;height:100%;overflow-x:hidden;}\r\ndiv{padding:20px 50px 100px 50px;}</style>");
			sb.append("\r\n</head>\r\n<body>\r\n<div>");
			sb.append("\r\n<h2>").append(title).append("</h2>\r\n<hr>");
			String content = divEl.html();
			sb.append(content);
			sb.append("\r\n</div>\r\n</body>\r\n</html>");

			File newFile = new File("D:\\liaoxuefeng\\" + i + "、 " + title + ".html");
			FileWriter fw = new FileWriter(newFile);
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		}
	}

	public static void get() throws Exception {
		InputStream in = Liaoxuefeng.class.getClassLoader().getResourceAsStream("urls.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String url = null;
		int i = 1;
		while ((url = br.readLine()) != null) {
			Document doc = Jsoup.connect(url).get();
			Elements titleEl = doc.select("div .x-content h4");
			String title = titleEl.html();
			title = title.replaceAll("\r", "");
			title = title.replaceAll("\n", "");
			title = title.replaceAll("\t", "");
			title = title.replaceAll("/", "");
			title = title.replaceAll("\\\\", "");
			title = title.replaceAll("\"", "");
			title = title.replaceAll(":", "");
			title = title.replaceAll("[<]", "");
			title = title.replaceAll("[>]", "");
			title = title.replaceAll("[|]", "");
			title = title.replaceAll("[*]", "");
			title = title.replaceAll("[?]", "");
			title = title.replaceAll("？", "");
			title = title.trim();
			Elements divEl = doc.select("div .x-wiki-content");
			StringBuilder sb = new StringBuilder();
			sb.append("<!DOCTYPE html><html><head><meta charset=\"GBK\"/><title>");
			sb.append(title).append("</title>");
			sb.append("</head><body><div class=\"x-wiki-content\">");
			String content = divEl.html();
			sb.append(content);
			sb.append("</div></body></html>");

			File file = new File("D:\\liaoxuefeng\\" + i + "_" + title + ".html");
			FileWriter fw = new FileWriter(file);
			fw.write(sb.toString());
			fw.flush();
			fw.close();
			i++;
		}
	}
}
