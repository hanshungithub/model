package cn.hassan.model.site.file.pojo;

import lombok.Data;

@Data
public class UploadResult {

    private int resultCode;

    private String message;

    private UploadFile file;

    private UploadResult(int code, String message){
        this.resultCode = code;
        this.message = message;
    }

    public UploadResult() {
        this.resultCode = -1;
    }

	public static UploadResult success(){
        return new UploadResult(0,"上传成功！");
    }

    public static UploadResult uploadFaild(String message){
        return new UploadResult(-1,"上传失败！");
    }

    public static UploadResult mergeFailed() {
        UploadResult result = new UploadResult();
        result.setMessage("文件合并失败！");
        result.setResultCode(-1);
        return result;
    }

	public static UploadResult uploadFileSuccess(UploadFile file) {
		UploadResult result = new UploadResult();
		result.setResultCode(0);
		result.setMessage("上传成功！");
		result.setFile(file);
		return result;
	}
}
