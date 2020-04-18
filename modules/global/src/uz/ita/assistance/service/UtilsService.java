package uz.ita.assistance.service;

import uz.ita.assistance.entity.address.Address;

public interface UtilsService {
    String NAME = "assistance_UtilsService";

    String sumText(Double sum);
    String complateAddress(Address address);
}