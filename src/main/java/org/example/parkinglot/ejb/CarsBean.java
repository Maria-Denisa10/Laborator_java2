 package org.example.parkinglot.ejb;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.common.CarDto;
import org.example.parkinglot.entities.Car;


@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<Car> findAllCars() {
        LOG.info("msg: \"findAllCars\"");
        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCar(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<Car> copyCarsToDto(List<Car> cars) {
        List<Car> dtos = new ArrayList<Car>();
        for (Car car : cars) {
            Car dto = new Car(
                    car.getId(),
                    car.getli(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername()
            );
            dtos.add(dto);
        }
        return dtos;
    }

}