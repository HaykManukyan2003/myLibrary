package servlet;

import lombok.SneakyThrows;
import manager.AuthorManager;
import manager.BookManager;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/book/edit")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,    // 1mb
        maxFileSize = 1024 * 1024 * 10,     // 10mb
        maxRequestSize = 1024 * 1024 * 100  // 100mb
)
public class EditBookServlet extends HttpServlet {

    private final BookManager bookManager = new BookManager();

    private final AuthorManager authorManager = new AuthorManager();

    private final static String IMAGE_PATH = "C:\\Users\\Hayk\\IdeaProjects\\myLibrary\\projectImages\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("bookId"));
        Book book = bookManager.getBookById(id);
        req.setAttribute("book", book);
        req.setAttribute("authors", authorManager.showAuthors());
        req.getRequestDispatcher("/WEB-INF/editBook.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("bookId"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int authorId = Integer.parseInt(req.getParameter("authorId")); //porci
        Part coverImg = req.getPart("coverImg");

        String fileName = null;
        if (coverImg != null) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + coverImg.getSubmittedFileName();
            coverImg.write(IMAGE_PATH + fileName);
        }

        Book book = Book.builder()
                .id(id)
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getAuthorById(authorId))
                .coverImg(fileName)
                .build();
        bookManager.edit(book);
        resp.sendRedirect("/books");
    }

}
