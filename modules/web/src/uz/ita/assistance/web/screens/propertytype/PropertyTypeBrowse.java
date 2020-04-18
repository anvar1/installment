package uz.ita.assistance.web.screens.propertytype;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.PropertyType;

@UiController("assistance_PropertyType.browse")
@UiDescriptor("property-type-browse.xml")
@LookupComponent("propertyTypesTable")
@LoadDataBeforeShow
public class PropertyTypeBrowse extends StandardLookup<PropertyType> {
}