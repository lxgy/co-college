package net.seehope.college.util.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 下载工具.
 * ==================
 *
 * @Author：lxgy
 * @date:2018-12-21
 */
public class DownloadUtil {

    /**
     * @param file_name:文件名称
     * @param file_path：文件路径
     * @param request：请求
     * @param response：相应
     * @throws IOException
     */
    public static void download_file(String file_name, String file_path, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("user-agent").toLowerCase().contains("msie")) {
            //将不安全的文件名改为utf-8格式
            file_name = URLEncoder.encode(file_name, "utf-8");
        } else {
            //火狐浏览器
            file_name = new String(file_name.getBytes("utf-8"), "iso-8859-1");
        }
        /*设置下载的mime类型*/
        response.setContentType(request.getServletContext().getMimeType(file_name));
        /*设置下载的头部信息*/
        response.setHeader("Content-Disposition", "attachment;filename=" + file_name);
        InputStream is = new FileInputStream(file_path);
        OutputStream os = response.getOutputStream();
        /*输出*/
        int b;
        while((b = is.read()) != -1){
            os.write(b);
        }
        /*关闭流*/
        os.flush();
        os.close();
        is.close();
    }
}
