package uz.ita.assistance.web.screens.address;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.address.Country;

@UiController("assistance_Country.edit")
@UiDescriptor("country-edit.xml")
@EditedEntityContainer("countryDc")
@LoadDataBeforeShow
public class CountryEdit extends StandardEditor<Country> {
}