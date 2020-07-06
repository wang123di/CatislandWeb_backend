package cloud.catisland.ivory.common.service;

import java.io.File;
import java.util.Optional;

/**
 * 图片服务，用来上传图片到指定的OSS
 * 
 * @Author: Xy718
 * @Date: 2020-07-06 14:32:01
 * @LastEditors: Xy718
 * @LastEditTime: 2020-07-06 15:13:24
 */
public interface ImageService {
    
    public Optional<String> upImage(File imgFile);
    public Optional<Boolean> deleteImage();
    public Optional<String> copy();
}