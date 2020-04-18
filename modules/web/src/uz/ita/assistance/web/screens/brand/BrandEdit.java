package uz.ita.assistance.web.screens.brand;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Brand;

@UiController("assistance_Brand.edit")
@UiDescriptor("brand-edit.xml")
@EditedEntityContainer("brandDc")
@LoadDataBeforeShow
public class BrandEdit extends StandardEditor<Brand> {
}