package servlet;

import lombok.SneakyThrows;
import manager.AuthorManager;
import model.Author;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/edit")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,    // 1mb
        maxFileSize = 1024 * 1024 * 10,     // 10mb
        maxRequestSize = 1024 * 1024 * 100  // 100mb
)
public class EditAuthorServlet extends HttpServlet {

    private final AuthorManager authorManager = new AuthorManager();

    private final static String IMAGE_PATH = "C:\\Users\\Hayk\\IdeaProjects\\myLibrary\\projectImages\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("authorId"));
        Author author = authorManager.getAuthorById(id);
        req.setAttribute("author", author);
        req.getRequestDispatcher("/WEB-INF/editAuthor.jsp").forward(req, resp);
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("authorId"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));

        Part image = req.getPart("profilePicture");
        String fileName = null;
        if (image != null) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + image.getSubmittedFileName();
            image.write(IMAGE_PATH + fileName);
        }
        Author author = Author.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .email(email)
                .age(age)
                .profilePicture(fileName)
                .build();
        authorManager.edit(author);
        resp.sendRedirect("/authors");
    }
}
