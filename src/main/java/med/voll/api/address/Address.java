package med.voll.api.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
}
