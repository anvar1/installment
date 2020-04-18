package uz.ita.assistance.web.screens.propertytype;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.PropertyType;

@UiController("assistance_PropertyType.edit")
@UiDescriptor("property-type-edit.xml")
@EditedEntityContainer("propertyTypeDc")
@LoadDataBeforeShow
public class PropertyTypeEdit extends StandardEditor<PropertyType> {
}