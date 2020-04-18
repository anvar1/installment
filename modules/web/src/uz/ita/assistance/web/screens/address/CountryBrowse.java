package uz.ita.assistance.web.screens.address;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.address.Country;

@UiController("assistance_Country.browse")
@UiDescriptor("country-browse.xml")
@LookupComponent("countriesTable")
@LoadDataBeforeShow
public class CountryBrowse extends StandardLookup<Country> {
}