package net.seehope.college.util.file;

import java.io.*;

/**
 * @Description：文件读写工具.
 * @Tips:路径不建议使用带中文字符.
 * @Author：lxgy
 * @date：2018-12-21
 */
public class FileRWUtil {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 使用字符流（缓冲流）读取文件内容.
     *
     * @param file_name：完整文件名，使用默认的utf-8编码格式
     * @return
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static String read_file_reader(String file_name) {
        return read_file_reader(file_name, DEFAULT_CHARSET);
    }

    /**
     * 使用字符流（缓冲流）读取文件内容.
     *
     * @param file_name：完整文件名
     * @param charset：编码格式
     * @return
     */
    public static String read_file_reader(String file_name, String charset) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file_name), charset));
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }


    /**
     * @param file_name
     * @return
     * @Description：以字节流读取文件
     * @Tips：不建议带有中文.
     */
    public static String read_file_bytes(String file_name) {
        return read_file_bytes(file_name, DEFAULT_CHARSET);
    }

    /**
     * @param file_name：完整文件名
     * @param defaultCharset：编码格式
     * @return
     * @Description：以字节流读取文件.
     */
    public static String read_file_bytes(String file_name, String defaultCharset) {
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try {
            byte[] by = new byte[1024];
            is = new FileInputStream(new File(file_name));
            while (is.read(by) != -1) {
                sb.append(new String(by));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /**
     * @param file_name：完整的文件路径名称
     * @param content：追加内容.
     * @Description:在文件后添加内容
     */
    public static void append_after_file(String file_name, String content) {
        FileWriter file_writer = null;
        try {
            file_writer = new FileWriter(file_name, true);
            file_writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file_writer != null) {
                try {
                    file_writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param file_name
     * @param content
     * @Description：把内容输出到文件.
     */
    public static void write_to_file(String file_name, String content) {
        File file = new File(file_name);
        OutputStreamWriter osw = null;
        mkdirs(file_name);
        try {
            osw = new OutputStreamWriter(new FileOutputStream(file), DEFAULT_CHARSET);
            osw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.flush();
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param in
     * @param save_path
     * @Description使用流的形式保存文件
     */
    public static void write_to_file(InputStream in, String save_path) {
        File file = new File(save_path);
        mkdirs(save_path);
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[1024 * 4];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @Description：创建文件路径.
     * @param file_name
     */
    public static void mkdirs(String file_name) {
        String temp_path = file_name.replace('\\', '/');
        int idx = temp_path.lastIndexOf("/");
        if (idx != -1) {
            temp_path = temp_path.substring(0, idx);
            idx = temp_path.lastIndexOf("/");
            if (idx != -1) {
                File dirs = new File(temp_path);
                if (!dirs.exists()) {
                    dirs.mkdirs();
                }
            }
        }
    }
}
