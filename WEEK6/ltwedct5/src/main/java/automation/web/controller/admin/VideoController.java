package automation.web.controller.admin;

import static Automation.Web.utils.ConstantUpload.UPLOAD_DIRECTORY;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Automation.Web.entity.Video;
import Automation.Web.services.InterFaceVideoService;
import Automation.Web.services.impl.VideoServiceImpl;
import Automation.Web.utils.ConstantUpload;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(name = "MultiPartServlet", urlPatterns = { "/admin/videos", "/admin/video/create", "/admin/video/update",
		"/admin/video/delete" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InterFaceVideoService videoService = new VideoServiceImpl();

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return ConstantUpload.DEFAULT_FILENAME;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();

		if (url.contains("videos")) {
			List<Video> list = videoService.findAll();
			req.setAttribute("Listvid", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);

		} else if (url.contains("create")) {
			req.getRequestDispatcher("/views/admin/video-create.jsp").forward(req, resp);
		}

		else if (url.contains("update")) {

			int videoid = Integer.parseInt(req.getParameter("id"));
			Video video = videoService.findById(videoid);
			req.setAttribute("cate", video);

			req.getRequestDispatcher("/views/admin/video-update.jsp").forward(req, resp);
		}

		else if (url.contains("delete")) {
			int videoid = Integer.parseInt(req.getParameter("id"));
			try {
				videoService.delete(videoid);
				List<Video> list = videoService.findAll();
				req.setAttribute("Listcate", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();

		if (url.contains("create")) {

			String linkimage = req.getParameter("linkimage");
			if (linkimage == null) {
				String uploadPath = File.separator + UPLOAD_DIRECTORY;
				try {
					Part filePart = req.getPart("multiPartServlet");
					String fileName = getFileName(filePart);
					if (fileName != null && !fileName.isEmpty()) {
						filePart.write(uploadPath + File.separator + fileName); // Write the file to the upload
																				// directory

						// Put values to database

						// Get parameter from view
						int active = Integer.parseInt(req.getParameter("active"));
						int views = Integer.parseInt(req.getParameter("views"));
						String description = req.getParameter("description");
						String title = req.getParameter("title");

						Video video = new Video();

						video.setActive(active);
						video.setViews(views);
						video.setDescription(description);
						video.setPoster(fileName);
						video.setTitle(title);

						// Call Function
						videoService.insert(video);

					}

				} catch (FileNotFoundException fne) {
					req.setAttribute("message", "There was an error: " + fne.getMessage());
				}
				resp.sendRedirect(req.getContextPath() + "/admin/videos");

			}

			else if (linkimage != null) {
				int active = Integer.parseInt(req.getParameter("active"));
				int views = Integer.parseInt(req.getParameter("views"));
				String description = req.getParameter("description");
				String title = req.getParameter("title");

				Video video = new Video();

				video.setActive(active);
				video.setViews(views);
				video.setDescription(description);
				video.setPoster(linkimage);
				video.setTitle(title);

				// Call Function
				videoService.insert(video);
				resp.sendRedirect(req.getContextPath() + "/admin/videos");
			}
		}

		else if (url.contains("update")) {

			String linkimage = req.getParameter("linkimage");
			if (linkimage == null) {
				String uploadPath = File.separator + UPLOAD_DIRECTORY;
				try {
					Part filePart = req.getPart("multiPartServlet");
					String fileName = getFileName(filePart);
					if (fileName != null && !fileName.isEmpty()) {
						filePart.write(uploadPath + File.separator + fileName); // Write the file to the upload
																				// directory

						// Put values to database

						// Get parameter from view
						int active = Integer.parseInt(req.getParameter("active"));
						int views = Integer.parseInt(req.getParameter("views"));
						String description = req.getParameter("description");
						String title = req.getParameter("title");

						Video video = new Video();

						video.setActive(active);
						video.setViews(views);
						video.setDescription(description);
						video.setPoster(fileName);
						video.setTitle(title);

						// Call Function
						videoService.update(video);

					}

				} catch (FileNotFoundException fne) {
					req.setAttribute("message", "There was an error: " + fne.getMessage());
				}
				resp.sendRedirect(req.getContextPath() + "/admin/categories");

			}

			else if (linkimage != null) {
				// Get parameter from view
				int active = Integer.parseInt(req.getParameter("active"));
				int views = Integer.parseInt(req.getParameter("views"));
				String description = req.getParameter("description");
				String title = req.getParameter("title");

				Video video = new Video();

				video.setActive(active);
				video.setViews(views);
				video.setDescription(description);
				video.setPoster(linkimage);
				video.setTitle(title);

				// Call Function
				videoService.update(video);
				resp.sendRedirect(req.getContextPath() + "/admin/categories");
			}

		}

	}
}
