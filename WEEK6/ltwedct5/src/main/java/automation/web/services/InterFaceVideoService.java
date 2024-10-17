package automation.web.services;

import java.util.List;

import Automation.Web.entity.Category;
import Automation.Web.entity.Video;

public interface InterFaceVideoService {

	int count();

	List<Video> findAll(int page, int pagesize);

	Video findByvideoname(String name) throws Exception;

	List<Video> findAll();

	Video findById(int videoid);

	void delete(int videoid) throws Exception;

	void update(Video video);

	void insert(Video video);
	
}
