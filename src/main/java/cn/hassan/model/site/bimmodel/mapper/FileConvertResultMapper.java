package cn.hassan.model.site.bimmodel.mapper;


import cn.hassan.model.site.bimmodel.entity.FileConvertResult;
import cn.hassan.model.site.bimmodel.query.BimfileQuery;

import java.util.List;

public interface FileConvertResultMapper {
    int deleteByPrimaryKey(Long convertid);

    int insert(FileConvertResult record);

    int insertSelective(FileConvertResult record);

    FileConvertResult selectByPrimaryKey(Long convertid);

    int updateByPrimaryKeySelective(FileConvertResult record);

    int updateByPrimaryKey(FileConvertResult record);

    List<FileConvertResult> findPBIMFileJsonListByFileId(BimfileQuery query);
}