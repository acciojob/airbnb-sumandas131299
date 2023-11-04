package com.driver.services;

import com.driver.model.Hotel;
import com.driver.model.User;
import com.driver.repository.HotelManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class HotelManagementServices {

    @Autowired
    HotelManagementRepo hotelManagementRepo;

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
}
