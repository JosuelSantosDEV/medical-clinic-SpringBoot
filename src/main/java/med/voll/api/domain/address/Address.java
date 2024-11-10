package med.voll.api.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String state;
    private String district;
    private String street;
    @Column(name = "postal_code")
    private String postalCode;
    private String number;
    private String complement;

    public  Address(AddressData data){
        this.country = data.country();
        this.state = data.state();
        this.city = data.city();
        this.district = data.district();
        this.street = data.street();
        this.postalCode = data.postalCode();
        this.number = data.number();
        this.complement = data.complement();
    }

    public void updateAttributes(AddressData address) {
        if(address.country() != null){
            this.country = address.country();
        }
        if(address.state() != null){
            this.state = address.state();
        }
        if(address.city() != null){
            this.city = address.city();
        }
        if(address.district() != null){
            this.district = address.district();
        }
        if(address.street() != null){
            this.street = address.street();
        }
        if(address.postalCode() != null){
            this.postalCode = address.postalCode();
        }
        if(address.number() != null){
            this.number = address.number();
        }
        if(address.complement() != null){
            this.complement = address.complement();
        }
    }
}
