package org.dkwork.leetcodesolved.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author jin
 * @date 2020/9/11
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProjecet tj-hall
 * @BelongPackage com.taiji.tjhall.common.utils
 * @Describe:
 */
@Slf4j
public class ResponseUtil {
    public static void putFileInputStream2Response(InputStream inputStream, HttpServletResponse response){
        ServletOutputStream outputStream = null;
        try{
            response.reset();
            outputStream = response.getOutputStream();
            // 在http响应中输出流
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = inputStream.read(cache)) != -1) {
                outputStream.write(cache, 0, nRead);
                outputStream.flush();
            }
            outputStream.flush();
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
