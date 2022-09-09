package servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/bookCoverImg/get")
public class GetBookCoverImgServlet extends HttpServlet {

    private final static String IMAGE_PATH = "C:\\Users\\Hayk\\IdeaProjects\\myLibrary\\projectImages\\";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String coverImg = req.getParameter("coverImg");

        String filePath = IMAGE_PATH + coverImg;
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            try (FileInputStream inputStream = new FileInputStream(imageFile)) {
                resp.setContentType("image/jpeg");
                resp.setContentLength((int) imageFile.length());

                ServletOutputStream outputStream = resp.getOutputStream();
                byte[] buffer = new byte[4096];
                int byteReader;
                while ((byteReader = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, byteReader);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
