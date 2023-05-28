package com.example.week5hw21.Controller;

import com.example.week5hw21.Model.Address;
import com.example.week5hw21.Service.AddressService;
import com.example.week5hw21.TDO.AddressTDO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressTDO tdo){
        addressService.addAddressToTeacher(tdo);
        return ResponseEntity.status(200).body("Address added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id, @Valid @RequestBody Address address){
        addressService.updateAddress(id, address);
        return ResponseEntity.status(200).body("Address updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address deleted");
    }
}
