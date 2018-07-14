package cn.hassan.model.site.web;

import cn.hassan.model.site.file.pojo.FileForFront;
import cn.hassan.model.site.file.pojo.UploadResult;
import cn.hassan.model.site.file.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(value="/", tags="独立组件上传服务")
@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;


    @ApiOperation(value="上传服务受理请求", notes = "上传服务受理请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "size", value = "文件大小", required = true),
            @ApiImplicitParam(name = "file", value = "文件", required = true),
            @ApiImplicitParam(name = "fileUUID", value = "文件唯一ID", required = true),
            @ApiImplicitParam(name = "name", value = "文件名，带扩展名", required = true),
            @ApiImplicitParam(name = "md5", value = "文件的md5值，分片时，传完整文件的md5", required = true),
            @ApiImplicitParam(name = "type", value = "文件类型", required = true),
            @ApiImplicitParam(name = "chunks", value = "总分片数", required = false),
            @ApiImplicitParam(name = "chunk", value = "当前分片编号", required = false)
    })
    @PostMapping("/front/upload.htm")
    @ResponseBody
    public UploadResult file(FileForFront frontFile) throws IOException {

        return null;
	}
}
