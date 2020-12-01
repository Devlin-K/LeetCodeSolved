package org.dkwork.javatemplate.common.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author liuyj
 * @Title: FreeMarkerUtil
 * @create 2020-08-18 16:19
 * @ProjectName wechat-back
 * @Description: 根据freemarker模板生成word
 */
@Slf4j
@Component
public class FreeMarkerUtil {
    private static final String ENCODING = "UTF-8";
    private static Configuration cfg = new Configuration();

    //初始化cfg
    static {
        //设置模板所在文件夹
        cfg.setClassForTemplateLoading(FreeMarkerUtil.class, "/templates/xsl-templates");
        // setEncoding这个方法一定要设置国家及其编码，不然在ftl中的中文在生成html后会变成乱码
        cfg.setEncoding(Locale.getDefault(), ENCODING);
        // 设置对象的包装器
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        // 设置异常处理器,这样的话就可以${a.b.c.d}即使没有属性也不会出错
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

    }

    //获取模板对象
    public static Template getTemplate(String templateFileName) throws IOException {
        return cfg.getTemplate(templateFileName, ENCODING);
    }

    /**
     * 据数据及模板生成文件
     * @param data             Map的数据结果集
     * @param templateFileName ftl模版文件名
     * @param outFilePath      生成文件名称(可带路径)
     */
    public static File createFile(Map<String, Object> data, String templateFileName, String outFilePath) {
        Writer out = null;
        File outFile = new File(outFilePath);
        try {
            // 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
            Template template = getTemplate(templateFileName);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            out = new OutputStreamWriter(new FileOutputStream(outFile), ENCODING);
            // 处理模版
            template.process(data, out);
            out.flush();
            log.info("由模板文件" + templateFileName + "生成" + outFilePath + "成功.");
        } catch (Exception e) {
            log.error("由模板文件" + templateFileName + "生成" + outFilePath + "出错");
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                log.error("关闭Write对象出错", e);
                e.printStackTrace();
            }
        }
        return outFile;
    }

    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<String, Object>();
        createFile(data, "justPromise.ftl", "D:/xxx.doc");
    }
}
