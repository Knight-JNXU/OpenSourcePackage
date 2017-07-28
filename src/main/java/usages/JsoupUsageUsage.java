/**
 
* Copyright (c) 2014 Baozun All Rights Reserved.
 
*
 
* This software is the confidential and proprietary information of Baozun.
 
* You shall not disclose such Confidential Information and shall use it only in
 
* accordance with the terms of the license agreement you entered into
 
* with Baozun.
 
*
 
* BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 
* SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 
* IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 
* PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 
* SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 
* THIS SOFTWARE OR ITS DERIVATIVES.
 
*
 
*/
package usages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
public class JsoupUsageUsage{

    private Logger logger = LoggerFactory.getLogger(JsoupUsageUsage.class);

    private String readFileUtil(String filePath){
        String lineTxt = "";
        try{
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                while (bufferedReader.readLine() != null){
                    lineTxt += (bufferedReader.readLine());
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e){
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return lineTxt;
    }

    @Test
    /**
     * 通过class值获取html值
     */
    public void getInnerHtmlByClassName() throws Exception{
        String fileStr = readFileUtil("D:/htmlContent.txt");
        Document document = Jsoup.parse(fileStr, "UTF-8");
        Elements element = document.select(".description-text");
        logger.info(element.toString());
    }

}
