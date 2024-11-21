package automation.web.services.impl;

import java.util.List;

import Automation.Web.dao.InterFaceVideoDao;
import Automation.Web.dao.impl.VideoDaoImpl;
import Automation.Web.entity.Video;
import Automation.Web.services.InterFaceVideoService;


public class VideoServiceImpl implements InterFaceVideoService {
	
	InterFaceVideoDao viddao = new VideoDaoImpl();

	public static void main(String[] args) {

        }

	@Override
	public int count() {
		
		return viddao.count();
	}

	@Override
	public List<Video> findAll(int page, int pagesize) {
		return viddao.findAll(page, pagesize);
	}

	@Override
	public Video findByvideoname(String name) throws Exception {
		return viddao.findByvideoname(name);
	}

	@Override
	public List<Video> findAll() {
		return viddao.findAll();
	}

	@Override
	public Video findById(int videoid) {
		return viddao.findById(videoid);
	}

	@Override
	public void delete(int videoid) throws Exception {
		viddao.delete(videoid);
		
	}

	@Override
	public void update(Video video) {
		viddao.update(video);
		
	}

	@Override
	public void insert(Video video) {
		viddao.insert(video);
		
	}
}
