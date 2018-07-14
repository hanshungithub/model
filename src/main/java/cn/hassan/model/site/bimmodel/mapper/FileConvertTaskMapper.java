package cn.hassan.model.site.bimmodel.mapper;


import cn.hassan.model.site.bimmodel.entity.CloudFileConvertTask;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 15:35
 * Description:
 */
public interface FileConvertTaskMapper {

	void updateFileConvertTask(CloudFileConvertTask task);

	CloudFileConvertTask findOne(CloudFileConvertTask task);
}
