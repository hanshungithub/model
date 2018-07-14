package cn.hassan.model.site.bimmodel.entity;

import java.io.Serializable;
import java.util.Date;

public class CloudProjectfile implements Serializable {
    private String fileid;

    private String linkfileid;

    private String revisionid;

    private String filename;

    private Integer filetypeid;

    private Integer filesharetype;

    private String filebucket;

    private String filekey;

    private Long filesize;

    private String filemd5;

    private Date addtime;

    private String adduser;

    private String zipfilemd5;

    private Integer iszip;

    private Integer uploadstatus;

    private String fileextension;

    private Integer worktype;

    private Integer convertstatus;

    private String convertresultdesc;

    private Integer taskenabled;

    private Integer recyclestatus;

    private Date recyclebatch;

    private String filepath;

    private static final long serialVersionUID = 1L;

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    public String getLinkfileid() {
        return linkfileid;
    }

    public void setLinkfileid(String linkfileid) {
        this.linkfileid = linkfileid == null ? null : linkfileid.trim();
    }

    public String getRevisionid() {
        return revisionid;
    }

    public void setRevisionid(String revisionid) {
        this.revisionid = revisionid == null ? null : revisionid.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(Integer filetypeid) {
        this.filetypeid = filetypeid;
    }

    public Integer getFilesharetype() {
        return filesharetype;
    }

    public void setFilesharetype(Integer filesharetype) {
        this.filesharetype = filesharetype;
    }

    public String getFilebucket() {
        return filebucket;
    }

    public void setFilebucket(String filebucket) {
        this.filebucket = filebucket == null ? null : filebucket.trim();
    }

    public String getFilekey() {
        return filekey;
    }

    public void setFilekey(String filekey) {
        this.filekey = filekey == null ? null : filekey.trim();
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getFilemd5() {
        return filemd5;
    }

    public void setFilemd5(String filemd5) {
        this.filemd5 = filemd5 == null ? null : filemd5.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAdduser() {
        return adduser;
    }

    public void setAdduser(String adduser) {
        this.adduser = adduser == null ? null : adduser.trim();
    }

    public String getZipfilemd5() {
        return zipfilemd5;
    }

    public void setZipfilemd5(String zipfilemd5) {
        this.zipfilemd5 = zipfilemd5 == null ? null : zipfilemd5.trim();
    }

    public Integer getIszip() {
        return iszip;
    }

    public void setIszip(Integer iszip) {
        this.iszip = iszip;
    }

    public Integer getUploadstatus() {
        return uploadstatus;
    }

    public void setUploadstatus(Integer uploadstatus) {
        this.uploadstatus = uploadstatus;
    }

    public String getFileextension() {
        return fileextension;
    }

    public void setFileextension(String fileextension) {
        this.fileextension = fileextension == null ? null : fileextension.trim();
    }

    public Integer getWorktype() {
        return worktype;
    }

    public void setWorktype(Integer worktype) {
        this.worktype = worktype;
    }

    public Integer getConvertstatus() {
        return convertstatus;
    }

    public void setConvertstatus(Integer convertstatus) {
        this.convertstatus = convertstatus;
    }

    public String getConvertresultdesc() {
        return convertresultdesc;
    }

    public void setConvertresultdesc(String convertresultdesc) {
        this.convertresultdesc = convertresultdesc == null ? null : convertresultdesc.trim();
    }

    public Integer getTaskenabled() {
        return taskenabled;
    }

    public void setTaskenabled(Integer taskenabled) {
        this.taskenabled = taskenabled;
    }

    public Integer getRecyclestatus() {
        return recyclestatus;
    }

    public void setRecyclestatus(Integer recyclestatus) {
        this.recyclestatus = recyclestatus;
    }

    public Date getRecyclebatch() {
        return recyclebatch;
    }

    public void setRecyclebatch(Date recyclebatch) {
        this.recyclebatch = recyclebatch;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

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
        CloudProjectfile other = (CloudProjectfile) that;
        return (this.getFileid() == null ? other.getFileid() == null : this.getFileid().equals(other.getFileid()))
            && (this.getLinkfileid() == null ? other.getLinkfileid() == null : this.getLinkfileid().equals(other.getLinkfileid()))
            && (this.getRevisionid() == null ? other.getRevisionid() == null : this.getRevisionid().equals(other.getRevisionid()))
            && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
            && (this.getFiletypeid() == null ? other.getFiletypeid() == null : this.getFiletypeid().equals(other.getFiletypeid()))
            && (this.getFilesharetype() == null ? other.getFilesharetype() == null : this.getFilesharetype().equals(other.getFilesharetype()))
            && (this.getFilebucket() == null ? other.getFilebucket() == null : this.getFilebucket().equals(other.getFilebucket()))
            && (this.getFilekey() == null ? other.getFilekey() == null : this.getFilekey().equals(other.getFilekey()))
            && (this.getFilesize() == null ? other.getFilesize() == null : this.getFilesize().equals(other.getFilesize()))
            && (this.getFilemd5() == null ? other.getFilemd5() == null : this.getFilemd5().equals(other.getFilemd5()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getAdduser() == null ? other.getAdduser() == null : this.getAdduser().equals(other.getAdduser()))
            && (this.getZipfilemd5() == null ? other.getZipfilemd5() == null : this.getZipfilemd5().equals(other.getZipfilemd5()))
            && (this.getIszip() == null ? other.getIszip() == null : this.getIszip().equals(other.getIszip()))
            && (this.getUploadstatus() == null ? other.getUploadstatus() == null : this.getUploadstatus().equals(other.getUploadstatus()))
            && (this.getFileextension() == null ? other.getFileextension() == null : this.getFileextension().equals(other.getFileextension()))
            && (this.getWorktype() == null ? other.getWorktype() == null : this.getWorktype().equals(other.getWorktype()))
            && (this.getConvertstatus() == null ? other.getConvertstatus() == null : this.getConvertstatus().equals(other.getConvertstatus()))
            && (this.getConvertresultdesc() == null ? other.getConvertresultdesc() == null : this.getConvertresultdesc().equals(other.getConvertresultdesc()))
            && (this.getTaskenabled() == null ? other.getTaskenabled() == null : this.getTaskenabled().equals(other.getTaskenabled()))
            && (this.getRecyclestatus() == null ? other.getRecyclestatus() == null : this.getRecyclestatus().equals(other.getRecyclestatus()))
            && (this.getRecyclebatch() == null ? other.getRecyclebatch() == null : this.getRecyclebatch().equals(other.getRecyclebatch()))
            && (this.getFilepath() == null ? other.getFilepath() == null : this.getFilepath().equals(other.getFilepath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFileid() == null) ? 0 : getFileid().hashCode());
        result = prime * result + ((getLinkfileid() == null) ? 0 : getLinkfileid().hashCode());
        result = prime * result + ((getRevisionid() == null) ? 0 : getRevisionid().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getFiletypeid() == null) ? 0 : getFiletypeid().hashCode());
        result = prime * result + ((getFilesharetype() == null) ? 0 : getFilesharetype().hashCode());
        result = prime * result + ((getFilebucket() == null) ? 0 : getFilebucket().hashCode());
        result = prime * result + ((getFilekey() == null) ? 0 : getFilekey().hashCode());
        result = prime * result + ((getFilesize() == null) ? 0 : getFilesize().hashCode());
        result = prime * result + ((getFilemd5() == null) ? 0 : getFilemd5().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getAdduser() == null) ? 0 : getAdduser().hashCode());
        result = prime * result + ((getZipfilemd5() == null) ? 0 : getZipfilemd5().hashCode());
        result = prime * result + ((getIszip() == null) ? 0 : getIszip().hashCode());
        result = prime * result + ((getUploadstatus() == null) ? 0 : getUploadstatus().hashCode());
        result = prime * result + ((getFileextension() == null) ? 0 : getFileextension().hashCode());
        result = prime * result + ((getWorktype() == null) ? 0 : getWorktype().hashCode());
        result = prime * result + ((getConvertstatus() == null) ? 0 : getConvertstatus().hashCode());
        result = prime * result + ((getConvertresultdesc() == null) ? 0 : getConvertresultdesc().hashCode());
        result = prime * result + ((getTaskenabled() == null) ? 0 : getTaskenabled().hashCode());
        result = prime * result + ((getRecyclestatus() == null) ? 0 : getRecyclestatus().hashCode());
        result = prime * result + ((getRecyclebatch() == null) ? 0 : getRecyclebatch().hashCode());
        result = prime * result + ((getFilepath() == null) ? 0 : getFilepath().hashCode());
        return result;
    }
}