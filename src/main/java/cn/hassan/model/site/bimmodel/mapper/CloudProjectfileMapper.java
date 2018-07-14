package cn.hassan.model.site.bimmodel.mapper;

import cn.hassan.model.site.bimmodel.entity.CloudProjectfile;
import cn.hassan.model.site.bimmodel.query.BimfileQuery;
import org.apache.ibatis.annotations.Param;

public interface CloudProjectfileMapper {

    int deleteByPrimaryKey(String fileid);

    int insert(CloudProjectfile record);

    int insertSelective(CloudProjectfile record);

    CloudProjectfile selectByPrimaryKey(String fileid);

    int updateByPrimaryKeySelective(CloudProjectfile record);

    int updateByPrimaryKeyWithBLOBs(CloudProjectfile record);

    int updateByPrimaryKey(CloudProjectfile record);

	CloudProjectfile findFileByFileId(String fileId);

	CloudProjectfile findFileIsExit(BimfileQuery query);

    CloudProjectfile findFileIsExit(@Param(value = "fileMd5") String fileMd5, @Param(value = "fileSize") Long fileSize);
}