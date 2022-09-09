package servlet;

import manager.AuthorManager;
import manager.BookManager;
import model.Author;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/book/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,    // 1mb
        maxFileSize = 1024 * 1024 * 10,     // 10mb
        maxRequestSize = 1024 * 1024 * 100  // 100mb
)
public class AddBookServlet extends HttpServlet {

    private final BookManager bookManager = new BookManager();
    private final AuthorManager authorManager = new AuthorManager();

    private final static String IMAGE_PATH = "C:\\Users\\Hayk\\IdeaProjects\\myLibrary\\projectImages\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", authorManager.showAuthors());
        req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        Part coverImgPart = req.getPart("coverImg");
        String fileName = null;
        if (coverImgPart.getSize() != 0) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + coverImgPart.getSubmittedFileName();
            coverImgPart.write(IMAGE_PATH + fileName);
        }
        Book book = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getAuthorById(authorId))
                .coverImg(fileName)
                .build();
        bookManager.addBook(book);
        resp.sendRedirect("/books");
    }
}
