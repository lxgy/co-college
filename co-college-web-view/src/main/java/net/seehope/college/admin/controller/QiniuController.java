package net.seehope.college.admin.controller;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/qiniu")
class QiuniuController {
    /**
     * 获取七牛云令牌
     * @return
     */
    @GetMapping
    public Object get_upload_token() {
        Map<String, Object> data = new HashMap<String, Object>();
        Auth auth = Auth.create("F-FOuyp7JH3RsLuXnxaHYtFjYKTe5nEzO-9bt0Pw", "9fqMinKa2yYu_7OiJ4MwC2un0XxGiuf-I9kDe30-");
        String uptoken = auth.uploadToken("ganluren");
        data.put("uptoken", uptoken);
        return data;
    }



    /**
     * 删除七牛云文件
     * @param request
     * @param response
     * @param id
     */
    @DeleteMapping
    public void delete_upload(HttpServletRequest request, HttpServletResponse response,String id){
        Auth auth = Auth.create("F-FOuyp7JH3RsLuXnxaHYtFjYKTe5nEzO-9bt0Pw", "9fqMinKa2yYu_7OiJ4MwC2un0XxGiuf-I9kDe30-");
        Configuration config = new Configuration(Zone.autoZone());
        BucketManager bucketMgr = new BucketManager(auth, config);
        //指定需要删除的文件，和文件所在的存储空间
        String bucketName = "ganluren";
        String  key = id;
        try {
            Response delete = bucketMgr.delete(bucketName, key);
            delete.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
