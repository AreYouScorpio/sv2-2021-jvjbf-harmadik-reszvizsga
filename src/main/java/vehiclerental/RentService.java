package vehiclerental;

import java.time.LocalTime;
import java.util.*;

public class RentService {


    // private Set<User> users = new LinkedHashSet<>();
    private Set<User> users = new HashSet<>();

    //Set<Rentable> rentables = new TreeSet<>();
    private Set<Rentable> rentables = new HashSet<>();

    // private TreeMap<Rentable, User> actualRenting = new TreeMap<>();
    private Map<Rentable, User> actualRenting = new TreeMap<>();

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

    /*
    public void addRentable( Rentable r){

        if(r instanceof Car)
            if(rentables.stream().anyMatch(rentable->rentable
                    instanceof Car && ((Car) rentable).getID().equals(((Car) r).getID())
                    && ((Car) rentable).getPrice()==(((Car) r).getPrice())))
                return ;
        if(r instanceof Bike)
            if(rentables.stream().anyMatch(rentable->rentable instanceof Bike
                    && ((Bike) rentable).getID().equals(((Bike) r).getID())))
                return ;

        if (rentables.contains(r)) return;
        rentables.add(r);
    }

     */

    public void addRentable(Rentable rentable){
        rentables.add(rentable);
    }

    public  void    rent(User user, Rentable rentable, LocalTime time){
        if((rentable.getRentingTime()!=null)||(user.getBalance()<rentable.calculateSumPrice(3*60)))
            throw new IllegalStateException("Rentable is taken or low money.");
        rentable.rent(time);
        actualRenting.put(rentable, user);
    }

    public Map<Rentable, User>  getActualRenting()
    {
        return actualRenting;
    }
/*  saját mego:


    public void closeRent(Rentable rentable, int minutes){
        actualRenting.get(rentable).setBalance(actualRenting.get(rentable).
                getBalance()-rentable.calculateSumPrice(minutes));
        actualRenting.remove(rentable);
        rentable.closeRent();

    }

 */

    // tanári megoldás:
    public void closeRent(Rentable rentable, int minutes){
    if(!actualRenting.containsKey(rentable)) {
        throw new IllegalStateException("Rentable is not taken!");
    }
    User user = actualRenting.get(rentable);
    user.minusBalance(rentable.calculateSumPrice(minutes));
    actualRenting.remove(rentable);
    rentable.closeRent();

    }}
