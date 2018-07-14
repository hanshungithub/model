package cn.hassan.model.site.bimmodel.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FileConvertResult implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long convertid;

    private String fileid;

    private Integer filetypeid;

    private String filebucket;

    private String filekey;

    private Long filesize;

    private String filemd5;

    private Date addtime;

    private String adduser;

    private String zipfilemd5;

    private Integer iszip;

    private Integer worktype;

    private Integer resulttype;

    private Integer recyclestatus;

    private Date recyclebatch;

	public String floorName;

	public Integer floorId;

	public Integer orderId;

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FileConvertResult other = (FileConvertResult) that;
        return (this.getConvertid() == null ? other.getConvertid() == null : this.getConvertid().equals(other.getConvertid()))
            && (this.getFileid() == null ? other.getFileid() == null : this.getFileid().equals(other.getFileid()))
            && (this.getFiletypeid() == null ? other.getFiletypeid() == null : this.getFiletypeid().equals(other.getFiletypeid()))
            && (this.getFilebucket() == null ? other.getFilebucket() == null : this.getFilebucket().equals(other.getFilebucket()))
            && (this.getFilekey() == null ? other.getFilekey() == null : this.getFilekey().equals(other.getFilekey()))
            && (this.getFilesize() == null ? other.getFilesize() == null : this.getFilesize().equals(other.getFilesize()))
            && (this.getFilemd5() == null ? other.getFilemd5() == null : this.getFilemd5().equals(other.getFilemd5()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getAdduser() == null ? other.getAdduser() == null : this.getAdduser().equals(other.getAdduser()))
            && (this.getZipfilemd5() == null ? other.getZipfilemd5() == null : this.getZipfilemd5().equals(other.getZipfilemd5()))
            && (this.getIszip() == null ? other.getIszip() == null : this.getIszip().equals(other.getIszip()))
            && (this.getWorktype() == null ? other.getWorktype() == null : this.getWorktype().equals(other.getWorktype()))
            && (this.getResulttype() == null ? other.getResulttype() == null : this.getResulttype().equals(other.getResulttype()))
            && (this.getRecyclestatus() == null ? other.getRecyclestatus() == null : this.getRecyclestatus().equals(other.getRecyclestatus()))
            && (this.getRecyclebatch() == null ? other.getRecyclebatch() == null : this.getRecyclebatch().equals(other.getRecyclebatch()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConvertid() == null) ? 0 : getConvertid().hashCode());
        result = prime * result + ((getFileid() == null) ? 0 : getFileid().hashCode());
        result = prime * result + ((getFiletypeid() == null) ? 0 : getFiletypeid().hashCode());
        result = prime * result + ((getFilebucket() == null) ? 0 : getFilebucket().hashCode());
        result = prime * result + ((getFilekey() == null) ? 0 : getFilekey().hashCode());
        result = prime * result + ((getFilesize() == null) ? 0 : getFilesize().hashCode());
        result = prime * result + ((getFilemd5() == null) ? 0 : getFilemd5().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getAdduser() == null) ? 0 : getAdduser().hashCode());
        result = prime * result + ((getZipfilemd5() == null) ? 0 : getZipfilemd5().hashCode());
        result = prime * result + ((getIszip() == null) ? 0 : getIszip().hashCode());
        result = prime * result + ((getWorktype() == null) ? 0 : getWorktype().hashCode());
        result = prime * result + ((getResulttype() == null) ? 0 : getResulttype().hashCode());
        result = prime * result + ((getRecyclestatus() == null) ? 0 : getRecyclestatus().hashCode());
        result = prime * result + ((getRecyclebatch() == null) ? 0 : getRecyclebatch().hashCode());
        return result;
    }
}