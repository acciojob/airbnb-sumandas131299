package com.driver.repository;

import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HotelManagementRepo {


    private HashMap<String, Hotel> hotelmap = new HashMap();
    private HashMap<Integer, User> usermap = new HashMap();
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
}
