package com.driver.services;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import com.driver.repository.HotelManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HotelManagementServices {


    HotelManagementRepo hotelManagementRepo = new HotelManagementRepo();

    public HotelManagementServices() {
    }

    public String addHotel(Hotel hotel) {
        return this.hotelManagementRepo.addHotel(hotel);
    }

    public Integer addUser(User user) {
        return this.hotelManagementRepo.addUser(user);
    }

    public String getHotelWithMostFacilities() {
        return this.hotelManagementRepo.getHotelWithMostFacilities();
    }

    public int bookARoom(Booking booking) {
        return  this.hotelManagementRepo.bookARoom(booking);
    }

    public int getBookings(Integer aadharCard) {
        return this.hotelManagementRepo.getBookings(aadharCard);
    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
        return this.hotelManagementRepo.updateFacilities(newFacilities,hotelName);
    }
}
