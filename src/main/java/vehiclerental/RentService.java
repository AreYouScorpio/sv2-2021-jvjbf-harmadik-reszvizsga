package vehiclerental;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class RentService {


    Set<User> users = new LinkedHashSet<>();

    Set<Rentable> rentables = new TreeSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public Set<Rentable> getRentables() {
        return rentables;
    }

    public RentService() {
    }


    public void registerUser(User u) throws UserNameIsAlreadyTakenException {
        if (users.stream().anyMatch(user->user.getUserName()==u.getUserName()))
            throw new UserNameIsAlreadyTakenException ("Username is taken!");
        users.add(u);
    }

    public void addRentable( Rentable r){
        if(r instanceof Car)
            if(rentables.stream().anyMatch(rentable->rentable instanceof Car && ((Car) rentable).getID().equals(((Car) r).getID()) && ((Car) rentable).getPrice()==(((Car) r).getPrice())))
                return ;
        if(r instanceof Bike)
            if(rentables.stream().anyMatch(rentable->rentable instanceof Bike && ((Bike) rentable).getID().equals(((Bike) r).getID())))
                return ;

        if (rentables.contains(r)) return;
        rentables.add(r);
    }

    public  void    rent(User user, Rentable rentable, LocalTime time){

    }

}
