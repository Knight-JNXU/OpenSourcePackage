package usages;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liuwen
 * @version 1.0
 * @date 2017年7月28日
 *       funcation :
 */
public class JsoupUsageUsage {

    private Logger logger = LoggerFactory.getLogger(JsoupUsageUsage.class);

    private String readFileJava7(String filePath) throws Exception{
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    private String readFileJava8(String filePath) throws Exception{
        List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        return String.join("\n", lines);
    }


    /**
     * 通过class值获取html
     */
    @Test
    public void getInnerHtmlByClassName() throws Exception{
        String fileStr = readFileJava7("D:/htmlContent.txt");
        Document document = Jsoup.parse(fileStr, "UTF-8");
        Elements elements = document.select(".description-text");
        logger.info(elements.toString());

        logger.info("---------------------------------");

        elements = document.getElementsByClass(".description-text");
        logger.info(elements.toString());
    }

    /**
     * 通过 class 和 标签 获取html
     * @throws Exception
     */
    @Test
    public void getInnerHtmlByClassNameAngTagName() throws Exception{
        String fileStr = readFileJava8("D:/htmlContent.txt");
        Document document = Jsoup.parse(fileStr, "UTF-8");
        Elements elements = document.select(".description-text h2");
        logger.info(elements.toString());
    }

    /**
     * 通过 class 和 标签 获取html值
     * @throws Exception
     */
    @Test
    public void getInnerHtmlValueByClassNameAngTagName() throws Exception{
        String fileStr = readFileJava8("D:/htmlContent.txt");
        Document document = Jsoup.parse(fileStr, "UTF-8");
        Elements elements = document.select(".description-text h2");
        logger.info(elements.text());

        elements = document.select(".text-a p");
        logger.info(elements.text());

        elements = document.select(".text-a span");
        logger.info(elements.text());
    }

}
