package net.seehope.college.util.file;

import java.io.File;
import java.io.FileFilter;

/**
 * file过滤器工具.
 * @Author：lxgy
 * @date：2018-12-21
 */
public class FileFilterUtil implements FileFilter {

    private String name;

    public FileFilterUtil(String name) {
        this.name = name;
    }

    /**
     * 文件过滤器.
     *
     * @param file
     * @return
     */
    @Override
    public boolean accept(File file) {
        boolean ret = false;
        try {
            String get_file_name = file.getName();
            if (get_file_name.startsWith(this.name)) {
                ret = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
