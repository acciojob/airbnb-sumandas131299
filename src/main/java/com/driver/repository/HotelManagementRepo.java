package com.driver.repository;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class HotelManagementRepo {


    private HashMap<String, Hotel> hotelmap = new HashMap();
    private HashMap<Integer, User> usermap = new HashMap();
    private HashMap<String, Booking> bookmap = new HashMap();

    public HotelManagementRepo() {

    }

    public String addHotel(Hotel hotel) {

        if(hotel.getHotelName() == null || hotel == null ) return "Failure";
        if(hotelmap.containsKey(hotel.getHotelName())) return "Failure";
        else hotelmap.put(hotel.getHotelName(), hotel);

        return "SUCCESS";

    }

    public Integer addUser(User user) {

        usermap.put(user.getaadharCardNo(),user);
        return user.getaadharCardNo();


    }

    public String getHotelWithMostFacilities() {
        int level = 1;
        String ans = "";
        for(String name : hotelmap.keySet())
        {
            if(hotelmap.get(name).getFacilities().size()>level){
                level = hotelmap.get(name).getFacilities().size();
                ans = name;                
            } else if (hotelmap.get(name).getFacilities().size() == level) {
                if(0>ans.compareTo(name)) ans = name;
            }
        }
        return ans;
    }

    public int bookARoom(Booking booking) {
        booking.setBookingId(String.valueOf(UUID.randomUUID()));
        if(booking.getNoOfRooms() <= hotelmap.get(booking.getHotelName()).getAvailableRooms()){
            booking.setAmountToBePaid(hotelmap.get(booking.getHotelName()).getPricePerNight()*booking.getNoOfRooms());
            bookmap.put(booking.getBookingId(), booking );
            return booking.getAmountToBePaid();
        }
        return -1;
    }

    public int getBookings(Integer aadharCard) {
        for (Booking book : bookmap.values()){
            if (book.getBookingAadharCard() == aadharCard) return Integer.valueOf(book.getBookingId());
        }
        return -1;
    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {

       for(Facility e : newFacilities){
           if(!hotelmap.get(hotelName).getFacilities().contains(e)) hotelmap.get(hotelName).getFacilities().add(e);
       }
       return hotelmap.get(hotelName);

    }
}
