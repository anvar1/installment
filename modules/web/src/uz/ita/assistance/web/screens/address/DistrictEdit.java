package uz.ita.assistance.web.screens.address;

import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.address.District;
import uz.ita.assistance.entity.address.Region;

import javax.inject.Inject;

@UiController("assistance_District.edit")
@UiDescriptor("district-edit.xml")
@EditedEntityContainer("districtDc")
@LoadDataBeforeShow
public class DistrictEdit extends StandardEditor<District> {

}