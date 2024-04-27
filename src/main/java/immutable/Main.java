package immutable;

import lombok.ToString;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address2 address = new Address2("Tashkent", "Amir Temur");
        User user = new User("elshod", address);
        System.out.println(user);
        Address2 address1 = user.getAddress();
        address1.setRegion("Buxara");
        System.out.println(user);

    }

}


final class User {
    private final String username;
    private final Address2 address;

    User(String username, Address2 address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public Address2 getAddress() throws CloneNotSupportedException {
        return (Address2) address.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address=" + address +
                '}';
    }
}

@ToString
final class Address {
    private final String region;
    private final String district;

    public Address(String region, String district) {
        this.region = region;
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

}

@ToString
class Address2 implements Cloneable {
    private String region;
    private String district;

    public Address2(String region, String district) {
        this.region = region;
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
