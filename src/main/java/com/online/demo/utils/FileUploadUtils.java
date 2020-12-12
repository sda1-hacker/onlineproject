package com.online.demo.utils;


import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class FileUploadUtils {

    // 先放在这里 -- 抽出到service中
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    public  String uploadFileToFastDFS(MultipartFile file) throws Exception{

        String file_name = file.getOriginalFilename();

        String extName = file_name.substring(file_name.lastIndexOf(".") + 1);

        InputStream inputStream = file.getInputStream();

        StorePath storePath = fastFileStorageClient.uploadFile(inputStream, file.getSize(), extName, null);

        String full_path = storePath.getFullPath();

        String base_url = "http://121.196.126.38/";

        // StringBuilder线程安全
        String img_url = new StringBuilder(base_url).append(full_path).toString();
        System.out.println(img_url);

        return img_url;
    }


    // http://121.196.126.38/group1/M00/00/00/rBB8NV_UPy-ASVjbAAAABj6is9c77_big.html
}
