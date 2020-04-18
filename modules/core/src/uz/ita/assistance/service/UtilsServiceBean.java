package uz.ita.assistance.service;

import com.ibm.icu.text.RuleBasedNumberFormat;
import org.springframework.stereotype.Service;
import uz.ita.assistance.entity.address.Address;

import java.util.Locale;
import java.util.Optional;

@Service(UtilsService.NAME)
public class UtilsServiceBean implements UtilsService {

    public String sumText(Double sum) {
        RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"),
                RuleBasedNumberFormat.SPELLOUT);
        return nf.format(sum);
    }

    public String complateAddress(Address address) {
        if (address != null) {
            String s = "";
            if (address.getRegion() != null) s = s + address.getRegion().getName() + ", ";
            if (address.getDistrict() != null) s = s + address.getDistrict().getName() + ", ";
            if (address.getCity() != null) s = s + address.getCity() + ", ";
            if (address.getAddress() != null) s = s + address.getAddress() + ", ";

            return Optional.ofNullable(s)
                    .filter(str -> str.length() != 0)
                    .map(str -> str.substring(0, str.length() - 2))
                    .orElse(s);
        } else return "";
    }
}