package org.example.parkinglot.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AddCar")
public class AddCarServlet extends HttpServlet {

    // afișează formularul (GET)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/pages/addCar.jsp").forward(req, resp);
    }

    // primește datele (POST)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String licensePlate = req.getParameter("license_plate");
        String parkingSpot  = req.getParameter("parking_spot");
        String ownerId      = req.getParameter("owner_id");


        // momentan, dacă vrei doar redirect la lista de cars:
        resp.sendRedirect(req.getContextPath() + "/cars"); // sau alt URL
    }
}
